import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';   // used for input fields
import { LoginService } from './services/login.service';

/*
ngModule decorator indicates that the following clas is a Module
The decorator has many fields that we must update as we use new features and create more
  classes in our application

Declarations - an array that holds classes that are related to view
Three types of classes can be listed here: components, directives, pipes
*/
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [LoginService],    // Hmm....
  bootstrap: [AppComponent]
})
export class AppModule { }
