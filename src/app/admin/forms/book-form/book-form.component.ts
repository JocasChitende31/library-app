import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../../../models/author';
import { Category } from '../../../models/category';
import { AuthorService } from '../../../services/author.service';
import { BookServiceService } from '../../../services/book-service.service';
import { CategoryService } from '../../../services/category.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})

export class BookFormComponent implements OnInit {

  bookForm = new FormGroup({
    id: new FormControl(''),
    title: new FormControl('', Validators.required),
    bookYear: new FormControl('', Validators.required),
    publisher: new FormControl('', Validators.required),
    edition: new FormControl('', Validators.required),
    imgUrl: new FormControl('', Validators.required),
    fkCategory: new FormControl('', Validators.required),
    shortSummary: new FormControl('', Validators.required),
    longSummary: new FormControl('', Validators.required),
    fkAuthor: new FormControl('', Validators.required)
  });
  titleCreateAuthor = "Adicionar Livro à Galeria";
  titleUpdateAuthor = "Actualizar Registo do Livro";
  defaultValueAuthor = "Escolha o autor do livro";
  defaultValueCategory = "Escolha a categoria do livro"
  categories: Category[] = [];
  authors: Author[] = [];

  bookId: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookServiceService,
    private categoryService: CategoryService,
    private authorService: AuthorService,
  ) {
    this.bookId = this.route.snapshot.paramMap.get('id');

  }
  ngOnInit(): void {
    if (this.bookId) {
      this.bookService.findById(this.bookId).subscribe(res => {
        this.bookForm.patchValue({
          id: res.id,
          title: res.title,
          bookYear: res.bookYear,
          publisher: res.publisher,
          edition: res.edition,
          imgUrl: res.imgUrl,
          fkCategory: res.fkCategory,
          shortSummary: res.shortSummary,
          longSummary: res.longSummary,
          fkAuthor: res.fkAuthor
        })
      })
    }
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
    this.authorService.findAll().subscribe(data => {
      this.authors = data;
    })
  }
  bookSubmit() {
    if (this.bookForm.valid) {
      this.bookService.save(this.bookForm.value).subscribe(res => {
        this.goToBookList();
        this.bookForm.reset();
      })
    }
  }
  updateBook() {
    if (this.bookForm.valid) {
      this.bookService.update(this.bookId, this.bookForm.value).subscribe(res => {
        this.goToBookList();
      })
    }
  }
  goToBookList() {
    this.router.navigate(['/admin/books']);
  }
}
