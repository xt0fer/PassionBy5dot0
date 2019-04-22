import { ShoppingItem } from "./shoppingitem";

export class AccountShoppingItem {
    note: string;
    quantity: number = 0;
    shoppingItem : ShoppingItem;
    account : Account;
    id : number;
}