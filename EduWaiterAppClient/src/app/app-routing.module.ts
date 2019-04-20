import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AdminRegisterComponent} from "./components/register/admin-register/admin-register.component";
import {RestaurantRegisterComponent} from "./components/register/restaurant-register/restaurant-register.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'register/admin', component: AdminRegisterComponent},
  {path: 'register/restaurant', component: RestaurantRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
