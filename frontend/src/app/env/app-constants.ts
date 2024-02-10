export class AppConstants {

    public static get baseUrlServer(): String {
        return 'http://localhost:8080/';
    }
    public static get apiUploadUrl(): String {
        return 'http://localhost:8081/';
    }
    public static get baseUrlApi(): String {
        return this.baseUrlServer + "api";
    }
    public static get baseUrlAuth(): String {
        return this.baseUrlServer + "auth";
    }
}
