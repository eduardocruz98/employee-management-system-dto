import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DepartamentoResponse } from '../../models/departamento-response.model';
import { EmpleadoRequest } from '../../models/empleado-request.model';
import { DepartamentoService } from '../../services/departamento-service';
import { EmpleadoService } from '../../services/empleado-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar-empleado',
  imports: [FormsModule],
  templateUrl: './agregar-empleado.html',
})
export class AgregarEmpleado {
  departamentos!: DepartamentoResponse[];

  empleado: EmpleadoRequest = new EmpleadoRequest();

  private departamentoServicio = inject(DepartamentoService);
  private empleadoServicio = inject(EmpleadoService);
  private cdr = inject(ChangeDetectorRef);
  private enrutador = inject(Router);

  ngOnInit(): void {
    this.obtenerDepartamentos();
  }

  onSubmit(): void {
    this.guardarEmpleado();
  }

  private obtenerDepartamentos(): void {
    this.departamentoServicio.obtenerDepartamentosLista().subscribe({
      next: (datos) => {
        this.departamentos = datos;
        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Error al obtener departamentos', error);
      },
    });
  }

  private guardarEmpleado(): void {
    this.empleadoServicio.agregarEmpleado(this.empleado).subscribe({
      next: (respuesta) => {
        console.log('Empleado agregado:', respuesta);

        this.enrutador.navigate(['/empleados']);
      },

      error: (error) => {
        console.error('Error al agregar empleado', error);
      },
    });
  }
}
