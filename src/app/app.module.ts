import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { BookFormComponent } from './book-form/book-form.component';
import { BookListByCategoryComponent } from './book-list-by-category/book-list-by-category.component';
import { BookListComponent } from './book-list/book-list.component';
import { FooterComponent } from './footer/footer.component';
import { BookServiceService } from './services/book-service.service';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookReadingComponent } from './book-reading/book-reading.component';

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookFormComponent,
    FooterComponent,
    BookListByCategoryComponent,
    BookDetailsComponent,
    BookReadingComponent
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
