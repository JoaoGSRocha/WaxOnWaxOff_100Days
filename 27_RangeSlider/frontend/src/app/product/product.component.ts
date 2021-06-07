import { Component, OnInit } from '@angular/core';
import {Skin} from "../common/skin";
import {ProductService} from "../services/product.service";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {LabelType, Options} from '@angular-slider/ngx-slider';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  minValue: number = 100;
  maxValue: number = 400;
  options: Options = {
    floor: 0,
    ceil: 500,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return "<b>Min price:</b> $" + value;
        case LabelType.High:
          return "<b>Max price:</b> $" + value;
        default:
          return "$" + value;
      }
    }
  };

  skins: Skin[] = [];
  currentExpansionId: any = 0;
  currentUnitsInStock: any = 100;
  // @ts-ignore
  public totalAngularPackages;
  constructor(private productService: ProductService,
              private route: ActivatedRoute, private http: HttpClient) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });

    // Simple GET request with response type <any>
    this.http.get<any>('http://localhost:8080/skins').subscribe(data => {
      this.totalAngularPackages = data._embedded.skins;
    })

    this.http.get<any>('http://localhost:8080/expansion').subscribe(data => {
      this.totalAngularPackages = data._embedded.expansion;
    })
  }

  listProducts() {
    // check if 'id' parameter is available
    const hasExpansionId: boolean = this.route.snapshot.paramMap.has("id");

    const hasUnitsInStock: boolean = this.route.snapshot.paramMap.has("units_in_stock");

    if(hasExpansionId) {
      //get the 'id' param string. convert string to a number using the "+" symbol
      // @ts-ignore
      this.currentExpansionId = +this.route.snapshot.paramMap.get('id');
    }
    else {
      // not category id avialable ... default to category id 1
      this.currentExpansionId = 0;
    }
    if(hasUnitsInStock) {
      // @ts-ignore
      this.currentUnitsInStock = +this.route.snapshot.paramMap.get('units_in_stock');
    }


    // now get the skins for the given expansion id
    this.productService.getProductList(this.currentExpansionId, this.currentUnitsInStock).subscribe(
      data => {
        this.skins = data;
      }
    )
  }

}
