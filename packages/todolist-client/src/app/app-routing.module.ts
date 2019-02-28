import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule, Routes } from "@angular/router";
import { DashboardComponent } from "./views/dashboard/dashboard.component";
import { DetailComponent } from "./views/detail/detail.component";

const routes: Routes = [
  {
    path: "",
    component: DashboardComponent
  },
  {
    path: "detail/:id",
    component: DetailComponent
  }
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
