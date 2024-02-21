package BE;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.SimplePlanMonitor;
import enstabretagne.helloworld.PlanHelloWorld;

public class CureTatooing {
	public static void main(String[] args) {
		//penser � utiliser cette m�thode en d�but dans le main
		//sinon un soucis de classloading est remont� par jsonb.
		Logger.load();
		
		
		LogicalDateTime start = new LogicalDateTime("04/12/2019 14:00");
		LogicalDateTime end = new LogicalDateTime("04/12/2019 15:00");

		PlanTatooing plan2 = new PlanTatooing(5,start,end);
		PlanTatooing plan = new PlanTatooing(4, start, end);

		SimplePlanMonitor spm = new SimplePlanMonitor(plan);
		spm.run();
		
	}
}
