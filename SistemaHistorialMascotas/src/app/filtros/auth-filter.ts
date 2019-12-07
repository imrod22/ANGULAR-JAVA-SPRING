import { Injectable } from '@angular/core';
import { CanActivate, Router, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { AutenticacionService } from '../servicios/autenticacion.service';

@Injectable({ providedIn: 'root' })

export class AuthFilter implements CanActivate  {

  constructor(
    private router: Router,
    private authenticationService: AutenticacionService
) { }

canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const currentUser = this.authenticationService.usuarioActualValue;
    if (currentUser) {
        return true;
    }

    this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
    return false;
}

}
