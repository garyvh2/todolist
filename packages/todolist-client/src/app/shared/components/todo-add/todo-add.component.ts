import { Todo } from './../../../models/todo';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-todo-add',
    templateUrl: './todo-add.component.html',
    styleUrls: ['./todo-add.component.scss']
})
export class TodoAddComponent implements OnInit {
    @Output() submit: EventEmitter<Todo> = new EventEmitter();

    todo: Todo = new Todo();

    constructor() {}

    ngOnInit() {}

    addTodo() {
        this.submit.emit(this.todo);
    }
}
