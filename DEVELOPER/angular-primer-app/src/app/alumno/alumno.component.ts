import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { ALUMNOS } from './alumno.json';
import { AlumnoService } from './alumno.service';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent implements OnInit {
  alumnos ?: Alumno[];

  //constructor() { }
  constructor(private alumnoService: AlumnoService) { }//se inyecta el Service

  ngOnInit(): void {
    //this.alumnos = ALUMNOS;
    this.alumnoService.getAlumnos().subscribe(
      alumnos => this.alumnos = alumnos
   );
  }

}
