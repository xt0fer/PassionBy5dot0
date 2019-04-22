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
  loggedInUser :User;
  constructor(public http: HttpClient) {
    console.log('Hello UserProvider Provider');
  }

   //checkUserUrl = 'http://192.168.3.101:8080//user/checklogin'
   checkUserUrl = 'http://localhost:8080//user/checklogin'
 
  /** GET heroes from the server */
  checkUserLogin (user: User): Observable<User> {
        return this.http.put<User>(this.checkUserUrl, user);
  }
  setUserLoggedIn(logInSuccessful : boolean){
    this.loggedIn = logInSuccessful;
    if(logInSuccessful == false){
      this.loggedInUser = null;
    }
  }
  setUser(user : User){
    this.loggedInUser = user;
  }
  getLoggedInUser(){
    return this.loggedInUser;
  }
  isUserLoggedIn(){
    return this.loggedIn;
  }
  
}
