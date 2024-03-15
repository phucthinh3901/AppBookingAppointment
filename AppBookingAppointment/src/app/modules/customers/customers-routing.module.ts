import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers.component';
import { DepartmentComponent } from './department/department.component';

const routes: Routes = [{
  path: '', component: CustomersComponent, children: [
    { path: 'department', component: DepartmentComponent }
  ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { }
