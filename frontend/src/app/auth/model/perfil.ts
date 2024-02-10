export class Perfil {
    id?: string;
    login?: string;
    password?: string;
    role?: string;
    authorities?: [];
    accountNonExpired?: boolean;
    accountNoLocked?: boolean;
    credentialsNonExpired?: boolean;
    username?: string;

    public constructor(id: string, login: string, password: string, role: string, authorities: [], accountNonExpired: boolean, accountNoLocked: boolean, credentialsNonExpired: boolean, username: string) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNoLocked = accountNoLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.username = username;
    }
}
