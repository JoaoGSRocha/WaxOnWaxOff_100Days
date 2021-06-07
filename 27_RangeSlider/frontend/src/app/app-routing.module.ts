import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductSingleComponent} from "./product-single/product-single.component";
import {ProductComponent} from "./product/product.component";

const routes: Routes = [
  {
    path: 'product-single',
    component: ProductSingleComponent
  },
  {
    path: 'product',
    component: ProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
