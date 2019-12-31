1- escribir en el directorio del proyecto: nota(se debe tener gradle instalado en el sistema, o ejecutar el gradlew)
    
   gradle bootRun


2-) el programa empezara a ejecutar la tarea a las 13:35, tal como se indico. (nota: sera necesario cambiar la hora de la pc, o cambiar el cron del Schedule a la hora o tiempo deseado y hacer gradle bootRun).

3-) acceder a la consola web h2 : http://localhost:8080/h2
    jdbc-url:  jdbc:h2:mem:test
    user: sa
  
  Hay estara la tabla mock_data, cuando corra el job este cargara la data del csv.
