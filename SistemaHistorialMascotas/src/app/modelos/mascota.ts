import { environment } from 'src/environments/environment';

export class Mascota {
    public id: string;
    public nombre: string;
    public imagen: string;
    public raza: string;
    public especie: string;
    public fechanacimiento: string;
    public idVeterinario: string;
    public nombreapellidoVeterinario: string;
    public idDueno: string;
    public nombreapellidoDueno: string;
    public senasParticulares: string;
    public color: string;
    public sexo: string;

    public getImagenUrl() {
       return  environment.url.concat('imagenes/' + this.imagen );
    }

    constructor(mascota: any) {  }
}
