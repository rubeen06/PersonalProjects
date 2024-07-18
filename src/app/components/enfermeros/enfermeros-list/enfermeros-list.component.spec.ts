import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnfermerosListComponent } from './enfermeros-list.component';

describe('EnfermerosListComponent', () => {
  let component: EnfermerosListComponent;
  let fixture: ComponentFixture<EnfermerosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnfermerosListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnfermerosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
