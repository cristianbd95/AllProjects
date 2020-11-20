package hilo6;

public class CajeraRunnable implements Runnable {

	private Cliente cliente;

        public CajeraRunnable(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
           String campo1,campo2,campo3,campo4;
           campo1 = "CAJERA" + " " + Thread.currentThread().getName() + " ";
           campo2 = "ATIENDE AL CLIENTE" + " " + this.cliente.getNumeroCliente() + ". ";
           System.out.print(campo1 + campo2);
           this.cliente.hacerMovimiento(this.cliente.getCuenta(), this.cliente.getCantidad());
           campo3 = "CLIENTE" + " " + this.cliente.getNumeroCliente() + " " 
                                    + this.cliente.getTexto() + " " 
                                    + this.cliente.getCantidad() + "€. ";
           campo4 = "SALDO NUEVO EN CUENTA" + " " + this.cliente.getCuenta().getSaldo() + "€";
           System.out.println(campo3 + campo4);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}