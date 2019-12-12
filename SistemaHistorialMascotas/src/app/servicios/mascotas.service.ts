import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Mascota } from '../modelos/mascota';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MascotasService {

  constructor(private http: HttpClient) { }

  obtenerMascotasPublico() {

    let mascotas: Mascota[] = [];

    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', }), responseType: 'text' as 'json' };
    this.http.get<any[]>(environment.url.concat('mascotas/24')).subscribe(
      result => {
        result.forEach(element => {

          mascotas.push(new Mascota(element)); 

        });
      }
    );

    console.log(mascotas);

    return mascotas;
  }
}
