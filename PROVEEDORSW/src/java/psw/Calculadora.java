package psw;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Calculadora")
public class Calculadora {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "calculadora")
    public double calculadora(@WebParam(name = "numero1") double numero1, @WebParam(name = "numero2") double numero2, @WebParam(name = "operacion") int operacion) {
        double resultado;

        switch (operacion) {
            case 1:
                resultado = numero1 + numero2;
                break;
            case 2:
                resultado = numero1 - numero2;
                break;
            case 3:
                resultado = numero1 * numero2;
                break;
            case 4:
                resultado = numero1 / numero2;
                break;
            default:
                resultado = 0;
        }

        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public List<Transaccion> operation() {
        File f1 = new File("C:\\Users\\Campus FP\\Documents\\NetBeansProjects\\PROVEEDORSW\\src\\java\\psw\\inmobiliaria.csv");
        String rutaAbsolutaArchivo = f1.getAbsolutePath();
        System.out.println("Ruta del archivo : " + rutaAbsolutaArchivo);

        String registro;

        int referencia;
        String fechaAlta;
        String tipo;
        String operacion;
        String provincia;
        int superficie;
        int precioVenta;
        String fechaVenta;
        String vendedor;

        String[] parte;
        List<Transaccion> transacciones_al = new ArrayList<Transaccion>();

        File f;
        FileReader fr = null;
        BufferedReader br;

        try {
            f = new File(rutaAbsolutaArchivo);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                parte = registro.split(";");
                referencia = Integer.parseInt(parte[0].trim());
                fechaAlta = parte[1].trim();
                tipo = parte[2].trim();
                operacion = parte[3].trim();
                provincia = parte[4].trim();
                superficie = Integer.parseInt(parte[5].trim());
                precioVenta = Integer.parseInt(parte[6].trim());
                fechaVenta = parte[7].trim();
                vendedor = parte[8].trim();

                Transaccion transaccion = new Transaccion(referencia, fechaAlta, tipo, operacion, provincia, superficie, precioVenta, fechaVenta, vendedor);
                System.out.println(transaccion);
                transacciones_al.add(transaccion);
            }
            return transacciones_al;
        } catch (IOException e) {
            return null;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                return null;
            }
        }
    }

}
