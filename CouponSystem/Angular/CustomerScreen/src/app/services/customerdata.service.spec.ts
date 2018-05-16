import { TestBed, inject } from '@angular/core/testing';

import { CustomerdataService } from './customerdata.service';

describe('CustomerdataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CustomerdataService]
    });
  });

  it('should be created', inject([CustomerdataService], (service: CustomerdataService) => {
    expect(service).toBeTruthy();
  }));
});
