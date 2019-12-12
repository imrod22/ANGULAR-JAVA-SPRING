import { Component, OnInit } from '@angular/core';
import { Mascota } from 'src/app/modelos/mascota';
import { MascotasService } from 'src/app/servicios/mascotas.service';

@Component({
  selector: 'app-home-public',
  templateUrl: './home-public.component.html',
  styleUrls: ['./home-public.component.css']
})
export class HomePublicComponent implements OnInit {

  mascotas : Mascota[];

  constructor(private mascotaService : MascotasService) { }

  ngOnInit() {
    this.mascotas = this.mascotaService.obtenerMascotasPublico();
  }
}
