package zw.co.dobadoba.savicscodingchallenge.service;

import zw.co.dobadoba.savicscodingchallenge.model.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {

    List<MedicalRecord> findAll();
    MedicalRecord save(MedicalRecord medicalRecord);
    MedicalRecord findCheckedById(String recordId);
}
