import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from 'src/app/models/author';
import { AuthorService } from 'src/app/services/author.service';

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {

  author: Author;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authorService: AuthorService
  ) {
    this.author = new Author();
  }

  ngOnInit(): void {
  }
  onSubmit() {
    this.authorService.save(this.author).subscribe(result => {
      this.goToListAuthor();
    })
  }
  goToListAuthor() {
    this.router.navigate(['/admin/authors']);
  }
}
