import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcularEdad {
    static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
        Date fechaAct = new Date();
        Date fechaNac;
        Scanner s = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Ingrese la fecha de nacimiento (dd/mm/aaaa)");
            fechaNac = format.parse(s.nextLine());
            long diferenciaMilis = fechaAct.getTime() - fechaNac.getTime();
            long edad;
            edad = (long) (diferenciaMilis / (1000 * 60 * 60 * 24 * 365.25));
            System.out.println("La edad es: " + edad + " años.");
        } catch (ParseException e) {
            System.out.println("Formato de fecha invalido");
            throw new RuntimeException(e);
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            System.out.println("Utilizando la clase time");
            System.out.println("Ingrese la fecha de nacimiento (dd/mm/aaaa)");
            String fechaNac2 = s.nextLine();
            LocalDate fechadeNac = LocalDate.parse(fechaNac2, formato);
            LocalDate fechaActual = LocalDate.now();
            Period periodo = Period.between(fechadeNac, fechaActual);
            int edad1 = periodo.getYears();
            System.out.println("La edad es: " + edad1 + " años.");
        }catch (DateTimeParseException e) {
          System.out.println("Formato de fecha incorrecto.");
        }
    }
}
