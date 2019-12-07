import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Usuario } from '../modelos/usuario';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class AutenticacionService {

  private usuarioActualSubject: BehaviorSubject<Usuario>;
  public usuarioActual: Observable<Usuario>;

  constructor(private http: HttpClient) {
  this.usuarioActualSubject = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem('usuarioActual')));
  this.usuarioActual = this.usuarioActualSubject.asObservable();
}

public get usuarioActualValue(): Usuario {
return this.usuarioActualSubject.value;
}

login(usuario: string, password: string) {
  const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  return this.http.post<any>(environment.url.concat('login'), { usuario, password }, httpOptions).pipe(map(response => {

    if (response && response.headers.token) {
      const usuarioLogueado = new Usuario(usuario, password);
      usuarioLogueado.token = response.headers.token;

      localStorage.setItem('usuarioActual', JSON.stringify(usuarioLogueado));
      this.usuarioActualSubject.next(usuarioLogueado);
    }

    return response;
}));
}

logout() {
  localStorage.removeItem('usuarioActual');
  this.usuarioActualSubject.next(null);
}
}