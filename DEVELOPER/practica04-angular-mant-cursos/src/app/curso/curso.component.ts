import { Component, OnInit } from '@angular/core';
import {Curso } from './curso'
//import {CURSOS} from './cursos.json'
import { CursoService } from './curso.service';
import swal from 'sweetalert2'
import { Router } from '@angular/router';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html'
})
export class CursoComponent implements OnInit {
  
  cursos? : Curso[]; //= [
    //{id:'c01', nombre:'programmer', creditos:5},
    //{id:'c02', nombre:'developer', creditos:5},
    //{id:'c03', nombre:'expert', creditos:5}
  //]

  constructor(private cursoService: CursoService,private router: Router) { }

  ngOnInit(): void {
    //this.cursos = CURSOS;
     // this.cursos = this.cursoService.getCursos();
     this.cursoService.getCursos().subscribe(
      cursos => this.cursos = cursos
   );
  }


  delete(curso: Curso): void {
    swal.fire({
      title: 'Está seguro?',
      icon: 'warning',
      text: `¿Seguro que desea eliminar el curso ${curso.nombre}?`,
      showCloseButton: true,
      showCancelButton: true,
      focusConfirm: false,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {

      if (result.value) {
        var _me = this.cursos
        this.cursoService.delete(curso.id).subscribe(
          response => {
            //_me = this.cursos?.filter(cur => cur !== curso)
            this.cursoService.getCursos().subscribe(
              cursos => this.cursos = cursos
           );            
            swal.fire(
              'Curso Eliminado!',
              `Curso ${curso.nombre} eliminado con éxito.`,
              'success'
            )
          }
        )

      }
    })
  }

}
