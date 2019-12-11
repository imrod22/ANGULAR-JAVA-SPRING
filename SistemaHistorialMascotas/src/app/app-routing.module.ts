import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { AuthFilter } from './filtros/auth-filter';
import { HomeComponent } from './componentes/home/home.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { PerfilComponent } from './componentes/perfil/perfil.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AuthFilter]
},
{
    path: 'login',
    component: LoginComponent
},
{   path: 'registro',
    component: RegistroComponent
  },
  {   path: 'perfil',
    component: PerfilComponent,
    canActivate: [AuthFilter]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
