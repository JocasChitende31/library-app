import { Component, Input } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : String;
  cardTitle: String;

  constructor(){
    this.title = 'Atende.Library';
    this.cardTitle = 'Livraria';
  }
}
