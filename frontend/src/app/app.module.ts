import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';


import {BoardModule} from './board/board.module';
import {BoardService} from './board/board.service';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BoardModule,
    RouterModule,
  ],
  providers: [BoardService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
