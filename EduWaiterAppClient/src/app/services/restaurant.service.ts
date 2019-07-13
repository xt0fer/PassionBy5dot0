import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";
import {map} from "rxjs/operators";
import {LocalStorageService} from "ngx-webstorage";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private url = "/api/restaurants"

  constructor(private http: HttpClient,
              private storage: LocalStorageService) { }

  registerRestaurant(restaurant: Restaurant): Observable<Restaurant> {
    return this.http.post<Restaurant>(this.url, restaurant, httpOptions);
  }

  findById(id: number): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${this.url}/${id}`);
  }

  loginRestaurant(id: number, password: string): any {
    return this.findById(id).pipe(
      map(restaurant => {
        this.storage.store("restaurant", restaurant);
        if(restaurant == null){
          return "Invalid Restaurant Id!";
        }
        return restaurant;
      }),
      map(restaurant => {
        if(restaurant != "Invalid Restaurant Id!"){
          if((restaurant as Restaurant).password !== password){
            return "Invalid Password!";
          }
        }
        return restaurant;
      }),
      map(restaurant => {
        if((restaurant != "Invalid Restaurant Id!") && (restaurant != "Invalid Password!")){
          return this.storage.retrieve("restaurant");
        }
        return restaurant;
      })
    );
  }

  addAdmin(restaurant: Restaurant, adminId: number): Observable<Restaurant> {
    return this.http.put<Restaurant>(`${this.url}/addAdmin/${adminId}`, restaurant, httpOptions);
  }

  addEmployee(restaurant: Restaurant, employeeId: number): Observable<Restaurant> {
    return this.http.put<Restaurant>(`${this.url}/addEmployee/${employeeId}`, restaurant, httpOptions);
  }

  addMenu(restaurant: Restaurant, menuId: number): Observable<Restaurant> {
    return this.http.put<Restaurant>(`${this.url}/addMenu/${menuId}`, restaurant, httpOptions);
  }
}
