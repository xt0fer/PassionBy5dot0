import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {AccountService} from "../../services/account.service";
import {first} from "rxjs/operators";
import {LocalStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted: boolean;


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private accountService: AccountService,
              private storage: LocalStorageService) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: '',
      lastName: '',
      password: ''
    });
  }

  onSubmit() {
    this.submitted = true;
    this.accountService.registerAdmin(this.registerForm.value).subscribe(
      account => {
        this.storage.store("admin", account);
      }
    );
    console.log(this.storage.retrieve("admin"));
  }

}
