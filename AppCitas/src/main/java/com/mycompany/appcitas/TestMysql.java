/*
PROGRAMA TESTEO CONEXIÓN BBDD MYSQL

Cuestiones:
        -String foto (clase Caractetetísticas)
        -INSERT y UPDATE: necesita añadir ubicación alea, en un futuro que lo realice sola 
        -pulsar enter para seguir con el proceso: ent.nextLine();
        -AccesoApp agregar tlf (atributo)
        -que la edad se mod en tiempo real
        -filtrar: buscar desde admin los premium, chicos/chicas-altura...
        -ficheros
        -documentacion: explicar lo que hace cada metodo
        -arquitectura, usabilidada (Menú interfaz), modelo entidad/relacion, paquete dominio (conexion)
ERROR:
        -Entra en insertar caracateristicas todo el rato no funciona true o false
        -qué poner en caso de que no elijan ninguna de las opciones como yes o no y no salga error
        -REVISAR LISTAR DESDE ADMI

   
*/
package com.mycompany.appcitas;
//Importar desde datos:
import datos.CaracteristicasDao;
import datos.UsuarioDao;
//Importar desde el dominio
import dominio.Caracteristicas;
import dominio.Usuario;
import dominio.Premium;
//importar desde negocio:
import negocio.gestionUs;
import negocio.gestionAdmi;
//Importar las interfaces
//import datos.IAccesoDatosUsuario;
//import datos.IAccesoDatosCaracteristicas;
//import datos.IAccesoDatosPremium;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ilc19
 */
public class TestMysql {
    static Scanner ent = new Scanner(System.in);
    //PARA LLAMAR A UN MÉTODO DE UNA CLASE SE DEBE CREAR UN OBJETO DE ESA CLASE:
    static  UsuarioDao usuarioDao=new UsuarioDao();
    //static PremiumDao premiumDao=new PremiumDao();
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
  //PREMIUM:
        DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("d/MM/yyyy");
        String d="1/02/2022";
        LocalDate ldFecha=LocalDate.parse(d,formatoFecha);
        java.sql.Date fechaFinal=java.sql.Date.valueOf(ldFecha);
        //idUsuario, Date fechaAlta, Date fechaBaja
    Premium p1=new Premium(1,fechaFinal,fechaFinal);
    Premium p2=new Premium(1,fechaFinal,fechaFinal,24.00);
    Premium p3=new Premium(22);
    
  //INSERTAR:
    //llamamos a la clase 'usuarioDao' donde esta el método 'insertar' y el objeto que queremos agregar al ArrayList 'p':
    //usuarioDao.insertar(u1);
    //usuarioDao.insertar(u2);
    //llamamos a la clase 'CaracteristicasDao' donde esta el método 'insertar' y el objeto que queremos agregar al ArrayList 'c':
    //caracteristicasDao.insertar(c1);
    //premiumDao.insertar(p1);
  //ACTUALIZAR:
    //caracteristicasDao.actualizar(c1);
    //usuarioDao.actualizar(u5);
    //premiumDao.actualizar(p2);
  //ELIMINAR:
    //usuarioDao.borrar(u1);
    //usuarioDao.borrar(u4);
    //caracteristicasDao.borrar(c3);
    //premiumDao.borrar(p3);
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
                      gestionUs.accesoApp();
                    break;
                case 2:
                    System.out.printf("\nREGISTRO USUARIO: \n");
                    System.out.printf("================\n");
                    gestionUs.registrarUsuario();
                    break;
                case 0:
                    System.out.println("\n\nGracias por usar la aplicación\n");
                    break;
                default:
                    System.out.printf("\nElija entre 0 y 2\n\n");
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
                    gestionAdmi.listar();
                    break;
                case 2:
                    gestionAdmi.eliminar();
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
    //entras desde accessoApp y registrarUsuario: ***agregar otro parametro donde diga si esta dado de A,B o Act
    public static void menuUsuario (int idUs){
        int opcion=-1;//variable para el menú
	while(opcion!=0){
            for (int i = 0; i < 5; i++) {
                System.out.println("");
            }
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).getIdUsuario()==idUs){
                        System.out.println("MENÚ USUARIO: "+usuarioDao.seleccionar().get(i).getNick());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("====================\n");
            System.out.printf("1.- Candidatxs\n");
            System.out.printf("2.- Ver perfil\n");
            System.out.printf("3.- Completar/Editar Perfil\n");
            System.out.printf("4.- Premium\n");
            System.out.printf("5.- Borrar cuenta\n");
            System.out.printf("0.- Cerrar sesión\n"); 
            opcion = ent.nextInt();
            System.out.println("");
            switch(opcion){
                case 1:
                    System.out.println("Mis Candidatos");
                    System.out.println("====================\n");
                    gestionUs.mostrarCandidatos(idUs);
                    break;
                case 2:
                    System.out.println("Mi perfil");
                    System.out.println("====================\n");
                    gestionUs.listarUs(idUs);
                    break;
                case 3:
                    System.out.println("Insertar Características");
                    System.out.println("========================\n");
                    gestionUs.insertCar(idUs);
                    break;
                case 4:
                    System.out.println("Premium");
                    System.out.println("==========\n");
                    gestionUs.altaBaja(idUs);
                    break;
                case 5:
                    System.out.println("Eliminar Perfil");
                    System.out.println("====================\n");
                    gestionUs.eliminarUs(idUs);
                    break;
                case 0:
                    break;  
                default:
                    System.out.printf("\nElija entre 0 y 5\n\n");
                    break;
            }
        }
    }
}
        
