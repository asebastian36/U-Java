# Transacciones en JDBC

Una transaccion es un conjunto de instrucciones  en SQL (SELECT, INSERT, etc) las cuales son agrupadas en bloques de ejecucion,
si alguna de las instrucciones falla podemos dar marcha atras haciendo un **rollback** a todo el bloque ejecutado esto es sin alterar el estado de la bd, Por otro lado si todo es correcto guardamos los cambios haciendo **commit** de todo el bloque ejecutado.

## Uso de metodos en una transaccion

---
> normalmente **es recomendable antes de empezar a hacer una transaccion hacer el autocommit
> como false** ya que hace un commit de manera automatica y es mejor solo hacer commit si estamos
> seguros de los cambios hechos.

* **autocommit**. (*true o false*).
* **commit**. Guarda los cambios en la BD del *bloque de ejecucion*.
* **rollback**. Revierte todos los cambios realizados por el bloque de ejecucion.

> Si cerramos la conexion de JDBC se hace un commit, incluso si se deshabilito la propiedad autocommit, esto es asi para asegurarse que se guarden los cambios.
> **Es recomendable envolver una transaccion en un bloque try-catch** y una vez que un error sucede aplicamos un rollback a toda la transaccion para evitar inconsistencias o errores en la bd.
