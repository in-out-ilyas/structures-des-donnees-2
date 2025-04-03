import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ControleDAcces {

	Map<Employe, Badge> listeEmployes;
	Set<Badge> present;

	public ControleDAcces() {
		listeEmployes = new HashMap<>();
		present = new LinkedHashSet<>();
	}

	// associe le badge � un employ�
	public void donnerBadge(Badge b, Employe e) {
		if (b==null || e==null) {
			throw new IllegalArgumentException();
		}
		listeEmployes.put(e, b);
	}

	// met � jour les employ�s pr�sents dans le batiment
	public void entrerBatiment(Badge b) {
		present.add(b);
	}

	// met � jour les employ�s pr�sents dans le batiment
	public void sortirBatiment(Badge b) {
		present.remove(b);
	}

	// renvoie vrai si l'employ� est dans le batiment, faux sinon
	public boolean estDansBatiment(Employe e) {
		Badge b = listeEmployes.get(e);
		return present.contains(b);
	}

}
