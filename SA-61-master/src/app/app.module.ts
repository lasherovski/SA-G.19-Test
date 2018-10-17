import{BrowserModule}from'@angular/platform-browser';
import {NgModule }from '@angular/core';
import {AppComponent}from './app.component';
import {HttpClientModule}from '@angular/common/http';
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule,MatSelectModule}from '@angular/material';
import {BrowserAnimationsModule}from '@angular/platform-browser/animations';
import {FormsModule }from '@angular/forms';
import {RouterModule, Routes}from '@angular/router';
import {RestaComponent}from './resta/resta.component';
import {RestaService}from './resta.service';
import {RestainfoComponent}from './restainfo/restainfo.component';
const appRoutes: Routes = [
{
path: '',
redirectTo: 'resta',
pathMatch: 'full'
},
{
path: 'resta',
component: RestaComponent
}
,
{
path: 'restainfo/:rid',
component: RestainfoComponent
}
];

@NgModule({
  declarations: [
    AppComponent,
    RestaComponent,
    RestainfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatSelectModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [RestaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
