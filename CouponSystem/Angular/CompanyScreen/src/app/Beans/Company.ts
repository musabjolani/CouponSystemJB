export class Company {
    constructor(private _id?:number, private _comp_NAME?:string, private _password?:string,
        private _email?:string)
    {
    }
    get id() : number {
      return this._id;
    }
    set id(newID : number)
    {
      this._id = newID;
    }
    get comp_NAME() : string {
        return this._comp_NAME;
      }
      set comp_NAME(newName : string)
      {
        this._comp_NAME = newName;
      }
      get password() : string {
        return this._password;
      }
      set password(newName : string)
      {
        this._password = newName;
      }
   
    get email() : string {
      return this._email;
    }
    set email(newName : string)
    {
      this._email = newName;
    }
  }
  
