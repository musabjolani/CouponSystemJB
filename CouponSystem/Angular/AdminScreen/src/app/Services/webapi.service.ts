import { Injectable } from '@angular/core';

import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Company } from '../Beans/Company' ;
import { Customer } from '../Beans/Customer' ;

@Injectable()
export class WebapiService {

  constructor(public http:Http) { }


  public getAllCompanies()
  {
    return this.http.get('http://localhost:9090/getAllCompanies').map( 
      x => x.json() );
  }

  public getCompany(id:number)
  {
    return this.http.get('http://localhost:9090/getCompany/' + id ).map( 
      x => x.json() );
  }
  
public createCompany(company:Company)
{
  
  return this.http.post('http://localhost:9090/createCompany', company)
}

public updateCompany(company:Company)
{

  return this.http.put('http://localhost:9090/updateCompany', company)
}

public removeCompany(company:Company)
{
 
  return this.http.delete('http://localhost:9090/removeCompany', { body: company })
}



public getAllCustomers()
{
  return this.http.get('http://localhost:9090/getAllCustomers').map( 
    x => x.json() );
}

public getCustomer(id:number)
{
  return this.http.get('http://localhost:9090/getCustomer/' + id ).map( 
    x => x.json() );
}

public createCustomer(customer:Customer)
{

return this.http.post('http://localhost:9090/createCustomer', customer)
}

public updateCustomer(customer:Customer)
{

return this.http.put('http://localhost:9090/updateCustomer', customer)
}

public removeCustomer(customer:Customer)
{

return this.http.delete('http://localhost:9090/removeCustomer', { body: customer })
}



}
