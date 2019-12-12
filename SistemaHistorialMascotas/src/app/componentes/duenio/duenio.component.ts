import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, MatPaginator, MatTableDataSource } from '@angular/material';
import { MascotaService } from 'src/app/servicios/mascota.service';
import { Mascota } from 'src/app/modelos/mascota';
import { first } from 'rxjs/operators';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Usuario } from 'src/app/modelos/usuario';

@Component({
  selector: 'app-duenio',
  templateUrl: './duenio.component.html',
  styleUrls: ['./duenio.component.css']
})
export class DuenioComponent implements OnInit {

  usuario: Usuario;
  misMascotas: MatTableDataSource<Mascota>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private mascotaService: MascotaService,
    private authService: AutenticacionService) { 

    this.authService.usuarioActual.subscribe(x => this.usuario = x);
  }

  ngOnInit() {

    this.mascotaService.obtenerMascotas(this.usuario.id).pipe(first())
    .subscribe(
      data => {
        this.misMascotas = new MatTableDataSource(data);
        this.misMascotas.paginator = this.paginator;
        this.misMascotas.sort = this.sort;
      });

  }

}
