/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CurrencyProviderService } from './currency-provider.service';

describe('CurrencyProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CurrencyProviderService]
    });
  });

  it('should ...', inject([CurrencyProviderService], (service: CurrencyProviderService) => {
    expect(service).toBeTruthy();
  }));
});
