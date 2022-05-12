import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/models/categoria';
import { Producto } from 'src/app/models/producto';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-producto-form',
  templateUrl: './producto-form.component.html',
  styleUrls: ['./producto-form.component.css']
})
export class ProductoFormComponent implements OnInit {

  producto: Producto = new Producto();

  categorias: Categoria[] = [];

  constructor(private productoService: ProductoService,
    private activateRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.productoService.getCategorias()
      .subscribe(response => this.categorias = response);

    this.activateRoute.params
      .subscribe(params => {
        let id: number = params['id'];
        if (id) {
          this.productoService.obtenerProducto(id)
            .subscribe(response => this.producto = response);
        }
      })
  }

  crearProducto() {
    this.productoService.crearProducto(this.producto)
      .subscribe(response => this.router.navigate(['']));
  }

  actualizarProducto() {
    this.productoService.actualizarProducto(this.producto)
      .subscribe(response => this.router.navigate(['']));
  }

  compararCategoria(o1: Categoria, o2: Categoria): boolean {
    if (o1 === undefined && o2 === undefined) return true;
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false: o1.id == o2.id;
  }

}
