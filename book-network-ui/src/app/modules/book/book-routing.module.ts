import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppComponent} from "../../app.component";
import {MainComponent} from "./pages/main/main.component";

const routes: Routes = [
  {
    path:'',
    component: MainComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
