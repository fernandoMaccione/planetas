package com.meli.galaxias.server.galaxiaLejana;

import java.util.HashMap;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.model.Planet;
import com.meli.galaxias.server.core.model.SolarSystem;
import com.meli.galaxias.server.galaxiaLejana.planet.Betasoides;
import com.meli.galaxias.server.galaxiaLejana.planet.Ferengis;
import com.meli.galaxias.server.galaxiaLejana.planet.Vulcanos;

public class GalaxiaLejana extends SolarSystem{

	public GalaxiaLejana() {
		super(Config.GALAXIA_LEJANA);
		
		planets= new HashMap<String, Planet>();
		planets.put(Config.BETASOIDES_NAME, new Betasoides());
		planets.put(Config.FERENGIS_NAME, new Ferengis());
		planets.put(Config.VULCANOS_NAME, new Vulcanos());
	}
	
}
