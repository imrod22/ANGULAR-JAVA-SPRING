import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {  MatTableModule, MatPaginatorModule, MatSortModule, MatPaginatorIntl,
  MatFormFieldModule, MatInputModule, MatNativeDateModule, MatDatepickerModule, MAT_DATE_LOCALE } from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './componentes/home/home.component';
import { JwtTokenInterceptor } from './helpers/jwt-token-interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DuenioComponent } from './componentes/duenio/duenio.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { ErrorInterceptor } from './helpers/error-interceptor';
import { AlertaComponent } from './componentes/alerta/alerta.component';
import { PerfilComponent } from './componentes/perfil/perfil.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomePublicComponent } from './componentes/home/home-public/home-public.component';
import { FormularioMascotaComponent } from './componentes/formulario-mascota/formulario-mascota.component';
import { VeterinarioComponent } from './componentes/veterinario/veterinario.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    DuenioComponent,
    RegistroComponent,
    AlertaComponent,
    PerfilComponent,
    VeterinarioComponent,
    HomePublicComponent,
    FormularioMascotaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgbModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    AngularFontAwesomeModule
  ],
  providers: [
              { provide: HTTP_INTERCEPTORS, useClass: JwtTokenInterceptor, multi: true },
              { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
            ],
  bootstrap: [AppComponent]
})
export class AppModule { }
