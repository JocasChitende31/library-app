import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthorizationService } from 'src/app/auth/service/authorization.service';
import { Book } from 'src/app/models/book';
import { Category } from 'src/app/models/category';
import { ReadingListPost } from 'src/app/models/reading-list-post';
import { BookServiceService } from 'src/app/services/book-service.service';
import { CategoryService } from 'src/app/services/category.service';
import { ReadingListService } from 'src/app/services/reading-list.service';
import { FileServService } from 'src/app/services/upload-service/file-serv.service';

@Component({
  selector: 'app-book-list-user',
  templateUrl: './book-list-user.component.html',
  styleUrls: ['./book-list-user.component.css']
})

export class BookListUserComponent implements OnInit {
  user= 'Página Principal'
  serverUnvaliable: String = '';
  bgDanger: String = '';
  qtdT: Number = 0;
  bookId: any;
  books: Book[] = [];
  userLoggedId?: any;
  userLoggedObj: any;
  @Input() categories: Category[] = [];
  linkGenerated = '';
  titleOfBookDownload?: String;
  itemReadingList?: ReadingListPost;


  addToReadListSmsSuccess?: String;

  constructor(
    private bookService: BookServiceService,
    private categoryService: CategoryService,
    private filesService: FileServService,
    private readingListService: ReadingListService,
    private userService: AuthorizationService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
  ) {

    //this.bookId = this.route.snapshot.params['id'];
    const paramId = this.route.snapshot.paramMap;
    this.bookId = Number(paramId.get('id'));
    this.addToReadListSmsSuccess;

  }
  ngOnInit(): void {

    this.findAllBooksAndCategories();
  }

  findAllBooksAndCategories() {
    if (this.books.length <= 0) {
      setTimeout(() => {
        this.serverUnvaliable = 'Serviço temporariamente indisponível';
        this.bgDanger = 'bg-danger';
      }, 3500);
    }
    this.bookService.findAll().subscribe(data => {
      this.books = data;
      this.categoryService.findAll().subscribe(resul => {
        this.categories = resul;
      })
      let i = 0;
      for (let index = 0; index < data.length; index++) {
        i++;
      }
      this.qtdT = i;
    });
  }

  onDelete(bookId: any) {
    this.bookService.deleteBook(bookId).subscribe(data => {
      // console.log(bookId);
      this.goToBookList();
    })
  }

  goToBookList() {
    this.router.navigate(['/books']);
    window.location.reload();
  }

  downloadFile(fielId: any) {
    if (fielId !== null) {
      this.filesService.downloadFile(fielId).subscribe(data => {
        var obj = JSON.parse(JSON.stringify(data));
        this.books.forEach(element => {
          if (element.downloaderRefPDF === fielId) {
            this.titleOfBookDownload = element.title;
            console.log(this.titleOfBookDownload);
          }
        });
        const downloadLink = obj['url'];
        this.linkGenerated = downloadLink;
      })
    }
    this.titleOfBookDownload = 'Indisponível';

  }

  saveItemToReadingList(idBook: any) {
    let userLogged = localStorage.getItem('userLogged');

    if (userLogged != null) {
      this.userService.getByName(userLogged).subscribe(user => {
        this.bookService.findById(idBook).subscribe(book => {
          this.itemReadingList = new ReadingListPost('', user, book);
          // console.log(" reading object", { user, book });
          this.readingListService.saveToMyReadingList(this.itemReadingList).subscribe(item => {
            this.addToReadListSmsSuccess = 'Livro Adicionado a Lista' + item;
          });
        })
      })
    } else {
      this.router.navigate(['/login']);
    }
  }

}
