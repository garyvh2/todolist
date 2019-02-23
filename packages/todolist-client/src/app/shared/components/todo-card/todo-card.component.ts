import { Todo } from './../../../models/todo';
import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-todo-card',
    templateUrl: './todo-card.component.html',
    styleUrls: ['./todo-card.component.scss']
})
export class TodoCardComponent implements OnInit {
    @Input() todo: Todo;

    constructor() {}

    ngOnInit() {}
}
