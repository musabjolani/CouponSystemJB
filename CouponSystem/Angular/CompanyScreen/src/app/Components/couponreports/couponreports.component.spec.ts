import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CouponreportsComponent } from './couponreports.component';

describe('CouponreportsComponent', () => {
  let component: CouponreportsComponent;
  let fixture: ComponentFixture<CouponreportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CouponreportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CouponreportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
