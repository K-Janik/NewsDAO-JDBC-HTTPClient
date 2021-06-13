import { TestBed } from '@angular/core/testing';

import { InfoDaoService } from './info-dao.service';

describe('InfoDaoService', () => {
  let service: InfoDaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InfoDaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
