import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersRegisteredComponent } from './users-registered.component';

describe('UsersRegisteredComponent', () => {
  let component: UsersRegisteredComponent;
  let fixture: ComponentFixture<UsersRegisteredComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsersRegisteredComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersRegisteredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
