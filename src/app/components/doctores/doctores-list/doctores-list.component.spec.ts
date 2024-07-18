import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctoresListComponent } from './doctores-list.component';

describe('DoctoresListComponent', () => {
  let component: DoctoresListComponent;
  let fixture: ComponentFixture<DoctoresListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DoctoresListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoctoresListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
