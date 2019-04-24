import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";
import {RestaurantService} from "../../../services/restaurant.service";
import {Restaurant} from "../../../models/restaurant";

@Component({
  selector: 'app-employee-register',
  templateUrl: './employee-register.component.html',
  styleUrls: ['./employee-register.component.css']
})
export class EmployeeRegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted: boolean;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService,
              private storage: LocalStorageService,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      restaurantId: '',
      restaurantPassword: ''
    });
  }

  onSubmit() {
    this.submitted = true;
    let json =
      "{" +
      "\"firstName\" : \"" + this.registerForm.controls.firstName.value + "\"," +
      "\"lastName\" : \"" + this.registerForm.controls.lastName.value + "\"," +
      "\"username\" : \"" + this.registerForm.controls.username.value + "\"," +
      "\"password\" : \"" + this.registerForm.controls.password.value + "\"," +
      "\"restaurant\" : null" +
      "}";
    let restaurantId: number = this.registerForm.controls.restaurantId.value;
    console.log(restaurantId);
    this.accountService.registerEmployee(JSON.parse(json)).subscribe(account => {
      this.accountService.employeeUpdateRestaurant(restaurantId, account).subscribe(account => {
        this.storage.store("restaurant", account.restaurant);
        this.storage.store("employee", account);
        this
          .router
          .navigate(['/home']);
      });
    });
  }
}
