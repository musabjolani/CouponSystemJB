import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CouponComponent } from './Components/coupon/coupon.component';
import { MenuComponent } from './Components/menu/menu.component';
import { HeaderComponent } from './Components/header/header.component';
import { CompanyComponent } from './Components/company/company.component'
import { SavedcompletedComponent } from './Components/savedcompleted/savedcompleted.component';
import { RouterModule,Routes } from '@angular/router'




import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { WebapiService } from './services/webapi.service';
import { SavedataService } from './services/savedata.service';
import { CoupondataService } from './services/coupondata.service'
import { DatePipe } from '@angular/common'
import { HttpModule } from '@angular/http';
import { CouponreportsComponent } from './Components/couponreports/couponreports.component';
import {MatNativeDateModule} from  '@angular/material';







@NgModule({
  declarations: [
    AppComponent,
    CouponComponent,
    MenuComponent,
    HeaderComponent,
    SavedcompletedComponent,
    CouponreportsComponent,
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatCheckboxModule,
    MatRadioModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatSelectModule,
    MatButtonModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
    HttpModule,
    RouterModule.forRoot([
    
      {
        path:'company',
        component: CompanyComponent
      },
      {
        path:'coupon',
        component: CouponComponent
      },
      {
        path:'savedcompleted',
        component: SavedcompletedComponent
       },
      {
        path:'couponreports',
        component: CouponreportsComponent
       }
    ])
  ],
  providers: [WebapiService,SavedataService,CoupondataService,DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
