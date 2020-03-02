package zw.co.dobadoba.savicscodingchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.dobadoba.savicscodingchallenge.exception.ResourceNotFoundException;
import zw.co.dobadoba.savicscodingchallenge.model.MedicalRecord;
import zw.co.dobadoba.savicscodingchallenge.repository.MedicalRecordRepository;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public MedicalRecord findCheckedById(String recordId) {
        return medicalRecordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + recordId));

    }

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {
        if(medicalRecordRepository.findByFirstNameAndLastNameAndCityAndCountry(medicalRecord.getFirstName(), medicalRecord.getLastName(), medicalRecord.getCity(), medicalRecord.getCountry()).isPresent()){
            throw new IllegalArgumentException("Record already added");
        }
        return medicalRecordRepository.save(medicalRecord);
    }
}
