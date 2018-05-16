import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedcompletedComponent } from './savedcompleted.component';

describe('SavedcompletedComponent', () => {
  let component: SavedcompletedComponent;
  let fixture: ComponentFixture<SavedcompletedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavedcompletedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavedcompletedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
