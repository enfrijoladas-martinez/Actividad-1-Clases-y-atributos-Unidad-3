# Actividad 1 · Encuentra clases y atributos

**Unidad 3 · Semántica** — Arquitectura Orientada a Servicios
**Equipo:** Elias Martinez Garcia y Jose de Jesus Junior Barba Cano

Texto del caso: «La cafetería de la universidad vende productos a estudiantes y profesores. De cada producto se registra su nombre, precio y categoría. Cada venta tiene una fecha, un total y un método de pago».

## Clases encontradas

| Clase | Identificador | Atributos y tipo |
|---|---|---|
| `Producto` | `id: Long` (clave sustituta) | `nombre: String`, `precio: BigDecimal`, `categoria: Categoria` (BEBIDA, ALIMENTO, SNACK, POSTRE) |
| `Venta` | `folio: Long` (clave sustituta) | `fecha: LocalDateTime`, `total: BigDecimal`, `metodoPago: MetodoPago` (EFECTIVO, TARJETA, TRANSFERENCIA) |
| `Estudiante` | `matricula: String` (clave natural) | `nombre: String`, `correo: String` |
| `Profesor` | `numeroEmpleado: String` (clave natural) | `nombre: String`, `correo: String` |

"Cafetería" no es una clase: hay una sola y no tiene atributos propios en el texto.

## Ejecutar

1. Copiar `.env.example` como `.env` y poner la contraseña de MySQL (la base `cafeteria_clases` se crea sola).
2. `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`). Arranca en `http://localhost:8085` con objetos de ejemplo.
3. Importar `postman/Actividad1_Clases.postman_collection.json` (11 solicitudes).

## Endpoints

| Método | Ruta | Qué muestra |
|---|---|---|
| GET | `/api/v1/modelo` | Cada clase con sus atributos, tipo, identificador y valores permitidos (leído del código) |
| GET | `/api/v1/productos` · `/{id}` | Objetos de la clase Producto |
| GET | `/api/v1/ventas` · `/{folio}` | Objetos de la clase Venta |
| GET | `/api/v1/estudiantes` · `/{matricula}` | Objetos de la clase Estudiante |
| GET | `/api/v1/profesores` · `/{numeroEmpleado}` | Objetos de la clase Profesor |

Un identificador inexistente responde `404` con `{"status", "codigo", "mensaje"}`.

## Objeto de ejemplo

```json
{ "id": 1, "nombre": "Café americano", "precio": 35.00, "categoria": "BEBIDA" }
```

Tecnologías: Java 25, Spring Boot 4.1.1, Spring Data JPA, MySQL.
