import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'
import { Alumno } from './alumno';
import { AlumnoService } from './alumno.service';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-form-alumno',
  templateUrl: './form-alumno.component.html',
  providers:[DatePipe]
})
export class FormAlumnoComponent implements OnInit {

  alumno: Alumno = new Alumno()
  titulo:string = "Crear alumno"
  flag : boolean = true

  constructor(private alumnoService: AlumnoService,
  private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarAlumno()
  }

  cargarAlumno(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.alumnoService.getAlumno(id).subscribe( (alumno) => {
          this.alumno = alumno
          this.titulo = "Editar Alumno"
          this.flag=false
        })
      }
    })
  }

  create(): void {
    console.log("Fecha de nacimiento antes de enviar al service en create")
    console.log(this.alumno.fenac)
    this.alumnoService.create(this.alumno)
      .subscribe(alumno => {
        this.router.navigate(['/alumno'])
        swal.fire('Nuevo alumno', `Alumno ${alumno.nombre} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    this.alumnoService.update(this.alumno)
    .subscribe( alumno => {
      this.router.navigate(['/alumno'])
      swal.fire('Alumno Actualizado', `Alumno ${alumno.nombre} actualizado con éxito!`, 'success')
    }
    )
  }

}
