import { Component, OnInit } from '@angular/core';
import { Mascota } from 'src/app/modelos/mascota';
import { MascotaService } from 'src/app/servicios/mascota.service';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-home-public',
  templateUrl: './home-public.component.html',
  styleUrls: ['./home-public.component.css']
})
export class HomePublicComponent implements OnInit {
  mascotas: Mascota[];

  constructor(private mascotaService: MascotaService) {

    //this.mascotas =[];

    console.log(this.mascotaService.obtenerMascotaPublico().pipe());

    this.mascotaService.obtenerMascotaPublico().pipe().subscribe(
      data => this.mascotas = data
    );

    console.log(this.mascotas);

  }

  ngOnInit() {

  }

}
