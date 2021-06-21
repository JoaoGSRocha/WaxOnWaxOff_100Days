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

  minValue: any = 0;
  maxValue: any = 40;
  rarity: string = "";
  condition: string = "";
  priceOptions: Options = {
    floor: 0,
    ceil: 40,
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
  currentExpansionId: any = null;
  minStock: any = 0;
  maxStock: any = 300;
  stockOptions: Options = {
    floor: 0,
    ceil: 300,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return "<b>Min Stock Units:</b> " + value;
        case LabelType.High:
          return "<b>Max Stock Units:</b> " + value;
        default:
          return "" + value;
      }
    }
  };
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
    const hasStockMin: boolean = this.route.snapshot.paramMap.has("stockMin");
    const hasStockMax: boolean = this.route.snapshot.paramMap.has("stockMax");
    const hasMinPrice: boolean = this.route.snapshot.paramMap.has("price1");
    const hasMaxPrice: boolean = this.route.snapshot.paramMap.has("price2");
    const hasRarity: boolean = this.route.snapshot.paramMap.has("rarity");
    const hasCondition: boolean = this.route.snapshot.paramMap.has("condition");

    if(hasExpansionId) {
      //get the 'id' param string. convert string to a number using the "+" symbol
      // @ts-ignore
      this.currentExpansionId = +this.route.snapshot.paramMap.get('id');
    }
    else {
      // not category id available ... default to category id 0
      this.currentExpansionId = 0;
    }
    if(hasStockMax) {
      // @ts-ignore
      this.maxStock = +this.route.snapshot.paramMap.get('stockMax');
    }

    // now get the skins for the given expansion id
    this.productService.getProductList(this.currentExpansionId, this.minStock, this.maxStock,
      this.minValue, this.maxValue, this.rarity, this.condition).subscribe(
      data => {
        this.skins = data;
      }
    )
  }

}
