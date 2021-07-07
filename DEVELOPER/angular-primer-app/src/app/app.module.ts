import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { PieComponent } from './pie/pie.component';
import { CursoComponent } from './curso/curso.component';
import { AlumnoComponent } from './alumno/alumno.component';
import { HttpClientModule } from '@angular/common/http';
import { CursoService } from './curso/curso.service';

@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    PieComponent,
    CursoComponent,
    AlumnoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    //CursoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
