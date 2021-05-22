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

  getProductList(theCategoryId: number): Observable<Skin[]>  {
    const searchUrl = `${this.baseUrl}/search/findByExpansionId?id=${theCategoryId}`

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
