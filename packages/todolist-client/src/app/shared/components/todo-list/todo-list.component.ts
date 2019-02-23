import { Todo } from './../../../models/todo';
import { TodoService } from './../../../services/todo.service';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-todo-list',
    templateUrl: './todo-list.component.html',
    styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {
    todos: Todo[];

    constructor(private todoService: TodoService) {}

    ngOnInit() {
        this.loadTodos();
    }

    loadTodos() {
        this.todoService.getTodos().subscribe(data => {
            this.todos = data;
        });
    }
}
