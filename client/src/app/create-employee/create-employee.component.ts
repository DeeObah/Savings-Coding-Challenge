import {Component, OnInit} from '@angular/core';
import {Employee} from '../model/employee';
import {Router} from '@angular/router';
import {EmployeeService} from '../service/employee.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Observable} from "rxjs";
import {filter, map} from 'rxjs/operators';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;
  term: string;
  showMinorsOnly = false;
  medicalRecordForm: FormGroup;
  employees: Observable<Employee[]>;

  selectedCountry = '--Choose Country--';

  countries: Array<any> = [
    {name: 'Germany', cities: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn']},
    {name: 'Spain', cities: ['Barcelona']},
    {name: 'USA', cities: ['Downers Grove']},
    {name: 'Mexico', cities: ['Puebla']},
    {name: 'India', cities: ['Delhi', 'Kolkata', 'Mumbai', 'Bangalore']},
    {name: 'Zimbabwe', cities: ['Harare', 'Bulawayo', 'Mutare', 'Chinhoyi']},
  ];


  cities: Array<any>;

  constructor(private employeeService: EmployeeService, private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.medicalRecordForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      country: [this.selectedCountry, Validators.required],
      city: ['', Validators.required],
      age: ['', [Validators.required]],
      gender: [Validators.required, Validators.pattern('^(MALE)|(FEMALE)$')],
      diabetesStatus: [Validators.required, Validators.pattern('^(YES)|(NO)|(UNKNOWN)$')],
    });
    this.reloadData();
  }


  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
    this.showMinorsOnly = false;
  }

  filterForMinors(isChecked: boolean) {
    if (isChecked) {
      this.employees = this.employees.pipe(map(arr =>
          arr.filter(emp => emp.age < 18))
      );
    } else {
      this.reloadData();
    }
  }

  // convenience getter for easy access to form fields
  get formField() {
    return this.medicalRecordForm.controls;
  }

  save() {
    if (this.medicalRecordForm.invalid) {
      return;
    } else {
      this.populateEmployee();
      this.employeeService.createEmployee(this.employee)
        .subscribe(data => {
          console.log(data);
          this.showMinorsOnly = false;
          this.reloadData();
        }, error => console.log(error));
      this.employee = new Employee();
    }
  }

  populateEmployee() {
    this.employee.firstName = this.medicalRecordForm.get('firstName').value;
    this.employee.lastName = this.medicalRecordForm.get('lastName').value;
    this.employee.gender = this.medicalRecordForm.get('gender').value;
    this.employee.diabetesStatus = this.medicalRecordForm.get('diabetesStatus').value;
    this.employee.age = +this.medicalRecordForm.get('age').value;
    this.employee.city = this.medicalRecordForm.get('city').value;
    this.employee.country = this.medicalRecordForm.get('country').value;
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  changeCountry(country) {
    this.cities = this.countries.find(cntry => cntry.name == country).cities;
  }

}
