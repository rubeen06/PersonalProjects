import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnfermerosDetailComponent } from './enfermeros-detail.component';

describe('EnfermerosDetailComponent', () => {
  let component: EnfermerosDetailComponent;
  let fixture: ComponentFixture<EnfermerosDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnfermerosDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnfermerosDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
