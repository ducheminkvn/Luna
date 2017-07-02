package webapps;

public class Airport {
	private final String id;
	private final String ident;
	private final String type;
	private final String name;
	private final String latitude_deg;
	private final String longitude_deg;
	private final String elevation_ft;
	private final String continent;
	private final String iso_country;
	private final String iso_region;
	private final String municipality;
	private final String scheduled_service;
	private final String gps_code;
	private final String iata_code;
	private final String local_code;
	private final String home_link;
	private final String wikipedia_link;
	private final String keywords;

	public Airport( String id, String ident, String type, String name, String latitude_deg, String longitude_deg, String elevation_ft, String continent, String iso_country, String iso_region, String municipality, String scheduled_service, String gps_code, String iata_code, String local_code, String home_link, String wikipedia_link, String keywords) {
		this.id = id;
		this.ident = ident;
		this.type = type;
		this.name = name;
		this.latitude_deg = latitude_deg;
		this.longitude_deg = longitude_deg;
		this.elevation_ft = elevation_ft;
		this.continent = continent;
		this.iso_country = iso_country;
		this.iso_region = iso_region;
		this.municipality = municipality;
		this.scheduled_service = scheduled_service;
		this.gps_code = gps_code;
		this.iata_code = iata_code;
		this.local_code = local_code;
		this.home_link = home_link;
		this.wikipedia_link = wikipedia_link;
		this.keywords = keywords;
	}
	
	

	@Override
	public String toString() {
		return "Airport [id=" + id + ", ident=" + ident + ", type=" + type + ", name=" + name + ", latitude_deg="
				+ latitude_deg + ", longitude_deg=" + longitude_deg + ", elevation_ft=" + elevation_ft + ", continent="
				+ continent + ", iso_country=" + iso_country + ", iso_region=" + iso_region + ", municipality="
				+ municipality + ", scheduled_service=" + scheduled_service + ", gps_code=" + gps_code + ", iata_code="
				+ iata_code + ", local_code=" + local_code + ", home_link=" + home_link + ", wikipedia_link="
				+ wikipedia_link + ", keywords=" + keywords + "]";
	}



	public String getId() {
		return id;
	}

	public String getIdent() {
		return ident;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getLatitude_deg() {
		return latitude_deg;
	}

	public String getLongitude_deg() {
		return longitude_deg;
	}

	public String getElevation_ft() {
		return elevation_ft;
	}

	public String getContinent() {
		return continent;
	}

	public String getIso_country() {
		return iso_country;
	}

	public String getIso_region() {
		return iso_region;
	}

	public String getMunicipality() {
		return municipality;
	}

	public String getScheduled_service() {
		return scheduled_service;
	}

	public String getGps_code() {
		return gps_code;
	}

	public String getIata_code() {
		return iata_code;
	}

	public String getLocal_code() {
		return local_code;
	}

	public String getHome_link() {
		return home_link;
	}

	public String getWikipedia_link() {
		return wikipedia_link;
	}

	public String getKeywords() {
		return keywords;
	}
}
