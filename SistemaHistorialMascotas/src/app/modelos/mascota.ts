import { environment } from 'src/environments/environment';

export class Mascota {
    public id: string;
    public nombre: string;
    public imagen: string;
    public descripcionRaza: string;
    public descripcionEspecie: string;
    public fechanacimiento: string;
    public idVeterinario: string;
    public nombreVeterinario: string;
    public idDueno: string;
    public nombreDuenio: string;
    public senasParticulares: string;
    public color: string;
    public sexo: string;

    public getImagenUrl() {
       return  environment.url.concat('imagenes/' + this.imagen );
    }

    constructor(mascota: any) {  }
}
