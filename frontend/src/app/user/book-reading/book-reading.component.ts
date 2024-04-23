import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorizationService } from 'src/app/auth/service/authorization.service';
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

  constructor(private readingListService: ReadingListService, private userService: AuthorizationService, private router: Router) {
    let loginUser = localStorage.getItem("userLogged");
    this.findUserLogged(loginUser);
    this.findIfThereIsContentToDisplay();
  }

  ngOnInit(): void {
  }

  findMyReadingList(userId: any) {
    this.readingListService.findMyReadingList(userId).subscribe(data => {
      console.log("Favoritos: ", data);
      this.myReadingList = data;
    }, error => {
      console.log("error", error);
    });
  }

  findUserLogged(loginUser: any) {
    this.userService.getByLogin(loginUser).subscribe(userFound => {
      this.findMyReadingList(userFound.id);
    })
  };

  findIfThereIsContentToDisplay() {
    if (this.myReadingList.length <= 0) {
      setTimeout(() => {
        this.noContent = 'Sem favoritos, pode adicionar!';
        this.bgDanger = 'bg-danger';
      }, 1000);
    }
  }
  delete(id: any) {
    this.readingListService.deleteItemFromMyReadingList(id).subscribe(data => {
      console.log(data);
    })
    // window.location.reload();
  }

  rediretTo() {
    this.router.navigate(['/login']);
  }
}
