
import { User } from "../auth/model/user";

export class ReadingListPost {

  id: String | undefined;
  user: User | undefined;
  book: Number | undefined;


constructor(id: String, user: User, book: Number) {
    this.id = id;
    this.user = user;
    this.book = book;
  }
}
