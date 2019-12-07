import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { AutenticacionService } from '../servicios/autenticacion.service';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class JwtTokenInterceptor  implements HttpInterceptor {
  constructor(private authenticationService: AutenticacionService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        const usuarioLogueado = this.authenticationService.usuarioActualValue;
        if (usuarioLogueado && usuarioLogueado.token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${usuarioLogueado.token}`
                }
            });
        }

        return next.handle(request);
    }
}
