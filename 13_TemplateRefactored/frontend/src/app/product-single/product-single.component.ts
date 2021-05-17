import { Component, OnInit } from '@angular/core';
import { HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-product-single',
  templateUrl: './product-single.component.html',
  styleUrls: ['./product-single.component.css']
})
export class ProductSingleComponent implements OnInit {

  // @ts-ignore
  public totalAngularPackages;

  public name="";
  public condition="";

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // Simple GET request with response type <any>
    this.http.get<any>('http://localhost:8080/api/skin').subscribe(data => {
      this.totalAngularPackages = data.total;
    })
  }
}
