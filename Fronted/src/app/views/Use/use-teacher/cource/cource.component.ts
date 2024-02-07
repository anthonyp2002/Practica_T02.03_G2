import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cource } from 'src/app/models/Cource/cource';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-cource',
  templateUrl: './cource.component.html',
  styleUrls: ['./cource.component.css']
})
export class CourceComponent implements OnInit {

  constructor(private courceService:ServicesService,private router: Router) {}
  personaId: number;
  course:Cource=new Cource();
  cursos:Cource[];
  showCreateProduct = false;
  showCreateProdu = true;

  ngOnInit(): void {
    this.personaId = this.courceService.getPersonaId();
    console.log("VALOR DE PERSONA",this.personaId)
      this.listCourceId(this.personaId);
  }

  toggleCreateProduct() {
    this.showCreateProduct = !this.showCreateProduct;
  }

  toggleButton() {
    this.showCreateProdu = !this.showCreateProdu;
    this.toggleCreateProduct();
  }

  toggle(){
    this.showCreateProdu = !this.showCreateProdu;
    this.showCreateProduct = !this.showCreateProduct;
  }

  registerCourse(){
    this.course.idTeacher=this.personaId;
    console.log("Persona",this.course)
    this.courceService.saveCourse(this.course).subscribe({
      next:dato=>{
        console.log(dato)
      },
    }) 
    this.course=new Cource(); 
    this.listCourceId(this.personaId);

  }

  listCourceId(idTeacher:number){
    this.courceService.listCourceidTeacher(idTeacher).subscribe(dato=>{
      this.cursos =dato;
      console.log(this.cursos)
    })
  }

}