
export class User {

  id: string | undefined;
  login: string | undefined;
  password: string | undefined;
  role: string | undefined;

  constructor(login: string, password: string, role: string){
    this.login = login;
    this.password = password;
    this.role = role;
  }
 
  public UserLogin(login: string, password: string) {
    this.login = login;
    this.password = password;
  }
}
