# Despliegue Kubernetes – Módulo Stock

## Archivos YAML

- `deployment.yaml`: Define el pod y el contenedor del servicio
- `service.yaml`: Expone el microservicio dentro del cluster

## Despliegue

```bash
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```

## Variables necesarias
```
DB_URL
DB_USER
DB_PASSWORD
```
