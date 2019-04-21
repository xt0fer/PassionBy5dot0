import { Component, OnInit } from '@angular/core';
import {LocalStorageService} from "ngx-webstorage";
import {AdminAccount} from "../../models/admin-account";
import {EmployeeAccount} from "../../models/employee-account";
import {AccountService} from "../../services/account.service";
import {Restaurant} from "../../models/restaurant";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../../app.component.css']
})
export class HomeComponent implements OnInit {

  currentAdmin: AdminAccount;
  currentEmployee: EmployeeAccount;
  currentRestaurant: Restaurant;


  constructor(private storage: LocalStorageService) { }

  ngOnInit() {
    this.currentAdmin = this.storage.retrieve("admin");
    this.currentEmployee = this.storage.retrieve("employee");
    this.currentRestaurant = this.storage.retrieve("restaurant");
  }

  ngAfterContentChecked(){
    this.currentAdmin = this.storage.retrieve("admin");
    this.currentEmployee = this.storage.retrieve("employee");
    this.currentRestaurant = this.storage.retrieve("restaurant");
  }


}
