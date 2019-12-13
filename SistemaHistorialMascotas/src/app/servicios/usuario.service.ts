import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../modelos/usuario';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import { InformacionUsuario } from '../modelos/informacion-usuario';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuarioActualSubject: BehaviorSubject<Usuario>;
  public usuarioActual: Observable<Usuario>;

  constructor(private http: HttpClient) {
    this.usuarioActualSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('usuarioActual')));
    this.usuarioActual = this.usuarioActualSubject.asObservable();
  }

  registrar(usuario: Usuario) {

    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', }), responseType: 'text' as 'json' };

    return this.http.post<any>(environment.url.concat('registrar'), usuario, httpOptions);
}

  obtenerInformacionBasica(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      observe: 'response' as 'body'
    };

    return this.http.post<any>(environment.url.concat('informacionusuario'), { id }, httpOptions)
    .pipe(map(response => {

      const infoBasica = new InformacionUsuario();

      if (response) {

        if (response.body.rol === 'Veterinario') {
          infoBasica.nombreClinica = response.body.nombreConsultorio;
          infoBasica.direccionClinica = response.body.direccion;
          infoBasica.idVeterinaria = response.body.idVeterinaria;
        }

        infoBasica.email = response.body.email;
        infoBasica.telefono = response.body.telefono;

        localStorage.setItem('infoBasica', JSON.stringify(infoBasica));
      }

      return infoBasica;
  }));

  }

  actualizar(info: InformacionUsuario) {

    this.usuarioActual.subscribe(x => {
      info.id = x.id;
      info.rol = x.rol;
    });

    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', }), responseType: 'text' as 'json' };

    return this.http.post<any>(environment.url.concat('actualizar'), info, httpOptions);
  }

  obtenerPacientes(id: string) {
    return this.http.get<any>(environment.url.concat('pacientes/').concat(id))
    .pipe(map(response => {
      return response;
  }));
  }
}
