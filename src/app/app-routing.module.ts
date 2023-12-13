import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookDetailsComponent } from './book-details/book-details.component';
import { BookFormComponent } from './book-form/book-form.component';
import { BookListByCategoryComponent } from './book-list-by-category/book-list-by-category.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookReadingComponent } from './book-reading/book-reading.component';


const routes: Routes = [
  { path: 'books', component: BookListComponent },
  { path: 'create/book', component: BookFormComponent },
  { path: ':id/books', component: BookListByCategoryComponent },
  { path: 'details/:id/book', component: BookDetailsComponent },
  { path: 'addbook/:id/reading-list', component: BookReadingComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
