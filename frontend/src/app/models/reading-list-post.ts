
import { User } from "../auth/model/user";
import { Book } from "./book";

export class ReadingListPost {

  id: String | undefined;
  user: User | undefined;
  book: Book | undefined;


   constructor() {

  }
 /*   constructor(id: String, user: User, book: Book) {
    this.id = id;
    this.user = user;
    this.book = book;
  } */

}
