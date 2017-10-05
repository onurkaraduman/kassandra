/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { NewsProviderService } from './news-provider.service';

describe('NewsProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NewsProviderService]
    });
  });

  it('should ...', inject([NewsProviderService], (service: NewsProviderService) => {
    expect(service).toBeTruthy();
  }));
});
