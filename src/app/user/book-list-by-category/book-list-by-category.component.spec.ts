import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookListByCategoryComponent } from './book-list-by-category.component';

describe('BookListByCategoryComponent', () => {
  let component: BookListByCategoryComponent;
  let fixture: ComponentFixture<BookListByCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookListByCategoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookListByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
