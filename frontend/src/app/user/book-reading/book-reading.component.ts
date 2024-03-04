import { Component, OnInit } from '@angular/core';
import { ReadingList } from 'src/app/models/reading-list';
import { ReadingListService } from 'src/app/services/reading-list.service';

@Component({
  selector: 'app-book-reading',
  templateUrl: './book-reading.component.html',
  styleUrls: ['./book-reading.component.css']
})
export class BookReadingComponent implements OnInit {
  noContent: String = '';
  bgDanger: String = '';
  myReadingList: ReadingList[] = [];

  constructor(private readingListService: ReadingListService ) {
    if (this.myReadingList.length <= 0) {
      setTimeout(() => {
          this.noContent = 'Sem favoritos, pode adicionar!';
          this.bgDanger = 'bg-danger';
        }, 3500);
      }

      /* this.findMyReadingList("bff69d28-25e8-4757-9d5e-ccabb5ea349f"); */
  }


  ngOnInit(): void {
  }

  findMyReadingList(userId:String){
    this.readingListService.findMyReadingList(userId).subscribe(data=>{
      this.myReadingList = data;
    });
  }
}
