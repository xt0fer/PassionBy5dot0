import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {AccountService} from "../../../services/account.service";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-employee-login',
  templateUrl: './employee-login.component.html',
  styleUrls: ['./employee-login.component.css']
})
export class EmployeeLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean;
  response: any;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: '',
      password: ''
    });
  }

  onSubmit() {
    let username = this.loginForm.controls.username.value;
    let password = this.loginForm.controls.password.value;
    this.accountService.loginEmployee(username, password).subscribe(success => {
      this.response = success;
      this.submitted = true;
      if(this.response instanceof Object){
        this.router.navigate(["/home"]);
      }
    });
  }
}
