package Colecciones.Boletin5.Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegistroEntradas {
	private Map<Influencer, EntradaVIP> entradas;

    public RegistroEntradas() {
        this.entradas = new HashMap<>();
    }
    public boolean añadirEntrada(Influencer inf, EntradaVIP entrada) {
        if (!entradas.containsKey(inf)) {
            entradas.put(inf, entrada);
            return true;
        } else {
            return false;
        }
    }

    public EntradaVIP buscarEntrada(String nick, String plataforma) {
        for (Influencer inf : entradas.keySet()) {
            if (inf.getNick().equalsIgnoreCase(nick) &&
                inf.getPlataforma().equalsIgnoreCase(plataforma)) {
                return entradas.get(inf);
            }
        }
        return null;
    }

    public boolean confirmarEntrada(String nick, String plataforma) {
        EntradaVIP entrada = buscarEntrada(nick, plataforma);
        if (entrada != null) {
            entrada.confirmar();
            return true;
        } else {
            return false; 
        }
    }

    public boolean cancelarEntrada(String nick, String plataforma) {
        EntradaVIP entrada = buscarEntrada(nick, plataforma);
        if (entrada != null) {
            entrada.cancelar();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Influencer> listarInfluencersPorEstado(EntradaVIP.Estado estadoBuscado) {
        ArrayList<Influencer> resultado = new ArrayList<>();
        for (Map.Entry<Influencer, EntradaVIP> entrada : entradas.entrySet()) {
            if (entrada.getValue().getEstado() == estadoBuscado) {
                resultado.add(entrada.getKey());
            }
        }
        return resultado;
    }

    public ArrayList<Influencer> obtenerTop3Influencers() {
        ArrayList<Influencer> todos = new ArrayList<>(entradas.keySet());
        
        for (int i = 0; i < todos.size() - 1; i++) {
            for (int j = i + 1; j < todos.size(); j++) {
                if (todos.get(j).getNumSeguidores() > todos.get(i).getNumSeguidores()) {
                    Influencer temp = todos.get(i);
                    todos.set(i, todos.get(j));
                    todos.set(j, temp);
                }
            }
        }

        ArrayList<Influencer> top3 = new ArrayList<>();
        for (int i = 0; i < todos.size() && i < 3; i++) {
            top3.add(todos.get(i));
        }

        return top3;
    }

    public void mostrarTop3ConTipo() {
        ArrayList<Influencer> top3 = obtenerTop3Influencers();
        for (Influencer inf : top3) {
            EntradaVIP entrada = entradas.get(inf);
            System.out.println(inf);
            System.out.println("Tipo de entrada: " + entrada.getTipo());
            System.out.println();
        }
    }
}
