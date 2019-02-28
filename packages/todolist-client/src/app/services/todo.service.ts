import { Todo } from "./../models/todo";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";
import { apiBase } from "../app.settings";

@Injectable()
export class TodoService {
  subject: Subject<Todo[]> = new Subject<Todo[]>();
  constructor(private http: HttpClient) {}

  getTodos(): Observable<Todo[]> {
    const url = `${apiBase}/todo`;
    this.http.get<Todo[]>(url).subscribe(data => this.subject.next(data));
    return this.subject.asObservable();
  }

  getTodo(id): Observable<Todo> {
    const url = `${apiBase}/todo/find-by-id/${id}`;
    const _get = new Subject<Todo>();
    this.http.get<Todo>(url).subscribe(todo => _get.next(todo));
    return _get.asObservable();
  }

  addTodo(todo: Todo): Observable<Todo> {
    const url = `${apiBase}/todo`;
    const add = new Subject<Todo>();
    this.http.post<Todo>(url, todo).subscribe(todo => {
      this.getTodos();
      add.next(todo);
    });
    return add.asObservable();
  }
}
