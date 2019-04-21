import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";
import {Local} from "protractor/built/driverProviders";
import {AdminAccount} from "../../../models/admin-account";

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean;
  response: any;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService) {
  }

  ngOnInit() {
    this.submitted = false;
    this.loginForm = this.formBuilder.group({
      username: '',
      password: ''
    });
  }

  onSubmit() {
    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;
    this.accountService.loginAdmin(username, password).subscribe(success => {
      this.response = success;
      this.submitted = true;
      if(this.response instanceof Object){
        this.router.navigate(["/home"]);
      }
    });
  }
}
