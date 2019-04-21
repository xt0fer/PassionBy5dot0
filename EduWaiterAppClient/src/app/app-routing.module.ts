import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AdminRegisterComponent} from "./components/register/admin-register/admin-register.component";
import {RestaurantRegisterComponent} from "./components/register/restaurant-register/restaurant-register.component";
import {EmployeeRegisterComponent} from "./components/register/employee-register/employee-register.component";
import {RegisterComponent} from "./components/register/register/register.component";
import {LoginComponent} from "./components/login/login.component";
import {EmployeeLoginComponent} from "./components/login/employee-login/employee-login.component";
import {AdminLoginComponent} from "./components/login/admin-login/admin-login.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'login/employee', component: EmployeeLoginComponent},
  {path: 'login/admin', component: AdminLoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'register/admin', component: AdminRegisterComponent},
  {path: 'register/restaurant', component: RestaurantRegisterComponent},
  {path: 'register/employee', component: EmployeeRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
