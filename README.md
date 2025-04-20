# Ejercicio de Depuración y Optimización

## Descripción del Proyecto :scroll:

Optimizar y depurar caso de gestión de venta de entradas con reserva de asiento, confirmación de compra, modificación de compra y generación de boleta. Además, se mantiene la aplicación de descuentos del 10% para estudiantes y del 15% para personas de la tercera edad. Se intenta mejorar el uso de Estructuras de Control y Condicionales en Java, identificacndo tipos de variables.

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Incluir un menú de opciones para que los usuarios puedan seleccionar diferentes acciones:
- Reservar entradas
- Comprar entradas
- Modificar una venta existente
- Imprimir boleta
Gestionadas de la siguiente manera: 
- Implementa un sistema de reservas que permita al usuario seleccionar asientos y mantenerlos en reserva por un tiempo limitado antes de la compra. 
- Integra un mecanismo para convertir una reserva en compra, asegurando una transición fluida para el usuario.
- Implementa la lógica para la selección de asientos, asegurándose de que sea intuitiva y fácil de entender para el usuario. 
- Valida la disponibilidad de asientos antes de completar la compra y manejar de manera adecuada cualquier inconveniente relacionado con la disponibilidad.
- Desarrolla la lógica para la generación de boletas, asegurándose de que contengan información relevante, como la ubicación del asiento, cantidad de entradas y costo total. 

👌 2. Identifica variables locales, de instancia y estáticas.

👌 3. Optimiza la implementación incorporando puntos de depuración:
- Incorpora puntos de depuración en el sistema de reservas para asegurar que las transiciones de reserva a compra se manejen correctamente. 
- Incorpora 3 puntos de depuración en la lógica de selección y validación de asientos, con el fin de simplificar la detección y corrección de posibles errores.
- Incorpora 3 puntos de depuración en el proceso de generación de boletas para verificar la correcta captura y presentación de la información.

👌 4. Optimiza Estructuras de Control:
Optimiza el código utilizando un mínimo de 2 estructuras de control eficientes, evitando redundancias y modularizando funciones para mejorar la legibilidad y mantenibilidad del código.


## Visuales :mage_woman:

### Funcionalidades, requerimientos y manejo de errores:

Manejo de errores en validacion de input en menú principal con letras o números distintos a las opciones:
![Captura de pantalla 2025-04-20 123117](https://github.com/user-attachments/assets/f57e6fb9-233a-467c-8ae4-dafb0c485ff2)

Validación de cantidad de entradas disponibles a la venta antes de proceder a la reserva o venta:
![Captura de pantalla 2025-04-20 123237](https://github.com/user-attachments/assets/654ca2e8-fe81-4274-88d7-da800e7c824b)

Manejo de error en input de cantidad de entradas:
![Captura de pantalla 2025-04-20 123304](https://github.com/user-attachments/assets/b2365007-684c-409f-8b02-a5cecdc783f5)

Validación y paso a reserva de manera fluida: 
![Captura de pantalla 2025-04-20 123631](https://github.com/user-attachments/assets/657be937-6953-416e-af5e-009d509c3aa8)

Cuando es más de una entrada la selección es de manera ordenada indicando el número cada entrada que se reserva paso por paso y validando su reserva de manera visual en el mapa: 
![Captura de pantalla 2025-04-20 123726](https://github.com/user-attachments/assets/93a139f7-3b1a-4db5-b1bb-0c0ed653de9b)

Manejo de errores en inputs de zona y número de asiento:
![Captura de pantalla 2025-04-20 123912](https://github.com/user-attachments/assets/2a7ba02e-c369-4403-8b63-505781eb5390)

Validación de asientos ocupados, ya reservados o comprados:
![Captura de pantalla 2025-04-20 124015](https://github.com/user-attachments/assets/a8e3e20c-69bd-4e5a-b8cb-2a248e4b1561)

Al terminar la reserva de la cantidad de entradas seleccionadas, solicita edad para aplicar descuentos y calcular total, mostrando detalle de la reserva al final del proceso:
![Captura de pantalla 2025-04-20 124301](https://github.com/user-attachments/assets/0ddf0960-a4f3-4111-8708-6903061a39f6)

Muestra inmediatamente mensaje de tiempo de reserva con cronómetro, esperando input del usuario:
![Captura de pantalla 2025-04-20 124411](https://github.com/user-attachments/assets/89befd18-f04a-42c5-be0c-831b81ccb917)

Si se solicita Impresión de boleta de la compra reciente genera el detalle respectivo:
![Captura de pantalla 2025-04-20 124530](https://github.com/user-attachments/assets/18f89aae-4f80-46f3-9ab8-5da1a90a5df1)

Se permite modificar la compra reciente sólo con la opción de devolución de entradas
Se valida que no se ingrese un número mayor a las entradas compradas:
![Captura de pantalla 2025-04-20 124656](https://github.com/user-attachments/assets/29ac68f4-f807-4681-a6c6-d89ea083a62a)

Al ingresar las entradas a devolver, muestra el plano con entradas liberadas
y muestra el cálculo del reembolso respectivo:
![Captura de pantalla 2025-04-20 124806](https://github.com/user-attachments/assets/531a0180-7a6a-436f-a6e0-9c1ce868aa41)

Si posterior a eso se solicita reemprimir la boleta con el detalle de la modificación
Incorpora el nuevo detalle de los asientos y valor a total posterior a la modificación, devolución de las entradas:
![Captura de pantalla 2025-04-20 125019](https://github.com/user-attachments/assets/85220c4d-66ab-4490-867d-485dea3aa361)

En el menú de estadísticas globales se puede apreciar el estado actual del sistema entre compras: 
![Captura de pantalla 2025-04-20 125057](https://github.com/user-attachments/assets/15b2a8f6-54fc-42b3-8451-cd1fb319269f)
![Captura de pantalla 2025-04-20 125647](https://github.com/user-attachments/assets/98627edc-c6e5-49a8-a287-a970ceb402e2)

La opción de compra simula el proceso directo sin el tiempo de reserva:
![Captura de pantalla 2025-04-20 125241](https://github.com/user-attachments/assets/f9450646-b0dc-4bdc-9ab9-230f7da0a957)

Valida si no hay entradas disponibles para la venta: 
![Captura de pantalla 2025-04-20 125353](https://github.com/user-attachments/assets/f89cbf3e-7bd2-433b-a799-0fd32f394f0a)
![Captura de pantalla 2025-04-20 125334](https://github.com/user-attachments/assets/ecdbc7bc-a120-4c1e-9cdf-c3f4a3a16369)

Cuando no se ha realizado compras, no se puede imprimir boletas:
![Captura de pantalla 2025-04-20 125449](https://github.com/user-attachments/assets/6fc8ae3d-2f29-4a00-a52b-d9f1c7519fc2)

Cuando no se ha realizado compras, no se puede modificar boletas: 
![Captura de pantalla 2025-04-20 125603](https://github.com/user-attachments/assets/9ea95d64-1039-4974-a8f6-51fea14007d3)

Manejo de error en input de usuario durante tiempo de reserva
y eliminación de reserva y muestra de plano con asientos liberados 
![Captura de pantalla 2025-04-20 125800](https://github.com/user-attachments/assets/573c68e5-fc53-4943-aeb3-914e48a1e308)

Reservas liberadas automáticamente cuando se acaba el tiempo de reserva:
![Captura de pantalla 2025-04-20 125953](https://github.com/user-attachments/assets/10d7a401-ae89-4df2-8c1e-d79d1e3c0868)


### Evidencia de Breakpoints o puntos de depuración:

Transición de reserva a compra: (2 puntos de depuración)
- Breakpoint 1: Linea 65
Validación de entrada verificando la cantidad de entradas reservadas.

- Breakpoint 2: Linea 83
Asegura que se estén confirmando los asientos reservados


Selección y Validación de Asientos: (3 puntos de depuración)
-Breakpoint 3: Linea 69
Revisa que los asientos seleccionados correspondan a entradas válidas.

- Breakpoint 4: Linea 356
Detecta si el asiento ya fue reservado / comprado con el uso de las variables zona y numeroAsiento en las lógicas if/else

- Breakpoint 5: Linea 425
Confirma la correcta asignación del asiento

Generación de Boletas: (3 puntos de depuración)
- Breakpoint 6: Linea 97
Asegura que los datos entregados para impresión estén correctos

- Breakpoint 7: Linea 501
Verifica que el total a pagar sea correctos tanto con la compra como con la post modificación 

- Breakpoint 8: Linea 498
  Valid que los asientos impresos coincidan con la compra y post modificación



## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
