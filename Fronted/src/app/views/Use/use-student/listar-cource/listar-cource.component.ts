import { Component, OnInit } from '@angular/core';
import { Cource } from 'src/app/models/Cource/cource';
import { Inscription } from 'src/app/models/Inscription/inscription';
import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-listar-cource',
  templateUrl: './listar-cource.component.html',
  styleUrls: ['./listar-cource.component.css']
})
export class ListarCourceComponent implements OnInit {


  constructor(private courceServicio:ServicesService) {}
  id: number;
  cource:Cource[];
  cusos:Cource[];
  personaId: number;
  person: any = {};
  inscrip:Inscription=new Inscription();
  mostrarMensaje: boolean = false;
  mostrarMensaje_two: boolean = false;
  curs: boolean = false;


  ngOnInit(): void {
    this.personaId = this.courceServicio.getPersonaId();
    console.log("VALOR DE PERSONA",this.personaId)
    this.listPerson();
  }

  listCourceAnio(anioLectivo:String){
    this.courceServicio.listCourceAnio(anioLectivo).subscribe(dato=>{
      this.cource =dato;
      console.log(this.cource)
    })
  }

  listPerson() {
    this.courceServicio.listPerson(this.personaId).subscribe(
      data => {
        this.person = data;
        const aniolec: any = (this.person as any).ciclo;
        console.log(this.person);
        console.log(aniolec);
        this.listCourceAnio(aniolec);
      },
      error => {
        console.error('Error al recuperar la información del estudiante:', error);
      }
    );
  }

  async saveIns(idCourse:number){
    console.log("Mi curso que seleccion es el id "+idCourse+" y mi usuario es "+this.personaId)
    this.inscrip.courseid = idCourse;
    this.inscrip.userid = this.personaId;

    this.courceServicio.listCourceUse(this.personaId).subscribe(dato=>{
      this.cusos=dato;
      console.log(this.cusos)
      this.cusos.forEach(curso => {
        if (curso.id === idCourse) {
          this.curs=true;
          console.log(this.curs)

        }else{
          console.log('this.cource is not empty:', this.cusos);
        }
      });
      console.log(this.curs)
      if(this.curs) {
        this.mostrarMensaje_two = true;
        setTimeout(() => {
          this.mostrarMensaje_two = false;
        }, 5000);
        this.curs=false;
      }else{
        console.log('this.cource is not empty:', this.cusos);
        this.saveIni();
      }
    })

  }

  saveIni(){
    this.courceServicio.saveInscripccion(this.inscrip).subscribe({
      next:dato=>{
        console.log("Mis datos",dato);
        this.inscrip = new Inscription()
        this.mostrarMensaje = true;
        setTimeout(() => {
          this.mostrarMensaje = false;
        }, 5000);
      },
      error: err => console.log(err)
    })
  }
}
