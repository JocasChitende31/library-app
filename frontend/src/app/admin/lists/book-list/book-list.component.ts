import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FileServService } from 'src/app/services/upload-service/file-serv.service';
import { Book } from '../../../models/book';
import { Category } from '../../../models/category';
import { BookServiceService } from '../../../services/book-service.service';
import { CategoryService } from '../../../services/category.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
// Serviço temporariamente indisponível
export class BookListComponent implements OnInit {
  serverUnvaliable: String = '';
  linkGenerated = '';
  bgDanger: String = '';
  qtdT: Number = 0;
  bookId: Number;
  books: Book[] = [];
  categories: Category[] = [];
  userLogged: [] = [];
  admin = localStorage.getItem('role');

  titleOfBookDownload?: String;


  constructor(
    private bookService: BookServiceService,
    private categoryService: CategoryService,
    private filesService: FileServService,
    private route: ActivatedRoute,
    private router: Router
  ) {

    this.bookId = this.route.snapshot.params['id'];

    this.findAllBook();
    this.findAllCategories();
    this.servicerNotAvaileble();


  }

  ngOnInit(): void {

  }

  findAllBook() {
    this.bookService.findAll().subscribe(data => {
      this.books = data;
      console.log(data);

      let i = 0;
      for (let index = 0; index < data.length; index++) {
        i++;
      }
      this.qtdT = i;
    });
  }
  findAllCategories() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;

    })
  }
  onDelete(bookId: any) {
    this.bookService.deleteBook(bookId).subscribe(data => {
      this.goToBookList();
    })
  }
  goToBookList() {
    this.router.navigate(['/books']);
    window.location.reload();
  }
  servicerNotAvaileble() {
    if (this.books.length <= 0) {
      setTimeout(() => {
        this.serverUnvaliable = 'Serviço temporariamente indisponível';
        this.bgDanger = 'bg-danger';
      }, 3500);
    }
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


}
