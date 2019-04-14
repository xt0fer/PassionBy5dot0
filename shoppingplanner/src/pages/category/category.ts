import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Category } from '../../category';
import { CategoryProvider } from '../../providers/category/category';

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
        .subscribe(categories => {
          this.categories = categories}, error => this.logError("Error response")
          );
  }

  ionViewDidLoad() {
    
  }
  logError(message : string){
      console.log(message);
  }
  itemTapped(event, category) {
    // That's right, we're pushing to ourselves!
    // this.navCtrl.push(ListPage, {
    //   item: item
    // });
  }
}
