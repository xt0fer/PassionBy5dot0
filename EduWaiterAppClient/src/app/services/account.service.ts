import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AdminAccount} from "../models/admin-account";
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class AccountService {

  private url = "/api/accounts"

  constructor(private http: HttpClient) { }

  registerAdmin(adminAccount: AdminAccount): Observable<AdminAccount> {
    return this.http.post<AdminAccount>(`${this.url}/admin`, adminAccount, httpOptions);
  }

}
