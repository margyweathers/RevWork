import { Component } from '@angular/core';

@Component({
  // Selector - custom HTML element used to include this component in the app
  selector: 'app-root',
  // templateURL - link to Template(HTML, FILE) for this component. Can be replaced with in-line HTML
  //    using the template attribute
// templateUrl: '<h1>This is my {{title}} app</h1>',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-first-app';
}
