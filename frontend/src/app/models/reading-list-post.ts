import { User } from "../auth/model/user";
import { Book } from "./book";

export class ReadingListPost {

  id: String;
  userId: User;
  boookId: Book;

  constructor(id: String, userId: User, boookId: Book) {
    this.id = id;
    this.userId = userId;
    this.boookId = boookId;
  }

  
}
