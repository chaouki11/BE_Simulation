package enstabretagne.engine;

import enstabretagne.base.time.LogicalDateTime;

/**
 * Evenement de simulation à surcharger
 *
 */

public abstract class SimEvent implements Comparable<SimEvent> {
	//référence à l'entité porteuse de l'événement
	protected EntiteSimulee entitePorteuseEvenement;
	//instant d'occurence de l'événement
	private LogicalDateTime d;
	protected LogicalDateTime getDateOccurence()
	{
		return d;
	}

	//replanification de l'événement
	protected void rescheduleAt(LogicalDateTime d)
	{
		this.d=d;
	}
	public SimEvent(LogicalDateTime d) {
		this.d=d;
	}
	
	@Override
	public int compareTo(SimEvent ev) {
		return this.d.compareTo(ev.d);
	}

	//méthode à surcharger pour exécuter une action
	public abstract void process();

}
