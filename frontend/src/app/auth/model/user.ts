
export class User {

    id: string | undefined;
    login: string | undefined;
    password: string | undefined;
    role: string | undefined;

    public User(id: string, login: string, password: string, role: string){
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public UserLogin(login:string, password:string){
        this.login = login;
        this.password = password;
    }
}
