package webapps;

public class Country {
	private String id;
	private String code;
	private String name;
	private String continent;
	private String wikipedia_link;
	private String keywords;


	public Country(String id, String code, String name, String continent, String wikipedia_link, String keywords) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.wikipedia_link = wikipedia_link;
		this.keywords = keywords;
		
	}
	
	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public String getWikipedia_link() {
		return wikipedia_link;
	}

	public String getKeywords() {
		return keywords;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + ", continent=" + continent
				+ ", wikipedia_link=" + wikipedia_link + ", keywords=" + keywords + "]";
	}

	

}
