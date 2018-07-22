import {RouterModule, Routes} from '@angular/router';
import {CreateComponent} from './create/create.component';
import {EditComponent} from './edit/edit.component';
import {ListComponent} from './list/list.component';

const routes: Routes = [
  {path: 'board-list', component: ListComponent},
  {path: 'board-create', component: CreateComponent},
  {path: 'board-editor', component: EditComponent},
];

export const routing = RouterModule.forRoot(routes);
