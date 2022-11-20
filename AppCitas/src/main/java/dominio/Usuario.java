/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import com.mycompany.appcitas.TestMysql;
import datos.UsuarioDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import datos.CaracteristicasDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilc19
 */
public class Usuario implements Serializable{
   //VARIABLES:
    private int idUsuario;
    private String nick;
    private String clave;
    private String correo;
    private boolean genero;
    private boolean interes;
    private int edad;
    private Double longitud;
    private Double latitud;
    //CONSTRUCTORES:
    //VACIO:
    public Usuario() {
        
    }
    //para el administrador:
    public Usuario(String nick, String clave, String correo) {
        this.nick = nick;
        this.clave = clave;
        this.correo = correo;
    }
    
    //con todos los atributos:
    public Usuario(int idUsuario, String nick, String clave, String correo, boolean genero, boolean interes, int edad, Double longitud, Double latitud) {
        this.idUsuario=idUsuario;
        this.nick = nick;
        this.correo = correo;
        this.clave = clave;
        this.genero = genero;
        this.interes = interes;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud=latitud;
    }
    
    //sin identidicador:
    public Usuario(String nick, String clave, String correo, boolean genero, boolean interes, int edad, Double longitud, Double latitud) {
        this.nick = nick;
        this.clave = clave;
        this.correo = correo;
        this.genero = genero;
        this.interes = interes;
        this.edad = edad;
        this.longitud = longitud;
        this.latitud = latitud;
    }
    
    //¿con solo identificador?:
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //solo correo:
    public Usuario(String correo) {
        this.correo = correo;
    }
    
    //con fecha y ubicación por defecto
    public Usuario(int idUsuario, String nick, String clave, String correo, boolean genero, boolean interes) {
        this.idUsuario= idUsuario;
        this.nick = nick;
        this.correo = correo;
        this.clave = clave;
        this.genero = genero;
        this.interes = interes;
        this.edad= 32;
        this.longitud=this.longitud=40.4165;
        this.latitud=this.latitud=-3.7025;
    }
    //GET & SET:

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean isInteres() {
        return interes;
    }

    public void setInteres(boolean interes) {
        this.interes = interes;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    
    //EQUAL & HASHCODE:

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n identificador: ").append(idUsuario);
        sb.append("\n\t nick: ").append(nick);
        sb.append("\n\t clave: ").append(clave);
        sb.append("\n\t correo: ").append(correo);
        sb.append("\n\t genero: ").append(genero);
        sb.append("\n\t interes: ").append(interes);
        sb.append("\n\t Edad: ").append(edad);
        sb.append("\n\t longitud: ").append(longitud);
        sb.append("\n\t latitud: ").append(latitud);
        return sb.toString();
    }
    
    static Scanner ent = new Scanner(System.in);
    ////PARA LLAMAR A UN MÉTODO/FUNCION ('INSERTAR') DE UNA CLASE ('USUARIODAO') SE DEBE CREAR UN OBJETO DE ESA CLASE:
    static UsuarioDao usuarioDao=new UsuarioDao(); 
    static CaracteristicasDao caracteristicasDao=new CaracteristicasDao();
    
    public static void registrarUsuario(){
        boolean interes=true;
        boolean genero=true;
        double longitud=0;
        double latitud=0;
        Calendar cal=new GregorianCalendar();
        int edad=0;
        int diaActual=cal.get(Calendar.DAY_OF_MONTH);
        int mesActual=cal.get(Calendar.MONTH)+1;//sumo uno porque falla por un mes
        int ayioActual=cal.get(Calendar.YEAR);
        int d=0;
        int m=0;
        int a=0;
        int idUs=0;
        //AÑADIR UNA EXCEPCION EN CASO DE QUE EL CORREO YA EXISTA!!!!!!
        System.out.println("\nIntroduzca su correo: ");
        String correo=ent.nextLine();
//        Usuario u7=new Usuario(correo);
        while(correo==""){
            System.out.println("\nDebe introducir un correo: ");
            correo=ent.nextLine();
        }
        System.out.println("\nIntroduzca su nombre de usuario: ");
            String nombre=ent.nextLine();
            while(nombre==""){
                System.out.println("\nDebe introducir un nombre de usuario: ");
                nombre=ent.nextLine();
            }
        System.out.println("\nIntroduzca su contraseña: ");
            String clave=ent.nextLine();
            while(clave==""){
                System.out.println("\nDebe introducir una contraseña: ");
                clave=ent.nextLine();
            }
        System.out.println("\nIntroduzca su género (Masculino/Femenino): ");
            String sexo=ent.nextLine();
            while(sexo==""){
                System.out.println("\nDebe introducir su género: ");
                sexo=ent.nextLine();
            }
            if(sexo.compareToIgnoreCase("masculino")==0){
                genero=true;//1
            }
            else if(sexo.compareToIgnoreCase("femenino")==0){
                genero=false;//0
            }
        System.out.println("\nIntroduzca el género que le atrae(Masculino/Femenino): ");
            String sexoOpuesto=ent.nextLine();
            while(sexoOpuesto==""){
                System.out.println("\nDebe introducir un género: ");
                sexoOpuesto=ent.nextLine();
            }
            if(sexoOpuesto.compareToIgnoreCase("masculino")==0){
                interes=true;
            }
            else if(sexoOpuesto.compareToIgnoreCase("femenino")==0){
                interes=false;
            }
            System.out.println("\nIntroduzca año de nacimiento(AAAA)): ");
                a=ent.nextInt();
                if ((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0))){
                    System.out.println("\nIntroduzca mes de nacimiento(MM): ");
                     m=ent.nextInt();
                        while(m<1||m>12){
                            System.out.println("El mes debe estar comprendido entre 1 y 12: ");
                            m=ent.nextInt();
                        }
                        if(m==2){
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>29){
                                System.out.println("El día debe estar comprendido entre 1 y 29: ");
                                d=ent.nextInt();
                            }
                        }else if(m==1||m==3||m==5||m==7||m==9||m==11){
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>31){
                                System.out.println("El día debe estar comprendido entre 1 y 31: ");
                                d=ent.nextInt();
                            }
                        }else{
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>30){
                                System.out.println("El día debe estar comprendido entre 1 y 30: ");
                                d=ent.nextInt();
                            }
                        }
                }
                else{
                     System.out.println("\nIntroduzca mes de nacimiento(MM): ");
                     m=ent.nextInt();
                        while(m<1||m>12){
                            System.out.println("El mes debe estar comprendido entre 1 y 12: ");
                            m=ent.nextInt();
                        }
                        if(m==2){
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>28){
                                System.out.println("El día debe estar comprendido entre 1 y 29: ");
                                d=ent.nextInt();
                            }
                        }else if(m==1||m==3||m==5||m==7||m==9||m==11){
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>31){
                                System.out.println("El día debe estar comprendido entre 1 y 31: ");
                                d=ent.nextInt();
                            }
                        }else{
                            System.out.println("\nIntroduzca día de nacimiento(dd): ");
                            d=ent.nextInt();
                            while(d<1||d>30){
                                System.out.println("El día debe estar comprendido entre 1 y 30: ");
                                d=ent.nextInt();
                            }
                        }
                }
                if(m>=mesActual){
                    if(d>diaActual){
                        edad=((ayioActual-a)-1);
                    }else{
                        edad=((ayioActual-a));
                    }
                }else{
                    edad=(ayioActual-a);
                }
            System.out.println("Permitir que la aplicación acceda a su ubicación: YES/NO");
                ent.nextLine();//para evitar que se salte de linea
                String res=ent.nextLine();
                if(res.equalsIgnoreCase("YES")==true){
                    longitud=40.4165;
                    latitud=-3.7025;
                }else if(res.equalsIgnoreCase("NO")==false){
                    longitud=0;
                    latitud=0;
                }
                Usuario u5=new Usuario(nombre,clave,correo,genero,interes,edad,longitud,latitud);
                //Antes debemos crear el objeto usuarioDao:
                usuarioDao.insertar(u5);
                //con el correo dado los busco en el arrays para saber su id de usuario
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).correo.equalsIgnoreCase(correo)){
                        //creo una var con idUs para poder manejar el menuUsuario
                        idUs=usuarioDao.seleccionar().get(i).idUsuario;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("");
        }
                System.out.println("BIENVENIDO A LA APPCITAS:");
                TestMysql.menuUsuario(idUs);
        }
    
        public static void accesoApp(){
            //boolean condicion=true;
            System.out.println("\nIngrese su correo: ");
            String email =ent.nextLine();
            //Usuario u8=new Usuario(email);
            System.out.println("\nIntroduzca su contraseña: ");
            String password =ent.nextLine();
            System.out.println("");
            //Si el correo y contraseña coinciden se va al menuAdmi...
            if(email.equals("theboss@gmail.com")==true && password.equals("0000")==true){
               TestMysql.menuAdmin();
            }
            //...sino va a un for donde recorrerá el arrayList donde estan todos los registros...
            else{
                //falta agregar un if con la posibilidad de que no existan registros aún!!!!
                try {
                    for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                        //...si el correo y la clave son iguales accederé a mi menú de usuario...
                        if(usuarioDao.seleccionar().get(i).correo.equalsIgnoreCase(email) && usuarioDao.seleccionar().get(i).clave.equals(password)){
                           //le mando como parametro a menuUsuario el idUsuario que corresponde al nickname ingresado
                           TestMysql.menuUsuario(usuarioDao.seleccionar().get(i).idUsuario);
                        }
                    }
                System.out.println("Usuario y/o contraseña incorrecta\n");
                } catch (SQLException ex) {
                     ex.printStackTrace(System.out);
                }
                //...sino me devuelve al menú principal
                return;
            }
        }
        
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
                }
                );
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        //Para mostrar las personas que tenemos en la bbdd:
            try {
                //debemos crear antes un objeto caracteristicasDao
                List<Caracteristicas>caracteristicas=caracteristicasDao.seleccionar();
                caracteristicas.forEach(caracteristica->{
                    System.out.println("caracteristicas: "+caracteristica);
                }
                );
            } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            }  
        }
        static int ayios;
        static String nickName;
        static boolean sexo=true;
        static boolean sexoOp=true;
        
        static String info;
        static String job;
        static String estudios;
        static String city;
        static int alt;
        static boolean drink=true;
        static boolean sport=true;
        static boolean smoke=true;
        static boolean son=true;
        static String pic;

        public static void listarUs(int idUs){
            Usuario u8 =new Usuario(idUs);
            Caracteristicas c8=new Caracteristicas(idUs);
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).idUsuario==u8.idUsuario){
                        nickName=usuarioDao.seleccionar().get(i).nick;
                        sexo= usuarioDao.seleccionar().get(i).genero;
                        sexoOp= usuarioDao.seleccionar().get(i).interes;
                        ayios=usuarioDao.seleccionar().get(i).edad;
                        double lon=usuarioDao.seleccionar().get(i).longitud;
                        double lat=usuarioDao.seleccionar().get(i).latitud;
                       
                        System.out.printf("\n\t"+nickName+", "+ayios);
                        if(sexo==true){
                                System.out.printf("\n\tHombre");
                            }else{
                                System.out.printf("\n\tMujer");
                            }
                        System.out.printf("\n\tvivo en: "+lon+", "+lat);
                        
                    }
                }
                for (int i = 0; i < caracteristicasDao.seleccionar().size(); i++) {
                    if(caracteristicasDao.seleccionar().get(i).getIdUsuario()==c8.getIdUsuario()){
                        //String fotos
                            info=caracteristicasDao.seleccionar().get(i).getBio();
                            job=caracteristicasDao.seleccionar().get(i).getTrabajo();
                            estudios=caracteristicasDao.seleccionar().get(i).getFormacion();
                            city=caracteristicasDao.seleccionar().get(i).getCiudad();
                            alt=caracteristicasDao.seleccionar().get(i).getEstatura();
                            drink=caracteristicasDao.seleccionar().get(i).isAlcohol();
                            sport=caracteristicasDao.seleccionar().get(i).isDeporte();
                            smoke=caracteristicasDao.seleccionar().get(i).isTabaco();
                            son=caracteristicasDao.seleccionar().get(i).isHijos();
                            pic=caracteristicasDao.seleccionar().get(i).getFotos();
                            
                            System.out.printf("\n\t"+job);
                            System.out.printf("\n\t"+info);
                            System.out.printf("\n   Acerca de mí: ");
                            System.out.printf("\n\t"+alt+"cm");
                            if(sport==true){
                                System.out.printf("\n\t Deportista");
                            }else if(sport==false){
                                System.out.printf("\n\t Sedentario");
                            }
                             if(drink==true){
                                System.out.printf("\n\t Consumo alcohol");
                            }else{
                                System.out.printf("\n\t Abstemio");
                            }
                              if(smoke==true){
                                System.out.printf("\n\t Fumador");
                            }else{
                                System.out.printf("\n\t No fumo");
                            }
                            if(son==true){
                                System.out.printf("\n\t Con hijos");
                            }else{
                                System.out.printf("\n\t Sin hijos");
                            }
                            System.out.printf("\n\t Ciudad natal: "+city);
                    }
                }
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
                        if(usuarioDao.seleccionar().get(i).idUsuario==u6.idUsuario){
                            //busca y muestra los atributos del idUsuario seleccionado:
                            System.out.println("Seguro que quiere eliminar al usuario: " +usuarioDao.seleccionar().get(i).nick+" con correo: "+usuarioDao.seleccionar().get(i).correo+" \nYES/NO");
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
        
        public static void eliminarUs(int idUs){
                System.out.println(idUs);
            Usuario u7 =new Usuario(idUs);
            Caracteristicas c7=new Caracteristicas(idUs);
            System.out.println("¿Esta seguro de que desea eliminar su perfil? (YES/NO)");
            String con=ent.nextLine();
            if(con.equalsIgnoreCase("YES")==true){
                //enviamos como parámetro a la función 'borrar' el objeto creado
                usuarioDao.borrar(u7);
                caracteristicasDao.borrar(c7);
                System.out.println("---TE ECHAREMOS DE MENOS---");
            }else if(con.equalsIgnoreCase("NO")==true){
                System.out.println("---CREEMOS EN LAS SEGUNDAS OPORTUNIDADES---");
                return;
            }
        }
    }
