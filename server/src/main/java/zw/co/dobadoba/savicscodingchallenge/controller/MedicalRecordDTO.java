package zw.co.dobadoba.savicscodingchallenge.controller;

import lombok.Data;
import zw.co.dobadoba.savicscodingchallenge.model.DiabetesStatus;
import zw.co.dobadoba.savicscodingchallenge.model.Gender;


@Data
public class MedicalRecordDTO {

	protected String id;
	private String createdByUser;
	private String creationTime;
	private String modifiedByUser;
	private String modificationTime;
	private boolean activeStatus = true;
	private String firstName;
	private String lastName;
	private int age;
	private DiabetesStatus diabetesStatus;
	private Gender gender;
	private String city;
	private String country;

}
