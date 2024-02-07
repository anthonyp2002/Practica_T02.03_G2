import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/Person/persona';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

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
        this.router.navigate(['/useStudet']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Cursos':
        this.router.navigate(['/useStudetListCource']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Cursos-Inscritos':
        this.router.navigate(['/useStudetListCourceIns']);
        this.navService.setPersonaId(this.personaId);
        break;
      case 'Tareas':
        this.router.navigate(['/useStudetListTarea']);
        this.navService.setPersonaId(this.personaId);
        break;
    }
  }

}
