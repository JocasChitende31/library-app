import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigDashboardComponent } from './config-dashboard.component';

describe('ConfigDashboardComponent', () => {
  let component: ConfigDashboardComponent;
  let fixture: ComponentFixture<ConfigDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfigDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
