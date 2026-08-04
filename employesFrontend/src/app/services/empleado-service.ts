import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { EmpleadoRequest } from '../models/empleado-request.model';
import { EmpleadoResponse } from '../models/empleado-response.model';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {

  private urlBase = 'http://localhost:8080/employe-app';

  private clienteHttp = inject(HttpClient);

  obtenerEmpleadosLista(): Observable<EmpleadoResponse[]> {
    return this.clienteHttp.get<EmpleadoResponse[]>(this.urlBase);
  }

  agregarEmpleado(empleado: EmpleadoRequest): Observable<EmpleadoResponse> {
    return this.clienteHttp.post<EmpleadoResponse>(this.urlBase, empleado);
  }

  obtenerEmpleadoPorId(id: number): Observable<EmpleadoResponse> {
    return this.clienteHttp.get<EmpleadoResponse>(`${this.urlBase}/id/${id}`);
  }

  obtenerEmpleadoPorNombre(nombre: string): Observable<EmpleadoResponse[]> {
    return this.clienteHttp.get<EmpleadoResponse[]>(`${this.urlBase}/nombre/${nombre}`);
  }

  editarEmpleadoPorId(id: number,empleado: EmpleadoRequest): Observable<EmpleadoResponse> {
    return this.clienteHttp.put<EmpleadoResponse>(`${this.urlBase}/id/${id}`,empleado);
  }

  eliminarEmpleado(id: number): Observable<void> {
    return this.clienteHttp.delete<void>(`${this.urlBase}/id/${id}`);
  }

}