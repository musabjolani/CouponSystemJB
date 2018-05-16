import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router'
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { MenuComponent } from './Components/menu/menu.component';
import { HeaderComponent } from './Components/header/header.component';
import { MainComponent } from './Components/main/main.component';
import { CompanyComponent } from './Components/company/company.component';
import { GetcompanyComponent } from './Components/getcompany/getcompany.component';
import { MatInputModule } from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import { WebapiService } from './services/webapi.service';
import { SavedataService } from './services/savedata.service';

import { HttpModule } from '@angular/http';
import { SavedCompletedComponent } from './Components/saved-completed/saved-completed.component';
import { CustomerComponent } from './Components/customer/customer.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HeaderComponent,
    MainComponent,
    CompanyComponent,
    GetcompanyComponent,
    SavedCompletedComponent,
    CustomerComponent
   
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatCheckboxModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatSelectModule,
    MatButtonModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path:'company',
        component: CompanyComponent
      },
      {
        path:'customer',
        component: CustomerComponent
      },
      {
        path:'getcompany',
        component: GetcompanyComponent
      },      
      {
        path:'savedcompleted',
        component: SavedCompletedComponent
      },      
      
    ])
  ],
  providers: [WebapiService,SavedataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
