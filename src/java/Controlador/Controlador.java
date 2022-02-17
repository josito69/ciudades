
package Controlador;

import Modelo.Modelo_Ciudades;
//****************************************************************PARA EJECUTAR CON TOMCAT  9*****************************************************
//****************************************CON TOMCAT 10 DESCOMENTAR IMPORT DE YAKARTA Y COMENTAR IMPORT DE JAVAX*********************************
//import jakarta.annotation.Resource;
//import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.*;
import javax.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    @Resource(name="jdbc/ciudades") private DataSource thePool;
    Modelo_Ciudades modeloCiudades;
    
    @Override
    public void init() throws ServletException{
        modeloCiudades=new Modelo_Ciudades(thePool);
        
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) action="";
        
        switch (action) {
            case "insertaCiudad": insertaCiudad(request,response);break;
            case "cargaCiudad": cargaCiudad(request,response);break;
            case "updateCiudad": updateCiudad(request,response);break;
            case "borraCiudad" : borraCiudad(request,response);break;
            default : listarCiudades(request,response);break;
        }
    }

    private void listarCiudades(HttpServletRequest request, HttpServletResponse response){
        try{
            RequestDispatcher despachador=request.getRequestDispatcher("listaCiudades.jsp");
            List<Ciudad> ciudades=modeloCiudades.getCiudades();
            request.setAttribute("ListaCiudades", ciudades);
            despachador.forward(request, response);
        }
        catch (IOException | ServletException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);} 
    }

    private void insertaCiudad(HttpServletRequest request, HttpServletResponse response) {
        String nombre=request.getParameter("nombre");
        String codigoPais=request.getParameter("codigoPais");
        String distrito=request.getParameter("distrito");
        int poblacion=Integer.parseInt(request.getParameter("poblacion"));
        Ciudad city=new Ciudad(0,nombre,codigoPais,distrito,poblacion);
        modeloCiudades.setCiudad(city);
        listarCiudades(request,response);
    }

    private void cargaCiudad(HttpServletRequest request, HttpServletResponse response) {
       
       int ID=Integer.parseInt(request.getParameter("IdCiudad"));
       Ciudad city;
       try{
          RequestDispatcher despachador=request.getRequestDispatcher("CargaCiudad.jsp");
          city=modeloCiudades.getCiudad(ID);
          request.setAttribute("Ciudad", city);
          despachador.forward(request, response);}
       catch (IOException | ServletException ex) {
           Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);} 
    }
    private void updateCiudad(HttpServletRequest request, HttpServletResponse response) {
       
       int ID=Integer.parseInt(request.getParameter("IdCiudad"));
       Ciudad city=new Ciudad(ID,request.getParameter("nombre"),request.getParameter("codigoPais"),request.getParameter("distrito"),Integer.parseInt(request.getParameter("poblacion")));
       modeloCiudades.updateCiudad(ID,city);
       listarCiudades(request,response);
    }

    private void borraCiudad(HttpServletRequest request, HttpServletResponse response){
       int ID=Integer.parseInt(request.getParameter("IdCiudad"));
       modeloCiudades.borraCiudad(ID);
       listarCiudades(request,response);
    }
}
