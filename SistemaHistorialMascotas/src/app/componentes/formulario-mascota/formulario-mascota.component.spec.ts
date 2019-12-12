import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioMascotaComponent } from './formulario-mascota.component';

describe('FormularioMascotaComponent', () => {
  let component: FormularioMascotaComponent;
  let fixture: ComponentFixture<FormularioMascotaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioMascotaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioMascotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
