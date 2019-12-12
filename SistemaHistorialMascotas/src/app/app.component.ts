import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from './modelos/usuario';
import { AutenticacionService } from './servicios/autenticacion.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'HospitalDeMascotas';
  usuarioLogueado: Usuario;

  constructor(
      private router: Router,
      private authService: AutenticacionService
  ) {
      this.authService.usuarioActual.subscribe(x => this.usuarioLogueado = x);
  }

  logout() {
      this.authService.logout();
      this.router.navigate(['/']);
  }
}
