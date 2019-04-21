import { Component, OnInit } from '@angular/core';
import {AdminAccount} from "../../../models/admin-account";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  currentAdmin: AdminAccount;

  constructor(private storage: LocalStorageService) { }

  ngOnInit() {
    this.currentAdmin = this.storage.retrieve("admin");
  }

}
