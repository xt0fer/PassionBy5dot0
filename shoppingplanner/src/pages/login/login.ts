import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { UserProvider } from '../../providers/user/user';
import { User } from '../../user';
import { ItemsListPage } from '../items-list/items-list';
/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  username : string;
  password : string;
  constructor(public navCtrl: NavController,
    private userProvider : UserProvider) {
      this.username = "";
      this.password = "";
      userProvider.setUserLoggedIn(false);
  }
  onClick(){
    let user = new User();
    console.log(this.username+ " " + this.password);
    user.userName=this.username;
    user.password = this.password;
    this.userProvider.checkUserLogin(user)
        .subscribe(user => {
          this.doUserLogin(user)},error => this.doUserLogin(null)
          );
  }

  doUserLogin(user : User){
    if(user != null){
      this.userProvider.setUserLoggedIn(true);
      this.navCtrl.setRoot(ItemsListPage)
    }
    else
      console.log("login failed");
  }

}

