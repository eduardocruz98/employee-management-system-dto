import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { DepartamentoRequest } from '../../models/departamento-request.model';
import { DepartamentoResponse } from '../../models/departamento-response.model';
import { DepartamentoService } from '../../services/departamento-service';

@Component({
  selector: 'app-editar-departamento',
  imports: [FormsModule],
  templateUrl: './editar-departamento.html',
})
export class EditarDepartamento {
  // Lo que el formulario enviará al backend
  departamento: DepartamentoRequest = new DepartamentoRequest();

  // Solo para almacenar la respuesta del backend
  departamentoResponse!: DepartamentoResponse;

  private id!: number;

  private enrutador = inject(Router);
  private ruta = inject(ActivatedRoute);
  private cdr = inject(ChangeDetectorRef);
  private departamentoServicio = inject(DepartamentoService);

  ngOnInit(): void {
    this.id = Number(this.ruta.snapshot.params['id']);

    this.departamentoServicio.obtenerDepartamentoPorId(this.id).subscribe({
      next: (datos) => {
        this.departamentoResponse = datos;

        // Copiar datos Response -> Request
        this.departamento.nombre = datos.nombre;

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Error al obtener el departamento:', error);
      },
    });
  }

  onSubmit(): void {
    this.actualizarDepartamento();
  }

  private actualizarDepartamento(): void {
    this.departamentoServicio.editarDepartamentoPorId(this.id, this.departamento).subscribe({
      next: () => {
        console.log('Departamento actualizado correctamente');

        this.irDepartamentoLista();
      },

      error: (error) => {
        console.error('Error al actualizar el departamento:', error);
      },
    });
  }

  private irDepartamentoLista(): void {
    this.enrutador.navigate(['/agregar-departamento']);
  }
}
