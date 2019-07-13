import {Component, OnInit} from '@angular/core';
import {LocalStorageService} from "ngx-webstorage";
import {Menu} from "../../../models/menu";
import {MenuItem} from "../../../models/menu-item";
import {AdminAccount} from "../../../models/admin-account";
import {EmployeeAccount} from "../../../models/employee-account";
import {MenuService} from "../../../services/menu.service";
import {Restaurant} from "../../../models/restaurant";

@Component({
  selector: 'app-menu-detail',
  templateUrl: './menu-detail.component.html',
  styleUrls: ['./menu-detail.component.css']
})
export class MenuDetailComponent implements OnInit {

  menu: Menu;
  menuItems: MenuItem[];
  admin: AdminAccount;
  restaurant: Restaurant;
  employee: EmployeeAccount;
  editing: boolean;

  constructor(private storage: LocalStorageService,
              private menuService: MenuService) {
  }

  ngOnInit() {
    this.menu = this.storage.retrieve("currentMenu");
    this.restaurant = this.storage.retrieve("restaurant");
    this.admin = this.storage.retrieve("admin");
    this.employee = this.storage.retrieve("employee");
  }

  goBack() {
    this.storage.store("currentMenu", null);
  }


  saveDescription() {
    console.log(this.menu);
    this.menuService.updateRestaurant(this.menu, this.restaurant.id).subscribe(updatedMenu => {
      this.menuService.updateDescription(updatedMenu, this.menu.description).subscribe(menu => {
        this.storage.store("currentMenu", menu);
        this.menu = menu;
        console.log(menu);
        this.editing = false;
      });
    });
  }


  addMenuItem() {
  }

}
