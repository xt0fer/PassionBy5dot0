import {Component, OnInit} from '@angular/core';
import {Menu} from "../../models/menu";
import {Restaurant} from "../../models/restaurant";
import {LocalStorageService} from "ngx-webstorage";
import {MenuService} from "../../services/menu.service";
import {RestaurantService} from "../../services/restaurant.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  employee: Account;
  admin: Account;
  restaurant: Restaurant;
  currentMenu: Menu;
  newMenuName: string;
  dropdown: any;

  constructor(private storage: LocalStorageService,
              private menuService: MenuService,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.dropdown = document.getElementById("dropdown");
    this.admin = this.storage.retrieve("admin");
    this.employee = this.storage.retrieve("employee");
    this.restaurantService.findById(this.storage.retrieve("restaurant").id).subscribe(restaurant => {
      this.populateDropdown(restaurant.menus);
      this.restaurant = restaurant;
    });
  }

  addMenu() {
    this.menuService.createMenu(new Menu(this.newMenuName)).subscribe(newMenu => {
      this.restaurantService.addMenu(this.restaurant, newMenu.id).subscribe(restaurant => {
        this.storage.store("restaurant", restaurant);
        this.currentMenu = newMenu;
        this.dropdown[this.dropdown.options.length] = new Option(newMenu.name);
      });
    });

  }

  populateDropdown(menus: Menu[]) {
    for (let i = 0; i < menus.length; i++) {
      this.dropdown.options[this.dropdown.options.length] = new Option(menus[i].name);
    }
  }

}
