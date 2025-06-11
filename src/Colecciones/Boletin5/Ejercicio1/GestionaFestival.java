package Colecciones.Boletin5.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionaFestival {

	public static void main(String[] args) {
		RegistroEntradas registro = new RegistroEntradas();

        Influencer inf1 = new Influencer("Ana", "anitaYT", 150000, "YouTube");     
        Influencer inf2 = new Influencer("Juan", "juanDraw", 180000, "YouTube");  
        Influencer inf3 = new Influencer("Leo", "leoFunny", 105000, "TikTok");     

        Influencer inf4 = new Influencer("Carlos", "carlitox", 70000, "Twitch");   
        Influencer inf5 = new Influencer("Lucía", "luGames", 92000, "Twitch");     
        Influencer inf6 = new Influencer("Pedro", "pedroShow", 56000, "TikTok");  

        Influencer inf7 = new Influencer("Marta", "martaCosplay", 23000, "Instagram"); 
        Influencer inf8 = new Influencer("Sara", "saraArt", 21000, "Instagram");      
        Influencer inf9 = new Influencer("Elena", "elenaMakeup", 48000, "Instagram");  

        registro.añadirEntrada(inf1, new EntradaVIP("VIP1", LocalDate.now(), EntradaVIP.Tipo.PLATINIUM));
        registro.añadirEntrada(inf2, new EntradaVIP("VIP2", LocalDate.now(), EntradaVIP.Tipo.PLATINIUM));
        registro.añadirEntrada(inf3, new EntradaVIP("VIP3", LocalDate.now(), EntradaVIP.Tipo.PLATINIUM));

        registro.añadirEntrada(inf4, new EntradaVIP("VIP4", LocalDate.now(), EntradaVIP.Tipo.GOLD));
        registro.añadirEntrada(inf5, new EntradaVIP("VIP5", LocalDate.now(), EntradaVIP.Tipo.GOLD));
        registro.añadirEntrada(inf6, new EntradaVIP("VIP6", LocalDate.now(), EntradaVIP.Tipo.GOLD));

        registro.añadirEntrada(inf7, new EntradaVIP("VIP7", LocalDate.now(), EntradaVIP.Tipo.SILVER));
        registro.añadirEntrada(inf8, new EntradaVIP("VIP8", LocalDate.now(), EntradaVIP.Tipo.SILVER));
        registro.añadirEntrada(inf9, new EntradaVIP("VIP9", LocalDate.now(), EntradaVIP.Tipo.SILVER));

        System.out.println("Buscar entrada de 'anitaYT' (YouTube):");
        EntradaVIP entradaBuscada1 = registro.buscarEntrada("anitaYT", "YouTube");
        System.out.println(entradaBuscada1);
        System.out.println();

        System.out.println("Buscar entrada de 'randomNick' (TikTok):");
        EntradaVIP entradaBuscada2 = registro.buscarEntrada("randomNick", "TikTok");
        System.out.println(entradaBuscada2);
        System.out.println();

        registro.confirmarEntrada("anitaYT", "YouTube");    
        registro.confirmarEntrada("carlitox", "Twitch");      
        registro.confirmarEntrada("martaCosplay", "Instagram"); 

        registro.cancelarEntrada("luGames", "Twitch");

        System.out.println("Confirmados:");
        ArrayList<Influencer> confirmados = registro.listarInfluencersPorEstado(EntradaVIP.Estado.CONFIRMADA);
        for (Influencer i : confirmados) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("Cancelados:");
        ArrayList<Influencer> cancelados = registro.listarInfluencersPorEstado(EntradaVIP.Estado.CANCELADA);
        for (Influencer i : cancelados) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("Pendientes:");
        ArrayList<Influencer> pendientes = registro.listarInfluencersPorEstado(EntradaVIP.Estado.ENVIADA);
        for (Influencer i : pendientes) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("Top 3 influencers con más seguidores:");
        registro.mostrarTop3ConTipo();
    }
}

