import { Component, OnInit, ViewChild } from '@angular/core';
import { Mascota } from 'src/app/modelos/mascota';
import { Usuario } from 'src/app/modelos/usuario';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})
export class VeterinarioComponent implements OnInit {
  usuario: Usuario;

  loading = false;
  pacientes: MatTableDataSource<Mascota>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor() {}

  ngOnInit() {}
}
