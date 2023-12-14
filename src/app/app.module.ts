import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { BookFormComponent } from './admin/book-form/book-form.component';
import { BookListComponent } from './admin/book-list/book-list.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { BookServiceService } from './services/book-service.service';
import { BookDetailsComponent } from './user/book-details/book-details.component';
import { BookListByCategoryComponent } from './user/book-list-by-category/book-list-by-category.component';
import { BookReadingComponent } from './user/book-reading/book-reading.component';
import { BookListUserComponent } from './user/book-list-user/book-list-user.component';

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
    BookListUserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
    

  ],
  providers: [BookServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
