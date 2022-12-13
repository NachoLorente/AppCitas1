/*
 * Conecta mediante metodos con acceso a datos.
 */
package negocio;

import com.mycompany.appcitas.TestMysql;
import datos.CaracteristicasDao;
import datos.PremiumDao;
import datos.UsuarioDao;
import dominio.Caracteristicas;
import dominio.Premium;
import dominio.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilc19
 */
public class gestionUs {
      static Scanner ent = new Scanner(System.in);
    ////PARA LLAMAR A UN MÉTODO/FUNCION ('INSERTAR') DE UNA CLASE ('USUARIODAO') SE DEBE CREAR UN OBJETO DE ESA CLASE:
    static UsuarioDao usuarioDao=new UsuarioDao(); 
    static CaracteristicasDao caracteristicasDao=new CaracteristicasDao();
    static PremiumDao premiumDao=new PremiumDao();
    
    public static void accesoApp(){
            gestionUs us2=new gestionUs();
            System.out.println("\nIngrese su correo: ");
            String email =ent.nextLine();
            System.out.println("\nIntroduzca su contraseña: ");
            String password =ent.nextLine();
            //creo una variable donde a la clave introducida en tiempo real se le aplica la función MD5
            String claveUs=us2.MD5(password);
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
                        //compara la clave introducida cifrada ('claveUs') en tiempo real con la clave de la bbdd ('clave')
                        if(usuarioDao.seleccionar().get(i).getCorreo().equalsIgnoreCase(email) && usuarioDao.seleccionar().get(i).getClave().equals(claveUs)){
                           //le mando como parametro a menuUsuario el idUsuario que corresponde al nickname ingresado
                           TestMysql.menuUsuario(usuarioDao.seleccionar().get(i).getIdUsuario());
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
        try {
             //si el correo es igual a alguno de la bbdd:
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).getCorreo().equalsIgnoreCase(correo)){
                        System.out.println("\nParece que ya se encuentra registrado con ese correo en la App\n");
                        return;
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        System.out.println("\nIntroduzca su nombre de usuario: ");
            String nombre=ent.nextLine();
            while(nombre==""){
                System.out.println("\nDebe introducir un nombre de usuario: ");
                nombre=ent.nextLine();
            }
        System.out.println("\nIntroduzca su contraseña: ");
            String clave=ent.nextLine();
            gestionUs u1=new gestionUs();
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
//            try {
//                usuarioDao.buscarGen(interes);
//            } catch (SQLException ex) {
//                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
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
                //mandamos la clave introducida en el objeto instanciado u para cifrarla en el metodo MD5:
                Usuario u5=new Usuario(nombre,u1.MD5(clave),correo,genero,interes,edad,longitud,latitud);
                //Antes debemos crear el objeto usuarioDao:
                usuarioDao.insertar(u5);
                //con el correo dado los busco en el arrays para saber su id de usuario
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).getCorreo().equalsIgnoreCase(correo)){
                        //creo una var con idUs para poder manejar el menuUsuario
                        idUs=usuarioDao.seleccionar().get(i).getIdUsuario();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("");
        }
                System.out.println("BIENVENIDO A LA APPCITAS:");
                TestMysql.menuUsuario(idUs);
        }
    
    //función para encriptar, recibe 'clave'
         public String MD5(String md5){
             try{
                 java.security.MessageDigest md=java.security.MessageDigest.getInstance("MD5");
                 byte[]array=md.digest(md5.getBytes());
                 StringBuffer sb=new StringBuffer();
                 for (int i = 0; i < array.length; i++) {
                     sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                 }
                 return sb.toString();
             }catch(java.security.NoSuchAlgorithmException e){
                 
             }
             return null;
         }
         //método para swipear:
         /*género=false(femenino) y interes=true(masculino)
         monstrar us con genero igual que su interés=true (mascu), error: me mostrará us que su gén=true(m), pero su int=true(m)(gays)
         g==inte && interes!=inte
         */
         
          public static void mostrarCandidatos(int idUs){
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                   if(usuarioDao.seleccionar().get(i).getIdUsuario()==idUs){
                        //meter en una variable booleana el interes del usuario con el que se esta trabajando
                        Boolean inte=usuarioDao.seleccionar().get(i).isInteres();//ej. true (m)
                       //si su interés es distinto a su genero (hetero):
                        if(inte!=usuarioDao.seleccionar().get(i).isGenero()){
                        //listar los usuarios enviando como parámetro el interes y gen del usuario a la función buscarGen
                           boolean gen=usuarioDao.seleccionar().get(i).isGenero();//ej. false (f)
                           List<Usuario>usuarios=usuarioDao.buscarGen(inte, gen, idUs);
                           usuarios.forEach(usuario->{
                            System.out.println(usuario.getNick()+", "+usuario.getEdad());
                             if(usuario.isInteres()==true){
                                 System.out.println("Interés: Hombres");
                             }else{
                                 System.out.println("Interés: Mujeres");
                             }
                                System.out.println(usuario.getLongitud());
                                System.out.println(usuario.getLatitud());
                                System.out.println("");
                            });
                           return;
                       //si su interés es igual a su genero (gays):
                        }else{
                            //listar los usuarios enviando como parámetro el interes del usuario a la función buscarGen
                           boolean gen=usuarioDao.seleccionar().get(i).isGenero();//ej. true (t)
                           List<Usuario>usuarios=usuarioDao.buscarGen(inte, gen, idUs);
                           usuarios.forEach(usuario->{
                            System.out.println(usuario.getNick()+", "+usuario.getEdad());
                             if(usuario.isInteres()==true){
                                 System.out.println("Interés: Hombres");
                             }else{
                                 System.out.println("Interés: Mujeres");
                             }
                                System.out.println(usuario.getLongitud());
                                System.out.println(usuario.getLatitud());
                                System.out.println("");
                            });
                           return;
                       }
                         
                   }
               }
            } catch (SQLException ex) {
                Logger.getLogger(TestMysql.class.getName()).log(Level.SEVERE, null, ex);
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
            Premium p8=new Premium(idUs);
            try {
                for (int i = 0; i < usuarioDao.seleccionar().size(); i++) {
                    if(usuarioDao.seleccionar().get(i).getIdUsuario()==u8.getIdUsuario()){
                        nickName=usuarioDao.seleccionar().get(i).getNick();
                        sexo= usuarioDao.seleccionar().get(i).isGenero();
                        sexoOp= usuarioDao.seleccionar().get(i).isInteres();
                        ayios=usuarioDao.seleccionar().get(i).getEdad();
                        double lon=usuarioDao.seleccionar().get(i).getLongitud();
                        double lat=usuarioDao.seleccionar().get(i).getLatitud();
                       
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
                for (int i = 0; i < premiumDao.seleccionar().size(); i++) {
                    if(premiumDao.seleccionar().get(i).getIdUsuario()==c8.getIdUsuario()){
                            System.out.printf("\n\t--USUARIO PREMIUM--");
                    }
                }
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }
            
        }
         
    public static void insertCar(int idUs){
        boolean var=true;
        try {
            //ningún usuario agrego caracteristicas
            if(caracteristicasDao.seleccionar().isEmpty()){
                var=true;
                ingresarCarac(idUs,var);
                return;
           //en ca so de que sí haya usuarios con caracteristicas...
            }else{
                //para encontrar un usuario en concreto
                for (int i = 0; i < caracteristicasDao.seleccionar().size(); i++) {
                //ya existe unas caracteristicas para ese idUs: 
                    if(caracteristicasDao.seleccionar().get(i).getIdUsuario()==idUs){
                        var=false;
                        ingresarCarac(idUs, var);
                        return;
                    }
                }
                //en caso de que haya un usuario creado, pero sin caracteristicas agregadas:
                var=true;
                ingresarCarac(idUs, var);
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void ingresarCarac(int idUs, boolean v){
        boolean alcohol=true;
        boolean deporte=true;
        boolean tabaco=true;
        boolean hijos=true;
        System.out.println("Acerca de mí");
                    System.out.println("Sobre mí: ");
                        String bio=ent.nextLine();
                    System.out.println("Trabajo: ");
                        String trabajo=ent.nextLine();
                    System.out.println("Formación: ");
                        String formacion=ent.nextLine();
                    System.out.println("Ciudad natal: ");
                        String ciudad=ent.nextLine();
                    System.out.println("Más sobre mí");
                    System.out.println("Estatura: ");
                        int estatura=ent.nextInt();
                    System.out.println("Alcohol(Yes/No): ");
                        String conf1=ent.nextLine();
                        ent.nextLine();
                            if(conf1.compareToIgnoreCase("Yes")==0){
                                alcohol=true;
                            }else if(conf1.compareToIgnoreCase("No")==0){
                                alcohol=false;
                            }
                    System.out.println("Deporte: (Yes/No)");
                        String conf2=ent.nextLine();
                            if(conf2.compareToIgnoreCase("Yes")==0){
                                deporte=true;
                            }else if(conf2.compareToIgnoreCase("No")==0){
                                deporte=false;
                            }
                    System.out.println("Tabaco: (Yes/No)");
                        String conf3=ent.nextLine();
                            if(conf3.compareToIgnoreCase("Yes")==0){
                                tabaco=true;
                            }else if(conf3.compareToIgnoreCase("No")==0){
                                tabaco=false;
                            }
                    System.out.println("Hijos: (Yes/No)");
                        String conf4=ent.nextLine();
                            if(conf4.compareToIgnoreCase("Yes")==0){
                                    hijos=true;
                                }else if(conf4.compareToIgnoreCase("No")==0){
                                    hijos=false;
                                }
                    System.out.println("Insertar Fotos: ");
                        String fotos=ent.nextLine();
                    if(v==true){
                        Caracteristicas c4=new Caracteristicas(idUs,bio,trabajo,formacion,ciudad,estatura,alcohol,deporte,tabaco,hijos,fotos);
                        caracteristicasDao.insertar(c4);
                        System.out.println("\n--CARACTERÍSTICAS AGREGADAS--");
                    }else if(v==false){
                        Caracteristicas c4=new Caracteristicas(idUs,bio,trabajo,formacion,ciudad,estatura,alcohol,deporte,tabaco,hijos,fotos);
                        caracteristicasDao.actualizar(c4);
                        System.out.println("\n--PERFIL ACTUALIZADO--\n");
                        
                    }
    }
    
    //static Scanner ent = new Scanner(System.in);
    //static PremiumDao premiumDao= new PremiumDao();
    public static void altaBaja(int idUs){
//        DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("d/MM/yyyy");
//        String d="1/02/2022";
        LocalDate fechaAlta=LocalDate.now();
        LocalDate fechaBaja=fechaAlta.plusMonths(1);
        //pasar de formato LocalDate a Date
        Date date1 = java.sql.Date.valueOf(fechaAlta);
        Date date2 = java.sql.Date.valueOf(fechaBaja);
        
        try {
            //si esta vacia la lista:
            if(premiumDao.seleccionar().isEmpty()){
                System.out.println("Quiere darse de alta como usuario premium: YES/NO");
                    String res1=ent.nextLine();
                            if(res1.compareToIgnoreCase("Yes")==0){
                                Premium p5=new Premium(idUs,date1,date2,14.99);
                                premiumDao.insertar(p5);
                                System.out.println("FELICIDADES AHORA GOZA DE TODAS LAS PRESTACIONES DE SER PREMIUM");
                            }else if(res1.compareToIgnoreCase("No")==0){
                            
                            }
                            return;
            }else{
                //for para encontrar un usuario en concreto
                for (int i = 0; i < premiumDao.seleccionar().size(); i++) {
                    //ya existe una alta para ese idUs:
                    if(premiumDao.seleccionar().get(i).getIdUsuario()==idUs){
                        System.out.println("Quiere darse de baja como usuario premium: YES/NO");
                        String res2=ent.nextLine();
                            if(res2.compareToIgnoreCase("Yes")==0){
                                Premium p5=new Premium(idUs);
                                premiumDao.borrar(p5);
                                System.out.println("SE COMPLETÓ LA BAJA COMO PREMIUM");
                            }else if(res2.compareToIgnoreCase("No")==0){
                            
                            }
                            return;
                    }
                }
                //no esta dado de alta con ese id:
                System.out.println("Quiere darse de alta como usuario premium: YES/NO");
                    String res3=ent.nextLine();
                            if(res3.compareToIgnoreCase("Yes")==0){
                                Premium p5=new Premium(idUs,date1,date2,14.99);
                                premiumDao.insertar(p5);
                                System.out.println("FELICIDADES AHORA GOZA DE TODAS LAS PRESTACIONES DE SER PREMIUM");
                            }else if(res3.compareToIgnoreCase("No")==0){
                            
                            }
                            return;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Premium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void eliminarUs(int idUs){
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
