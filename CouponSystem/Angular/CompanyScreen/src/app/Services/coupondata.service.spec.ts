import { TestBed, inject } from '@angular/core/testing';

import { CoupondataService } from './coupondata.service';

describe('CoupondataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CoupondataService]
    });
  });

  it('should be created', inject([CoupondataService], (service: CoupondataService) => {
    expect(service).toBeTruthy();
  }));
});
