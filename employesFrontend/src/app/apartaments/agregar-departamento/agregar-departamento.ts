import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { DepartamentoRequest } from '../../models/departamento-request.model';
import { DepartamentoService } from '../../services/departamento-service';
import { ListarDepartamento } from '../listar-departamento/listar-departamento';

@Component({
  selector: 'app-agregar-departamento',
  imports: [FormsModule, ListarDepartamento],
  templateUrl: './agregar-departamento.html',
})
export class AgregarDepartamento {
  departamento: DepartamentoRequest = new DepartamentoRequest();

  private departamentoServicio = inject(DepartamentoService);
  private enrutador = inject(Router);

  onSubmit(): void {
    this.guardarDepartamento();
  }

  private guardarDepartamento(): void {
    this.departamentoServicio.agregarDepartamento(this.departamento).subscribe({
      next: (departamentoGuardado) => {
        console.log('Departamento agregado:', departamentoGuardado);

        this.enrutador.navigate(['/empleados']);
      },

      error: (error) => {
        console.error('Error al agregar el departamento:', error);
      },
    });
  }
}
