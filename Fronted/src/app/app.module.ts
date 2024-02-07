import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './views/Login/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterComponent } from './views/Login/register/register.component';
import { UseStudentComponent } from './views/Use/use-student/use-student.component';
import { ListarCourceComponent } from './views/Use/use-student/listar-cource/listar-cource.component';
import { ListarTareaComponent } from './views/Use/use-student/listar-tarea/listar-tarea.component';
import { ListarCourseInsComponent } from './views/Use/use-student/listar-course-ins/listar-course-ins.component';
import { NavbarComponent } from './views/Use/use-student/navbar/navbar.component';
import { UseTeacherComponent } from './views/Use/use-teacher/use-teacher.component';
import { NavComponent } from './views/Use/use-teacher/nav/nav.component';
import { CourceComponent } from './views/Use/use-teacher/cource/cource.component';
import { TareasComponent } from './views/Use/use-teacher/tareas/tareas.component';
import { ClassComponent } from './views/Use/use-teacher/class/class.component';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UseStudentComponent,
    ListarCourceComponent,
    ListarTareaComponent,
    ListarCourseInsComponent,
    NavbarComponent,
    UseTeacherComponent,
    NavComponent,
    CourceComponent,
    TareasComponent,
    ClassComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
