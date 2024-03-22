import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthorizationService } from 'src/app/auth/service/authorization.service';
import { Book } from 'src/app/models/book';
import { Category } from 'src/app/models/category';
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

  addToReadingListForm: FormGroup;

  addToReadListSmsSuccess = '';

  constructor(
    private bookService: BookServiceService,
    private categoryService: CategoryService,
    private filesService: FileServService,
    private readingListService: ReadingListService,
    private userService: AuthorizationService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) {


    this.bookId = this.route.snapshot.params['id'];
    if (this.books.length <= 0) {
      setTimeout(() => {
        this.serverUnvaliable = 'Serviço temporariamente indisponível';
        this.bgDanger = 'bg-danger';
      }, 3500);
    }

    let userLogged = localStorage.getItem('userLogged');
    if (userLogged != null) {
      this.userService.getByName(userLogged).subscribe(data => {
        console.info("Normalized data", data);
        this.userLoggedId = data;
        this.userLoggedObj = data;
      })
    }

    this.addToReadingListForm = this.formBuilder.group({
      id: [null],
      user: [null],
      book: [null]
    });
  }
  ngOnInit(): void {
    this.bookId = this.route.snapshot.paramMap.get('id');
    this.findAllBook();
    this.findAllCategory();
  }

  findAllBook() {
    this.bookService.findAll().subscribe(data => {
      this.books = data;

      let i = 0;
      for (let index = 0; index < data.length; index++) {
        i++;
      }
      this.qtdT = i;
    });
  }

  findAllCategory() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
  }

  onDelete(bookId: any) {
    this.bookService.deleteBook(bookId).subscribe(data => {
      console.log(bookId);
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

  saveItemToReadingList() {
    console.info("Submission", this.addToReadingListForm.value)

    this.readingListService.saveToMyReadingList(this.addToReadingListForm.value).subscribe(item => {
      this.addToReadListSmsSuccess = 'Livro Adicionado a Lista';
      console.info(item.id);
    })
  }
}
