package codejava;
import java.util.Objects;

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
		this.id = Objects.requireNonNull(id);
		this.ident = Objects.requireNonNull(ident);
		this.type = Objects.requireNonNull(type);
		this.name = Objects.requireNonNull(name);
		this.latitude_deg = Objects.requireNonNull(latitude_deg);
		this.longitude_deg = Objects.requireNonNull(longitude_deg);
		this.elevation_ft = Objects.requireNonNull(elevation_ft);
		this.continent = Objects.requireNonNull(continent);
		this.iso_country = Objects.requireNonNull(iso_country);
		this.iso_region = Objects.requireNonNull(iso_region);
		this.municipality = Objects.requireNonNull(municipality);
		this.scheduled_service = Objects.requireNonNull(scheduled_service);
		this.gps_code = Objects.requireNonNull(gps_code);
		this.iata_code = Objects.requireNonNull(iata_code);
		this.local_code = Objects.requireNonNull(local_code);
		this.home_link = Objects.requireNonNull(home_link);
		this.wikipedia_link = Objects.requireNonNull(wikipedia_link);
		this.keywords = Objects.requireNonNull(keywords);
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
