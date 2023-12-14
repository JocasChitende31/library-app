import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookReadingComponent } from './book-reading.component';

describe('BookReadingComponent', () => {
  let component: BookReadingComponent;
  let fixture: ComponentFixture<BookReadingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookReadingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookReadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
