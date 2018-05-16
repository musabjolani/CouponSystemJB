import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedCompletedComponent } from './saved-completed.component';

describe('SavedCompletedComponent', () => {
  let component: SavedCompletedComponent;
  let fixture: ComponentFixture<SavedCompletedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavedCompletedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavedCompletedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
