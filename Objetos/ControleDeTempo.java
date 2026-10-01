package Objetos;

import java.time.LocalDate;

public class ControleDeTempo {

    private static LocalDate dia = LocalDate.now();

    public static void passarUmDia() {
        dia = dia.plusDays(1);
    }

    public static LocalDate getDia() {
        return dia;
    }

}