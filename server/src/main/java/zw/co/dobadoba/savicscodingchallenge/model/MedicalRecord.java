package zw.co.dobadoba.savicscodingchallenge.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "MedicalRecord")
public class MedicalRecord {

	@Id
	@Indexed
	protected ObjectId id;
	@Field
	private String createdByUser;
	@Field
	private String creationTime;
	@Field
	private String modifiedByUser;
	@Field
	private String modificationTime;
	@Field
	private boolean activeStatus = true;
	@Field(value = "first_name")
	private String firstName;
	@Field(value = "last_name")
	private String lastName;
	@Field(value = "age")
	private int age;
	@Field(value = "diabetes_status")
	private DiabetesStatus diabetesStatus;
	@Field(value = "gender")
	private Gender gender;
	@Field(value = "country")
	private String country;
	@Field(value = "city")
	private String city;
}
