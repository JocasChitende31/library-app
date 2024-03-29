import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../../models/book';
import { BookServiceService } from '../../services/book-service.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  book: Book | undefined;
  idBook: Number | undefined;
  constructor(
    private bookService: BookServiceService,
    private route: ActivatedRoute
  ) {
    const id = this.route.snapshot.paramMap;
    this.idBook = Number(id.get('id'));
  }

  ngOnInit(): void {
    this.getBookItem(this.idBook);
  }
  
  getBookItem(id: any){
    this.bookService.findById(id).subscribe(data => {
      this.book = data;
    })
  }


}
