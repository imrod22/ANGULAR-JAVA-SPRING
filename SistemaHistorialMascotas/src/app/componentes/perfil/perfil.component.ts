import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { Usuario } from 'src/app/modelos/usuario';
import { AlertaService } from 'src/app/servicios/alerta.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  miInfoForm: FormGroup;
  usuario: Usuario;

  constructor(private formBuilder: FormBuilder, private authService: AutenticacionService, private alertaServicio: AlertaService)
  {
    this.authService.usuarioActual.subscribe(x => this.usuario = x);
  }

 get f() { return this.miInfoForm.controls; }

  ngOnInit() {

    this.miInfoForm = this.formBuilder.group({
          email: ['', Validators.required],
          telefono: ['', Validators.required],
          contrasenaactual: ['', [Validators.required, Validators.minLength(6)]],
          contrasenanueva: ['', [Validators.required, Validators.minLength(6)]],
          nombreClinica: [''],
          direccionClinica: [''],
      });

    this.miInfoForm.patchValue({
        email: this.usuario.rol
      });

  }

  onSubmit() {
    if (this.usuario.rol === 'Veterinario' && !this.miInfoForm.value.nombreClinica) {
      this.alertaServicio.error('El nombre de la veterinaria es requerido');
      return;
    }

    if (this.usuario.rol === 'Veterinario' && !this.miInfoForm.value.direccionClinica) {
      this.alertaServicio.error('La direccion de la veterinaria es requerida');
      return;
    }
  }

}
