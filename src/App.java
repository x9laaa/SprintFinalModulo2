import java.time.LocalDate;

import sprint.Profesional;

public class App {
    public static void main(String[] args) throws Exception {
        Profesional a = new Profesional(1234, "a", "u", LocalDate.of(1994, 1, 13), "aa", "1994-10-11");
        System.out.println(a.toString());
    }
}
