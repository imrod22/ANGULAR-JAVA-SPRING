import { environment } from 'src/environments/environment';

export class Mascota {
    public id: string;
    public nombre: string;
    public imagenUrl: any;

    constructor(mascota: any) {

        //nombre
        this.nombre = mascota.campoFicha.find(ficha => ficha.campo.nombre == "Nombre") !== undefined ?
            mascota.campoFicha.find(ficha => ficha.campo.nombre == "Nombre").valor : null;

        console.log(mascota);

        //id
        this.id = mascota.campoFicha.find(ficha => ficha.campo.nombre == "id") !== undefined ?
            mascota.campoFicha.find(ficha => ficha.campo.nombre == "id").valor : null;

        //imagen
        this.imagenUrl = mascota.campoFicha.find(ficha => ficha.campo.nombre == "imagen") !== undefined ?
            environment.url.concat('imagenes/' + mascota.campoFicha.find(ficha => ficha.campo.nombre == "imagen").valor) : null;

        //console.log (this.imagenUrl);
    }
}
