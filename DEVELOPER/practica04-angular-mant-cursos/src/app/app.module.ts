import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CursoComponent } from './curso/curso.component';
import { FormComponent } from './curso/form.component';
import { AlumnoComponent } from './alumno/alumno.component';
import { FormAlumnoComponent } from './alumno/form-alumno.component';

const routes: Routes = [
  {path: '', redirectTo: '/alumno',pathMatch : 'full'},
  {path: 'curso', component: CursoComponent},
  {path: 'curso/form', component: FormComponent},
  {path: 'curso/form/:id', component: FormComponent},
  {path: 'alumno', component: AlumnoComponent},
  {path: 'alumno/form', component: FormAlumnoComponent},
  {path: 'alumno/form/:id', component: FormAlumnoComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    CursoComponent,
    FormComponent,
    AlumnoComponent,
    FormAlumnoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
