import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelos/usuario';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuarioLogueado: Usuario;

  constructor(private authService: AutenticacionService) {
    this.authService.usuarioActual.subscribe(x => this.usuarioLogueado = x);
  }

  ngOnInit() {
    
  }

  isHomePublic(){
    return true;
  }

}
