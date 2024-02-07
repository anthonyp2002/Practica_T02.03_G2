import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/Person/persona';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  persona:Persona=new Persona();
  tipoUser:String="Tipo de Usuario";

  constructor(private personaServicio:ServicesService,private router: Router) {}
  id: number;
  ngOnInit(): void {

  }

  onSubmit() {
    if (!this.persona.nombre || !this.persona.apellido || !this.persona.fe_nacimi || !this.persona.cedula)  {
      console.log("Ingrese todos los datos")
    } else {
      if(this.tipoUser=="Maestro"){
        console.log("Es maestro")
        this.registerteacher();
      }else{
        this.registerStudent();
      }
    }
  }

  registerStudent(){
    console.log("Persona",this.persona)
    this.personaServicio.registerPerson(this.persona).subscribe({
      next:(dato: any) =>{
        for (const prop in dato) {
          if (Object.prototype.hasOwnProperty.call(dato, prop)) {
            if (typeof dato[prop] === 'number') {
             this.personaServicio.setPersonaId(dato[prop]);
              this.router.navigate(['/useStudet']);
              console.log(dato[prop]);
              
            }
          }
        }
        this.persona = new Persona()
      },
      error: err => console.log(err)
    })
    
  }

  registerteacher(){
    console.log("Persona",this.persona)
    this.personaServicio.registerteacher(this.persona).subscribe({
      next:(dato: any) =>{
        for (const prop in dato) {
          if (Object.prototype.hasOwnProperty.call(dato, prop)) {
            if (typeof dato[prop] === 'number') {
             this.personaServicio.setPersonaId(dato[prop]);
              this.router.navigate(['/useTeacher']);
              console.log(dato[prop]);
              
            }
          }
        }
        this.persona = new Persona()
      },
      error: err => console.log(err)
    })
    
  }

}
