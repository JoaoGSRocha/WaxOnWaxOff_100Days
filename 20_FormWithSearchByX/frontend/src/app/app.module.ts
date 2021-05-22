import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductSingleComponent } from './product-single/product-single.component';
import {FormsModule} from "@angular/forms";
import { ProductComponent } from './product/product.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {path: 'expansion/:id', component: ProductComponent},
  {path: 'expansion', component: ProductComponent},
  {path: 'skin', component: ProductComponent},
  {path: '', redirectTo: '/skins', pathMatch: 'full'},
  {path: '**', redirectTo: '/skins', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductSingleComponent,
    ProductComponent,
    ProductCategoryMenuComponent
  ],
    imports: [
        RouterModule.forRoot(routes),
        BrowserModule,
        // import HttpClientModule after BrowserModule.
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
