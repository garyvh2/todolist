import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../services/todo.service';
import { Todo } from '../../models/todo';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
    constructor(private todoService: TodoService) {}

    ngOnInit() {}

    addTodo(todo: Todo) {
        this.todoService.addTodo(todo);
    }
}
