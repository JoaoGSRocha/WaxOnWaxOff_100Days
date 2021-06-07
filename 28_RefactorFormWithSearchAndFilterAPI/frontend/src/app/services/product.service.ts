import {Component, Injectable} from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Skin} from "../common/skin";
import {map} from "rxjs/operators";
import {Expansion} from "../common/expansion";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/skins';

  private expansionUrl = 'http://localhost:8080/expansion';

  constructor(private http: HttpClient) { }
  getProductList(): Observable<Skin[]>;
  getProductList(thisCategoryId: number): Observable<Skin[]>;
  getProductList(thisCategoryId: number, theUnitStock: number): Observable<Skin[]>;
  getProductList(theCategoryId?: number, theUnitStock?: number): Observable<Skin[]>  {
    let searchUrl = '';
    if(!theCategoryId && !theUnitStock && theUnitStock !== 0){
      searchUrl = `${this.baseUrl}`;
    }
    else if(!theCategoryId)
      searchUrl = `${this.baseUrl}/search/findByUnitsInStockLessThanEqual?units_in_stock=${theUnitStock}`;
    else if(!theUnitStock && theUnitStock !== 0)
      searchUrl = `${this.baseUrl}/search/findByExpansionId?id=${theCategoryId}`;
    else
      searchUrl = `${this.baseUrl}/search/findByExpansionIdAndUnitsInStockLessThanEqual?id=${theCategoryId}
        &units_in_stock=${theUnitStock}`;

    return this.http.get<GetResponseSkins>(searchUrl).pipe(
      map(response => response._embedded.skins)
    )
  }


  getProductExpansions(): Observable<Expansion[]>{
    return this.http.get<GetResponseExpansion>(this.expansionUrl).pipe(
      map(response => response._embedded.expansion)
    )
  }
}

interface GetResponseSkins {
  _embedded: {
    skins: Skin[];
  }
}

interface GetResponseExpansion {
  _embedded: {
    expansion: Expansion[];
  }
}
