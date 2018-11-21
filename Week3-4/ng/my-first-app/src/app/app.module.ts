import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';   // used for input fields
import { LoginService } from './services/login.service';
import { DirectivesComponent } from './components/directives/directives.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DataBindingComponent } from './components/data-binding/data-binding.component';
import { HttpComponent } from './components/http/http.component';
import { PipesComponent } from './components/pipes/pipes.component';

/*
app-module AKA root module
NOTES IN GIT
*/

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
    LoginComponent,
    DirectivesComponent,
    NavbarComponent,
    DataBindingComponent,
    HttpComponent,
    PipesComponent
  ],

    /*
  , exports:[]
  classes that need to be accessible to the components
  of other modules. However, we're not making a
  multi-modular app at the moment, so we do not need
  anything in the exports array
  */

  imports: [
      /*
   modules whose classes are needed by classes within
   this current module
   */
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [LoginService],    // Anything that is provided becomes available for injection (kind of like private/protected)
  bootstrap: [AppComponent]
})
export class AppModule { }
