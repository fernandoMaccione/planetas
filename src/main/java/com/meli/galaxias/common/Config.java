package com.meli.galaxias.common;

public class Config {
	/*
	 * Esto en realidad se debería de tener que persistir con algún backofice, y  no que estén estaticos.
	 */
	public static final String VULCANOS_NAME = "Vulcanos";
	public static final int VULCANOS_GREDEES = -5;
	public static final int VULCANOS_RADIO = 1000;
	
	public static final String FERENGIS_NAME = "Ferengis";
	public static final int FERENGIS_GREDEES = 1;
	public static final int FERENGIS_RADIO = 500;

	public static final String BETASOIDES_NAME = "Betasoides";
	public static final int BETASOIDES_GREDEES = 3;
	public static final int BETASOIDES_RADIO = 2000;
	
	public static final String GALAXIA_LEJANA = "ANDROMEDA";
	public static final int DAY_PER_YEAR = 365;
	
	public static final int TIME_PERIOD = DAY_PER_YEAR * 10;
	public static final int FIRTS_DAY = 0;
	public static final int LAST_DAY = TIME_PERIOD + FIRTS_DAY;
	
	public static final int PRECICION_CALCULE = 24  * 60;  //intervalo por dia que se toma en cuenta para realizar los calculos. Cada 1 minuto.
}
