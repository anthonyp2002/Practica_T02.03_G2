import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCourseInsComponent } from './listar-course-ins.component';

describe('ListarCourseInsComponent', () => {
  let component: ListarCourseInsComponent;
  let fixture: ComponentFixture<ListarCourseInsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCourseInsComponent]
    });
    fixture = TestBed.createComponent(ListarCourseInsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
