export class ReadingList {
  id: String;
  userId: String;
  login: String;
  bookId: Number;
  title: String;
  imgUrl: String;


  constructor(id: String, userId: String, login: String, bookId:Number, title: String, imgUrl: String){
    this.id = id;
    this.userId = userId;
    this.login = login;
    this.bookId = bookId;
    this.title = title;
    this.imgUrl = imgUrl;
  }
}
