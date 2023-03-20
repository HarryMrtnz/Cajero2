package logica;

import javax.swing.JOptionPane;

public class Cliente extends Persona {

	private String cuenta;
	private String pin;
	private double saldo;
	private Movimiento mov;


	public Cliente(String nombre, String apellido, String cuenta, String pin, double saldo) {
		super(nombre, apellido);
		this.cuenta = cuenta;
		this.pin = pin;
		this.saldo = saldo;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Movimiento getMov() {
		return mov;
	}

	public void setMov(Movimiento mov) {
		this.mov = mov;
	}

	@Override
	public String toString() {
		return "Cliente [cuenta=" + cuenta + ", pin=" + pin + ", saldo=" + saldo +", getNombre()="
				+ getNombre() + ", getApellido()=" + getApellido() + "]";
	}
	
	
	@Override
	public boolean login(String pin) { //  jose: Cuenta = 4444 pin = 1234
		
		//This hace referencia al usuario que utiliza esta funcion
		if (pin.equals(this.getPin())) {
			
			return true;
			
		}else {
			
			return false;
		}
		
	}
	
	public String retirarDinero(Cajero cajero, int monto) {

		if (this.getSaldo() >= monto) { //Si tengo saldo en la cuenta
			
			if (cajero.getSaldoCajero() >= monto) { //Si hay dinero en el cajero
				this.setSaldo(this.getSaldo() - monto);
				cajero.setSaldoCajero(cajero.getSaldoCajero() - monto);
				return "Retiro exitoso, desconto de la cuenta " + monto 
						+ "\n El saldo restante es: " + this.getSaldo();
			}else {
				return "No hay saldo en el cajero";
			}
		} else {
			return "No hay saldo suficiente en la cuenta";
		}
	}
	
	public boolean cambiarPin() {
		
		String nuevoPin = JOptionPane.showInputDialog("Porfa ingrese su nuevo pin"
				+ "\n→ Asegurese de no repetir su pin, "
				+ "\nsi no pa q lo vas a cambiar? ¬¬");
		if (nuevoPin.equals(this.getPin())) {
			return false;
		}
		this.setPin(nuevoPin);

		//System.out.println("la calve ha sido cambiada por "+this.getPin());
		return true;
	}

}
