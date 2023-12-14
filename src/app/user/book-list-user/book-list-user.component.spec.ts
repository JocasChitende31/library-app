import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookListUserComponent } from './book-list-user.component';

describe('BookListUserComponent', () => {
  let component: BookListUserComponent;
  let fixture: ComponentFixture<BookListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
