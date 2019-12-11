export class Usuario {
  public id: string;
  public nombreusuario: string;
  public nombre: string;
  public apellido: string;
  public rol: string;
  public token?: string;

  constructor(
    nombreusuario: string,
    id: string,
    nombre: string,
    rol: string
    ) {
      this.nombreusuario = nombreusuario;
      this.id = id;
      this.nombre = nombre;
      this.rol = rol;
    }
}
