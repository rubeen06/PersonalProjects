import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctoresDetailComponent } from './doctores-detail.component';

describe('DoctoresDetailComponent', () => {
  let component: DoctoresDetailComponent;
  let fixture: ComponentFixture<DoctoresDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctoresDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctoresDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
