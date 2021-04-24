import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// components
import { AddUserComponent } from '../app/add-user/add-user.component';
import { AddEntryComponent } from '../app/add-entry/add-entry.component';


const routes: Routes = [
  { path: 'add-entry', component: AddEntryComponent },
  { path: 'add-user', component: AddUserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
