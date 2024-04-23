
import { User } from "../auth/model/user";
import { Book } from "./book";

export class ReadingListPost {

  id: String | undefined;
  user: User;
  book: Book;


constructor(id: String, user: User, book: Book) {
    this.id = id;
    this.user = user;
    this.book = book;
  }
}
