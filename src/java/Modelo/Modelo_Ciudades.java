/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josito
 */
public class Modelo_Ciudades {
   DataSource origenDatos;
   Connection conexion=null;
   PreparedStatement preparedStatement=null;
   Statement statement=null;

    public Modelo_Ciudades(DataSource origenDatos) {
        this.origenDatos = origenDatos;}
    
    public List<Ciudad> getCiudades() {
        ArrayList<Ciudad> ciudades=new ArrayList();
        try{
           conexion=origenDatos.getConnection();
           statement=conexion.createStatement();
           ResultSet resultado=statement.executeQuery("Select * from city");
           while(resultado.next()){
                ciudades.add(new Ciudad(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5)));}
        }catch(SQLException e){
            System.out.println(e.getMessage());}
        finally{
           try {
               statement.close();
               conexion.close();}
           catch (SQLException ex) {
               Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}           
       }
        
        return ciudades;
    }
    
    public void setCiudad(Ciudad city) {
       try{
          conexion=origenDatos.getConnection();
          String consulta="insert into city (Name,CountryCode,District,Population)values(?,?,?,?)";
          preparedStatement=conexion.prepareStatement(consulta);
          preparedStatement.setString(1,city.getNombre());
          preparedStatement.setString(2,city.getCodigoPais());
          preparedStatement.setString(3,city.getDistrito());
          preparedStatement.setInt(4, city.getPoblacion());
          preparedStatement.execute();}
       catch(SQLException e){
          System.out.println(e.getMessage());}
       finally{
           try {
               preparedStatement.close();
               conexion.close();}
           catch (SQLException ex) {
               Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}           
       }
    }
    public Ciudad getCiudad(int IdCiudad) {
        Ciudad city=null;
        try{
            conexion=origenDatos.getConnection();
            String consulta="select * from city where ID=?";
            preparedStatement=conexion.prepareStatement(consulta);
            preparedStatement.setInt(1, IdCiudad);
            ResultSet resultado=preparedStatement.executeQuery();
            while(resultado.next()){
                city=new Ciudad(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getInt(5));}
            return city;}
         catch(SQLException e){
          System.out.println(e.getMessage());}
       finally{
           try {
               preparedStatement.close();
               conexion.close();}
           catch (SQLException ex) {
               Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}}
        return city;
    }
    public void updateCiudad(int IdCiudad,Ciudad city){
        try{
            conexion=origenDatos.getConnection();
            String consulta="update  city set Name=?,CountryCode=?,District=?,Population=? where ID=?";        
            preparedStatement=conexion.prepareStatement(consulta);
            preparedStatement.setString(1, city.getNombre());
            preparedStatement.setString(2, city.getCodigoPais());
            preparedStatement.setString(3, city.getDistrito());
            preparedStatement.setInt(4, city.getPoblacion());
            preparedStatement.setInt(5, IdCiudad);
            preparedStatement.execute();} 
        catch (SQLException ex) {
           Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}
        finally{
            try {
               preparedStatement.close();
               conexion.close();}
           catch (SQLException ex) {
               Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}}
    }
    public void borraCiudad(int IdCiudad){
        try{
           conexion=origenDatos.getConnection();
           String consulta="delete from  city where ID=?";        
           preparedStatement=conexion.prepareStatement(consulta);
           preparedStatement.setInt(1, IdCiudad);
           preparedStatement.execute();}
         catch (SQLException ex) {
           Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}
        finally{
            try {
               preparedStatement.close();
               conexion.close();}
           catch (SQLException ex) {
               Logger.getLogger(Modelo_Ciudades.class.getName()).log(Level.SEVERE, null, ex);}}   
    }
}
