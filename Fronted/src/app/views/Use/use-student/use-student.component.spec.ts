import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UseStudentComponent } from './use-student.component';

describe('UseStudentComponent', () => {
  let component: UseStudentComponent;
  let fixture: ComponentFixture<UseStudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UseStudentComponent]
    });
    fixture = TestBed.createComponent(UseStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
