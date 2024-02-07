import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCourceComponent } from './listar-cource.component';

describe('ListarCourceComponent', () => {
  let component: ListarCourceComponent;
  let fixture: ComponentFixture<ListarCourceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCourceComponent]
    });
    fixture = TestBed.createComponent(ListarCourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
