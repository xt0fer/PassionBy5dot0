import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AdminAccount} from "../models/admin-account";
import {Observable} from "rxjs";
import {map} from 'rxjs/operators';
import {EmployeeAccount} from "../models/employee-account";
import {LocalStorageService} from "ngx-webstorage";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class AccountService {

  private url = "/api/accounts";

  constructor(private http: HttpClient,
              private storage: LocalStorageService) {
  }

  registerAdmin(adminAccount: AdminAccount): Observable<AdminAccount> {
    return this.http.post<AdminAccount>(`${this.url}/admin`, adminAccount, httpOptions);
  }

  registerEmployee(employeeAccount: EmployeeAccount): Observable<EmployeeAccount> {
    return this.http.post<EmployeeAccount>(`${this.url}/employees`, employeeAccount, httpOptions);
  }

  findAdminByUsername(username: string): Observable<AdminAccount> {
    return this.http.get<AdminAccount>(`${this.url}/admin/username/${username}`);
  }

  loginAdmin(username: string, password: string){
   return this.findAdminByUsername(username).pipe(
      map(admin => {
        this.storage.store("admin", admin);
          if (admin == null) {
            return "Invalid username!";
          }
          return admin;
        }),
      map(admin => {
        if(admin != "Invalid username!") {
          if (admin.password !== password) {
            return "Invalid password!";
          }
        }
        return admin;
      }),
     map( admin => {
       if((admin != "Invalid username!") && (admin != "Invalid password!")) {
         return this.storage.retrieve("admin");
       }
       return admin;
     })
   );
  }

}
