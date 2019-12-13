import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MascotaService } from 'src/app/servicios/mascota.service';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Usuario } from 'src/app/modelos/usuario';
import { first } from 'rxjs/operators';
import { Raza } from 'src/app/modelos/raza';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { AlertaService } from 'src/app/servicios/alerta.service';

@Component({
  selector: 'app-formulario-mascota',
  templateUrl: './formulario-mascota.component.html',
  styleUrls: ['./formulario-mascota.component.css']
})
export class FormularioMascotaComponent implements OnInit {

  nuevaMascotaForm: FormGroup;
  usuario: Usuario;

  loading = false;
  submitted = false;
  veterinarios: Usuario[];
  razas: Raza[];

  sexo = [{clave: 'F',  nombre: 'Hembra'}, {clave: 'M', nombre : 'Macho'}];

  constructor(private formBuilder: FormBuilder,
              private authService: AutenticacionService,
              private mascotaService: MascotaService,
              private router: Router,
              private alertaServicio: AlertaService) {
    this.authService.usuarioActual.subscribe(x => this.usuario = x);

    this.mascotaService.obtenerVeterinarios().pipe().subscribe(
      data => this.veterinarios = data
    );

    this.mascotaService.obtenerRazas().pipe().subscribe(
      data => this.razas = data
    );
  }

  ngOnInit() {
    this.nuevaMascotaForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      fechanacimiento: ['', Validators.required],
      raza: ['', Validators.required],
      idVeterinario: [''],
      idDueno: [''],
      senasParticulares: ['', Validators.required],
      color: ['', Validators.required],
      sexo: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;
    this.alertaServicio.clear();

    if (this.nuevaMascotaForm.invalid) {
        return;
    }

    if (!this.nuevaMascotaForm.value.raza) {
      this.alertaServicio.error('La raza de la nueva mascota es obligatoria');
      return;
    }

    if (!this.nuevaMascotaForm.value.idVeterinario) {
      this.alertaServicio.error('Se debe asignar un veterinario a la nueva mascota.');
      return;
    }

    if (!this.nuevaMascotaForm.value.sexo) {
      this.alertaServicio.error('Se debe asignar un veterinario a la nueva mascota.');
      return;
    }

    this.loading = true;
    this.mascotaService.agregarMascota(this.nuevaMascotaForm.value)
        .pipe(first())
        .subscribe(
            data => {
                this.alertaServicio.success('Se ha registrado la mascota exitosamente en el sistema.');
                this.router.navigate(['/']);
            },
            error => {
                this.alertaServicio.error('Ha ocurrido un error en el servidor. Verifique los valores ingresados.');
                this.loading = false;
            });
}

}
