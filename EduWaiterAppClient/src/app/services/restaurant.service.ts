import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AdminAccount} from "../models/admin-account";
import {Observable} from "rxjs";
import {Restaurant} from "../models/restaurant";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private url = "/api/restaurants"

  constructor(private http: HttpClient) { }

  registerRestaurant(restaurant: Restaurant): Observable<Restaurant> {
    return this.http.post<Restaurant>(this.url, restaurant, httpOptions);
  }
}
