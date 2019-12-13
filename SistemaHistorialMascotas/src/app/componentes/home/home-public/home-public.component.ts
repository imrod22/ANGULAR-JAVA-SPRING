import { Component, OnInit } from '@angular/core';
import { Mascota } from 'src/app/modelos/mascota';
import { MascotaService } from 'src/app/servicios/mascota.service';

@Component({
  selector: 'app-home-public',
  templateUrl: './home-public.component.html',
  styleUrls: ['./home-public.component.css']
})
export class HomePublicComponent implements OnInit {

  mascotas: Mascota[];

  constructor(private mascotaService: MascotaService) { }

  ngOnInit() {  }
}
