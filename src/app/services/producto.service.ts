import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  url: string ="http://localhost:7000";
  constructor(private http: HttpClient) { }

  getProductos(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.url+"/productos");
  }

  getCategorias():Observable<Categoria[]>{
    return this.http.get<Categoria[]>(this.url+"/categorias");
  }
  crearProducto(producto: Producto):Observable<Producto>{
    return this.http.post<Producto>(this.url+"/productos/crear",producto);
  }
  actualizarProducto(producto: Producto):Observable<Producto>{
    return this.http.put<Producto>(this.url+"/productos/actualizar",producto);
  }
  obtenerProducto(id: number):Observable<Producto>{
    return this.http.get<Producto>(this.url+"/productos/encontrar/"+id);
  }
  eliminarProducto(id: number):Observable<Producto>{
    return this.http.delete<Producto>(this.url+"/productos/eliminar/"+id);
  }
}
