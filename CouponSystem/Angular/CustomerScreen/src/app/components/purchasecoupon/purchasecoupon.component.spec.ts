import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchasecouponComponent } from './purchasecoupon.component';

describe('PurchasecouponComponent', () => {
  let component: PurchasecouponComponent;
  let fixture: ComponentFixture<PurchasecouponComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchasecouponComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchasecouponComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
