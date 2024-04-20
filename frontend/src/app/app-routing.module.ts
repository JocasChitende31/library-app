import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { AboutComponent } from './about/about.component';
import { ConfigDashboardComponent } from './admin/config/config-dashboard/config-dashboard.component';
import { AuthorFormComponent } from './admin/forms/author-form/author-form.component';
import { BookFormComponent } from './admin/forms/book-form/book-form.component';
import { CategoryFormComponent } from './admin/forms/category-form/category-form.component';
import { UploadFileFormComponent } from './admin/forms/upload-file-form/upload-file-form.component';
import { AuthorListComponent } from './admin/lists/author-list/author-list.component';
import { BookListComponent } from './admin/lists/book-list/book-list.component';
import { CategoryListComponent } from './admin/lists/category-list/category-list.component';
import { PerfilComponent } from './auth/login/perfil/perfil.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BookDetailsComponent } from './user/book-details/book-details.component';
import { BookListByCategoryComponent } from './user/book-list-by-category/book-list-by-category.component';
import { BookListUserComponent } from './user/book-list-user/book-list-user.component';
import { BookReadingComponent } from './user/book-reading/book-reading.component';


const routes: Routes = [
  { path: '', redirectTo: '/books', pathMatch: 'full' },
  { path: 'admin/create/book', component: BookFormComponent },
  { path: 'admin/books', component: BookListComponent },
  { path: 'books', component: BookListUserComponent },
  { path: 'addbook/:id/reading-list', component: BookReadingComponent },
  { path: 'details/:id/book', component: BookDetailsComponent },
  { path: 'admin/update/:id/book', component: BookFormComponent },
  { path: 'admin/authors', component: AuthorListComponent },
  { path: 'admin/update/:id/author', component: AuthorFormComponent },
  { path: 'admin/create/author', component: AuthorFormComponent },
  { path: 'admin/categories', component: CategoryListComponent },
  { path: 'admin/create/category', component: CategoryFormComponent },
  { path: 'admin/update/:id/category', component: CategoryFormComponent },
  { path: 'admin/create/book', component: BookFormComponent },
  { path: ':id/category', component: BookListByCategoryComponent },
  { path: 'my-reading-list/:id', component: BookReadingComponent },
  { path: 'uploadFile', component: UploadFileFormComponent },
  { path: 'about', component: AboutComponent },
  { path: 'login', loadChildren: () => import('./auth/log-in/log-in-routing.module').then(m => m.LogInRoutingModule) },
  { path: 'signup', loadChildren: () => import('./auth/sign-up/sign-up-routing.module').then(m => m.SignUpRoutingModule) },
  {
    path: 'admin/config/logged/profile/:name', component: ConfigDashboardComponent,
    /* children: [{
      path: 'users', component: UsersRegisteredComponent
    }] */
  },
  {
    path: 'user/profile/:name', component: PerfilComponent
  },
  { path: '**', pathMatch: 'full', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
