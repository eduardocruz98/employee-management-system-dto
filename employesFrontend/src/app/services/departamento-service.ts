import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { DepartamentoRequest } from '../models/departamento-request.model';
import { DepartamentoResponse } from '../models/departamento-response.model';

@Injectable({
  providedIn: 'root',
})
export class DepartamentoService {

  private urlBase =
    'http://localhost:8080/employe-app/departamentos';

  private clienteHttp = inject(HttpClient);

  obtenerDepartamentosLista(): Observable<DepartamentoResponse[]>{
    return this.clienteHttp.get<DepartamentoResponse[]>(this.urlBase);
  }

  agregarDepartamento(departamento: DepartamentoRequest): Observable<DepartamentoResponse>{
    return this.clienteHttp.post<DepartamentoResponse>(this.urlBase,departamento);
  }

  obtenerDepartamentoPorId(id: number): Observable<DepartamentoResponse>{
    return this.clienteHttp.get<DepartamentoResponse>(`${this.urlBase}/${id}`);
  }

  editarDepartamentoPorId(id: number,departamento: DepartamentoRequest): Observable<DepartamentoResponse>{
    return this.clienteHttp.put<DepartamentoResponse>(`${this.urlBase}/${id}`,departamento);
  }

  eliminarDepartamento(id: number): Observable<void> {
    return this.clienteHttp.delete<void>(`${this.urlBase}/${id}`);
  }
}