export class Usuario {
  public nombre: string;
  public password: string;
  public token?: string;


  constructor(
    nombre: string
    ) {
      this.nombre = nombre;
    }
}
