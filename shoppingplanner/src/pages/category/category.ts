import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Category } from '../../category';
import { CategoryProvider } from '../../providers/category/category';
import { ShoppingItemsPage } from '../shopping-items/shopping-items';

/**
 * Generated class for the CategoryPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-category',
  templateUrl: 'category.html',
})
export class CategoryPage {
  categories : Category[];
  constructor(public navCtrl: NavController, public navParams: NavParams,
    private categoryProvider: CategoryProvider) {
      this.categoryProvider.getCategory()
        .subscribe(categories => {console.log("here");
          let newCategories : Category[] = [{name: 'All' , description: "List all shopping items", id: 0}];
          this.categories = newCategories.concat(categories);
        }, error => this.logError("Error response"));
  }

  ionViewDidLoad() {
    
  }
  logError(message : string){
      console.log(message);
  }
  itemTapped(event, category) {
    this.navCtrl.push(ShoppingItemsPage, {
      categoryId: category.id
    });
  }
}
