package com.meli.galaxias.server.galaxiaLejana;

import java.util.ArrayList;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.SolarSystem;
import com.meli.galaxias.server.galaxiaLejana.planet.Betasoides;
import com.meli.galaxias.server.galaxiaLejana.planet.Ferengis;
import com.meli.galaxias.server.galaxiaLejana.planet.Vulcanos;
/*
 * Esta clase representa al sistema solar del ejercicio pedido. 
 * Su existencia, practicamente es simbolica a lo igual que los planetas que estan relacionados a ellas 
 * porque tranquilamente bien se podrian dar de alta en una base de datos todas las galaxias a las que se les desea realizar un calculo.  
 */
public class GalaxiaLejana extends SolarSystem{

	public GalaxiaLejana() {
		super(Config.GALAXIA_LEJANA);
		
		planets= new ArrayList<Planet>();
		planets.add(new Ferengis());
		planets.add(new Vulcanos());
		planets.add(new Betasoides());		
		
	}
	
}
