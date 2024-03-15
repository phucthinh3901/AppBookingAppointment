import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from '../../environment/environment';
import { delay, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private http: HttpClient) { }

  getAllDepartment(id: number): Observable<any>{
    return this.http.get<any>(`${environment.apiUrl}/department/${id}`).pipe(retry(1), delay(1000))
  }

  createOrUpdateDepartment(request: any): Observable<any>{
    return this.http.post<any>(`${environment.apiUrl}/department/createOrUpdate`,request).pipe(retry(1),delay(1000))

  }

}
