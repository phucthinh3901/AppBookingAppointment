import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'customers', loadChildren: () => import('./modules/customers/customers.module').then(m => m.CustomersModule) }, { path: 'administration', loadChildren: () => import('./modules/administration/administration.module').then(m => m.AdministrationModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
