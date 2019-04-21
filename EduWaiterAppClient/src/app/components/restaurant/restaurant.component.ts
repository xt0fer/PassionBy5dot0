import { Component, OnInit } from '@angular/core';
import {Restaurant} from "../../models/restaurant";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  currentRestaurant: Restaurant;

  constructor(private storage: LocalStorageService) { }

  ngOnInit() {
    this.currentRestaurant = this.storage.retrieve("restaurant");
  }

}
