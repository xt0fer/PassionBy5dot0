import {MenuItem} from "./menu-item";
import {Restaurant} from "./restaurant";

export class Menu {

  id: number;
  name: string;
  description: string;
  menuItems: MenuItem[];
  restaurant: Restaurant;

}
