import { Component, OnInit } from '@angular/core';
import {EmployeeAccount} from "../../../models/employee-account";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  currentEmployee: EmployeeAccount;

  constructor(private storage: LocalStorageService) { }

  ngOnInit() {
    this.currentEmployee = this.storage.retrieve("employee");
  }

}
