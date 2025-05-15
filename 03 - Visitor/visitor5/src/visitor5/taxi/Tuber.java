package visitor5.taxi;

import java.util.ArrayList;
import java.util.List;

import visitor.VisitorTaxi;


public class Tuber {
	
	private List<Taxi> taxis = new ArrayList<>();
	
	public void accept(VisitorTaxi visitor) throws Exception {
		
		for (Taxi taxi:taxis) 
			taxi.accept(visitor);
		
	}

	public void add(Taxi t) {
		taxis.add(t);
	}
	
}
