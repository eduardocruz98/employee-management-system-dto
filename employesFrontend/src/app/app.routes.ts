import { Routes } from '@angular/router';
import { ListarEmpleados } from './employes/listar-empleados/listar-empleados';
import { AgregarEmpleado } from './employes/agregar-empleado/agregar-empleado';
import { EditarEmpleado } from './employes/editar-empleado/editar-empleado';
import { EditarDepartamento } from './apartaments/editar-departamento/editar-departamento';
import { AgregarDepartamento } from './apartaments/agregar-departamento/agregar-departamento';

export const routes: Routes = [
    //Ruta de inicio en mi proyecto
  //http://localhost:4200/empleados
  //http://localhost:4200/
  { path: 'empleados', component: ListarEmpleados },
  { path: '', redirectTo: 'empleados', pathMatch: 'full' },
  //http://localhost:4200/agregar-empleado
  { path: 'agregar-empleado', component: AgregarEmpleado },
  //http://localhost:4200/editar-empleado/1
  {path: 'editar-empleado/:id', component: EditarEmpleado},
  {path: 'agregar-departamento', component: AgregarDepartamento},
  {path:'editar-departamento/:id', component: EditarDepartamento}
];
