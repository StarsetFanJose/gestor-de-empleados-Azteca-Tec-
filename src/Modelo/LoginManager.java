/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;

/**
 *
 * @author josea
 */
public class LoginManager {
    
    private static final String FILE_PATH = "usuarios.txt";
    
    public boolean crearUsuario(String usuario, String email, String contraseña)throws IOException {
        if (existeUsuario(usuario, email)) {
            return false;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(usuario + "," + email + "," + contraseña);
            writer.newLine();
        }
        return true;
    }
    
    public boolean validarLogin(String usuario, String contraseña)throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals(usuario) && partes[2].equals(contraseña)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Metodo para recuperar la contra por que sino estoy pendejo
    public String[]recuperarDatos(String email)throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes[1].equals(email)) {
                    return new String[]{ partes[0], partes[2]};
                }
            }
        }
        return null;
    }
    
    public boolean borrarUsuario(String usuario)throws IOException {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp.txt");
        
        boolean borrar = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (!partes[0].equals(usuario)) {
                    writer.write(linea);
                    writer.newLine();
                } else {
                    borrar = true;
                }
            }
        }
        if (borrar && inputFile.delete()) {
            return tempFile.renameTo(inputFile);
        }
        return false;
    }
    
    private boolean existeUsuario(String usuario, String email)throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes[0].equals(usuario) || partes[1].equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }
}
