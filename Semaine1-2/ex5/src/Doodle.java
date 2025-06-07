import java.util.*;

public class Doodle {
	private PlageHoraire[] plages;
	// a compl�ter
	private Map<String, boolean[]> disponibilites;

	public Doodle(PlageHoraire... plages) {
		this.plages = plages;
		// a compl�ter
		this.disponibilites = new HashMap<>();
	}

	// ajoute les disponibilit�s d'un participant sous forme d'un tableau de booleen.
	// les indices du tableau correspondent aux indices du tableau plages
	// true � l'indice i veut dire que le participant est disponible pour la plage � l'indice i du tableau plages
	// false � l'indice i veut dire que le participant n'est pas disponible pour la plage � l'indice i du tableau plages
	public void ajouterDisponibilites(String participant,
			boolean[] disponibilites) {
		if (disponibilites.length != plages.length)
			throw new IllegalArgumentException();
		//a compl�ter
		this.disponibilites.put(participant, disponibilites);

	}
	
	// Hypoth�se: la PlageHoraire plage en param�tre fait bien partie du tableau plages
	// renvoie vrai si le participant est disponible pour cette plage horaire
	// renvoie faux si le participant n'est pas disponible ou s'il n'a pas rempli le
	// sondage doodle
	public boolean estDisponible(String participant, PlageHoraire plage) {
		if (!this.disponibilites.containsKey(participant)) {
			return false;
		}

		boolean[] disposParticipants = this.disponibilites.get(participant);
		for (int i = 0; i < plages.length; i++) {
			if (plages[i].equals(plage)) {
				return disposParticipants[i];
			}
		}
		return false;
	}

	// renvoie une des plages horaires qui a le maximum de participants pr�vus
	// cette m�thode est appel�e apr�s que les participants aient rempli leurs disponibilit�s
	public PlageHoraire trouverPlageQuiConvientLeMieux() {
		if (disponibilites.isEmpty()) {
			throw new IllegalArgumentException();
		}

		PlageHoraire max = null;
		int maxCount = -1;
		
		for (int i = 0; i < plages.length; i++) {
			int count  = 0;
			for (boolean[] dispos : disponibilites.values()) {
				if (dispos[i]) {
					count ++;
				}
			}
			plages[i].setNbParticipantPresent(count);
			if (count>maxCount) {
				maxCount=count;
				max = plages[i];
			}
		}

		return max;
	}

}
