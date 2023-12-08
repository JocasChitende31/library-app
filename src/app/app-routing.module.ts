import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BookFormComponent } from './book-form/book-form.component';
import { BookListComponent } from './book-list/book-list.component';


const routes: Routes = [
  { path: 'books', component: BookListComponent },
  { path: 'create/book', component: BookFormComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
