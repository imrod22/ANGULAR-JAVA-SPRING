export class Usuario {
  public nombre: string;
  public password: string;
  public token?: string;


  constructor(
    nombre: string,
    password: string
    ) {
      this.nombre = nombre;
      this.password = password;
    }
}
