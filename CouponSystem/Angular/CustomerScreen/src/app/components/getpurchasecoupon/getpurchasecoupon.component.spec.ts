import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetpurchasecouponComponent } from './getpurchasecoupon.component';

describe('GetpurchasecouponComponent', () => {
  let component: GetpurchasecouponComponent;
  let fixture: ComponentFixture<GetpurchasecouponComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetpurchasecouponComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetpurchasecouponComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
