package BE;
import java.util.List;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimuEngine;
import enstabretagne.helloworld.Etudiant.EtudiantSimple;

public class ScenarioTatooine extends Scenario {

	public ScenarioTatooine(SimuEngine engine, ScenarioTatooineInit init) {
		// TODO Auto-generated constructor stub
		super(engine, init);
	}

	@Override
	public void creerEntitesSimulees() {
		// TODO Auto-generated method stub
		
	}
	//influence en mois à faire : voir tableau excel nombre en % * 180 ca donne 90 ....
	long nbClient;
	public void creerClientAleatoire() {
		ClientInitData iniClient = new ClientInitData("C"+nbClient++);
		 new Client(getEngine(),iniClient);
	}
	
	@Override
	protected void init() {
		super.init();
		List<EntiteSimulee> l = recherche(e->{return e instanceof EtudiantSimple ;});

		//on demande l'initialisation de ces entit�s
		for(EntiteSimulee e: l) {
			e.requestInit();
		}
	}

}
