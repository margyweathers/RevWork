import { Injectable } from '@angular/core';
import { SwUpdate } from '@angular/service-worker';

@Injectable({
  providedIn: 'root'
})
export class ServiceWorkerWatcherService {

  updateIsReady = false;

  constructor(updates: SwUpdate) {
    console.log('service worker here');

    updates.available.subscribe(
      () => this.updateIsReady = true
    );

   }
}
