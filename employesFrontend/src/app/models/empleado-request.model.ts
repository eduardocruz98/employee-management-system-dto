export class EmpleadoRequest {
 //Este modelo representa el JSON que angular enviara al backend 
 //para agregar empleado por ejemplo   
  nombre!: string;
  apellido!: string;
  correo!: string;
  telefono!: string;
  salario!: number;
  idDepartamento!: number;
}
