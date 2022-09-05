package com.assessment.hospitalplanning.service.implementation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assessment.hospitalplanning.dto.StaffDTO;
import com.assessment.hospitalplanning.model.StaffProfile;
import com.assessment.hospitalplanning.repository.StaffRepository;
import com.assessment.hospitalplanning.response.MessageResponse;
import com.assessment.hospitalplanning.response.ResponseConstants;
import com.assessment.hospitalplanning.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

//    private static final Logger LOGGER = Logger.getLogger(StaffService.class);
	private StaffRepository staffRepository;

	public StaffServiceImpl(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	public ResponseEntity<?> staff(StaffDTO staffDTO) {
		try {
			//check that no two user has same UUID
			//Its all Ready Set to be Unique in the database
			StaffProfile staffProfile = new StaffProfile();
			String uuid = generateType1UUID().toString();
			Integer staffExists =  staffRepository.findByUuid(uuid).getId();
			if (staffExists != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse<Object>(
						ResponseConstants.ALREADY_EXIST_CODE, ResponseConstants.ALREADY_EXIST_MESSAGE, null));
			}
			staffProfile.setName(staffDTO.getName());
			staffProfile.setRegistrationDate(registrationDate());
			staffProfile.setUuid(uuid);
			StaffProfile entity = staffRepository.save(staffProfile);
			if (entity.getId() != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse<Object>(
						ResponseConstants.SUCCEESS_CODE, ResponseConstants.SUCCEESS_MESSAGE, null));
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse<Object>(
						ResponseConstants.FAILED_CODE, ResponseConstants.FAILED_MESSAGE, null));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new MessageResponse<Object>(ResponseConstants.FAILED_CODE, ResponseConstants.FAILED_MESSAGE, null));
		}
	}

	public ResponseEntity<?> staffUpdate(StaffDTO staffDTO) {
		try {
			StaffProfile staffProfile = new StaffProfile();
			staffProfile.setName(staffDTO.getName());
			staffProfile.setRegistrationDate(staffDTO.getRegistrationDate());
			staffProfile.setUuid(generateType1UUID().toString());
			staffRepository.save(staffProfile);
		} catch (Exception e) {
			System.err.println("Saving A New Staff Failed");
		}
		return null;
	}

	private static long get64LeastSignificantBitsForVersion1() {
		Random random = new Random();
		long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
		long variant3BitFlag = 0x8000000000000000L;
		return random63BitLong + variant3BitFlag;
	}

	private static long get64MostSignificantBitsForVersion1() {
		LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
		Duration duration = Duration.between(start, LocalDateTime.now());
		long seconds = duration.getSeconds();
		long nanos = duration.getNano();
		long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
		long least12SignificatBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
		long version = 1 << 12;
		return (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificatBitOfTime;
	}

	public static UUID generateType1UUID() {
		long most64SigBits = get64MostSignificantBitsForVersion1();
		long least64SigBits = get64LeastSignificantBitsForVersion1();

		return new UUID(most64SigBits, least64SigBits);
	}

	public String registrationDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		return dtf.format(now);
	}

}
