package org.dam19.tcgjpaserver.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLDatabaseManager {
    private static final String SSH_HOST = "mvs.sytes.net";
    private static final int SSH_PORT = 11010;
    private static final String SSH_USER = "sshuser";
    private static final String SSH_PRIVATE_KEY = "C:\\Users\\Marco\\Claves SSH\\id_rsa";
    private static final String DB_HOST = "127.0.0.1"; // PostgreSQL en el servidor remoto
    private static final int DB_PORT = 5432; // Aquí debe ser el puerto real de PostgreSQL en el servidor SSH
    private static final int LOCAL_PORT = 5432; // Puerto local para redirigir PostgreSQL

    private static Session sshSession; // Sesión SSH

    /**
     * Establece un túnel SSH a PostgreSQL.
     */
    public static void connectSSH() {
        try {
            JSch jsch = new JSch();
            jsch.addIdentity(SSH_PRIVATE_KEY);

            // Configurar sesión SSH
            sshSession = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(config);
            sshSession.connect();

            // Establecer reenvío de puertos
            sshSession.setPortForwardingL(LOCAL_PORT, DB_HOST, DB_PORT);
        } catch (Exception e) {
            throw new RuntimeException("Error estableciendo túnel SSH", e);
        }
    }

    /**
     * Cierra la conexión SSH.
     */
    public static void disconnectSSH() {
        if (sshSession != null && sshSession.isConnected()) {
            sshSession.disconnect();
            System.out.println("Túnel SSH cerrado.");
        }
    }
}