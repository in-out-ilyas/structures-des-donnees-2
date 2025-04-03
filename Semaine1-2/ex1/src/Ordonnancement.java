import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX = 5;
	private PriorityQueue<Tache> listeTaches;

	public Ordonnancement() {
		listeTaches = new PriorityQueue<>((p1, p2) -> {
			int comparaison = Integer.compare(p2.getPriorite(), p1.getPriorite());
			if (comparaison == 0) {
				return (p1.getDate().compareTo(p2.getDate()));
			}
			return comparaison;
		});
	}

	public void ajouterTache(String descriptif, int priorite) {
		if (descriptif.isBlank() || priorite > 5 || priorite < 1) {
			throw new IllegalArgumentException();
		}
		Tache newTache = new Tache(descriptif, priorite);
		listeTaches.add(newTache);
	}

	// renvoie la tache prioritaire
	// renvoie null si plus de tache presente
	public Tache attribuerTache() {

		return listeTaches.poll();
	}
}
