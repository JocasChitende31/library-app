import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { AboutComponent } from './about/about.component';
import { AuthorFormComponent } from './admin/forms/author-form/author-form.component';
import { BookFormComponent } from './admin/forms/book-form/book-form.component';
import { CategoryFormComponent } from './admin/forms/category-form/category-form.component';
import { AuthorListComponent } from './admin/lists/author-list/author-list.component';
import { BookListComponent } from './admin/lists/book-list/book-list.component';
import { CategoryListComponent } from './admin/lists/category-list/category-list.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { BookServiceService } from './services/book-service.service';
import { BookDetailsComponent } from './user/book-details/book-details.component';
import { BookListByCategoryComponent } from './user/book-list-by-category/book-list-by-category.component';
import { BookListUserComponent } from './user/book-list-user/book-list-user.component';
import { BookReadingComponent } from './user/book-reading/book-reading.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookFormComponent,
    FooterComponent,
    BookListByCategoryComponent,
    BookDetailsComponent,
    BookReadingComponent,
    HeaderComponent,
    BookListUserComponent,
    AuthorListComponent,
    AboutComponent,
    CategoryListComponent,
    AuthorFormComponent,
    CategoryFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
],
  providers: [BookServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
