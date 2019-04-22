import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ShoppingItemsProvider } from '../../providers/shopping-items/shopping-items';
import { ShoppingItem } from '../../shoppingitem';
import { UserProvider } from '../../providers/user/user';
import { AccountShoppingItem } from '../../account-shoppingitem';

/**
 * Generated class for the ShoppingItemsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-shopping-items',
  templateUrl: 'shopping-items.html',
})
export class ShoppingItemsPage {
  categoryId: any;
  shoppingItems : ShoppingItem[];
  show : boolean = false;
  selectedIdx = -1;
  note : string;
  quantity : number;
  constructor(public navCtrl: NavController, public navParams: NavParams,
    private shoppingItemProvider : ShoppingItemsProvider,
    private userProvider:UserProvider) {
    this.categoryId = navParams.get('categoryId');
    this.shoppingItemProvider.getShoppingItemsForCategory(this.categoryId)
        .subscribe(shoppingItems => {
          this.shoppingItems = shoppingItems;
         }, error => console.log("Error response : " + error));
  }
  itemTapped(event, index) {
   this.show = true;
   this.selectedIdx = index;
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad ShoppingItemsPage');
  }
  onCancelAddItem(){
    this.show = false;
  }
  onAddItem(){
    let user = this.userProvider.getLoggedInUser();
    let accountShoppingItem = new AccountShoppingItem();
    accountShoppingItem.note = this.note;
    accountShoppingItem.quantity = this.quantity;

    this.shoppingItemProvider.addShoppingItem(user.activeAccount.id, 
      this.shoppingItems[this.selectedIdx].id, accountShoppingItem).subscribe(
        something=>console.log(something), error=>console.log(error));
    this.show = false;  
  }
}
