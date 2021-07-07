import { Component, OnInit } from '@angular/core';
import { CURSOS } from './curso.json';
import { Curso } from './curso';
import { CursoService } from './curso.service';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {
  cursos ?: Curso[];

  //constructor() { }
  constructor(private cursoService: CursoService) { }//se inyecta el Service

  ngOnInit(): void {
    //this.cursos = CURSOS;
    //this.cursos = this.cursoService.getCursos();
    this.cursoService.getCursos().subscribe(
      cursos => this.cursos = cursos
   );
  }
}


