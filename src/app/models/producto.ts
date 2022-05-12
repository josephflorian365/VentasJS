import { Categoria } from "./categoria";

export class Producto {
    id!: number;
    nombre!: string;
    precio!: number;
    categoria!: Categoria;
}
