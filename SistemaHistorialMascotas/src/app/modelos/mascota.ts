import { environment } from 'src/environments/environment';

export class Mascota {
    public id: string;
    public nombre: string;
    public urlImagen: string;
    public raza: string;
    public fechanacimiento: string;
    public idVeterinario: string;
    public idDueno: string;
    public senasParticulares: string;
    public color: string;
    public sexo: string;


    public getUrlImagen(){
        return  environment.url.concat("imagenes/"+ this.urlImagen);
    }

    constructor(){
        console.log("entro");
        
    }
}
