import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private httpOptions = {
    headers: new HttpHeaders({"Content-Type":"application/json"})
  }

  private url = environment.API_URL + "cliente";

  constructor(
    private http: HttpClient
  ) { }

  //findAll
  public findAll(): Observable<Cliente[]>
  {
    return this.http.get<Cliente[]>(this.url, this.httpOptions);
  }

  //Create
  public save(cliente: Cliente): Observable<Cliente>
  {
    return this.http.post<Cliente>(this.url+"/save",cliente,this.httpOptions);
  }

  //Read
  public findById(id: number): Observable<Cliente>
  {
    return this.http.get<Cliente>(this.url+"/"+id);
  }

  //Update
  public update(cliente: Cliente): Observable<Cliente>
  {
    return this.http.put<Cliente>(this.url,cliente,this.httpOptions)
  }

  //Delete
  public deleteById(id: number): Observable<Cliente>
  {
    return this.http.delete<Cliente>(this.url+"/delete/"+id);
  }



}
