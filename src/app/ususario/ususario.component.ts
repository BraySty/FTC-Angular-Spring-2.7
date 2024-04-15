import { Component } from '@angular/core';
import { jwtDecode } from 'jwt-decode';

@Component({
  selector: 'app-ususario',
  templateUrl: './ususario.component.html',
  styleUrl: './ususario.component.css'
})
export class UsusarioComponent {

  nombre = "";
  email = "";
  password = "";

  constructor() {
    const token = localStorage.getItem('token');
    if (token) {
      const tokenInfo = this.getDecodedAccessToken(token);
      const expireDate = tokenInfo.exp;
      this.nombre = tokenInfo.sub;
      console.log(expireDate);
    } else {
      // handle the case where the token is null
    }
  }

  /**
   * 
   * @param token Decodifica el token
   * @returns 
   */
  getDecodedAccessToken(token: string): any {
    try {
      return jwtDecode(token);
    } catch (Error) {
      return null;
    }
  }

}
