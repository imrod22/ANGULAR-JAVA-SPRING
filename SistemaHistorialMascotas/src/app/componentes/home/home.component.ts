import { Component, OnInit } from '@angular/core';
import { MascotasService } from 'src/app/servicios/mascotas.service';
import { Mascota } from 'src/app/modelos/mascota';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    
  }

  isHomePublic(){
    return true;
  }

}
