import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Location } from "@angular/common";
import { TodoService } from "../../services/todo.service";
import { Todo } from "../../models/todo";

@Component({
  selector: "app-detail",
  templateUrl: "./detail.component.html",
  styleUrls: ["./detail.component.scss"]
})
export class DetailComponent implements OnInit {
  id: string;
  todo: Todo = new Todo();

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private todoService: TodoService
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get("id");
    this.todoService.getTodo(this.id).subscribe(todo => {
      this.todo = todo;
    });
  }
}
