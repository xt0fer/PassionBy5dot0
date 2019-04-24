import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AdminRegisterComponent } from './components/register/admin-register/admin-register.component';
import {LocalStorageService, NgxWebstorageModule} from "ngx-webstorage";
import {HttpClientModule} from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {AccountService} from "./services/account.service";
import { ShowHidePasswordModule } from 'ngx-show-hide-password';
import { EmployeeRegisterComponent } from './components/register/employee-register/employee-register.component';
import { RegisterComponent } from './components/register/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { EmployeeLoginComponent } from './components/login/employee-login/employee-login.component';
import { AdminLoginComponent } from './components/login/admin-login/admin-login.component';
import { AdminHomeComponent } from './components/home/admin-home/admin-home.component';
import { EmployeeHomeComponent } from './components/home/employee-home/employee-home.component';
import { RestaurantComponent } from './components/restaurant/restaurant.component';
import { MenuComponent } from './components/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminRegisterComponent,
    EmployeeRegisterComponent,
    RegisterComponent,
    LoginComponent,
    EmployeeLoginComponent,
    AdminLoginComponent,
    AdminHomeComponent,
    EmployeeHomeComponent,
    RestaurantComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ShowHidePasswordModule,
    NgxWebstorageModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
