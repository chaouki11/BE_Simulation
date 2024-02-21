package enstabretagne.helloworld.Etudiant;

import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.SimuEngine;

public class EtudiantSimple extends EntiteSimulee{
	
	
	
	public EtudiantSimple(SimuEngine engine,InitEtudiant ini) {
		super(engine,ini);
		
	}

	//on surcharge la méthode init pour pouvoir faire l'effet "boule de neige" de l'événementiel
	@Override
	public void init() {
		super.init();//ne pas oublier d'appeler l'init du dessus pour bien mettre l'état à jour		
		Post(new Bonjour(Now().add(LogicalDuration.ofMinutes(15)), getInit().getName()));
	}
	
	@Override
	public String toString() {
		return getInit().getName();
	}

	//on surcharge la méthode terminate()
	//elle reste vide car il n'y a pas de variables à remettre à zero
	//sur une entité plus complexe, il faudrait:
	// vider les listes, mettre les références à d'autres objets à null
	@Override
	public void terminate() {
		
	}
}
