import { Component, OnInit } from '@angular/core';
import {Curso} from './curso'
import {CursoService} from './curso.service'
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  curso: Curso = new Curso()
  titulo:string = "Crear curso"
  flag : boolean = true

  constructor(private cursoService: CursoService,
  private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCurso()
  }

  cargarCurso(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.cursoService.getCurso(id).subscribe( (curso) => this.curso = curso)
        this.titulo = "Editar Curso"
        this.flag=false
      }
    })
  }

  create(): void {
    this.cursoService.create(this.curso)
      .subscribe(curso => {
        this.router.navigate(['/curso'])
        swal.fire('Nuevo curso', `Curso ${curso.nombre} creado con éxito!`, 'success')
      }
      );
  }

  update():void{
    console.log("Creditos antes de enviar al service en update")
    console.log(this.curso.creditos)
    this.cursoService.update(this.curso)
    .subscribe( curso => {
      this.router.navigate(['/curso'])
      swal.fire('Curso Actualizado', `Curso ${curso.nombre} actualizado con éxito!`, 'success')
    }

    )
  }

}
