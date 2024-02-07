import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/Person/persona';
import { Cource } from '../models/Cource/cource';
import { Inscription } from '../models/Inscription/inscription';
import { Class } from '../models/Clases/class';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private personaId: number;

  private baseUrl = "http://localhost:8001/user";

  constructor(private httpClient : HttpClient) { }

  registerPerson(student:Persona):Observable<Object>{  
    return this.httpClient.post(`${this.baseUrl}/save/student`,student);
  }

  registerteacher(teacher:Persona):Observable<Object>{  
    return this.httpClient.post(`${this.baseUrl}/save/teacher`,teacher);
  }

  getPersonConUse(usuario:String,password:String):Observable<Persona[]>{
    return this.httpClient.get<Persona[]>(`${this.baseUrl}/buscar?nombreUsuario=${usuario}&contrasena=${password}`,)
  }

  setPersonaId(id: number) {
    this.personaId = id;
  }

  getPersonaId(): number {
    return this.personaId;
  }

  listPerson(id:number):Observable<Persona[]>{
    return this.httpClient.get<Persona[]>(`${this.baseUrl}/${id}`)
  }

  listCource():Observable<Cource[]>{
    return this.httpClient.get<Cource[]>(`${this.baseUrl}/getCursoall`)
  }

  listCourceAnio(anioLectivo:String):Observable<Cource[]>{
    return this.httpClient.get<Cource[]>(`${this.baseUrl}/getCursoallAnioLec?anioLectivo=${anioLectivo}`)
  }

  listCourceidTeacher(idTeacher:number):Observable<Cource[]>{
    return this.httpClient.get<Cource[]>(`${this.baseUrl}/cursoIdTeacher?idTeacher=${idTeacher}`)
  }

  listCourceId(id:number):Observable<Cource[]>{
    return this.httpClient.get<Cource[]>(`${this.baseUrl}/getCurso/${id}`)
  }

  listCourceUse(id:number):Observable<Cource[]>{
    return this.httpClient.get<Cource[]>(`${this.baseUrl}/getCursosUse/${id}`)
  }

  listClassCourse(id:number):Observable<Class[]>{
    return this.httpClient.get<Class[]>(`${this.baseUrl}/class/getClassCourse?idCourse=${id}`)
  }

  
  listClasses():Observable<Class[]>{
    return this.httpClient.get<Class[]>(`${this.baseUrl}/class/getClassall`)
  }

  saveInscripccion(ins:Inscription){
    return this.httpClient.post(`${this.baseUrl}/inscripciones/save`,ins);
  }

  saveCourse(cours:Cource){
    return this.httpClient.post(`${this.baseUrl}/saveCurso`,cours);
  }

  saveCls(clas:Class){
    return this.httpClient.post(`${this.baseUrl}/class/save`,clas);
  }
}
