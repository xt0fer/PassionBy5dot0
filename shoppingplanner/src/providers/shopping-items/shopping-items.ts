import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ShoppingItem } from '../../shoppingitem';
import { AccountShoppingItem } from '../../account-shoppingitem';

/*
  Generated class for the ShoppingItemsProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ShoppingItemsProvider {

  constructor(public http: HttpClient) {
    console.log('Hello ShoppingItemsProvider Provider');
  }
  // getShoppingItemUrl = 'http://192.168.3.101:8080/category/'
  // getAllShoppingItemUrl = 'http://192.168.3.101:8080/shoppingitem/all'
  getShoppingItemUrl = 'http://localhost:8080/category/'
  getAllShoppingItemUrl = 'http://localhost:8080/shoppingitem/all'
 
  getShoppingItemsForCategory (categoryId: number): Observable<ShoppingItem[]> {
    console.log("trying to get categories");
    if(categoryId == 0)
        return this.http.get<ShoppingItem[]>(this.getAllShoppingItemUrl);
    else
        return this.http.get<ShoppingItem[]>(this.getShoppingItemUrl + categoryId);
  }

  addShoppingItem (accountId: number, shoppingitemId: number,
    accountShoppingItem : AccountShoppingItem): Observable<AccountShoppingItem> {
      console.log(accountShoppingItem.note+"---"+accountShoppingItem.quantity+"********")
      let url = "http://localhost:8080/account/"+accountId+
      "/shoppingitem/"+shoppingitemId;
      console.log(url);
        return this.http.post<AccountShoppingItem>(url, accountShoppingItem);
  }
 
  getShoppingItemsForAccount (accountId: number): Observable<AccountShoppingItem[]> {
      let url = "http://localhost:8080/account/"+accountId+"/shoppingitem/all";
      console.log(url);
      return this.http.get<AccountShoppingItem[]>(url);
  }

  deleteShoppingItem(accountShoppingItemId : number):Observable<any>{
    let url = "http://localhost:8080/account/shoppingitem/" + accountShoppingItemId;
    console.log(url);
    return this.http.delete(url);
  }
}
