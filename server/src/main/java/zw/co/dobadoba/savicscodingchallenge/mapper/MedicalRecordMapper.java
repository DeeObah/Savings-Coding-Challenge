package zw.co.dobadoba.savicscodingchallenge.mapper;

import zw.co.dobadoba.savicscodingchallenge.controller.MedicalRecordDTO;
import zw.co.dobadoba.savicscodingchallenge.model.MedicalRecord;

public class MedicalRecordMapper {

    public static MedicalRecordDTO map(MedicalRecord medicalRecord){
        final MedicalRecordDTO medicalRecordDTO =new MedicalRecordDTO();
        medicalRecordDTO.setId(medicalRecord.getId().toString());
        medicalRecordDTO.setActiveStatus(medicalRecord.isActiveStatus());
        medicalRecordDTO.setCreatedByUser(medicalRecord.getCreatedByUser());
        medicalRecordDTO.setCreationTime(medicalRecord.getCreationTime());
        medicalRecordDTO.setCountry(medicalRecord.getCountry());
        medicalRecordDTO.setCity(medicalRecord.getCity());
        medicalRecordDTO.setFirstName(medicalRecord.getFirstName());
        medicalRecordDTO.setLastName(medicalRecord.getLastName());
        medicalRecordDTO.setModificationTime(medicalRecord.getModificationTime());
        medicalRecordDTO.setModifiedByUser(medicalRecord.getModifiedByUser());
        medicalRecordDTO.setDiabetesStatus(medicalRecord.getDiabetesStatus());
        medicalRecordDTO.setAge(medicalRecord.getAge());
        medicalRecordDTO.setGender(medicalRecord.getGender());
        return medicalRecordDTO;
    }

    public static MedicalRecord map(MedicalRecordDTO medicalRecordDTO){
        final MedicalRecord medicalRecord =new MedicalRecord();
        medicalRecord.setActiveStatus(medicalRecordDTO.isActiveStatus());
        medicalRecord.setCreatedByUser(medicalRecordDTO.getCreatedByUser());
        medicalRecord.setCreationTime(medicalRecordDTO.getCreationTime());
        medicalRecord.setCountry(medicalRecordDTO.getCountry());
        medicalRecord.setCity(medicalRecordDTO.getCity());
        medicalRecord.setFirstName(medicalRecordDTO.getFirstName());
        medicalRecord.setLastName(medicalRecordDTO.getLastName());
        medicalRecord.setModificationTime(medicalRecordDTO.getModificationTime());
        medicalRecord.setModifiedByUser(medicalRecordDTO.getModifiedByUser());
        medicalRecord.setDiabetesStatus(medicalRecordDTO.getDiabetesStatus());
        medicalRecord.setAge(medicalRecordDTO.getAge());
        medicalRecord.setGender(medicalRecordDTO.getGender());
        return medicalRecord;
    }
}
