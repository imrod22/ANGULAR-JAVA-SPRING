import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../modelos/usuario';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  registrar(usuario: Usuario) {

    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json', }), responseType: 'text' as 'json' };

    return this.http.post<any>(environment.url.concat('registrar'), usuario, httpOptions);
}
}
