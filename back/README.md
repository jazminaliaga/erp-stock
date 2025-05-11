# Backend - Módulo Stock

Proyecto Spring Boot para gestionar productos y movimientos de stock.

## Requisitos

- Java 17
- Maven
- MySQL 8

## Ejecutar localmente

1. Configurar variables de entorno (`DB_URL`, `USER`, `PASSWORD`)
2. Ejecutar `mvn spring-boot:run`

## Estructura del proyecto

- `controller`: Controladores REST
- `service`: Lógica de negocio
- `repository`: Acceso a base de datos
- `model`: Entidades (Producto, MovimientoStock)

## Endpoints esperados

- `GET /productos`
- `POST /productos`
- `PUT /productos/{id}`
- `DELETE /productos/{id}`
- `POST /entrada`
- `POST /salida`
