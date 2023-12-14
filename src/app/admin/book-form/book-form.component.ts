import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../../models/author';
import { Book } from '../../models/book';
import { Category } from '../../models/category';
import { AuthorService } from '../../services/author.service';
import { BookServiceService } from '../../services/book-service.service';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  titleForm: String | undefined;
  selectCategoryStandard: String[];

  defaultValue = "Escolha"

  book: Book;
  categories: Category[] = [];
  authors: Author[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private bookService: BookServiceService,
    private categoryService: CategoryService,
    private authorService: AuthorService,
  ) {
    this.titleForm = "Adicionar Livro a Galeria";
    this.selectCategoryStandard = ["Escolha a categoria"];
    this.book = new Book();

  }
  onSubmit() {
    this.bookService.save(this.book).subscribe(result => {
      this.goToBookList();
    })
  }
  goToBookList() {
    this.router.navigate(['/books']);
  }
  standInPage() {
    this.router.navigate(['/create/book']);
  }
  ngOnInit(): void {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
    this.authorService.findAll().subscribe(data => {
      this.authors = data;
    })
  }

}
