import java.util.*;
import java.util.stream.Collectors;

public class EjercicioSeccion3 {

    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        // Esto es para obtener un sublistado con las películas estrenadas en el siglo XXI
        List<Pelicula> peliculasSiglo21 = peliculas.stream()
                .filter(pelicula -> pelicula.getEstreno() >= 2000)
                .collect(Collectors.toList());
        System.out.println("Películas estrenadas en el siglo XXI:");
        peliculasSiglo21.forEach(System.out::println);

        // Esto es para mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg
        String titulosSpielberg = peliculas.stream()
                .filter(pelicula -> pelicula.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", "));
        System.out.println("\nTítulos de películas de Steven Spielberg: " + titulosSpielberg);

        // Esto es para obtener un sublistado con los nombres de las películas, ordenados alfabéticamente
        List<String> titulosOrdenados = peliculas.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\nTítulos de películas ordenados alfabéticamente:");
        titulosOrdenados.forEach(System.out::println);

        // Esto es para mostrar por pantalla el año de estreno más reciente
        int estrenoMasReciente = peliculas.stream()
                .mapToInt(Pelicula::getEstreno)
                .max()
                .orElse(-1);
        System.out.println("\nAño de estreno más reciente: " + estrenoMasReciente);
    }
}
