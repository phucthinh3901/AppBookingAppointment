import { Component, OnInit } from '@angular/core';
import { DepartmentService } from '../../../service/department.service';
import { finalize } from 'rxjs';
@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrl: '../customers.component.scss'
})
export class DepartmentComponent implements OnInit {

  depart: any
  constructor(private departmentService: DepartmentService) {
  }
  ngOnInit(): void {
    this.createOrUpdate()
  }

  createOrUpdate(){
    let request = {
      id: '1', departmentName: 'concac'
    }
    this.departmentService.createOrUpdateDepartment(request).subscribe()
  }

  getAllDepartmentIsActive() {
    return this.departmentService.getAllDepartment(1).subscribe(data => console.log(data))
  }
}

