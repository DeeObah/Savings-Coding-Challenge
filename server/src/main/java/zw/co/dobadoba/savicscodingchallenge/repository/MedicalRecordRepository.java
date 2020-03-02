package zw.co.dobadoba.savicscodingchallenge.repository;

import zw.co.dobadoba.savicscodingchallenge.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {

    Optional<MedicalRecord> findByFirstNameAndLastNameAndCityAndCountry(String name, String surname, String city, String country);
}
