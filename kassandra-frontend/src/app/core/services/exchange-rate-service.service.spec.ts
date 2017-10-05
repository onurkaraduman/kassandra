/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ExchangeRateServiceService } from './exchange-rate-service.service';

describe('ExchangeRateServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExchangeRateServiceService]
    });
  });

  it('should ...', inject([ExchangeRateServiceService], (service: ExchangeRateServiceService) => {
    expect(service).toBeTruthy();
  }));
});
