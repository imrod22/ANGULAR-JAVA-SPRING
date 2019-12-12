import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Mascota } from '../modelos/mascota';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';
import { Usuario } from '../modelos/usuario';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {

  private usuarioActualSubject: BehaviorSubject<Usuario>;
  public usuarioActual: Observable<Usuario>;
  public idDuenoActual: string;

  constructor(private http: HttpClient) {
    this.usuarioActualSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('usuarioActual')));
    this.usuarioActual = this.usuarioActualSubject.asObservable();
  }

  obtenerMascotas(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      observe: 'response' as 'body'
    };

    return this.http.get<any>(environment.url.concat('mismascotas/').concat(id))
      .pipe(map(response => {
        return response;
      }));

  }

  /**
   * obtiene todas las mascotas que se van a ver en forma publica
   */
  obtenerMascotaPublico(){
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      observe: 'response' as 'body'
    };

    return this.http.get<any>(environment.url.concat('mascotas'))
      .pipe(map(response => {
        return response;
      }));    
  }

  obtenerVeterinarios() {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      observe: 'response' as 'body'
    };

    return this.http.get<any>(environment.url.concat('veterinarios'))
      .pipe(map(response => {
        return response;
      }));

  }


}
