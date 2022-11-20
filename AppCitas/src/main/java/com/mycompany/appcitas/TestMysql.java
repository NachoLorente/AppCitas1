/*
PROGRAMA TESTEO CONEXIÓN BBDD MYSQL

Cuestiones:
        -String foto (clase Caractetetísticas)
        -INSERT y UPDATE: necesita añadir ubicación alea, en un futuro que lo realice sola 
        -codificar clave
        -pulsar enter para seguir con el proceso
        -AccesoApp agregar tlf (atributo)
        -que la edad se mod en tiempo real
        -meter un filtro para registrar en caso de que exista el correo
ERROR:
        -Entra en insertar caracateristicas todo el rato no funciona true o false
        -Mostrar en un sout el nick de cada usuario
        -qué poner en caso de que no elijan ninguna de las opciones como yes o no y no salga error
   
*/
package com.mycompany.appcitas;

import datos.CaracteristicasDao;
import datos.UsuarioDao;
//Importar desde el dominio
import dominio.Caracteristicas;
//Importar desde el dominio
import dominio.Usuario;
import java.sql.SQLException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;


/**
 *
 * @author ilc19
 */
public class TestMysql {
    static Scanner ent = new Scanner(System.in);
    //PARA LLAMAR A UN MÉTODO DE UNA CLASE SE DEBE CREAR UN OBJETO DE ESA CLASE:
    static  UsuarioDao usuarioDao=new UsuarioDao();
    static boolean eleccion=true;
    public static void main(String[] args) {
    //crea objeto personaDao
  
    CaracteristicasDao caracteristicasDao=new CaracteristicasDao();
    //instanciar objetos utilizando los constructores que necesite:
  //USUARIOS:
    //String nick, String clave, String correo, boolean genero, boolean interes, String fechaNacimiento, Double longitud, Double latitud
    Usuario u1=new Usuario("Nacho L.C.","1234","ilc1990@hotmail.com",true,false,32,40.4165,-3.7025);
    Usuario u2=new Usuario("Alytes","1111","ilc1990@hotmail.com",true,false,29,40.4165,-3.7025);
    //Usuario u3=new Usuario(1);
    Usuario u4=new Usuario(5);
    Usuario u5=new Usuario(2,"Nacho L.C.","0000","ilc1990@hotmail.com",true,false,32,40.4165,-3.7025);
  //CARACTERÍSTICAS:
    //idUsuario, String trabajo, String formacion, Integer estatura, boolean alcohol, boolean deporte, boolean tabaco, boolean hijos
    Caracteristicas c1=new Caracteristicas(5,"Dietista","Técnico Superior",175,true,true,false,false);
    Caracteristicas c2=new Caracteristicas("Desarrollador","Técnico Superior",175,true,true,false,false);
    Caracteristicas c3=new Caracteristicas(5);
    
  //INSERTAR:
    //llamamos a la clase 'usuarioDao' donde esta el método 'insertar' y el objeto que queremos agregar al ArrayList 'p':
    //usuarioDao.insertar(u1);
    //usuarioDao.insertar(u2);
    //llamamos a la clase 'CaracteristicasDao' donde esta el método 'insertar' y el objeto que queremos agregar al ArrayList 'c':
    //caracteristicasDao.insertar(c1);
  //ACTUALIZAR:
    //caracteristicasDao.actualizar(c1);
    //usuarioDao.actualizar(u5);
  //ELIMINAR:
    //usuarioDao.borrar(u1);
    //usuarioDao.borrar(u4);
    //caracteristicasDao.borrar(c3);
    menu();
    }
    
    public static void menu(){
        //para poder llamar a la función "accesoAdmin" es necesario crear un objeto de esa clase:
        
        Usuario u3=new Usuario();
        
        int opcion=-1;//variable para el menú
	while(opcion!=0){
            System.out.println("APP CITAS");
            System.out.println("====================\n");
            //MENÚ NUEVO:
            System.out.printf("1.- Acceder a la App\n");
            System.out.printf("2.- Resgistrarse\n");
            System.out.printf("0.- SALIR\n"); 
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    for (int i = 0; i < 5; i++) {
                         System.out.println("");
                    }
                    System.out.printf("MENÚ DE ACCESO: \n");
                    System.out.printf("================\n");
                      Usuario.accesoApp();
                    break;
                case 2:
                    System.out.printf("\nREGISTRO USUARIO: \n");
                    System.out.printf("================\n");
                    Usuario.registrarUsuario();
                    break;
                case 0:
                    System.out.println("\n\nGracias por usar la aplicación\n");
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 3\n\n");
                    break;
            }
            ent.nextLine();       
        }
    }
    
    public static void menuAdmin(){
        int opcion=-1;//variable para el menú
	while(opcion!=0){
            for (int i = 0; i < 10; i++) {
                System.out.println("");
            }
            System.out.println("MENÚ ADMINISTRADOR");
            System.out.println("====================\n");
            System.out.printf("1.- Listar Usuarios\n");
            System.out.printf("2.- Eliminar Usuarios\n");
            System.out.printf("0.- SALIR\n"); 
            opcion = ent.nextInt();
            switch(opcion){
                case 1:
                    Usuario.listar();
                    break;
                case 2:
                    Usuario.eliminar();
                    break;
                case 0:
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
                    break;
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("");
            }
            //ent.nextLine();     
        }
    }
    //entras desde accessoApp y registrarUsuario:
    public static void menuUsuario (int idUs){
        int opcion=-1;//variable para el menú
	while(opcion!=0){
            for (int i = 0; i < 5; i++) {
                System.out.println("");
            }
            System.out.println("MENÚ USUARIO: ");
            System.out.println("====================\n");
            System.out.printf("1.- Ver perfil\n");
            System.out.printf("2.- Completar/Editar Perfil\n");
            System.out.printf("3.- Eliminar Perfil\n");
            System.out.printf("0.- SALIR\n"); 
            opcion = ent.nextInt();
            System.out.println("");
            switch(opcion){
                case 1:
                    Usuario.listarUs(idUs);
                    break;
                case 2:
                    System.out.println("Insertar Características");
                    System.out.println("========================\n");
                    Caracteristicas.insertCar(idUs);
                    break;
                case 3:
                    System.out.println(idUs);
                    System.out.println("Eliminar Perfil");
                    System.out.println("====================\n");
                    Usuario.eliminarUs(idUs);
                     //break;
                     return;
                case 0:
                    break;  
                default:
                    System.out.printf("\nElija entre 0 y 3\n\n");
                    break;
            }
        }
    }
}
        
