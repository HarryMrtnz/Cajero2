package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Empleado;
import logica.Movimiento;
import logica.Cajero;
import logica.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Cliente jose = new Cliente("jose", "alvarez", "4444", "1234", 2000);
		Movimiento mov = null;
		LinkedList <Movimiento> movimientos = new LinkedList(); 
		menu(jose, mov, movimientos);
		
	}
	
	public static void menu(Cliente jose, Movimiento mov, LinkedList<Movimiento> movimientos) {
		int opcion;

		//  		Cuenta = 4444 pin = 1234
		Cajero cajero = new Cajero(5000);
		Empleado yo = new Empleado("Caja");
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog(
				"Elija su perfil para ingresar en el cajero: " 
						+ "\n 1- Cliente " 
						+ "\n 2- Empleado " 
						+ "\n 3- Salir"));

		switch (opcion) {
		case 1:// Ingreso como cliente
			String pin;
			int i = 0;
			do {
				pin = JOptionPane.showInputDialog("Ingrese el pin de la cuenta");
				if (jose.login(pin)) {
					JOptionPane.showMessageDialog(null, "Clave correcta");
					int opcionCuenta;
					
					do {
						opcionCuenta = Integer.parseInt(
							JOptionPane.showInputDialog("Bienvenido : " + jose.getNombre() + " que desea realizar: "
									+ "\n 1- Retirar dinero " 
									+ "\n 2- Cambiar Pin " 
									+ "\n 3- Ultimos movimientos "
									+ "\n 0- Salir"));
						switch (opcionCuenta) {
						case 1:
							int monto;
							monto = Integer.parseInt(JOptionPane.showInputDialog(""
									+ "\nSu saldo actual es: " +jose.getSaldo() 
									+ "\nIngrese el monto a retirar: "));
							JOptionPane.showMessageDialog(null, jose.retirarDinero(cajero, monto));
							mov.setMensaje("Se retiro $"+monto);
							mov = new Movimiento(mov.getID(), mov.getMensaje());
							movimientos.add(mov);
							mov.setId(mov.getID()+1);
							
							if(jose.retirarDinero(cajero, monto).equals("No hay saldo en el cajero")) {
								JOptionPane.showMessageDialog(null, "No hay saldo en el cajero");
								
							}else if(jose.retirarDinero(cajero, monto).equals("No hay saldo suficiente en la cuenta")){
								monto = Integer.parseInt(JOptionPane.showInputDialog(""
										+ "\nSu saldo actual es: " +jose.getSaldo() 
										+ "\nIngrese el monto a retirar: "));
								JOptionPane.showMessageDialog(null, jose.retirarDinero(cajero, monto));
							}
							break;
						case 2:
							String pinActual;
							do {
								pinActual = JOptionPane.showInputDialog(null, "Porfa, inserte su pin actual");
								
								if (pinActual.equals(jose.getPin())) {
									if (jose.cambiarPin() ) {
										JOptionPane.showMessageDialog(null, "Pin cambiado exitosamente"
												+ "\nVuelve a iniciar sesion porfa!");
										mov.setMensaje("Cambiaste tu pin");
										mov = new Movimiento(mov.getID(), mov.getMensaje());
										movimientos.add(mov);
										mov.setId(mov.getID()+1);
										
										menu(jose, mov, movimientos);
									}else {
										JOptionPane.showMessageDialog(null, "No puedes repetir el pin. Vuelve a intentarlo");

									}
								}else {
									JOptionPane.showMessageDialog(null, "Pin incorrecto");
									
								}
							} while (!pinActual.equals(jose.getPin()));	
							break;
								
						case 3:
							
							System.out.println(jose.getMov());
							break;
						case 0 : 
							JOptionPane.showMessageDialog(null, "Chau papu");
							break ;
							
						default:
							menu(jose, mov, movimientos);
						
						}
					
					}while(opcionCuenta!=0);
					// Ingresar cuenta
				} else {
					JOptionPane.showMessageDialog(null, "Clave incorrecta");
				}
				i++;
			} while (!jose.login(pin) && i <= 5);

			break;
		case 2:// Ingreso como cliente

			break;

		default:
			break;
		}

//		JOptionPane.showMessageDialog(null, jose.retirarDinero(cajero, 1000));
//		JOptionPane.showMessageDialog(null, jose.retirarDinero(cajero, 1000));
//		JOptionPane.showMessageDialog(null, cajero.getSaldoCajero());

	}

}
