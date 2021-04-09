import java.io.File;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.FilenameFilter;

public class TeoriaFilePlantilla {
    public static void main(String[] args) {
        // 1. LA CLASE File
        // Vamos a empezar creando un objeto File en el directorio de trabajo actual
        // Para ello, creamos una instancia de File y le pasamos un String con la ruta al fichero (absoluta o relativa)

        String raiz = "../ficheros/listado.txt";

        File fichero = new File(raiz);

        String raizd = "../ficheros/Quevedo/DAW";
        File directorio =  new File(raizd);
        // /Users/bryanrodriguezrios/IdeaProjects


        // Métodos básicos: la API de File
        //https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/io/File.html
        // boolean exists()
        System.out.println("****La API de File, metodos basicos**+* ");

        System.out.println("Exite: " + fichero.exists());
        System.out.println("Directori, Exite: " + directorio.exists());
        // String getName()
        // String getParent()
        System.out.println("Fichero");
        System.out.println("Nombre: "+ fichero.getName());
        System.out.println("Directorio padre: " + fichero.getParent());

        System.out.println("Directorio");
        System.out.println("Nombre: "+ directorio.getName());
        System.out.println("Directorio padre: " + directorio.getParent());

        // boolean isDirectory() --> si es true podemos utilizar list()
        // boolean isFile()

        System.out.println("¿es directorio? " + fichero.isDirectory());
        System.out.println("Directorio: ¿es directorio? " + directorio.isDirectory());
        if (directorio.isDirectory()){
            String[] lista = directorio.list();
            System.out.println("Listado: ");
            for (String elemento: lista) {
                System.out.println("    * " + elemento);
            }
        }

        System.out.println("¿es fichero? "+fichero.isFile());
        // long lastModified() --> ojo, devuelve un long; para "entenderlo" hay que combinarlo con Date

        System.out.println("Ultima modificación: "+
                directorio.lastModified());
        long ms = directorio.lastModified();


        Date d = new Date(ms);
        System.out.println(d);
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        String dia, mes, annio, hora, minuto, segundo;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));
        hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        minuto = Integer.toString(c.get(Calendar.MINUTE));
        segundo = Integer.toString(c.get(Calendar.SECOND));

        System.out.println (hora + ":" + minuto + ":" + segundo + " " + dia + "/" + mes +"/" + annio);


        // canRead(), canWrite(), canExecute()
        System.out.println("Permiso de lectura: " + directorio.canRead());

        System.out.println("Permiso de escritura: " + directorio.canWrite());
        System.out.println("Permiso de ejecucion: " + directorio.canExecute());

    }





}
