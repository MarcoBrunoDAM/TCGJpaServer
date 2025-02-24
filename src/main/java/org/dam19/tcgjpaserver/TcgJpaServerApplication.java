package org.dam19.tcgjpaserver;

import org.dam19.tcgjpaserver.ssh.SQLDatabaseManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcgJpaServerApplication {

    public static void main(String[] args) {
        // Establecer el túnel SSH
//        try {
//            SQLDatabaseManager.connectSSH();
//        } catch (Exception e) {
//            System.err.println("No se pudo abrir el túnel SSH: " + e.getMessage());
//            System.exit(1); // Detiene la aplicación si falla la conexión SSH
//        }

        // Iniciar Spring Boot después de abrir el túnel
        SpringApplication.run(TcgJpaServerApplication.class, args);

        // Cerrar el túnel cuando Spring Boot se detenga
        Runtime.getRuntime().addShutdownHook(new Thread(SQLDatabaseManager::disconnectSSH));

    }

}
