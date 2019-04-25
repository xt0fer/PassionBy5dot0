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

  findEmployeeByUsername(username: string): Observable<EmployeeAccount>{
    return this.http.get<EmployeeAccount>(`${this.url}/employees/username/${username}`)
  }

  loginAdmin(username: string, password: string) {
    return this.findAdminByUsername(username).pipe(
      map(admin => {
        this.storage.store("admin", admin);
        if (admin == null) {
          return "Invalid Username!";
        }
        return admin;
      }),
      map(admin => {
        if (admin != "Invalid Username!") {
          if ((admin as AdminAccount).password !== password) {
            return "Invalid Password!";
          }
        }
        return admin;
      }),
      map(admin => {
        if ((admin != "Invalid Username!") && (admin != "Invalid Password!")) {
          return this.storage.retrieve("admin");
        }
        return admin;
      })
    );
  }

  loginEmployee(username: string, password: string) {
    return this.findEmployeeByUsername(username).pipe(
      map(employee => {
        this.storage.store("employee", employee);
        if (employee == null) {
          return "Invalid Username!";
        }
        return employee;
      }),
      map(employee => {
        if (employee != "Invalid Username!") {
          if ((employee as EmployeeAccount).password !== password) {
            return "Invalid Password!";
          }
        }
        return employee;
      }),
      map(employee => {
        if ((employee != "Invalid Username!") && (employee != "Invalid Password!")) {
          return this.storage.retrieve("employee");
        }
        return employee;
      })
    )
  }

  logout() {
    this.storage.store("admin", null);
    this.storage.store("employee", null);
    this.storage.store("restaurant", null);
  }

  employeeUpdateRestaurant(restaurantId: number,  account: EmployeeAccount): Observable<EmployeeAccount> {
    return this.http.put<EmployeeAccount>(`${this.url}/employees/${account.id}/updateRestaurant?restaurantId=${restaurantId}`, account, httpOptions);
  }


  adminUpdateRestaurant(restaurantId: number,  account: AdminAccount): Observable<AdminAccount> {
    return this.http.put<AdminAccount>(`${this.url}/admin/${account.id}/updateRestaurant?restaurantId=${restaurantId}`, account, httpOptions);
  }

}
