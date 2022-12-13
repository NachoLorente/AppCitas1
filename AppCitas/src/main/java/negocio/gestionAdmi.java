/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import com.mycompany.appcitas.TestMysql;
import datos.CaracteristicasDao;
import datos.PremiumDao;
import dominio.Caracteristicas;
import dominio.Usuario;
import dominio.Premium;
import datos.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author ilc19
 */
public class gestionAdmi {
    
    static Scanner ent = new Scanner(System.in);
    ////PARA LLAMAR A UN MÉTODO/FUNCION ('INSERTAR') DE UNA CLASE ('USUARIODAO') SE DEBE CREAR UN OBJETO DE ESA CLASE:
    static UsuarioDao usuarioDao=new UsuarioDao(); 
    static CaracteristicasDao caracteristicasDao=new CaracteristicasDao();
    static PremiumDao premiumDao=new PremiumDao();
    
    public static void accesoAdmin(){
            System.out.println("\nIntroduzca su nombre de administrador: ");
            String userName =ent.nextLine();
            System.out.println("\nIntroduzca su contraseña: ");
            String password =ent.nextLine();
            if(userName.equals("theboss")==false || password.equals("0000")==false){
                System.out.println("Nombre de usuario o contraseña incorrecto (recuerde distinguir entre mayúsculas y minúsculas)");
                TestMysql.menu();
            }
            //return true;
        }
    
    public static void listar(){
            try {
                //debemos crear antes un objeto usuarioDao
                List<Usuario>usuarios=usuarioDao.seleccionar();
                usuarios.forEach(usuario->{
                    System.out.println("usuario: "+usuario);
                    System.out.println("");
                }
                );
                //debemos crear antes un objeto caracteristicasDao
                List<Caracteristicas>caracteristicas=caracteristicasDao.seleccionar();
                caracteristicas.forEach(caracteristica->{
                    System.out.println("caracteristicas: ");
                    System.out.println(caracteristicas);
                    System.out.println("idUsuario: "+caracteristica.getIdUsuario());
//                    if(caracteristica.getBio().equals(" ")){
//                        System.out.println("Bio: ");
//                    }else{
                        System.out.println("Bio: "+caracteristica.getBio());
                        System.out.println("Ocupación: "+caracteristica.getTrabajo());
                        System.out.println("Formación: "+caracteristica.getFormacion());
                        System.out.println("Ciudad: "+caracteristica.getCiudad());
                        System.out.println("Estatura: "+caracteristica.getEstatura()+"cm");
//                    }
                    System.out.println("");
                }
                );
                 //debemos crear antes un objeto premiumDao
                 List<Premium>premium=premiumDao.seleccionar();
                caracteristicas.forEach(Premium->{
                    System.out.println("Premium: "+premium);
                    System.out.println("");
                }
                );
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    
     public static void eliminar(){
                System.out.println("\nIntroduzca el idUsuario a eliminar: ");
                int idUsuario =ent.nextInt();
                //creamos un objeto que utiliza el constructor de 'idUsuario'
                Usuario u6 =new Usuario(idUsuario);
                Caracteristicas c6=new Caracteristicas(idUsuario);
                 //**REVISAR CUANDO HAYA CREADO EL ACCESO COMO USUARIO:**
                //Caracteristicas c6=new Caracteristicas (idUsuario);
                try {
                    //usuarioDao.seleccionar() se comporta como un ArrayList, ya que esta declarado como tal y retorna un arrays (usuario):
                    for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                        if(usuarioDao.seleccionar().get(i).getIdUsuario()==u6.getIdUsuario()){
                            //busca y muestra los atributos del idUsuario seleccionado:
                            System.out.println("Seguro que quiere eliminar al usuario: " +usuarioDao.seleccionar().get(i).getNick()+" con correo: "+usuarioDao.seleccionar().get(i).getCorreo()+" \nYES/NO");
                            ent.nextLine();//para evitar que salte de línea
                            String conf=ent.nextLine();
                            if(conf.equalsIgnoreCase("Yes")==true){
                                //enviamos como parámetro a la función 'borrar' el objeto creado
                                usuarioDao.borrar(u6);
                                caracteristicasDao.borrar(c6);
                                //**REVISAR CUANDO HAYA CREADO EL ACCESO COMO USUARIO:**
                                //caracteristicasDao.borrar(c6);
                                System.out.println("---USUARIO ELIMINADO---");
                                return;
                            }
                        }
                    }
                            System.out.println("No se encuentran coincidencias con usuario "+idUsuario+" en la base de datos");
                            return;
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
        }
}
