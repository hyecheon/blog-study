import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateComponent} from './create/create.component';
import {ListComponent} from './list/list.component';
import {EditComponent} from './edit/edit.component';
import {routing} from './board.routing';
import {FroalaEditorModule, FroalaViewModule} from 'angular-froala-wysiwyg';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    routing,
    FroalaEditorModule.forRoot(), FroalaViewModule.forRoot(),
    FormsModule, ReactiveFormsModule
  ],
  declarations: [CreateComponent, ListComponent, EditComponent]
})
export class BoardModule {
}
