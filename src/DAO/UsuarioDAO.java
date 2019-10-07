/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Javiera
 */
public class UsuarioDAO {

    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Usuario> getUsuarios() {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM usuario ";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_usuario = Integer.parseInt(resultados.getString("id"));
                String nombre = resultados.getString("nombre");
                usuarios.add(new Usuario(id_usuario, nombre));
            }
            //accesoBD.close();
            return usuarios;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    public Usuario getUsuario(int id_usuario) {
        Usuario u;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM Usuario WHERE id_usuario=" + id_usuario;
            Statement st = accesoBD.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {

                String nombre = rs.getString("nombre");
                u = new Usuario(id_usuario, nombre);
                return u;
            } else {

                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al obtenr");
            e.printStackTrace();
            return null;
        }
    }

}
