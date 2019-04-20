import {Ingredient} from "./ingredient";
import {Menu} from "./menu";

export class MenuItem {

  id: number;
  name: string;
  description: string;
  price: number;
  ingredients: Ingredient[];
  menus: Menu[];
}
