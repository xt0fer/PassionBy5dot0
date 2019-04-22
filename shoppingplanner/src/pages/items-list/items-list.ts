import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AccountShoppingItem } from '../../account-shoppingitem';
import { ShoppingItemsProvider } from '../../providers/shopping-items/shopping-items';
import { UserProvider } from '../../providers/user/user';

/**
 * Generated class for the ItemsListPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-items-list',
  templateUrl: 'items-list.html',
})
export class ItemsListPage {
  shoppingItems : AccountShoppingItem[];
  constructor(public navCtrl: NavController, public navParams: NavParams,
    private shoppingItemProvider : ShoppingItemsProvider,
    private userProvider:UserProvider) {

      let user = this.userProvider.getLoggedInUser();
      this.shoppingItemProvider.getShoppingItemsForAccount(user.activeAccount.id)
        .subscribe(shoppingItems => {
          this.shoppingItems = shoppingItems;
         }, error => console.log("Error response : " + error));
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ItemsListPage');
  }
  onDeleteItem(item : AccountShoppingItem, index : number){
    this.shoppingItemProvider.deleteShoppingItem(item.id)
    .subscribe(response => {
      this.shoppingItems.splice(index, 1);
     }, error => console.log("Error response : " + error));

  }
}
