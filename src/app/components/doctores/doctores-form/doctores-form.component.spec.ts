import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctoresFormComponent } from './doctores-form.component';

describe('DoctoresFormComponent', () => {
  let component: DoctoresFormComponent;
  let fixture: ComponentFixture<DoctoresFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctoresFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctoresFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
