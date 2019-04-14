import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../user';

/*
  Generated class for the UserProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class UserProvider {
  loggedIn = false; 
  constructor(public http: HttpClient) {
    console.log('Hello UserProvider Provider');
  }
  checkUserUrl = 'http://localhost:8080//user/checklogin'
  
  /** GET heroes from the server */
  checkUserLogin (user: User): Observable<User> {
        return this.http.put<User>(this.checkUserUrl, user);
  }
  setUserLoggedIn(logInSuccessful : boolean){
    this.loggedIn = logInSuccessful;
  }
  isUserLoggedIn(){
    return this.loggedIn;
  }
  
}
