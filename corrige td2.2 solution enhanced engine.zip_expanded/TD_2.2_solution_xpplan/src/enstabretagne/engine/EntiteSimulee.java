package enstabretagne.engine;

import java.util.List;
import java.util.function.Predicate;

import enstabretagne.base.math.MoreRandom;
import enstabretagne.base.time.LogicalDateTime;

/**
 * 
 * EntiteSimulee est l'entité dont il faut hériter pour créer des entités.
 *
 */
public abstract class EntiteSimulee {
	enum EtatEntite {NONE,INITIALIZED,DEAD};
	
	private SimuEngine engine;
	private InitData ini;
	
	//état de l'entité
	private EtatEntite etat;
	protected EtatEntite getEtat() {
		return etat;
	}
	
	public EntiteSimulee(SimuEngine engine,InitData ini) {
		this.etat= EtatEntite.NONE;
		this.engine=engine;
		this.ini=ini;
		engine.mesEntitesSimulees.add(this);
	}
	
	public SimuEngine getEngine() {
		return engine;
	}
	
	public String getName() {
		return ini.getName();
	}
	public InitData getInit() {
		return ini;
	}
	
	public void Post(SimEvent ev) {
		ev.entitePorteuseEvenement = this;
		engine.Post(ev);
	}
	
	public LogicalDateTime Now() {
		return engine.getCurrentDate();
	}
	
	public List<EntiteSimulee> recherche(Predicate<EntiteSimulee> query) {
		return engine.recherche(query);
	}
	
	public MoreRandom getRandomGenerator() {
		return engine.getRandomGenerator();
	}
	
	/**seule méthode vraiment publique
	elle évite de pouvoir appeler plusieurs fois l'initialisation	
	attention: quand une entité parente crée une entité fille c'est à elle qu'incombe 
	de demander son initialisation via le requestInit().
	en effet, le moteur ne peut pas savoir quand il est opportun de déclencher l'init pour cette entité*/
	
	public void requestInit() {
		if(etat==EtatEntite.NONE) init();
	}

	//méthode à surcharger	
	
	protected void init() {
		etat = EtatEntite.INITIALIZED;
	}
	//méthode à surcharger
	//lors de cet appel dans la surcharge on vide proprement les listes
	//on met à null tous les objets de manière à aider le garbage collector
	protected void terminate() {
		etat = EtatEntite.DEAD;
	}
}
