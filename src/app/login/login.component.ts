import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  loginObj: Login;

  constructor(private http: HttpClient, private router: Router) {
    this.loginObj = new Login();
  }

  OnLogin() {
    debugger;
    const headers = new HttpHeaders();
    const body = {userName: this.loginObj.nombre, password: this.loginObj.password}
    this.http.post<any>("http://localhost:8100/api/v1/auth/login", body, { headers }).subscribe((res:any)=>{
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

export class Login {

  nombre: string;
  password:string;

  constructor() {
    this.nombre = "";
    this.password = "";
  }

}
