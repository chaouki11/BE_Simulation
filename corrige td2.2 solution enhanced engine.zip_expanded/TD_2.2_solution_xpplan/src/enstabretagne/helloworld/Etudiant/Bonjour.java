package enstabretagne.helloworld.Etudiant;

import java.util.List;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.SimEvent;

//création d'un événement Bonjour
public class Bonjour extends SimEvent {

	private String nom;

	public Bonjour(LogicalDateTime d, String nom) {
		super(d);
		this.nom = nom;
	}

	//méthode utilitaire qui permet d'allerger l'implémentation de la méthode process
	//et contribue à sa lisibilité
	public String amiString(List<EntiteSimulee> amis, int n) {
		if (amis.size() > 0) {
			if (amis.size() == 1) {
				var ie = (InitEtudiant) amis.get(0).getInit();
				String amiString = "";
				switch (ie.genre) {
				case Homme: {
					amiString = "ami";
					break;
				}
				case Femme: {
					amiString = "amie";
					break;
				}
				case Autre: {
					amiString = "ami.e";
					break;
				}
				}

				return "mon " + amiString + " est " + ((EtudiantSimple) amis.get(0)).getName();
			} else {
				String amisString = "";
				for (EntiteSimulee e : amis) {
					amisString = amisString + ((EtudiantSimple) e).getName() + " ";
				}
				return "mes amis sont : " + amisString;

			}
		} else {
			return "je n'ai pas d'amis parmi les " + n + " étudiants";
		}

	}

	public void process() {
		Logger.Detail(entitePorteuseEvenement, "bonjour.Process",
				"Bonjour de la part de " + nom + " à " + getDateOccurence());
		Logger.Detail(entitePorteuseEvenement, "bonjour.Process",
				"mon film préféré est " + ((InitEtudiant) entitePorteuseEvenement.getInit()).filmPrefere);
		List<EntiteSimulee> allStudents = entitePorteuseEvenement.recherche(e -> ((e instanceof EtudiantSimple)));

		List<EntiteSimulee> amis = entitePorteuseEvenement.recherche(e -> ((e instanceof EtudiantSimple)
				&& (e != entitePorteuseEvenement) 
				&& ((InitEtudiant) e.getInit()).filmPrefere.equals(((InitEtudiant) entitePorteuseEvenement.getInit()).filmPrefere)));

		Logger.Detail(entitePorteuseEvenement, "bonjour.Process", amiString(amis, allStudents.size()));

		//exemple d'introduction d'un aléa temporel
		double alea = entitePorteuseEvenement.getRandomGenerator().nextDouble() * 3 * 60;

		//la prochaine occurence de l'événement est donc aléatoire
		this.rescheduleAt(getDateOccurence().add(LogicalDuration.ofMinutes(5).add(LogicalDuration.ofSeconds(alea))));
		entitePorteuseEvenement.Post(this);
	}

}
