package PruebaMapa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Mapa {

	public static void main(String[] args) {
		Mapa p = new Mapa();
		Map <String, Integer> mapa = new HashMap<>();
		mapa.put("juanki", 6);
		mapa.put("adrian", 6);
		mapa.put("puerto", 3);
		
		 Set <String> aprobados = p.getAprobados(mapa);
		 System.out.println(aprobados);
		
	}

	public Set <String> getAprobados (Map <String,Integer> mapas) {
		Set <String> aprobados = new HashSet<String>();
		Set<Entry<String, Integer>> entry = mapas.entrySet();
		Iterator it = entry.iterator();
		while (it.hasNext()) {
			Entry <String,Integer> pareja = (Entry<String, Integer>) it.next();
			if (pareja.getValue()>=5) {
				aprobados.add(pareja.getKey());
			
			}
		}
		return aprobados;
		
	}
	
	/*public Integer getNombre (Map <String,Integer> mapas) {
		
		Set <Integer> aprobados = new HashSet<String>();
		Set<Entry<String, Integer>> entry = mapas.entrySet();
		Iterator it = entry.iterator();
		while (it.hasNext()) {
			Entry <String,Integer> pareja = (Entry<String, Integer>) it.next();
			if (pareja.getKey()) {
				aprobados.add(pareja.getKey());
			
			}
		}
		return aprobados;
	}*/
}
