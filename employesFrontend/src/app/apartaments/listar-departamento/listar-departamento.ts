import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { Router } from '@angular/router';

import { DepartamentoResponse } from '../../models/departamento-response.model';
import { DepartamentoService } from '../../services/departamento-service';

@Component({
  selector: 'app-listar-departamento',
  imports: [],
  templateUrl: './listar-departamento.html',
})
export class ListarDepartamento {
  departamentos!: DepartamentoResponse[];

  private enrutador = inject(Router);
  private cdr = inject(ChangeDetectorRef);
  private departamentoServicio = inject(DepartamentoService);

  ngOnInit(): void {
    this.obtenerDepartamentos();
  }

  private obtenerDepartamentos(): void {
    this.departamentoServicio.obtenerDepartamentosLista().subscribe({
      next: (datos) => {
        this.departamentos = datos;

        this.cdr.detectChanges();
      },

      error: (error) => {
        console.error('Error al obtener la lista de departamentos:', error);
      },
    });
  }

  editarDepartamento(id: number): void {
    this.enrutador.navigate(['editar-departamento', id]);
  }

  eliminarDepartamento(id: number): void {
    this.departamentoServicio.eliminarDepartamento(id).subscribe({
      next: () => {
        console.log('Departamento eliminado con éxito');

        this.obtenerDepartamentos();
      },

      error: (error) => {
        alert(error.error);
      },
    });
  }
}
