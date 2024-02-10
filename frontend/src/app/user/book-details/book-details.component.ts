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
  id: Number | undefined;
  constructor(
    private bookService: BookServiceService,
    private route: ActivatedRoute
  ) {
    this.getBookItem();
  }

  ngOnInit(): void {
    
  }
  getBookItem(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.bookService.findById(id).subscribe(data => {
      this.book = data;
    })
  }


}
