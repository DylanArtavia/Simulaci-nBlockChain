# Sistema Cliente-Servidor Multihilo con Simulación de Blockchain

## 🧠 Descripción
Este proyecto implementa un servidor capaz de manejar múltiples clientes simultáneamente mediante el uso de hilos en Java.

Además, incorpora una simulación de conceptos clave de blockchain como bloques, mempool y validación de datos, con el objetivo de representar un sistema concurrente con persistencia.

---

## ⚙️ Características principales
- Conexión de múltiples clientes simultáneamente
- Uso de Threads para manejo concurrente
- Comunicación cliente-servidor mediante sockets
- Persistencia de datos
- Simulación de:
  - Bloques
  - MemPool
  - Validación de transacciones
  - Registro de votantes (tokens)

---

## 🧩 Arquitectura

- **Servidor**
  - Maneja conexiones entrantes
  - Crea un hilo por cliente
  - Gestiona la lógica de blockchain

- **Cliente**
  - Se conecta al servidor
  - Envía solicitudes
  - Recibe respuestas

---

## 🔄 Funcionamiento

1. El servidor inicia y carga:
   - Blockchain
   - MemPool
   - Datos de usuarios/votantes

2. Espera conexiones en el puerto 5000

3. Cada cliente conectado:
   - Es gestionado en un hilo independiente
   - Puede interactuar con el sistema

---

## 🧪 Ejemplo de ejecución
[2026-03-22] Servidor iniciado en puerto 5000
Cliente conectado: /127.0.0.1:49805
Blockchain cargada: bloques = 4


---

## ▶️ Cómo ejecutar

1. Ejecutar el servidor
2. Ejecutar uno o más clientes
3. Interactuar con el sistema

---

## 🎯 Objetivo

Demostrar el uso de concurrencia en aplicaciones cliente-servidor combinada con una simulación de estructuras de datos complejas.



