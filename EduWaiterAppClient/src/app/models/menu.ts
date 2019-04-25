import {MenuItem} from "./menu-item";
import {Restaurant} from "./restaurant";

export class Menu {

  id: number;
  name: string;
  description: string;
  menuItems: MenuItem[];
  restaurant: Restaurant;

  constructor(name: string){
    this.name = name;
    this.description = "";
    this.menuItems = [];
    this.restaurant = null;
  }
}
