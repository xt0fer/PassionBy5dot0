import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {RestaurantService} from "../../../services/restaurant.service";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-restaurant-login',
  templateUrl: './restaurant-login.component.html',
  styleUrls: ['./restaurant-login.component.css']
})
export class RestaurantLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean;
  response: any;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private restaurantService: RestaurantService,
              private storage: LocalStorageService) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      id: '',
      password: ''
    });
  }

  onSubmit() {
    let id = this.loginForm.controls.id.value;
    let password = this.loginForm.controls.password.value;
    this.restaurantService.loginRestaurant(id, password).subscribe(success => {
      this.response = success;
      this.submitted = true;
      if (this.response instanceof Object) {
        this.router.navigate(["/home"]);
        this.restaurantService.addAdmin(this.response, this.storage.retrieve("admin").id).subscribe(
          restaurant => {
            this.storage.store("restaurant", restaurant)
          });
      }
    });
  }
}
