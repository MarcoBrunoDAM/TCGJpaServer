package org.dam19.tcgjpaserver;

import org.dam19.tcgjpaserver.ssh.SQLDatabaseManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcgJpaServerApplication {

    public static void main(String[] args) {
        try{
            SQLDatabaseManager.connect();
        }catch(Exception e){
            e.printStackTrace();
        }
        SpringApplication.run(TcgJpaServerApplication.class, args);
    }

}
