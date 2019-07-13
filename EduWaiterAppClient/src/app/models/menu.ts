import {MenuItem} from "./menu-item";
import {Restaurant} from "./restaurant";

export class Menu {

  id: number;
  name: string;
  description: string;
  menuItems: MenuItem[];
  restaurant: Restaurant;

  constructor(id, name, description, menuItems, restaurant){
    this.id = id;
    this.name = name;
    this.description = description;
    this.menuItems = menuItems;
    this.restaurant = restaurant;
  }
}
