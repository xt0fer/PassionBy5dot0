import { Component, OnInit } from '@angular/core';
import {Restaurant} from "../../models/restaurant";
import {LocalStorageService} from "ngx-webstorage";
import {Menu} from "../../models/menu";

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  currentRestaurant: Restaurant;
  currentMenu: Menu;

  constructor(private storage: LocalStorageService) { }

  ngOnInit() {
    this.currentMenu = null;
    this.storage.store("currentMenu", null);
    this.currentRestaurant = this.storage.retrieve("restaurant");
  }

  ngDoCheck(){
    this.currentMenu = this.storage.retrieve("currentMenu");
  }

}
