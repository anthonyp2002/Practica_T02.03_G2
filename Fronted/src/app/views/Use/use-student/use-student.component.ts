import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/Person/persona';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-use-student',
  templateUrl: './use-student.component.html',
  styleUrls: ['./use-student.component.css']
})
export class UseStudentComponent implements OnInit {

  personaId: number;
  aniolec:String;
  constructor(private peliculaService:ServicesService,private router: Router) {}

  ngOnInit(): void {
    this.personaId = this.peliculaService.getPersonaId();
    this.listPerson();
    console.log("VALOR DE PERSONA",this.personaId)
  }
  
  persona:Persona = new Persona();
  person: any = {};

  listPerson() {
    this.peliculaService.listPerson(this.personaId).subscribe(
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
        this.router.navigate(['/useStudet']);
        this.peliculaService.setPersonaId(this.personaId);
        break;
      case 'Cursos':
        this.router.navigate(['/useStudetListCource']);
        this.peliculaService.setPersonaId(this.personaId);
        break;
      case 'Cursos-Inscritos':
        this.router.navigate(['/useStudetListCourceIns']);
        this.peliculaService.setPersonaId(this.personaId);
        break;
      case 'Tareas':
        this.router.navigate(['/useStudetListTarea']);
        this.peliculaService.setPersonaId(this.personaId);
        break;
    }
  }

}
