import {Component, OnInit} from '@angular/core';
import {LocalStorageService} from "ngx-webstorage";
import {AdminAccount} from "./models/admin-account";
import {EmployeeAccount} from "./models/employee-account";
import {Restaurant} from "./models/restaurant";
import {AccountService} from "./services/account.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'EduWaiter';
  loggedIn: boolean;
  currentEmployee: EmployeeAccount;
  currentAdmin: AdminAccount;
  currentRestaurant: Restaurant;

  constructor(private storage: LocalStorageService,
              private accountService: AccountService){}

  ngOnInit(): void {
    this.currentEmployee = this.storage.retrieve("employee");
    this.currentAdmin = this.storage.retrieve("admin");
    this.loggedIn = this.currentEmployee != null || this.currentAdmin != null;
  }

  ngAfterContentChecked(){
    this.currentAdmin = this.storage.retrieve("admin");
    this.currentEmployee = this.storage.retrieve("employee");
    this.currentRestaurant = this.storage.retrieve("restaurant");
    this.loggedIn = this.currentEmployee != null || this.currentAdmin != null;
  }

  logout(){
    this.accountService.logout();
    this.loggedIn = false;
  }
}
