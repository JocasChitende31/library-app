import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AboutComponent } from './about/about.component';
import { AuthorFormComponent } from './admin/forms/author-form/author-form.component';
import { BookFormComponent } from './admin/forms/book-form/book-form.component';
import { CategoryFormComponent } from './admin/forms/category-form/category-form.component';
import { AuthorListComponent } from './admin/lists/author-list/author-list.component';
import { BookListComponent } from './admin/lists/book-list/book-list.component';
import { CategoryListComponent } from './admin/lists/category-list/category-list.component';
import { LoginComponent } from './auth/login/login.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BookServiceService } from './services/book-service.service';
import { BookDetailsComponent } from './user/book-details/book-details.component';
import { BookListByCategoryComponent } from './user/book-list-by-category/book-list-by-category.component';
import { BookListUserComponent } from './user/book-list-user/book-list-user.component';
import { BookReadingComponent } from './user/book-reading/book-reading.component';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatOptionModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { ConfigDashboardComponent } from './admin/config/config-dashboard/config-dashboard.component';
import { UsersRegisteredComponent } from './admin/config/users-registered/users-registered.component';
import { PerfilComponent } from './auth/login/perfil/perfil.component';
import { SignupComponent } from './auth/signup/signup.component';
import { TokenInterceptor } from './core/interceptors/token.interceptor';
import { UploadFileFormComponent } from './admin/forms/upload-file-form/upload-file-form.component';

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
    CategoryFormComponent,
    PageNotFoundComponent,
    LoginComponent,
    SignupComponent,
    UsersRegisteredComponent,
    ConfigDashboardComponent,
    PerfilComponent,
    UploadFileFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatInputModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatOptionModule,
    MatTableModule,
    MatTabsModule,
    MatProgressBarModule,
  ],
  providers: [BookServiceService,{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
