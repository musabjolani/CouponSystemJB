import { Injectable } from '@angular/core';
import { Customer } from '../Beans/Customer'
@Injectable()
export class CustomerdataService {

  constructor() 
  {
   
   }

  public customer: Customer = new Customer();
 
}
