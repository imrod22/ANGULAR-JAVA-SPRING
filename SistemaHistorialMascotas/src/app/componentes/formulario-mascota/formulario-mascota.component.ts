import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSort, MatTableDataSource, MatDatepickerInputEvent, MatInput } from '@angular/material';
import { MatPaginator } from '@angular/material/paginator';
import { MascotaService } from 'src/app/servicios/mascota.service';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Usuario } from 'src/app/modelos/usuario';
import { first } from 'rxjs/operators';
import { Mascota } from 'src/app/modelos/mascota';

@Component({
  selector: 'app-formulario-mascota',
  templateUrl: './formulario-mascota.component.html',
  styleUrls: ['./formulario-mascota.component.css']
})
export class FormularioMascotaComponent implements OnInit {

  nuevaMascotaForm: FormGroup;
  usuario: Usuario;

  loading = false;
  veterinarios: Usuario[];


  displayedColumns: string[] = ['nombre', 'raza', 'fechanacimiento'];

  constructor(private formBuilder: FormBuilder,
    private authService: AutenticacionService,
    private mascotaService: MascotaService) {
    this.authService.usuarioActual.subscribe(x => this.usuario = x);

    this.mascotaService.obtenerVeterinarios().pipe().subscribe(
      data => this.veterinarios = data
    );


  }

  ngOnInit() {
    this.nuevaMascotaForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      fechanacimiento: ['', Validators.required],
      idRaza: ['', Validators.required],
      idVeterinario: [''],
      idDueno: [''],
      senasParticulares: ['', Validators.required],
      color: ['', Validators.required],
      sexo: ['', Validators.required]
    });
  }

  onSubmit() { }

}
