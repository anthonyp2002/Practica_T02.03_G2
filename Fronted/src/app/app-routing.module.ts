import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './views/Login/login/login.component';
import { RegisterComponent } from './views/Login/register/register.component';
import { UseStudentComponent } from './views/Use/use-student/use-student.component';
import { ListarCourceComponent } from './views/Use/use-student/listar-cource/listar-cource.component';
import { ListarTareaComponent } from './views/Use/use-student/listar-tarea/listar-tarea.component';
import { ListarCourseInsComponent } from './views/Use/use-student/listar-course-ins/listar-course-ins.component';
import { NavbarComponent} from './views/Use/use-student/navbar/navbar.component';
import { NavComponent } from './views/Use/use-teacher/nav/nav.component';
import { UseTeacherComponent } from './views/Use/use-teacher/use-teacher.component';
import { TareasComponent } from './views/Use/use-teacher/tareas/tareas.component';
import { CourceComponent } from './views/Use/use-teacher/cource/cource.component';
import { ClassComponent } from './views/Use/use-teacher/class/class.component';

const routes: Routes = [

  {path: '',component:LoginComponent},
  {path: 'nav',component:NavbarComponent},
  {path: 'na',component:NavComponent},
  {path: 'register',component:RegisterComponent},
  {path: 'useStudet',component:UseStudentComponent},
  {path: 'useStudetListCource',component:ListarCourceComponent},
  {path: 'useStudetListTarea',component:ListarTareaComponent},
  {path: 'useStudetListCourceIns',component:ListarCourseInsComponent},
  {path: 'useTeacher',component:UseTeacherComponent},
  {path: 'useTeacherCource',component:CourceComponent},
  {path: 'useTeacherTareas',component:TareasComponent},
  {path: 'useTeacherClass',component:ClassComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
