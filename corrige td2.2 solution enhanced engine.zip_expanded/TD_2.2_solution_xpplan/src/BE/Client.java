package BE;

import enstabretagne.base.logger.ToRecord;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.InitData;
import enstabretagne.engine.SimuEngine;

//clients qui vont arriver régulièrement
//créer la notion de client
//liste d'ateliers à faire (programme de soins)
//point total theorique 
//point total effectif actuel
@ToRecord(name="Client")
public class Client extends EntiteSimulee{

	public Client(SimuEngine engine, InitData ini) {
		super(engine, ini);
		// TODO Auto-generated constructor stub
	}

	@ToRecord(name="Points de soins")
	double getPointTotalEnCours() {
		return 0;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	
	
}
