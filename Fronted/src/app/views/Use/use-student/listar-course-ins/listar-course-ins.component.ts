import { Component, OnInit } from '@angular/core';
import { Cource } from 'src/app/models/Cource/cource';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-listar-course-ins',
  templateUrl: './listar-course-ins.component.html',
  styleUrls: ['./listar-course-ins.component.css']
})
export class ListarCourseInsComponent  implements OnInit {

  constructor(private courceUseServicio:ServicesService) {}
  personaId: number;
  cource:Cource[];
  course:Cource[];

  ngOnInit(): void {
    this.personaId = this.courceUseServicio.getPersonaId();
    console.log("VALOR DE PERSONA",this.personaId)
    this.listCourceUser();
  }

  listCourceId(anioLectivo:String){
    this.courceUseServicio.listCourceAnio(anioLectivo).subscribe(dato=>{
      this.cource =dato;
      console.log(this.cource)
    })
  }

  listCourceUser(){
    this.courceUseServicio.listCourceUse(this.personaId).subscribe(dato=>{
      this.cource=dato;
      console.log(this.cource)
    })
  }

}
