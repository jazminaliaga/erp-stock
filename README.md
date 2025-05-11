# Módulo de Stock – ERP

Este microservicio permite gestionar el inventario de productos y registrar entradas/salidas de stock.

## Estructura del repositorio

- `backend/`: Código en Spring Boot
- `k8s/`: Archivos YAML para despliegue en Kubernetes
- `docs/`: Documentación de endpoints y modelo

## Funcionalidades clave

- Crear, listar, editar y eliminar productos
- Registrar entradas de stock (compras)
- Registrar salidas de stock (ventas)

## Modelo de datos

- **Producto**: nombre, marca, stock, descripción, precio
- **MovimientoStock**: tipo (entrada/salida), cantidad, fecha, producto_id

## Lógica de negocio

- `POST /entrada`: suma stock
- `POST /salida`: descuenta stock si hay suficiente

## Próximos pasos

- Implementar validaciones
- Conectar con módulos de compras/ventas
- Desarrollar frontend
