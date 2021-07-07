import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { ListPage } from '../pages/list/list';
import { ItemsListPage } from '../pages/items-list/items-list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { UserProvider } from '../providers/user/user';
import { HttpClientModule }    from '@angular/common/http';
import { LoginPage } from '../pages/login/login';
import { CategoryProvider } from '../providers/category/category';
import { CategoryPage } from '../pages/category/category';
import { ShoppingItemsProvider } from '../providers/shopping-items/shopping-items';
import { ShoppingItemsPage } from '../pages/shopping-items/shopping-items';

@NgModule({
  declarations: [
    MyApp,
    ItemsListPage,
    LoginPage,
    CategoryPage,
    ShoppingItemsPage,
    ListPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    ItemsListPage,
    LoginPage,
    CategoryPage,
    ShoppingItemsPage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    UserProvider,
    CategoryProvider,
    ShoppingItemsProvider
  ]
})
export class AppModule {}
