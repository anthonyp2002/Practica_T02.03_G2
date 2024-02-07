import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UseTeacherComponent } from './use-teacher.component';

describe('UseTeacherComponent', () => {
  let component: UseTeacherComponent;
  let fixture: ComponentFixture<UseTeacherComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UseTeacherComponent]
    });
    fixture = TestBed.createComponent(UseTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
