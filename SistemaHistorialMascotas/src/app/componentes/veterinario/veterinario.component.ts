import { Component, OnInit, ViewChild } from '@angular/core';
import { Mascota } from 'src/app/modelos/mascota';
import { Usuario } from 'src/app/modelos/usuario';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})

export class VeterinarioComponent implements OnInit {
  usuario: Usuario;
  displayedColumns: string[] = ['nombre', 'raza', 'fechanacimiento'];
  loading = false;
  pacientes: MatTableDataSource<Mascota>;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private authService: AutenticacionService,
              private usuarioService: UsuarioService) {
    this.authService.usuarioActual.subscribe(x => this.usuario = x);
  }

  ngOnInit() {
    this.usuarioService.obtenerPacientes(this.usuario.id).pipe(first())
    .subscribe(
      data => {
        this.pacientes = new MatTableDataSource(data);
        this.pacientes.paginator = this.paginator;
        this.pacientes.sort = this.sort;
      });
  }
}
