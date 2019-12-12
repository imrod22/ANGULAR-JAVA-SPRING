import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { AlertaService } from 'src/app/servicios/alerta.service';

@Component({ templateUrl: 'login.component.html' })

export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AutenticacionService,
        private alertaService: AlertaService
    ) {

    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            usuario: ['', Validators.required],
            password: ['', Validators.required]
        });

        this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
    }

    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        this.alertaService.clear();

        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authService.login(this.f.usuario.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                  this.alertaService.error('Nombre de usuario o Contraseña incorrectas');
                  this.loading = false;
                });
    }
}
