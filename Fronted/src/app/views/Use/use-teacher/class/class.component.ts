import { Component, OnInit } from '@angular/core';
import { ServicesService } from 'src/app/service/services.service';
import { Router } from '@angular/router';
import { Class } from 'src/app/models/Clases/class';
import { Cource } from 'src/app/models/Cource/cource';

@Component({
  selector: 'app-class',
  templateUrl: './class.component.html',
  styleUrls: ['./class.component.css']
})
export class ClassComponent implements OnInit {

  constructor(private classServise:ServicesService,private router: Router){}
  personaId: number;
  clase:Class=new Class();
  mostrarMensaje: boolean = false;
  mostrarMensaje_two: boolean = false;
  cursos:Cource[];
  cla:Class[];
  numericValue: number
  idC : string
  as: any
  ngOnInit(): void {
    this.personaId = this.classServise.getPersonaId();
    this.listCourceId(this.personaId)
    this.listClasse()
  }

  saveClass(){
    console.log(this.clase)
    console.log(typeof  this.idC)
    this.numericValue = parseInt(this.idC, 10); 
    console.log(typeof  this.numericValue)
    this.clase.idCourse = this.numericValue 
    console.log(this.clase)
    this.classServise.saveCls(this.clase).subscribe({
      next:dato=>{
        console.log("Mis datos",dato);
        this.clase = new Class()
        this.listClasse()
        this.mostrarMensaje = true;
        setTimeout(() => {
          this.mostrarMensaje = false;
        }, 5000);
      },
      error: err => console.log(err)
    })
  }

  listCourceId(idTeacher:number){
    this.classServise.listCourceidTeacher(idTeacher).subscribe(dato=>{
      this.cursos =dato;
      console.log(this.cursos)
    })
  }

  listClasse(){
    this.classServise.listClasses().subscribe(dato=>{
      this.cla =dato;
      console.log(this.cla)
    })
  }
}
