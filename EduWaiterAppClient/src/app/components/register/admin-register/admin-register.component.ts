import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";
import {RestaurantService} from "../../../services/restaurant.service";
import {Restaurant} from "../../../models/restaurant";

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

  newRestaurantRegisterForm: FormGroup;
  existingRestaurantRegisterForm: FormGroup;
  submitted: boolean;
  newRestaurant: boolean;
  existingRestaurant: boolean;


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService,
              private storage: LocalStorageService,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.newRestaurantRegisterForm = this.formBuilder.group({
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      restaurantName: '',
      restaurantPassword: ''
    });

    this.existingRestaurantRegisterForm = this.formBuilder.group({
      firstName2: '',
      lastName2: '',
      username2: '',
      password2: '',
      restaurantId: '',
      restaurantPassword2: ''
    });
  }

  onSubmitNewRestaurant() {
    this.submitted = true;
    let restaurantJson =
      "{" +
      "\"name\" : \"" + this.newRestaurantRegisterForm.controls.restaurantName.value + "\"," +
      "\"password\" : \"" + this.newRestaurantRegisterForm.controls.restaurantPassword.value + "\"" +
      "}";
    this.restaurantService.registerRestaurant(JSON.parse(restaurantJson)).subscribe(restaurant => {
      let adminJson =
        "{" +
        "\"firstName\" : \"" + this.newRestaurantRegisterForm.controls.firstName.value + "\"," +
        "\"lastName\" : \"" + this.newRestaurantRegisterForm.controls.lastName.value + "\"," +
        "\"username\" : \"" + this.newRestaurantRegisterForm.controls.username.value + "\"," +
        "\"password\" : \"" + this.newRestaurantRegisterForm.controls.password.value + "\"," +
        "\"restaurant\" : null" +
        "}";
      this.accountService.registerAdmin(JSON.parse(adminJson)).subscribe(admin => {
        this.restaurantService.addAdmin(restaurant, admin.id).subscribe(restaurant => {
          this.storage.store("restaurant", restaurant);
          this.storage.store("admin", admin);
        });
      });
    });
    this.router.navigate(['/home']);
  }

  onSubmitExistingRestaurant() {
    this.submitted = true;
    let adminJson =
      "{" +
      "\"firstName\" : \"" + this.existingRestaurantRegisterForm.controls.firstName2.value + "\"," +
      "\"lastName\" : \"" + this.existingRestaurantRegisterForm.controls.lastName2.value + "\"," +
      "\"username\" : \"" + this.existingRestaurantRegisterForm.controls.username2.value + "\"," +
      "\"password\" : \"" + this.existingRestaurantRegisterForm.controls.password2.value + "\"," +
      "\"restaurant\" : null" +
      "}";
    let restaurantId: number = this.existingRestaurantRegisterForm.controls.restaurantId.value;
    this.accountService.registerAdmin(JSON.parse(adminJson)).subscribe(admin => {
      this.accountService.adminUpdateRestaurant(restaurantId, admin).subscribe(admin => {
        this.restaurantService.findById(admin.restaurant.id).subscribe(restaurant => {
          this.storage.store("restaurant", restaurant);
          admin.restaurant = restaurant;
          this.storage.store("admin", admin);
          this.router.navigate(['/home']);
        });
      });
    });
  }

  makeNewRestaurant(): void {
    this.newRestaurant = true;
    this.existingRestaurant = false;
  }

  useExistingRestaurant(): void {
    this.existingRestaurant = true;
    this.newRestaurant = false;
  }
}
