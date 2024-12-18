/**
 * Ruben Bernal Ramos, CSI1
 */

package controladores;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Clase controladora de la aplicacion
 * rbr - 181224
 */
public class Inicio {

	/**
	 * Metodo de entrada de la aplicacion
	 * rbr - 181224
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Variables
		LocalDateTime fecha;
		LocalDateTime fechaActual = LocalDateTime.now();
		String fechaComoTexto;
		Scanner sc = new Scanner(System.in);
		
		//Solicito al usuario la fecha y hora del evento
		System.out.println("Introduzca la fecha y hora del evento en formato (yyyy-MM-dd HH:mm):");
		fechaComoTexto = sc.next();
		
		//Convierto el string en un formato de fecha y hora
		fecha = LocalDateTime.parse(fechaComoTexto);
		
		//Valido si la fecha y hora del evento son futuras o pasadas
		boolean esAntes = fecha.isBefore(fechaActual);
		boolean esDespues = fecha.isAfter(fechaActual);
		boolean esIgual = fecha.isEqual(fechaActual);
		
		if(esAntes) {
			System.err.println("El evento no puede ser anterior a la fecha actual...");
		}else if(esDespues) {
			//Al ser un evento futuro, calculo cuanto queda para que llegue el momento del evento
			Duration duracion = Duration.between(fechaActual, fecha);
			System.out.println("Quedan: " + duracion.toDays() + " dias, " + duracion.toHours() + " horas y " + duracion.toMinutes() + " minutos.");
		}else {
			System.out.println("El evento esta teniendo lugar en estos momentos!!");
		}

	}

}
