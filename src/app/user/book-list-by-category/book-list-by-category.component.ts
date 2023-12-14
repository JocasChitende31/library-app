import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../../models/book';
import { Category } from '../../models/category';
import { BookServiceService } from '../../services/book-service.service';
import { CategoryService } from '../../services/category.service';
@Component({
  selector: 'app-book-list-by-category',
  templateUrl: './book-list-by-category.component.html',
  styleUrls: ['./book-list-by-category.component.css']
})
export class BookListByCategoryComponent implements OnInit {
  qtd: Number = 0;
  categories: Category[] = [];
  categoryId: Category | undefined;
  books: Book[] = [];
  id: Number | undefined;
  currentCategory: Category[] = [];

  constructor(
    private categoryService: CategoryService,
    private bookService: BookServiceService,
    private route: ActivatedRoute,
    private router: Router,
    @Inject(DOCUMENT) private _document: Document

  ) {
    this.id = this.route.snapshot.params['id'];
    // this.route.params.subscribe(params => {
    //   this.id = params['id'];
    // })
  }

  ngOnInit(): void {

    const catId = this.route.snapshot.params['id'];
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
    this.bookService.findBookByCategoryId(catId).subscribe(data => {
      this.books = data;
      let i = 0;
      for (let index = 0; index < data.length; index++) {
        i++;
        this.qtd = i;
      }
    })
    this.categoryService.findById(catId).subscribe(result => {
      this.categoryId = result;
    })
    this.goToCategory();
  }
  goToCategory() {
    this.router.navigate([`/${this.id}/category`])
  }
  reload() {
    this._document.defaultView?.location.reload();
  }
 
}
