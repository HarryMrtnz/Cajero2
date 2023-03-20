package logica;

import java.util.LinkedList;

public class Movimiento {

	int id  = 1;
	String mensaje = "";
	public Movimiento(int id, String mensaje) {
		super();
		this.id = id;
		this.mensaje = mensaje;
	}

	public int getID() {
		return id;
	}
	public void setId(int cont) {
		this.id = cont;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	@Override
	public String toString() {
		return "Movimiento [cont=" + id + ", mensaje=" + mensaje + "]";
		
	}
	
	public String mostrarMovimientos(LinkedList<Movimiento> movimientos) {
		String mensaje = "";
		if (movimientos.isEmpty()) {
			this.setMensaje("No se han registrado movimientos che :c");
			
			
		} else {
			for (Movimiento mov: movimientos) {

				mensaje = mov.getID() +" " +mov.getMensaje();
			}
		}
		return mensaje;
	}
	
	
	
	

}
