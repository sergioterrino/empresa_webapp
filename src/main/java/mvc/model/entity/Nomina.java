package mvc.model.entity;

public class Nomina {
	/**
	 * Array que almacena los sueldos base por categoría.
	 */
	private static final int SUELDO_BASE[] = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000 };

	/**
	 * Calcula el sueldo de un empleado en función de su categoría y años de servicio.
	 *
	 * @param emp El empleado del que se calcula el sueldo.
	 * @return El sueldo calculado del empleado.
	 */
	public int sueldo(Empleado emp) {
//		int sueldo = (50000 + (emp.getCategoria() -1)*20000);
		int sueldo = SUELDO_BASE[emp.getCategoria() - 1] + 5000 * emp.getAnyos();
		return sueldo;
	}
}
