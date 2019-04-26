import {Component, OnInit} from '@angular/core';
import {Menu} from "../../models/menu";
import {Restaurant} from "../../models/restaurant";
import {LocalStorageService} from "ngx-webstorage";
import {MenuService} from "../../services/menu.service";
import {RestaurantService} from "../../services/restaurant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  employee: Account;
  admin: Account;
  restaurant: Restaurant = new Restaurant();
  currentMenu: Menu;
  newMenuName: string;
  selectedLevel: any;

  constructor(private storage: LocalStorageService,
              private menuService: MenuService,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.currentMenu = null;
    this.storage.store("currentMenu", null);
    this.admin = this.storage.retrieve("admin");
    this.employee = this.storage.retrieve("employee");
    this.restaurantService.findById(this.storage.retrieve("restaurant").id).subscribe(restaurant => {
      this.restaurant = restaurant;
    });
  }

  selected() {
    if (this.selectedLevel) {
      this.storage.store("currentMenu", this.selectedLevel);
    }
  }


  addMenu() {
    if (this.newMenuName) {
      this.menuService.createMenu(new Menu(this.newMenuName)).subscribe(newMenu => {
        this.restaurantService.addMenu(this.restaurant, newMenu.id).subscribe(restaurant => {
          this.storage.store("restaurant", restaurant);
          this.storage.store("currentMenu", newMenu);
          this.restaurant = restaurant;
          this.currentMenu = newMenu;
        });
      });
    }

  }
}
