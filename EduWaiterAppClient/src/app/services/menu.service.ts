import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Menu} from "../models/menu";
import {Observable} from "rxjs";



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})


export class MenuService {

  url: string = "/api/menus"

  constructor(private http: HttpClient) {
  }

  createMenu(menu: Menu): Observable<Menu> {
    return this.http.post<Menu>(this.url, menu, httpOptions);
  }
}
