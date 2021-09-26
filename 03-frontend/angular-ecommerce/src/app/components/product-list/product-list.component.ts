import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  //initialize product list array
  products: Product[] = [];
  currentCategoryId: number = 1;
  searchMode: boolean = false;

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { } // inject the ActivatedRoute
              // The current active route that loaded the component. Useful for accessing route parameters.


  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {
    
    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    this.handleListProducts();
  }

  handleListProducts() { 
    //check if "id" paramter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if(hasCategoryId && this.route.snapshot.paramMap) {
      // get the "id" param string. convert string to a number using the "+" symbol
      this.currentCategoryId = +!this.route.snapshot.paramMap.get("id");
    }
    else {
      // not category id available ... default to category id 1
      this.currentCategoryId = 1;
    }

    // now get the products for the given category id
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    );
  }

}
