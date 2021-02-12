import java.util.*;

public class Menu {
	public static void main(String[] args) {
		Pacientes listaPacientes = new Pacientes();
		Medicos listaMedicos = new Medicos();
		PacientesNoAtendidos listaPacNoAtendidos = new PacientesNoAtendidos();

		// NO SE COMO HACER LO DEL 5.1, .2, ETC
		int opcion = 0;
		/*
		 * Inserta manualmente pacientes y médicos y comprueba que se ejecuta
		 * adecuadamente la funcionalidad que acabas de implementar y que se listan
		 * adecuadamente por pantalla.
		 */
		/* -- Lista de médicos -- */
		Medico m1 = new Medico("16878787J", "Victor", "Jimenez", "Dermatología");
		Medico m2 = new Medico("16784512H", "Sheila", "Martinez", "Oftalmología");
		// Creo un Arraylist donde voy a almacenar los médicos que he definido antes.
		listaMedicos.añadirMedico(m1);
		listaMedicos.añadirMedico(m2);

		/* -- Lista de Pacientes -- */
		Paciente p1 = new Paciente("17499666R", "12356789901R", "Juan", "Saldaña", 667765558, "Dermatología");
		Paciente p2 = new Paciente("17499667R", "12356789901R", "Javier", "Saldaña", 667765558, "Dolor de cabeza");
		// Creo un Arraylist donde voy a almacenar los pacientes que he definido antes.
		listaPacientes.añadirPacientes(p1);
		listaPacientes.añadirPacientes(p2);

		/* __Opciones de menú__ */
		do {
			System.out.println(
					"1. Dar de alta un paciente.\n" + "2. Dar de alta un medico.\n" + "3. Modificar paciente.\n"
							+ "4. Modificar medico.\n" + "5.1. Listar todos los pacientes atendidos.\n"
							+ "5.2. Listar pacientes atendidos por un médico.\n" + "5.3. Listar pacientes en espera.\n"
							+ "5.4. Listar pacientes que no han podido ser atendidos.\n" + "6. Listar medicos.\n"
							+ "7. Dar de baja un médico.\n" + "8. Atender un paciente.\n"
							+ "Elija una opción (0 para salir)\n");
			opcion = Teclado.leeEntero();

			switch (opcion) {
			// declaración case
			// los valores deben ser del mismo tipo de la expresión

			// 1. Dar de alta un paciente****
			case 1:
				System.out.print("Introduce el nombre: ");
				String nombrePaciente = Teclado.leeCadena();
				System.out.print("Introduce el apellido: ");
				String apellidoPaciente = Teclado.leeCadena();
				System.out.print("Intruce el DNI: ");
				String DNIPaciente = Teclado.leeCadena();
				System.out.print("Introduce el NSS: ");
				String NSSPaciente = Teclado.leeCadena();
				System.out.print("Introduce el teléfono: ");
				int telefonoPaciente = Teclado.leeEntero();
				System.out.print("Introduce la dolencia: ");
				String dolenciaPaciente = Teclado.leeCadena();

				Paciente p = new Paciente(DNIPaciente, NSSPaciente, nombrePaciente, apellidoPaciente, telefonoPaciente,
						dolenciaPaciente);
				listaPacientes.añadirPacientes(p);
				break; // break es opcional
			// 2. Dar de alta un medico****
			case 2:
				System.out.print("Introduce el DNI: ");
				String DNIMedico = Teclado.leeCadena();
				System.out.print("Introduce el nombre: ");
				String nombreMedico = Teclado.leeCadena();
				System.out.print("Introduce el apellido: ");
				String apellidoMedico = Teclado.leeCadena();
				System.out.print("Introduce la especialidad: ");
				String especialidadMedico = Teclado.leeCadena();

				Medico m = new Medico(DNIMedico, nombreMedico, apellidoMedico, especialidadMedico);
				listaMedicos.añadirMedico(m);

				break;
			// 3. Modificar paciente por DNI****
			case 3: {
				System.out.println("Introduce de DNI del paciente a modificar:");
				String busquedaDNIPaciente = Teclado.leeCadena();
				Paciente p11;
				p11 = listaPacientes.getListaPacientes().get(listaPacientes.buscarPorDNI(busquedaDNIPaciente));
				System.out.println("Datos actuales del paciente:");
				System.out.println(p11.toString());
				// --Nombre
				System.out.println("Introduce el nuevo nombre:");
				String nuevoNombrePaciente = Teclado.leeCadena();
				p11.setNombre(nuevoNombrePaciente);
				// --Apellido
				System.out.println("Introduce el nuevo apellido:");
				String nuevoApellidoPaciente = Teclado.leeCadena();
				p11.setApellido(nuevoApellidoPaciente);
				// --Teléfono
				System.out.println("Introduce el nuevo teléfono si tiene:");
				int nuevoTelefonoPaciente = Teclado.leeEntero();
				p11.setTelefono(nuevoTelefonoPaciente);
				// --Dolencia
				System.out.println("Introduce la nueva dolencia:");
				String nuevaDolenciaPaciente = Teclado.leeCadena();
				p11.setDolencia(nuevaDolenciaPaciente);
			}
				break;
			// 4. Modificar médico por DNI****
			case 4:
				System.out.println("Introduce el DNI del médico a modificar:");
				String busquedaDNIMedico = Teclado.leeCadena();
				if (listaMedicos.buscarMedicoPorDNI(busquedaDNIMedico)) {
					Medico medicoCoincidente = listaMedicos.mostrarMedicoCoincidenteConDNI(busquedaDNIMedico);
					System.out.println(medicoCoincidente.toString());
					listaMedicos.borrarMedicoDNI(busquedaDNIMedico);

					System.out.println("Introduce el nuevo nombre:");
					nombreMedico = Teclado.leeCadena();
					System.out.println("Introduce el apellido:");
					apellidoMedico = Teclado.leeCadena();

					System.out.println("Introduce la especialidad:");
					especialidadMedico = Teclado.leeCadena();

					Medico mModi = new Medico(busquedaDNIMedico, nombreMedico, apellidoMedico, especialidadMedico);
					listaMedicos.añadirMedico(mModi);

					System.out.println("El médico se ha modificado satisfactoriamente.");
				} else {
					System.err.println("El DNI introducido no es válido.");
				}
				break;
			// 5. Listar Pacientes****
			case 5:
				int opcionMenu5 = 0;
				System.out.println("Elige una opción:\n" + "  1. Listar todos los pacientes atendidos.\n"
						+ "  2. Listar pacientes atendidos por un médico.\n" + "  3. Listar pacientes en espera.\n"
						+ "  4. Listar pacientes que no han podido ser atendidos.");
				opcionMenu5 = Teclado.leeEntero();
				switch (opcionMenu5) {
				case 1: {
					// Cada vez que se atiende un paciente, este se borra
					// Medico.getPacientesAtendidos();
					listaMedicos.listaPacientesDeMedicos();
				}
					break;
				// Listar pacientes atendidos por un medico
				case 2: {
					System.out.println("Intruce el dni del médico:");
					String dniMedico = Teclado.leeCadena();

					Medico medicoCoincidente = listaMedicos.mostrarMedicoCoincidenteConDNI(dniMedico);
					System.out.println("Médico: ");
					System.out.println(medicoCoincidente.toString());
					System.out.println("Pacientes: ");
					medicoCoincidente.listarSusPacientes();
					// listaMedicos.;
					break;
				}
				// Listar pacientes en espera
				case 3: {
					listaPacientes.listaPacientes();
					break;
				}
				case 4: {
					System.out.println(listaPacNoAtendidos);
					break;
				}
				default:
					System.err.println("No has especificado ningun numero.");
				}
				break;
			// 6. Listar médicos
			case 6:
				listaMedicos.listaMedicos();
				break;
			// 1. Dar de alta un paciente
			case 7:
				System.out.println("Introduce el DNI del médico a borrar:");
				String dNImedBorrar1 = Teclado.leeCadena();

				if (listaMedicos.buscarMedicoPorDNI(dNImedBorrar1)) {
					listaMedicos.borrarMedicoDNI(dNImedBorrar1);
					System.out.println("El médico se ha borrado satisfactoriamente.");
				} else {
					System.out.println("El DNI introducido no es válido.");
				}
				break;
			// 8. Atender paciente
			case 8:
				Paciente pAtender = listaPacientes.primerPaciente();
				if (listaMedicos.hayMedicosDisponibles(pAtender.getDolencia())) {
					listaMedicos.atenderPaciente(pAtender);
				} else {
					listaPacNoAtendidos.añadirPacienteNoAtendido(pAtender);
					System.err.println("El paciente no puede ser atendido");
				}
				listaPacientes.eliminaPrimerPaciente();
				break;
			// 9. Especialidades de nuestro hospital [Info]
			case 9:
				System.out.println("Especialidades disponibles: ");
				for (int i = 0; i < Medico.listaEspecialidades.size(); i++) {
					String especialidad = Medico.listaEspecialidades.get(i);
					if (listaMedicos.hayMedicosDisponibles(especialidad)) {
						System.out.println(especialidad + ":");
					}
					listaMedicos.mostrarMedicoPorEspecialidad(especialidad);
				}
				System.out.println("Especialidades no disponibles: ");
				for (int i = 0; i < Medico.listaEspecialidades.size(); i++) {
					String especialidad = Medico.listaEspecialidades.get(i);
					if (!listaMedicos.hayMedicosDisponibles(especialidad)) {
						System.out.println(especialidad);
					}
				}
				break;
			// 10. Atender paciente
			case 10:
				break;
			default:
				break;
			}

		} while (opcion != 0);
	}

	public static void ListaPacientes(ArrayList<Paciente> listaPacientes) {
		for (int i = 0; i < listaPacientes.size(); i++) {
			System.out.println(listaPacientes.get(i).toString());
		}
	}

	public static void ListaMedicos(ArrayList<Medico> listaMedicos) {
		for (int i = 0; i < listaMedicos.size(); i++) {
			System.out.println(listaMedicos.get(i).toString());
		}
	}
}
