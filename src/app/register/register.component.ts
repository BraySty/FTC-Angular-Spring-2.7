import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  registerObj: Register;

  users: any[] = [];
  constructor(private http: HttpClient, private router: Router) {
    this.registerObj = new Register()
  }

  OnRegister() {
    debugger;
    const headers = new HttpHeaders();
    const body = { userName: this.registerObj.nombre, correo: this.registerObj.correo, password: this.registerObj.password }
    this.http.post<any>("http://localhost:8100/api/v1/auth/register", body, { headers }).subscribe((res: any) => {
      if (res.result) {
        alert("Login Success");
        localStorage.setItem("token", res.token)
        this.router.navigateByUrl("/usuario")
      } else {
        alert(res.message)
      }
    }, error => {
      alert("Error from API")
    })
  }

}

export class Register {

  nombre: string;
  correo: string;
  password: string;

  constructor() {
    this.nombre = "";
    this.correo = "";
    this.password = "";
  }

}
