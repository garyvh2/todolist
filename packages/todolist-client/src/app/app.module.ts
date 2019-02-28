import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { DashboardComponent } from "./views/dashboard/dashboard.component";
import { TodoService } from "./services/todo.service";
import { HttpClientModule } from "@angular/common/http";
import { TodoCardComponent } from "./shared/components/todo-card/todo-card.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {
  MatCardModule,
  MatButtonModule,
  MatInputModule
} from "@angular/material";
import { TodoListComponent } from "./shared/components/todo-list/todo-list.component";
import { TodoAddComponent } from "./shared/components/todo-add/todo-add.component";
import { AppRoutingModule } from './app-routing.module';
import { DetailComponent } from './views/detail/detail.component';
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TodoCardComponent,
    TodoListComponent,
    TodoAddComponent,
    DetailComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    AppRoutingModule
  ],
  providers: [TodoService],
  bootstrap: [AppComponent]
})
export class AppModule {}
