import { Component, OnInit } from '@angular/core';
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';
import swal from 'sweetalert2'
import { Router } from '@angular/router';


@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent implements OnInit {
  alumnos ?: Alumno[] = [];

  //constructor() { }
  constructor(private alumnoService: AlumnoService,private router: Router) { }//se inyecta el Service

  ngOnInit(): void {
    //this.alumnos = ALUMNOS;
    this.alumnoService.getAlumnos().subscribe(
      alumnos => this.alumnos = alumnos
   );
  }

  delete(alumno: Alumno): void {
    swal.fire({
      title: 'Está seguro?',
      icon: 'warning',
      text: `¿Seguro que desea eliminar el alumno ${alumno.nombre}?`,
      showCloseButton: true,
      showCancelButton: true,
      focusConfirm: false,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {

      if (result.value) {
        var _me = this.alumnos
        this.alumnoService.delete(alumno.id).subscribe(
          response => {

            //this.alumnos = ALUMNOS;
            this.alumnoService.getAlumnos().subscribe(
            alumnos => this.alumnos = alumnos
            ); 
            /*
            _me = this.alumnos?.filter(cur => cur !== alumno)
            */
            swal.fire(
              'Alumno Eliminado!',
              `Alumno ${alumno.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }

}
