import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnfermerosFormComponent } from './enfermeros-form.component';

describe('EnfermerosFormComponent', () => {
  let component: EnfermerosFormComponent;
  let fixture: ComponentFixture<EnfermerosFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnfermerosFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnfermerosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
