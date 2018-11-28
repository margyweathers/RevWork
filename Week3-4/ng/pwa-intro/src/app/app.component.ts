import { Component } from '@angular/core';
import { ServiceWorkerWatcherService } from '../app/Services/service-worker-watcher.service'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pwa-intro is awesome';

  constructor(public serviceWorker: ServiceWorkerWatcherService){}
  
}
