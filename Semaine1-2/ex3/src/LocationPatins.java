import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {
	
	private Map<Integer, Integer> listePatins;
	private Map<Integer, LocalTime> location;

	public LocationPatins(int[] casiers) {
		listePatins = new HashMap<>();
		location = new HashMap<>();
		for (int i = 0; i < casiers.length; i++) {
			listePatins.put(i, casiers[i]);
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();
		for (Map.Entry<Integer, Integer> entry : listePatins.entrySet()) {
			if (entry.getValue()==pointure && !location.containsKey(entry.getKey())) {
				int numCasier = entry.getKey();
				location.put(numCasier, l);
				return numCasier;
			}
		}

		return -1;
		//a compl�ter

	}

	public double libererCasier(int numeroCasier) {
		//a completer
		if (location.get(numeroCasier)==null) {
			throw new IllegalArgumentException();
		}
		double montant = prix(location.get(numeroCasier), LocalTime.now());
		location.remove(numeroCasier);
		return montant;
	}

}
