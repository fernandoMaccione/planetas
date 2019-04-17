package com.meli.galaxias.server.galaxiaLejana;

import java.util.ArrayList;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.SolarSystem;
import com.meli.galaxias.server.galaxiaLejana.planet.Betasoides;
import com.meli.galaxias.server.galaxiaLejana.planet.Ferengis;
import com.meli.galaxias.server.galaxiaLejana.planet.Vulcanos;

public class GalaxiaLejana extends SolarSystem{

	public GalaxiaLejana() {
		super(Config.GALAXIA_LEJANA);
		
		planets= new ArrayList<Planet>();
		planets.add(new Ferengis());
		planets.add(new Vulcanos());
		planets.add(new Betasoides());		
		
	}
	
}
