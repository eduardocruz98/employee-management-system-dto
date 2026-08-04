import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { Router } from '@angular/router';

import { EmpleadoResponse } from '../../models/empleado-response.model';
import { EmpleadoService } from '../../services/empleado-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listar-empleados',
  imports: [CurrencyPipe, FormsModule],
  templateUrl: './listar-empleados.html',
})
export class ListarEmpleados {
  nombreBuscar: string = '';
  empleados !: EmpleadoResponse[];

  private empleadoServicio = inject(EmpleadoService);
  private cdr = inject(ChangeDetectorRef);
  private enrutador = inject(Router);

  ngOnInit(): void {
    this.obtenerEmpleados();
  }

  obtenerEmpleados(): void {
    this.empleadoServicio.obtenerEmpleadosLista().subscribe({
      next: (datos) => {
        this.empleados = datos;
        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Error al obtener la lista de empleados:', error);
      },
    });
  }

  // Es público porque se utiliza desde el template HTML.
  editarEmpleado(id: number): void {
    this.enrutador.navigate(['editar-empleado', id]);
  }

  eliminarEmpleado(id: number): void {
    this.empleadoServicio.eliminarEmpleado(id).subscribe({
      next: () => {
        console.log('Empleado eliminado con éxito');
        this.obtenerEmpleados();
      },

      error: (error) => {
        console.error('Error al eliminar el empleado:', error);
      },
    });
  }

  buscarEmpleado(): void {
    if (this.nombreBuscar.trim() === '') {
      this.obtenerEmpleados();

      return;
    }

    this.empleadoServicio.obtenerEmpleadoPorNombre(this.nombreBuscar).subscribe({
      next: (datos) => {
      this.empleados = datos;

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error(error);
      },
    });
  }

}
