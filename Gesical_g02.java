package gesical_g02;

import java.util.Scanner;
import java.util.*;

public class Gesical_g02 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Solista> solistas = new ArrayList<>();
        ArrayList<Banda> bandas = new ArrayList<>();
        HashSet<Cancion> canciones = new HashSet<>();
        menuPrincipal(entrada);
        int opcion = entrada.nextInt();
        while (opcion != 9) {
            if (opcion == 1) {
                registrarSolista(entrada, solistas);
            } else if (opcion == 2) {
                registrarBanda(entrada, bandas);
            } else if (opcion == 3) {
                registrarCancion(entrada, canciones);
            } else if (opcion == 4) {
                registrarDisco(entrada, bandas, solistas);
            } else if (opcion == 5) {
                registroMasivo(bandas, solistas);
            } else if (opcion == 6) {
                entrada.nextLine();
                menuConsultas(entrada);
                String opcion2;
                opcion2 = entrada.nextLine();
                if (opcion2.equals("a")) {
                    consultaDisco(entrada, solistas, bandas);
                } else if (opcion2.equals("b")) {
                    consultaPlaylist(entrada, solistas, bandas);
                } else if (opcion2.equals("c")) {
                    borrarDiscos(entrada, solistas, bandas);
                } else if (opcion2.equals("d")) {
                    listarDiscos(entrada, solistas, bandas);                
                } else if (opcion2.equals("z")) {

                }
            }
            menuPrincipal(entrada);
            System.out.println();
            opcion = entrada.nextInt();

        }

    }

    private static void menuPrincipal(Scanner entrada) {
        System.out.println();
        System.out.println("Gesical - Sistema de GEStión MusICAL");
        System.out.println("Menú Principal");
        System.out.println("===============================");
        System.out.println("1) Registrar Solista");
        System.out.println("2) Registrar Banda");
        System.out.println("3) Registrar Canción");
        System.out.println("4) Registrar Disco");
        System.out.println("5) Registro Masivo - Datos de Prueba");
        System.out.println("6) Consultas");
        System.out.println();
        System.out.println("9.- Cerrar la aplicación");
        System.out.println();
        System.out.println("Ingrese una opción:");

    }

    private static void menuConsultas(Scanner entrada) {
        System.out.println();
        System.out.println("Gesical - Sistema de GEStión MusICAL");
        System.out.println("Consultas");
        System.out.println("===============================");
        System.out.println("a) Discos que duran más de X segundos");
        System.out.println("b) Playlist por género musical");
        System.out.println("c) Borrar discos según año de edición");
        System.out.println("d) Listar discos por banda");
        System.out.println();
        System.out.println("z) Volver al menú anterior");
        System.out.println();
        System.out.println("Ingrese una opción:");

    }

    private static void registrarSolista(Scanner entrada, ArrayList solistas) {
        ArrayList<Disco> discosSolista = new ArrayList<>();
        entrada.nextLine();
        Solista solista = new Solista("", "", "", true, null, null, null, 0, null, null);
        System.out.println("Ingrese genero del solista");
        String genero;
        genero = entrada.nextLine();
        System.out.println("Ingrese año de lanzamiento del solista");
        int anioLanzamiento = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese discografica del solista");
        String discografica;
        discografica = entrada.nextLine();
        System.out.println("Ingrese nombre del solista");
        String nombre;
        nombre = entrada.nextLine();
        System.out.println("Ingrese apellido del solista");
        String apellido;
        apellido = entrada.nextLine();
        System.out.println("Ingrese nacionalidad del solista");
        String nacionalidad;
        nacionalidad = entrada.nextLine();
        System.out.println("¿Toca algun instrumento?");
        String respuesta;
        respuesta = entrada.nextLine();
        boolean x;
        if (respuesta.equals("si")) {
            System.out.println("¿Que instrumento?");
            String instrumento;
            instrumento = entrada.nextLine();
            x = true;
            if (instrumento.equals("guitarra")) {
                Guitarra guitarra = new Guitarra();
                solista = new Solista(nombre, apellido, nacionalidad, x, guitarra, false, genero, anioLanzamiento, discografica, discosSolista);
            } else if (instrumento.equals("bajo")) {
                Bajo bajo = new Bajo();
                solista = new Solista(nombre, apellido, nacionalidad, x, bajo, false, genero, anioLanzamiento, discografica, discosSolista);
            } else if (instrumento.equals("bateria")) {
                Bateria bateria = new Bateria();
                solista = new Solista(nombre, apellido, nacionalidad, x, bateria, false, genero, anioLanzamiento, discografica, discosSolista);
            } else if (instrumento.equals("teclado")) {
                Teclado teclado = new Teclado();
                solista = new Solista(nombre, apellido, nacionalidad, x, teclado, false, genero, anioLanzamiento, discografica, discosSolista);
            }
        } else {
            x = false;
            solista = new Solista(nombre, apellido, nacionalidad, x, null, true, genero, anioLanzamiento, discografica, discosSolista);
        }
        solistas.add(solista);

    }

    private static void registrarBanda(Scanner entrada, ArrayList bandas) {
        ArrayList<Solista> solistasBanda = new ArrayList<>();
        ArrayList<Disco> discosBanda = new ArrayList<>();
        entrada.nextLine();
        System.out.println("Ingrese genero de la banda");
        String genero;
        genero = entrada.nextLine();
        System.out.println("Ingrese año de lanzamiento de la banda");
        int anioLanzamiento = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese discografica de la banda");
        String discografica;
        discografica = entrada.nextLine();
        System.out.println("Ingrese titulo de la banda");
        String titulo;
        titulo = entrada.nextLine();
        System.out.println("Ingrese la cantidad de integrantes que tiene la banda");
        int cantidad = entrada.nextInt();
        entrada.nextLine();
        Banda banda = new Banda(titulo, solistasBanda, genero, anioLanzamiento, discografica, discosBanda);
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese genero del integrante N°" + (i + 1));
            String generoIntegrante;
            generoIntegrante = entrada.nextLine();
            System.out.println("Ingrese año de lanzamiento del integrante");
            int anioLanzamiento2 = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingrese discografica del integrante");
            String discografica2;
            discografica2 = entrada.nextLine();
            System.out.println("Ingrese nombre del integrante");
            String nombre;
            nombre = entrada.nextLine();
            System.out.println("Ingrese apellido del integrante");
            String apellido;
            apellido = entrada.nextLine();
            System.out.println("Ingrese nacionalidad del integrante");
            String nacionalidad;
            nacionalidad = entrada.nextLine();
            System.out.println("¿Toca algun instrumento?");
            String respuesta;
            respuesta = entrada.nextLine();
            boolean x;
            Solista solista = new Solista(nombre, apellido, nacionalidad, null, null, null, generoIntegrante, anioLanzamiento2, discografica2, discosBanda);
            if (respuesta.equals("si")) {
                System.out.println("¿Que instrumento?");
                String instrumento;
                instrumento = entrada.nextLine();
                x = true;
                if (instrumento.equals("guitarra")) {
                    Guitarra guitarra = new Guitarra();
                    solista = new Solista(nombre, apellido, nacionalidad, x, guitarra, false, genero, anioLanzamiento, discografica, discosBanda);
                    solista.setInstrumento(guitarra);
                    solista.setEsCantante(false);
                } else if (instrumento.equals("bajo")) {
                    Bajo bajo = new Bajo();
                    solista = new Solista(nombre, apellido, nacionalidad, x, bajo, false, genero, anioLanzamiento, discografica, discosBanda);
                    solista.setInstrumento(bajo);
                    solista.setEsCantante(false);
                } else if (instrumento.equals("bateria")) {
                    Bateria bateria = new Bateria();
                    solista = new Solista(nombre, apellido, nacionalidad, x, bateria, false, genero, anioLanzamiento, discografica, discosBanda);
                    solista.setInstrumento(bateria);
                    solista.setEsCantante(false);
                } else if (instrumento.equals("teclado")) {
                    Teclado teclado = new Teclado();
                    solista = new Solista(nombre, apellido, nacionalidad, x, teclado, false, genero, anioLanzamiento, discografica, discosBanda);
                    solista.setInstrumento(teclado);
                    solista.setEsCantante(false);
                }
            } else {
                x = false;
                solista = new Solista(nombre, apellido, nacionalidad, x, null, true, genero, anioLanzamiento, discografica, discosBanda);
                solista.setEsCantante(true);
            }

            banda.solistas.add(solista);
        }
        bandas.add(banda);
    }

    private static void registrarCancion(Scanner entrada, HashSet canciones) {
        System.out.println("Ingrese nombre de la cancion");
        String nombre;
        nombre = entrada.nextLine();
        System.out.println("Ingrese la duración de la cancion en segundos");
        int duracion = entrada.nextInt();
        Cancion cancion = new Cancion(nombre, duracion);
        canciones.add(cancion);

    }

    private static void registrarDisco(Scanner entrada, ArrayList bandas,ArrayList solistas) {
        ArrayList<Disco> discosBanda = new ArrayList<>();
        ArrayList<Disco> discosSolista = new ArrayList<>();
        entrada.nextLine();
        HashSet<Cancion> cancionesDisco = new HashSet<>();
        System.out.println("Ingrese el titulo del disco");
        String titulo;
        titulo = entrada.nextLine();
        System.out.println("Ingrese el año de salida del disco");
        int anio = entrada.nextInt();
        System.out.println("Ingrese la cantidad de canciones");
        int cantidad = entrada.nextInt();
        Disco disco = new Disco(anio, titulo, cancionesDisco);
        for (int i = 0; i < cantidad; i++) {
            entrada.nextLine();
            System.out.println("Ingrese nombre de la cancion N°" + (i + 1));
            String nombre;
            nombre = entrada.nextLine();
            System.out.println("Ingrese la duración de la cancion en segundos");
            int duracion = entrada.nextInt();
            Cancion cancion = new Cancion(nombre, duracion);          
            cancionesDisco.add(cancion);
            disco.setCanciones(cancionesDisco);
                      
        }
        System.out.println("Si el disco pertenece a un solista digite 1, si pertenece a una banda digite 2");
        int bandaSolista;
        bandaSolista = entrada.nextInt();
        if (bandaSolista == 1) {
            System.out.println("Ingrese el nombre del solista");
            entrada.nextLine();
            String nombreSolista;
            nombreSolista = entrada.nextLine();
            for (int i = 0; i < solistas.size(); i++) {
                Solista solista = (Solista) solistas.get(i);
                if (solista.getNombre().equals(nombreSolista)) {
                    solista.discos.add(disco);
                }
            }
        } else if (bandaSolista == 2) {
            System.out.println("Ingrese el titulo de la banda");
            entrada.nextLine();
            String nombreBanda;
            nombreBanda = entrada.nextLine();
            for (int i = 0; i < bandas.size(); i++) {
                Banda banda = (Banda) bandas.get(i);
                if (banda.getTitulo().equals(nombreBanda)) {
                    banda.discos.add(disco);
                }
            }
        }
    }

    private static void registroMasivo(ArrayList<Banda> bandas, ArrayList<Solista> solistas) {
        ArrayList<Disco> discosBanda1 = new ArrayList<>();
        ArrayList<Disco> discosBanda2 = new ArrayList<>();
        ArrayList<Disco> discosSolista1 = new ArrayList<>();
        ArrayList<Disco> discosSolista2 = new ArrayList<>();
        ArrayList<Disco> discosSolista3 = new ArrayList<>();
        ArrayList<Disco> discosSolista4 = new ArrayList<>();
        ArrayList<Disco> discosSolista5 = new ArrayList<>();
        ArrayList<Disco> discosSolista6 = new ArrayList<>();
        ArrayList<Disco> discosSolista7 = new ArrayList<>();
        ArrayList<Disco> discosSolista8 = new ArrayList<>();
        ArrayList<Disco> discosSolista9 = new ArrayList<>();
        ArrayList<Disco> discosSolista10 = new ArrayList<>();

        Guitarra guitarra = new Guitarra();
        Teclado teclado = new Teclado();
        Bateria bateria = new Bateria();
        Bajo bajo = new Bajo();

        Solista solista1 = new Solista("Rodrigo", "Bueno", "Argentino", false, null, true, "Cuarteto", 2010, "Magenta Discos", discosSolista1);
        solistas.add(solista1);
        Solista solista2 = new Solista("Sergio", "Torres", "Argentino", false, null, true, "Cumbia", 1995, "Leader Music", discosSolista2);
        solistas.add(solista2);
        Solista solista3 = new Solista("Mauro", "Lombardo", "Argentino", false, null, true, "Trap", 2013, "DALE PLAY Records", discosSolista3);
        solistas.add(solista3);
        Solista solista4 = new Solista("Cristian", "Falcon", "Colombiano", true, bajo, false, "Rap", 2020, "Urban Music", discosSolista4);
        solistas.add(solista4);
        Solista solista5 = new Solista("Enrique", "Iglesias", "Español", false, null, true, "Pop", 1995, "Fonovisa", discosSolista5);
        solistas.add(solista5);
        Solista solista6 = new Solista("Gustavo", "Cerati", "Argentino", false, null, true, "Rock", 1984, "Columbia Records", discosSolista6);
        solistas.add(solista6);
        Solista solista7 = new Solista("Soledad", "Pastorutti", "Argentina", true, bajo, false, "Musica tradicional", 1996, "Sony Music Latin", discosSolista7);
        solistas.add(solista7);
        Solista solista8 = new Solista("Paulo", "Londra", "Argentino", false, null, true, "Urbano latino", 2017, "Warner Music Latina", discosSolista8);
        solistas.add(solista8);
        Solista solista9 = new Solista("Fito", "Paez", "Argentino", true, guitarra, false, "Rock", 1984, "EMI-Odeón S.A.", discosSolista9);
        solistas.add(solista9);
        Solista solista10 = new Solista("Nahuel", "Pennisi", "Argentino", true, bajo, false, "Pop", 2015, " Sony Music Entertainment Argentina S.A.", discosSolista10);
        solistas.add(solista10);

        ArrayList<Solista> solistaBanda1 = new ArrayList<>();
        solistaBanda1.add(solista5);
        solistaBanda1.add(solista10);
        ArrayList<Solista> solistaBanda2 = new ArrayList<>();
        solistaBanda2.add(solista6);
        solistaBanda2.add(solista8);
        solistaBanda2.add(solista9);

        Banda banda1 = new Banda("RockNacional&Urban", solistaBanda2, "Rock", 2017, "Sony Music Latin", discosBanda1);
        Banda banda2 = new Banda("ElJunte", solistaBanda1, "Pop", 2020, "Warner Music", discosBanda2);

        HashSet<Cancion> cancionesSolista = new HashSet<>();
        Cancion cancionSolista1 = new Cancion("Tal vez", 170);
        cancionesSolista.add(cancionSolista1);
        Cancion cancionSolista2 = new Cancion("Nena maldicion", 185);
        cancionesSolista.add(cancionSolista2);
        Cancion cancionSolista3 = new Cancion("Homerun", 150);
        cancionesSolista.add(cancionSolista3);
        Cancion cancionSolista4 = new Cancion("Adan y eva", 165);
        cancionesSolista.add(cancionSolista4);
        Cancion cancionSolista5 = new Cancion("Chica paranormal", 180);
        cancionesSolista.add(cancionSolista5);
        Cancion cancionSolista6 = new Cancion("De música ligera", 200);
        cancionesSolista.add(cancionSolista6);
        Cancion cancionSolista7 = new Cancion("Prófugos", 209);
        cancionesSolista.add(cancionSolista7);
        Cancion cancionSolista8 = new Cancion("Persiana americana", 180);
        cancionesSolista.add(cancionSolista8);
        Cancion cancionSolista9 = new Cancion("Juegos de seducción", 192);
        cancionesSolista.add(cancionSolista9);
        Cancion cancionSolista10 = new Cancion("En la ciudad de la furia", 176);
        cancionesSolista.add(cancionSolista10);
        Cancion cancionSolista11 = new Cancion("Universo paralelo", 178);
        cancionesSolista.add(cancionSolista11);
        Cancion cancionSolista12 = new Cancion("La noche", 170);
        cancionesSolista.add(cancionSolista12);
        Cancion cancionSolista13 = new Cancion("Eres", 165);
        cancionesSolista.add(cancionSolista13);
        Cancion cancionSolista14 = new Cancion("Quien dijo", 192);
        cancionesSolista.add(cancionSolista14);
        Cancion cancionSolista15 = new Cancion("Mariposa tecknicolor", 200);
        cancionesSolista.add(cancionSolista15);
        Cancion cancionSolista16 = new Cancion("A rodar la vida", 185);
        cancionesSolista.add(cancionSolista16);
        Cancion cancionSolista17 = new Cancion("El amor despues del amor", 190);
        cancionesSolista.add(cancionSolista17);
        Cancion cancionSolista18 = new Cancion("Tráfico por katmandu", 155);
        cancionesSolista.add(cancionSolista18);
        Cancion cancionSolista19 = new Cancion("Tumbas de la gloria", 245);
        cancionesSolista.add(cancionSolista19);
        Cancion cancionSolista20 = new Cancion("Taquicardia", 210);
        cancionesSolista.add(cancionSolista20);

        Disco discoBanda1 = new Disco(2020, "MixArgentino1", cancionesSolista);
        banda1.discos.add(discoBanda1);
        bandas.add(banda1);
        bandas.add(banda2);

        ArrayList<Disco> coleccionDiscos3 = new ArrayList<>();

        HashSet<Cancion> cancionesSolista1 = new HashSet<>();
        Cancion cancionSolistaDisco1 = new Cancion("Pintao", 168);
        cancionesSolista1.add(cancionSolistaDisco1);
        Cancion cancionSolistaDisco2 = new Cancion("Luna", 201);
        cancionesSolista1.add(cancionSolistaDisco2);
        Cancion cancionSolistaDisco3 = new Cancion("Malbec", 176);
        cancionesSolista1.add(cancionSolistaDisco3);
        Disco discoSolista1 = new Disco(2021, "Desde el fin del mundo", cancionesSolista1);
        discosSolista3.add(discoSolista1);
        coleccionDiscos3.add(discoSolista1);

        HashSet<Cancion> cancionesSolista2 = new HashSet<>();
        Cancion cancionSolistaDisco4 = new Cancion("Lo mejor del amor", 194);
        cancionesSolista2.add(cancionSolistaDisco4);
        Cancion cancionSolistaDisco5 = new Cancion("La mano de dios", 199);
        cancionesSolista2.add(cancionSolistaDisco5);
        Cancion cancionSolistaDisco6 = new Cancion("Que ironia", 240);
        cancionesSolista2.add(cancionSolistaDisco6);
        Disco discoSolista2 = new Disco(2003, "RodrigoBueno", cancionesSolista2);
        discosSolista1.add(discoSolista2);
        coleccionDiscos3.add(discoSolista2);

        HashSet<Cancion> cancionesBanda3 = new HashSet<>();
        Cancion cancionBandaDisco1 = new Cancion("Mi celosa hermosa", 124);
        cancionesBanda3.add(cancionBandaDisco1);
        Cancion cancionBandaDisco2 = new Cancion("Vino tinto", 191);
        cancionesBanda3.add(cancionBandaDisco2);
        Cancion cancionBandaDisco3 = new Cancion("Nadie", 150);
        cancionesBanda3.add(cancionBandaDisco3);
        Disco discoBanda3 = new Disco(2010, "Inolvidable", cancionesBanda3);
        discosSolista2.add(discoBanda3);
        coleccionDiscos3.add(discoBanda3);

    }

    private static void consultaDisco(Scanner entrada, ArrayList solistas, ArrayList bandas) {
        ArrayList<Disco> discosBanda = new ArrayList<>();
        ArrayList<Disco> discosSolista = new ArrayList<>();
        Disco disco = new Disco(0, "", null);
        Solista solista = new Solista("", "", "", true, null, false, "", 0, "", discosSolista);
        Banda banda = new Banda("", null, "", 0, "", discosBanda);
        System.out.println("Ingrese una cantidad de segundos");
        int segundos = entrada.nextInt();
        int duracionTotal = 0;
        int duracionCancion = 0;
        Iterator<Solista> solistasIt2 = solistas.iterator();
        Iterator<Banda> bandasIt2 = bandas.iterator();
        while (solistasIt2.hasNext()) {
            solista = (Solista) solistasIt2.next();
            ArrayList<Disco> discosS = solista.discos;
            Iterator<Disco> discosSolistaIt = discosS.iterator();
            while (discosSolistaIt.hasNext()) {
                duracionTotal = 0;
                Disco disco2 = discosSolistaIt.next();
                HashSet<Cancion> cancionesS = disco2.canciones;
                Iterator<Cancion> cancionesSolistaIt = cancionesS.iterator();
                while (cancionesSolistaIt.hasNext()) {
                    Cancion cancion = cancionesSolistaIt.next();
                    duracionCancion = cancion.getDuracion();
                    duracionTotal = duracionTotal + duracionCancion;
                }
                if (duracionTotal > segundos) {
                    System.out.println("Nombre del disco: " + disco2.getTitulo() + " Autor: " + solista.getNombre());
                } else {
                    System.out.println("No se encontraron resultados");
                }
            }
        }

        while (bandasIt2.hasNext()) {
            banda = (Banda) bandasIt2.next();
            ArrayList<Disco> discosB = banda.discos;
            Iterator<Disco> discosBandaIt = discosB.iterator();
            while (discosBandaIt.hasNext()) {
                duracionTotal = 0;
                Disco disco2 = discosBandaIt.next();
                HashSet<Cancion> cancionesB = disco2.canciones;
                Iterator<Cancion> cancionesBandaIt = cancionesB.iterator();
                while (cancionesBandaIt.hasNext()) {
                    Cancion cancion = cancionesBandaIt.next();
                    duracionCancion = cancion.getDuracion();
                    duracionTotal = duracionTotal + duracionCancion;
                    
                }
                if (duracionTotal > segundos) {
                        System.out.println("Nombre del disco: " + disco2.getTitulo() + " Autores: " + banda.solistas.toString());
                    } else {
                        System.out.println("No se encontraron resultados");
                    }
            }
        }
    }

    private static void consultaPlaylist(Scanner entrada, ArrayList solistas, ArrayList bandas) {
        ArrayList<Disco> discosBanda = new ArrayList<>();
        ArrayList<Disco> discosSolista = new ArrayList<>();
        System.out.println("Ingrese genero musical");
        String genero;
        genero = entrada.nextLine();
        Solista solista = new Solista("", "", "", true, null, false, "", 0, "", discosSolista);
        Banda banda = new Banda("", null, "", 0, "", discosBanda);
        
        Iterator<Solista> solistasIt2 = solistas.iterator();
        Iterator<Banda> bandasIt2 = bandas.iterator();
        
        while (solistasIt2.hasNext()) {
            int i = 0;
            solista = (Solista) solistasIt2.next();
            if (solista.getGenero().equals(genero)){
                System.out.println("Solista: " + solista.getNombre());
                ArrayList<Disco> discosS = solista.discos;
                Iterator<Disco> discosSolistaIt = discosS.iterator();
            while (discosSolistaIt.hasNext()) {               
                Disco disco2 = discosSolistaIt.next();
                System.out.println("Titulo del disco: " + disco2.getTitulo());
                HashSet<Cancion> cancionesS = disco2.canciones;
                Iterator<Cancion> cancionesSolistaIt = cancionesS.iterator();
                while (cancionesSolistaIt.hasNext()) {
                    Cancion cancion = cancionesSolistaIt.next();
                    System.out.println("Cancion N° " + (i + 1) + ": " + cancion.getNombre());
                    i++;
                }
            }     
        }
        }

        while (bandasIt2.hasNext()) {
            int i = 0;
            banda = (Banda) bandasIt2.next();    
            if (banda.getGenero().equals(genero)){
            System.out.println("Banda: " + banda.getTitulo());
            ArrayList<Disco> discosB = banda.discos;
            Iterator<Disco> discosBandaIt = discosB.iterator();
            while (discosBandaIt.hasNext()) {
                Disco disco2 = discosBandaIt.next();
                System.out.println("Titulo del disco: " + disco2.getTitulo());
                HashSet<Cancion> cancionesB = disco2.canciones;
                Iterator<Cancion> cancionesBandaIt = cancionesB.iterator();
                while (cancionesBandaIt.hasNext()) {
                    Cancion cancion = cancionesBandaIt.next(); 
                    System.out.println("Cancion N° " + (i + 1) + ": " + cancion.getNombre());
                    i++;
            }
        }
    }
  }
}

    private static void borrarDiscos(Scanner entrada, ArrayList solistas, ArrayList bandas) {
        ArrayList<Disco> discosBanda = new ArrayList<>();
        ArrayList<Disco> discosSolista = new ArrayList<>();
        System.out.println("Ingrese el año del disco que desea borrar");
        String nombreDisco;
        int anioDisco = entrada.nextInt();
        Disco disco = new Disco(0, "", null);
        Solista solista = new Solista("", "", "", true, null, false, "", 0, "", discosSolista);
        Banda banda = new Banda("", null, "", 0, "", discosBanda);
        for (int i = 0; i < solistas.size(); i++) {
            solista = (Solista) solistas.get(i);
            for (int k = 0; k < solista.discos.size(); k++) {
                disco = (Disco) solista.discos.get(k);
                if (disco.getAnio() == anioDisco) {
                    solista.discos.remove(disco);
                }
            }
        }
        for (int i = 0; i < bandas.size(); i++) {
            banda = (Banda) bandas.get(i);
            for (int k = 0; k < banda.discos.size(); k++) {
                disco = (Disco) banda.discos.get(k);
                if (disco.getAnio() == anioDisco) {
                    banda.discos.remove(disco);
                }
            }
        }

    }

    private static void listarDiscos(Scanner entrada, ArrayList solistas, ArrayList bandas) {
        ArrayList<Disco> discosBanda = new ArrayList<>();
        ArrayList<Disco> discosSolista = new ArrayList<>();
        Solista solista = new Solista("", "", "", true, null, false, "", 0, "", discosSolista);
        Banda banda = new Banda("", null, "", 0, "", discosBanda);
        Iterator<Solista> solistasIt = solistas.iterator();
        Iterator<Banda> bandasIt = bandas.iterator();
        Disco disco = new Disco(0, "", null);
        while (solistasIt.hasNext()) {
            System.out.println("Solistas registrados: ");
            solista = (Solista) solistasIt.next();
            System.out.println(solista.getNombre());
        }
        while (bandasIt.hasNext()) {
            System.out.println("Bandas registradas: ");
            banda = (Banda) bandasIt.next();
            System.out.println(banda.getTitulo());
        }
        System.out.println("Ingrese nombre del solista o titulo de la banda que desea ver");
        String nombre;
        nombre = entrada.nextLine();
        Iterator<Solista> solistasIt2 = solistas.iterator();
        Iterator<Banda> bandasIt2 = bandas.iterator();
        while (solistasIt2.hasNext()) {
            solista = (Solista) solistasIt2.next();
            ArrayList<Disco> discosS = solista.discos;
            Iterator<Disco> discosSolistaIt = discosS.iterator();
            if (solista.getNombre().equals(nombre)) {
                while (discosSolistaIt.hasNext()) {
                    Disco disco2 = discosSolistaIt.next();
                    System.out.println("Nombre del disco: " + disco2.getTitulo() + " Año de lanzamiento: " + disco2.getAnio());
                }
            }
        }
        while (bandasIt2.hasNext()) {
            banda = (Banda) bandasIt2.next();
            ArrayList<Disco> discosB = banda.discos;
            Iterator<Disco> discosBandaIt = discosB.iterator();
            if (nombre.equals(banda.getTitulo())) {
                while (discosBandaIt.hasNext()) {
                    Disco disco2 = discosBandaIt.next();
                    System.out.println("Nombre del disco: " + disco2.getTitulo() + " Año de lanzamiento: " + disco2.getAnio());
                }
            }
        }
    }

}
