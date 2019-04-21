import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {LocalStorageService} from "ngx-webstorage";
import {RestaurantService} from "../../../services/restaurant.service";

@Component({
  selector: 'app-restaurant-register',
  templateUrl: './restaurant-register.component.html',
  styleUrls: ['./restaurant-register.component.css']
})
export class RestaurantRegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted: boolean;


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private restaurantService: RestaurantService,
              private storage: LocalStorageService) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: '',
      password: ''
    });
  }

  onSubmit() {
    this.submitted = true;
    this.restaurantService.registerRestaurant(this.registerForm.value).subscribe(
      restaurant=> {
        this.restaurantService.addAdmin(restaurant, this.storage.retrieve("admin").id).subscribe(restaurant =>{
          this.storage.store("restaurant", restaurant);
        });
      }
    );
    this.router.navigate(['/home']);
  }
}
