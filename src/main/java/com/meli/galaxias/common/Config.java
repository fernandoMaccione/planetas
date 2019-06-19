package com.meli.galaxias.common;

public class Config {
	/*
	 * Esto en realidad se debería de tener que persistir con algún backofice, y  no que estén estaticos.
	 * Quedará para la segunda versión...
	 */
	public static final String VULCANOS_NAME = "Vulcanos";
	public static final int VULCANOS_GREDEES = 1;//-5; 
	public static final int VULCANOS_RADIO = 100;//1000;
	
	public static final String FERENGIS_NAME = "Ferengis";
	public static final int FERENGIS_GREDEES = -5;//1;
	public static final int FERENGIS_RADIO = 200;//500;

	public static final String BETASOIDES_NAME = "Betasoides";
	public static final int BETASOIDES_GREDEES = 10;//3;
	public static final int BETASOIDES_RADIO = 400;//2000;
	
	public static final String GALAXIA_LEJANA = "ANDROMEDA";
	public static final int DAY_PER_YEAR = 365;
	
	public static final int TIME_PERIOD = DAY_PER_YEAR * 10;
	public static final int FIRTS_DAY = 0;
	public static final int LAST_DAY = TIME_PERIOD + FIRTS_DAY;
	
	/*
	 * intervalo por dia que se toma en cuenta para realizar los calculos. 
		*Esta cada 0.5 segundos.
	 */
	public static final int PRECICION_CALCULE = 24  * 60 * 120;
	
	public static final int SERVER_PORT = 80;
	public static final String PERSISTENCE_UNIT = "dataAcces";
}
