import { Component, OnInit } from '@angular/core';
import {LocalStorageService} from "ngx-webstorage";
import {AdminAccount} from "../../models/admin-account";
import {EmployeeAccount} from "../../models/employee-account";
import {AccountService} from "../../services/account.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentAdmin: AdminAccount;
  currentEmployee: EmployeeAccount;
  loggedIn: boolean;

  constructor(private storage: LocalStorageService,
              private accountService: AccountService) { }

  ngOnInit() {
    this.currentAdmin = this.storage.retrieve("admin");
    this.currentEmployee = this.storage.retrieve("employee");
    this.loggedIn = this.currentEmployee != null || this.currentAdmin != null;
  }

  ngAfterContentChecked(){
    this.currentAdmin = this.storage.retrieve("admin");
    this.currentEmployee = this.storage.retrieve("employee");
    this.loggedIn = this.currentEmployee != null || this.currentAdmin != null;
  }


  logout(){
    this.accountService.logout();
    this.loggedIn = false;
  }

}
