import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/Person/persona';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent  implements OnInit {

  personaId: number;
  aniolec:String;

  constructor(private navService:ServicesService,private router: Router) {}

  ngOnInit(): void {
    this.personaId = this.navService.getPersonaId();
    console.log("VALOR DE PERSONA",this.personaId)
  }
  
  persona:Persona = new Persona();
  person: any = {};

  listPerson() {
    this.navService.listPerson(this.personaId).subscribe(
      data => {
        this.person = data;
        const aniolec: any = (this.person as any).aniolec;

        console.log(this.person);
      },
      error => {
        console.error('Error al recuperar la información del estudiante:', error);
      }
    );
  }

  
  personid(nav:String){
    switch (nav) {
      case 'Home':
        this.router.navigate(['/useTeacher']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Cursos':
        this.router.navigate(['/useTeacherCource']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Clases':
        this.router.navigate(['/useTeacherClass']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Tareas':
        this.router.navigate(['/useTeacherTareas']);
        this.navService.setPersonaId(this.personaId);
        break;
    }
  }

}
