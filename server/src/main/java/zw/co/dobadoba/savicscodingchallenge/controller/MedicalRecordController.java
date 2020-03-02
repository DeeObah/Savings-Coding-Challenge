package zw.co.dobadoba.savicscodingchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zw.co.dobadoba.savicscodingchallenge.mapper.MedicalRecordMapper;
import zw.co.dobadoba.savicscodingchallenge.model.MedicalRecord;
import zw.co.dobadoba.savicscodingchallenge.service.MedicalRecordService;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MedicalRecordController {
	@Autowired
	private MedicalRecordService medicalRecordService;

	@GetMapping("/medical-records")
	public List<MedicalRecordDTO> getAllRecords() {
		return medicalRecordService.findAll().parallelStream().map(MedicalRecordMapper::map).collect(toList());
	}

	@PostMapping("/medical-records")
	public MedicalRecord createRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO) {
		return medicalRecordService.save(MedicalRecordMapper.map(medicalRecordDTO));
	}

}
