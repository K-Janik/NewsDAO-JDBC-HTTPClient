import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoDaoComponent } from './info-dao.component';

describe('InfoDaoComponent', () => {
  let component: InfoDaoComponent;
  let fixture: ComponentFixture<InfoDaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoDaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoDaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
