import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AdminRegisterComponent} from "./components/admin-register/admin-register.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'register/admin', component: AdminRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
