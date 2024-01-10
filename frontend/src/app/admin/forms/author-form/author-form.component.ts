import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthorService } from 'src/app/services/author.service';

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {

  // author: Author;
  authorForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', Validators.required),
    birthday: new FormControl('', Validators.required),
    nationality: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required)
  });
  authId: any;
  titleCreateAuthor = "Adicionar Autor";
  titleUpdateAuthor = "Actualizar Registo do Autor";

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authorService: AuthorService
  ) {
    // this.author = new Author();
  }
  ngOnInit(): void {
    this.authId = this.route.snapshot.paramMap.get('id');
    if (this.authId) {
      this.authorService.findById(this.authId).subscribe(res => {
        this.authorForm.patchValue({
          id: res.id,
          name: res.name,
          birthday: res.birthday,
          nationality: res.nationality,
          status: res.status
        })
      })
    }
  }
  authorSubmit() {
    if (this.authorForm.valid) {
      this.authorService.save(this.authorForm.value).subscribe(res => {
        this.goToListAuthor();
        this.authorForm.reset();
      });
    }
  }
  updateAuthor() {
    if (this.authorForm.valid) {
      this.authorService.update(this.authId, this.authorForm.value).subscribe(res => {
        this.goToListAuthor();
      })
    }
  }
  goToListAuthor() {
    this.router.navigate(['/admin/authors']);
  }
}
