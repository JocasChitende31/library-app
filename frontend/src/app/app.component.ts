import { Component, Input } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : String;
  subTitle: String;

  constructor(){
    this.title = 'Livraria';
    this.subTitle = 'CentroSul';
  }
}
