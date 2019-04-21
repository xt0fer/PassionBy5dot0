import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";
import {RestaurantService} from "../../../services/restaurant.service";

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
      "\"restaurant\" : {\"id\" : " + this.registerForm.controls.restaurantId.value + "}" +
      "}";
    this.accountService.registerEmployee(JSON.parse(json)).subscribe(account => {
        this.restaurantService.findById(account.restaurant).subscribe(restaurant => {
          this.restaurantService.addEmployee(restaurant, account.id);
          this.storage.store("restaurant", restaurant);
        });
        this.storage.store("employee", account);
      }
    );
    this.router.navigate(['/home']);
  }
}
