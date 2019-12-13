import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Usuario } from 'src/app/modelos/usuario';
import { AlertaService } from 'src/app/servicios/alerta.service';
import { InformacionUsuario } from 'src/app/modelos/informacion-usuario';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  miInfoForm: FormGroup;
  usuario: Usuario;
  infobasica: InformacionUsuario;
  loading = false;

  constructor(private formBuilder: FormBuilder,
              private authService: AutenticacionService,
              private router: Router,
              private alertaServicio: AlertaService,
              private usuarioService: UsuarioService) {
    this.authService.usuarioActual.subscribe(x => this.usuario = x);

    this.usuarioService.obtenerInformacionBasica(this.usuario.id).pipe(first())
    .subscribe(
        data => {
            this.infobasica = data;

            this.miInfoForm.patchValue({
              idVeterinaria: this.infobasica.idVeterinaria
            });

            this.miInfoForm.patchValue({
              email: this.infobasica.email
            });

            this.miInfoForm.patchValue({
              telefono: this.infobasica.telefono
            });

            this.miInfoForm.patchValue({
              nombreClinica: this.infobasica.nombreClinica
            });

            this.miInfoForm.patchValue({
              direccionClinica: this.infobasica.direccionClinica
            });
        });
  }

 get f() { return this.miInfoForm.controls; }

  ngOnInit() {

    this.miInfoForm = this.formBuilder.group({
          email: ['', Validators.required],
          telefono: ['', Validators.required],
          contrasenia: ['', [Validators.required, Validators.minLength(6)]],
          contrasenarepetida: ['', [Validators.required, Validators.minLength(6)]],
          idVeterinaria: [''],
          nombreClinica: [''],
          direccionClinica: [''],
      });
  }

  onSubmit() {

    if (this.miInfoForm.invalid) {
      this.alertaServicio.error('No se ha ingresado toda la informacion necesaria.');
      this.loading = false;
      return;
    }

    if (this.miInfoForm.value.contrasenia !== this.miInfoForm.value.contrasenarepetida) {
      this.loading = false;
      this.alertaServicio.error('Las contraseñas ingresadas no coincide.');
      return;
    }

    if (this.usuario.rol === 'Veterinario' && !this.miInfoForm.value.nombreClinica) {
      this.loading = false;
      this.alertaServicio.error('El nombre de la veterinaria es requerido.');
      return;
    }

    if (this.usuario.rol === 'Veterinario' && !this.miInfoForm.value.direccionClinica) {
      this.loading = false;
      this.alertaServicio.error('La direccion de la veterinaria es requerida');
      return;
    }

    this.loading = true;
    this.usuarioService.actualizar(this.miInfoForm.value)
          .pipe(first())
          .subscribe(
              data => {
                  this.alertaServicio.success('Se ha actualizado la informacion exitosamente en el sistema.');
                  this.router.navigate(['/']);
              },
              error => {
                  this.alertaServicio.error('Ha ocurrido un error en el servidor. Verifique los valores ingresados.');
                  this.router.navigate(['/']);
                  this.loading = false;
              });


  }

}
