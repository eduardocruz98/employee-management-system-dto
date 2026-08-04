import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { EmpleadoService } from '../../services/empleado-service';
import { DepartamentoService } from '../../services/departamento-service';

import { EmpleadoRequest } from '../../models/empleado-request.model';
import { EmpleadoResponse } from '../../models/empleado-response.model';
import { DepartamentoResponse } from '../../models/departamento-response.model';

@Component({
  selector: 'app-editar-empleado',
  imports: [FormsModule],
  templateUrl: './editar-empleado.html',
})
export class EditarEmpleado {
  empleado: EmpleadoRequest = new EmpleadoRequest();

  departamentos!: DepartamentoResponse[];

  private id!: number;

  private enrutador = inject(Router);
  private ruta = inject(ActivatedRoute);
  private cdr = inject(ChangeDetectorRef);

  private empleadoServicio = inject(EmpleadoService);
  private departamentoServicio = inject(DepartamentoService);

  ngOnInit(): void {
    this.id = this.ruta.snapshot.params['id'];

    this.obtenerEmpleado();

    this.obtenerDepartamentos();
  }

  onSubmit(): void {
    this.guardarEmpleado();
  }

  private obtenerEmpleado(): void {
    this.empleadoServicio.obtenerEmpleadoPorId(this.id).subscribe({
      next: (datos: EmpleadoResponse) => {
        this.empleado.nombre = datos.nombre;
        this.empleado.apellido = datos.apellido;
        this.empleado.correo = datos.correo;
        this.empleado.telefono = datos.telefono;
        this.empleado.salario = datos.salario;

        this.empleado.idDepartamento = datos.idDepartamento;

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Error al obtener empleado', error);
      },
    });
  }

  private obtenerDepartamentos(): void {
    this.departamentoServicio.obtenerDepartamentosLista().subscribe({
      next: (datos) => {
        this.departamentos = datos;

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error(error);
      },
    });
  }

  private guardarEmpleado(): void {
    this.empleadoServicio.editarEmpleadoPorId(this.id, this.empleado).subscribe({
      next: () => {
        this.irLista();
      },

      error: (error) => {
        console.error(error);
      },
    });
  }

  private irLista(): void {
    this.enrutador.navigate(['/empleados']);
  }
}
