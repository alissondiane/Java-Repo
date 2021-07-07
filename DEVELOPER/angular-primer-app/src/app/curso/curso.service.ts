import { Injectable } from '@angular/core';
import { Curso } from './curso';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
/*
@Injectable()//{
   //providedIn: "root"
//}
*/
export class CursoService {
  private urlEndPoint: string = 'http://localhost:8086/api/cursos';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }

    getCursos(): Observable<Curso[]> {
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Curso[])
    );
  }

  create(curso: Curso) : Observable<Curso> {
    return this.http.post<Curso>(this.urlEndPoint, curso, {headers: this.httpHeaders})
  }

  getCurso(id?:string): Observable<Curso>{
    return this.http.get<Curso>(`${this.urlEndPoint}/${id}`)
  }

  update(curso: Curso): Observable<Curso>{
    return this.http.put<Curso>(`${this.urlEndPoint}/${curso.id}`, curso, {headers: this.httpHeaders})
  }

  delete(id?:string): Observable<Curso>{
    return this.http.delete<Curso>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }

}