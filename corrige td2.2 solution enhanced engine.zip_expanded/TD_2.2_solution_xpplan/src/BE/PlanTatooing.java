package BE;

import java.util.LinkedList;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.Plan;
import enstabretagne.engine.Scenario;
import enstabretagne.helloworld.scenario.ScenarioENSTA;
import enstabretagne.helloworld.scenario.ScenarioEnstaInitData;

public class PlanTatooing extends Plan {
	LogicalDateTime debut;
	LogicalDateTime fin;
	public PlanTatooing(int nbReplique,LogicalDateTime debut, LogicalDateTime fin) {
		super(nbReplique);
		this.debut = debut;
		this.fin = fin;
		tatooinesC=new LinkedList<ScenarioTatooine>();
	}
	LinkedList<ScenarioTatooine> tatooinesC;

	@Override
	public void initScenarii() {
		// TODO Auto-generated method stub
		for (int i = 0; i < getNbReplique(); i++)
			tatooinesC.add(
					new ScenarioTatooine(getEngine(), new ScenarioTatooineInit("Mon premier scenario", i, debut, fin, 1)));
		
	}

	@Override
	public boolean hasNextScenario() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Scenario nextScenario() {
		if (hasNextScenario()) {
			ScenarioTatooine sc = tatooinesC.pop();
			
			//on donne le sc�nario suivant au moteur
			engine.setCurrentScenario(sc);
			return sc;
		}
		return null;
	}

}
