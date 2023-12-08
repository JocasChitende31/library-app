import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookServiceService } from '../services/book-service.service';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})

export class BookListComponent implements OnInit {

  books: Book[] = [];

  constructor(
    private bookService: BookServiceService,
  ) {
  }

  ngOnInit(): void {
    this.bookService.findAll().subscribe(data => {
      this.books = data;
    });
  }

}
