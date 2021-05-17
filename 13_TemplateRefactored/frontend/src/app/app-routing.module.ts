import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductSingleComponent} from "./product-single/product-single.component";

const routes: Routes = [
  {
    path: 'product-single',
    component: ProductSingleComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
