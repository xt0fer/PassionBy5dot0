import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";
import {RestaurantService} from "../../../services/restaurant.service";

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean;
  response: any;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService,
              private storage: LocalStorageService,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.submitted = false;
    this.loginForm = this.formBuilder.group({
      username: '',
      password: ''
    });
  }

  onSubmit() {
    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;
    this.accountService.loginAdmin(username, password).subscribe(success => {
      this.response = success;
      this.submitted = true;
      if (this.response instanceof Object) {
        this.updateRestaurant(username);
        this.router.navigate(["/home"]);
      }
    });
  }

  updateRestaurant(username: string) {
    this.accountService.findAdminByUsername(username).subscribe(admin => {
      this.storage.store("restaurant", admin.restaurant);
    });
  }
}
