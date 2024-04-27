import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from 'src/app/models/author';
import { AuthorService } from 'src/app/services/author.service';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {
  admin = "ADMIN";
  authors: Author[] = [];
  author: Author;

  constructor(
    private authService: AuthorService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.author = new Author();
  }

  ngOnInit(): void {
    this.authService.findAll().subscribe(data => {
      this.authors = data;
    })

  }

  onDelete(authId: any) {
    this.authService.delete(authId).subscribe(result => {
      this.gotToListAuthor();
    })
  }

  gotToListAuthor() {
    this.router.navigate(['/admin/authors']);
    window.location.reload();
  }

}
