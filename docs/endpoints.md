# Documentación de Endpoints – Módulo Stock

## Productos

| Método | Ruta           | Descripción           |
|--------|----------------|-----------------------|
| GET    | /productos     | Obtener lista         |
| POST   | /productos     | Crear nuevo producto  |
| PUT    | /productos/{id}| Editar producto       |
| DELETE | /productos/{id}| Eliminar producto     |

## Movimientos de stock

| Método | Ruta      | Descripción                |
|--------|-----------|----------------------------|
| POST   | /entrada  | Registrar entrada de stock |
| POST   | /salida   | Registrar salida de stock  |

## Ejemplo de `POST /entrada`

```json
{
  "productoId": 1,
  "cantidad": 10
}

Respuesta esperada
{
  "id": 15,
  "productoId": 1,
  "cantidad": 10,
  "tipo": "ENTRADA",
  "fecha": "2025-05-11T12:00:00"
}
```