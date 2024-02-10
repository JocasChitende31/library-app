import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadFileFormComponent } from './upload-file-form.component';

describe('UploadFileFormComponent', () => {
  let component: UploadFileFormComponent;
  let fixture: ComponentFixture<UploadFileFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadFileFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadFileFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
