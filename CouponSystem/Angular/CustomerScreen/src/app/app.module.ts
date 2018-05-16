import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {BrowserAnimationsModule,NoopAnimationsModule} from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';

import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router'
import { AppComponent } from './app.component';
import { MenuComponent } from './components/menu/menu.component';
import { HeaderComponent } from './Components/header/header.component';
import { PurchasecouponComponent } from './Components/purchasecoupon/purchasecoupon.component';
import { GetpurchasecouponComponent } from './Components/getpurchasecoupon/getpurchasecoupon.component';
import { WebapiService } from './services/webapi.service';
import { CustomerdataService } from './services/customerdata.service';
import {SavedataService} from './services/savedata.service';
import { SavedcompletedComponent } from './Components/savedcompleted/savedcompleted.component'

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HeaderComponent,
    PurchasecouponComponent,
    GetpurchasecouponComponent,
    SavedcompletedComponent,
    
  ],
  imports: [
    MatRadioModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatSelectModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatCheckboxModule,
    MatTableModule,
    HttpModule,
    RouterModule.forRoot([
        {
         path:'',
         component: PurchasecouponComponent
        },
        {
          path:'purchaseCoupon',
          component: PurchasecouponComponent
        },
        {
          path:'getpurchaseCoupon',
          component: GetpurchasecouponComponent
        },
        {
          path:'savedcompleted',
          component:SavedcompletedComponent
        }
        
      ]),
    BrowserModule
  ],
  providers: [WebapiService,CustomerdataService,SavedataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
