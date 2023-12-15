import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AboutComponent } from './about/about.component';
import { AuthorListComponent } from './admin/author-list/author-list.component';
import { BookFormComponent } from './admin/book-form/book-form.component';
import { BookListComponent } from './admin/book-list/book-list.component';
import { CategoryListComponent } from './admin/category-list/category-list.component';
import { BookDetailsComponent } from './user/book-details/book-details.component';
import { BookListByCategoryComponent } from './user/book-list-by-category/book-list-by-category.component';
import { BookListUserComponent } from './user/book-list-user/book-list-user.component';
import { BookReadingComponent } from './user/book-reading/book-reading.component';


const routes: Routes = [
  { path: 'admin/books', component: BookListComponent },
  { path: 'admin/authors', component: AuthorListComponent },
  {path: 'admin/categories', component: CategoryListComponent},
  { path: 'admin/create/book', component: BookFormComponent },
  { path: ':id/category', component: BookListByCategoryComponent },
  { path: 'details/:id/book', component: BookDetailsComponent },
  { path: 'addbook/:id/reading-list', component: BookReadingComponent },
  { path: 'user/books', component: BookListUserComponent },
  {path: 'about', component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
