package misrcPostgres;

import java.io.*; 

public class Entrada {
	
   static InputStream flujo = System.in;
   static DataInputStream flujo_ent = new DataInputStream(flujo);
   static char    caracter;
   static String  cadena;
   static int     enteroCorto;
   static long    enteroLargo;
   static short   enteroShort;
   static byte    enteroByte;
   static float   realCorto;
   static double  realLargo;

   //*** METODO ENTRADA POR CONSOLA DE UN int ***

   public static int readInt() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN int
            enteroCorto = Integer.parseInt(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return enteroCorto;
   }
   
   //*** METODO ENTRADA POR CONSOLA DE UN long ***

   public static long readLon() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN long
            enteroLargo = Long.parseLong(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return enteroLargo;
   }
  
   //*** METODO ENTRADA POR CONSOLA DE UN short ***

   public static short readSho() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN short
            enteroShort = Short.parseShort(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return enteroShort;
   }

   //*** METODO ENTRADA POR CONSOLA DE UN byte ***

   public static byte readByt() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN byte
            enteroByte = Byte.parseByte(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return enteroByte;
   }
   //*** METODO ENTRADA POR CONSOLA DE UN float ***

   public static float readFlo() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN float
            realCorto = Float.parseFloat(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return realCorto;
   }
   
   //*** METODO ENTRADA POR CONSOLA DE UN double ***

   public static double readDou() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            //METODO QUE TRANFORMA UNA CADENA EN UN double
            realLargo = Double.parseDouble(cadena);
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return realLargo;
   }

   //*** METODO ENTRADA POR CONSOLA DE UN String ***

   public static String readStr() {
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return cadena;
   }
   
   //*** METODO ENTRADA POR CONSOLA DE UN char ***
   
    public static char readCha() {
      char c[] = new char[1];
      try {
            //METODO PARA LEER DESDE EL TECLADO UNA CADENA
            cadena = flujo_ent.readLine();
            c = cadena.toCharArray();
            caracter = c[0];
      }
      catch(IOException e) {
        System.out.println("ERROR DE ENTRADA:"+e);
      }
      return caracter;
    } 
}