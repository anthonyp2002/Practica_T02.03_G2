import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/Person/persona';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  persona:Persona = new Persona();
  personas:Persona[];
  user:String;
  password:String;

  constructor(private personaServicio:ServicesService,private router: Router) {}
  id: number;
  ngOnInit(): void {

  }

  onSubmit() {
    if (!this.user || !this.password)  {
      console.log("Ingrese todos los datos")
    } else {
      this.loginUser();
    }
  }

  loginUser(){
    this.personaServicio.getPersonConUse(this.user,this.password).subscribe(dato=>{
      this.personas=dato;
      if(this.personas==null){
        console.log("Ingrese todos los datos correctamente o cree una cuenta")
        console.log(this.personas)
      }else{
        console.log(this.personas)
        const id: any = (this.personas as any).id;
        const persona: any = (this.personas as any).especial;

        console.log("El id es" + id);
        console.log("La persona es " + persona);
        if(persona){
          console.log("Es  maestro");
          this.router.navigate(['/useTeacher']);
          this.personaServicio.setPersonaId(id);
        }else{
          console.log("Es  estudiante");
          this.router.navigate(['/useStudet']);
          this.personaServicio.setPersonaId(id);
        }

      }
    })
  }
}

