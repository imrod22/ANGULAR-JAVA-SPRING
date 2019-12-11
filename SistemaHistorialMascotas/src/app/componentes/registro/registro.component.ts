import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { first } from 'rxjs/operators';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { AlertaService } from 'src/app/servicios/alerta.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  registroForm: FormGroup;
  loading = false;
  submitted = false;
  roles = [{clave: 'Dueno',  nombre: 'Dueño'}, {clave: 'Veterinario', nombre : 'Veterinario'}];
  faltaNombreVeterinaria = false;
  faltaDireccionVeterinaria = false;

  constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      private authServicio: AutenticacionService,
      private usuarioServicio: UsuarioService,
      private alertaServicio: AlertaService
  ) {
      if (this.authServicio.usuarioActualValue) {
          this.router.navigate(['/']);
      }
  }

  ngOnInit() {
      this.registroForm = this.formBuilder.group({
          nombre: ['', Validators.required],
          apellido: ['', Validators.required],
          email: ['', Validators.required],
          telefono: ['', Validators.required],
          nombreusuario: ['', Validators.required],
          contrasena: ['', [Validators.required, Validators.minLength(6)]],
          rol: ['', Validators.required],
          nombreClinica: [''],
          direccionClinica: [''],

      });
  }

  get f() { return this.registroForm.controls; }

  onSubmit() {
      this.submitted = true;
      this.faltaDireccionVeterinaria = false;
      this.faltaNombreVeterinaria = false;
      this.alertaServicio.clear();

      if (this.registroForm.invalid) {
          return;
      }

      if (this.registroForm.value.rol === 'Veterinario' && !this.registroForm.value.nombreClinica) {
        this.alertaServicio.error('El nombre de la veterinaria es requerido');
        return;
      }

      if (this.registroForm.value.rol === 'Veterinario' && !this.registroForm.value.direccionClinica) {
        this.alertaServicio.error('La direccion de la veterinaria es requerida');
        return;
        return;
      }

      this.loading = true;
      this.usuarioServicio.registrar(this.registroForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.router.navigate(['/login']);
              },
              error => {
                  this.alertaServicio.error('Ha ocurrido un error en el servidor.');
                  this.loading = false;
              });
  }
}
