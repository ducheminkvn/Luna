package codejava;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kevin on 6/30/17.
 */

/*
2. Write a web application in Java or Scala that will ask the user for two actions : Query or Reports.

2.1 Query Option will ask the user for the country name or code and print the airports & runways at each airport. 
The input can be country code or country name. For bonus points make the test partial/fuzzy. e.g. entering zimb will result in Zimbabwe :)

2.2 Choosing Reports will print the following:

    10 countries with highest number of airports (with count) and countries with lowest number of airports.
    Type of runways (as indicated in "surface" column) per country
    Bonus: Print the top 10 most common runway identifications (indicated in "le_ident" column)

Feel free to use any library/framework as necessary but write it as a web application. 
 */

public class Luna {

	private Scanner console = new Scanner(System.in);
	private List<Airport> airports;
	private List<Runway> runways;
	private List<Country> countries;
	private String DEFAUL_PATH = "./input";
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public Luna(String path) throws IOException {
		try{
			System.out.println("Data Load from url : "+path);
			airports = ParseTest.parseAirports(ParseTest.parseFileToURL(path+"/airports.csv"));

			System.out.println("... airports.csv downloaded");
			countries = ParseTest.parseCountries(ParseTest.parseFileToURL(path+"/countries.csv"));
			System.out.println("... countries.csv downloaded");
			runways = ParseTest.parseRunways(ParseTest.parseFileToURL(path+"/runways.csv"));
			System.out.println("... runways.csv downloaded");
		} catch (IOException io) {
			System.out.println("Error for download all files needed\nLoad from Local DataBase");
			try {
				airports = ParseTest.parseAirports(
						ParseTest.parseFileToString(
								Paths.get(DEFAUL_PATH+"/airports.csv")));
				System.out.println("... airports.csv loaded");
				countries = ParseTest.parseCountries(
						ParseTest.parseFileToString(
								Paths.get(DEFAUL_PATH+"/countries.csv")));
				System.out.println("... countries.csv loaded");
				runways = ParseTest.parseRunways(
						ParseTest.parseFileToString(
								Paths.get(DEFAUL_PATH+"/runways.csv")));	
				System.out.println("... runways.csv loaded");
			} catch (IOException io2) {
				System.out.println("Error download files from server DataBase\n"+io+"\nAnd for load files from local DataBase");
				throw io2;
			}
		}
	}

	public String query(String string){
		System.out.println(string);
		StringBuilder sb = new StringBuilder();
		String codeOrName = string.toUpperCase();
		if(codeOrName.length() < 2) {
			return "Bad Code or Bad Name"+string;
		}
		Optional<String> code = Optional.empty();

		if(codeOrName.length() == 2)
			code = Optional.ofNullable(codeOrName);
		if(codeOrName.length() > 2) 
			for(Country country : countries)
				if(country.getName().toUpperCase().startsWith(codeOrName)) {
					code = Optional.ofNullable(country.getCode().toUpperCase());
					break;
				}
		if(!code.isPresent()) {
			return "Bad Code or Bad Name"+string;
		}
		sb.append("Code : " + code.get()+"\n");

		ArrayList<String> airportsId = new ArrayList<>();
		for(Airport airport : airports) {
			if(airport.getIso_country().toUpperCase().equals(code.get())) {
				sb.append(airport+"\n");
				airportsId.add(airport.getIdent());
			}
		}
		for(Runway runway : runways)
			for(String id : airportsId)
				if(id.equals(runway.getAirport_ident()))
					sb.append(runway+"\n");

		return sb.toString();
	}

	public String reports(){
		StringBuilder sb = new StringBuilder();
		sb.append(displayTopTenCountriesAirports());
		sb.append(displayLessTenCountriesAirports());
		sb.append(displayTypeRunwayPerCountry());
		sb.append(displayTopTenMostCommonRunway());
		return sb.toString();
	}

	private String displayTypeRunwayPerCountry() {

		StringBuilder sb = new StringBuilder();

		sb.append("\nRunway's type per Country :\n");
		countries.stream().forEach(country -> {
			String code = country.getCode();
			final Set<String> setSurface = new HashSet<>();
			Stream<Airport> streamCountryAirports = airports.stream()
					.filter(x -> code.equals(x.getIso_country().toUpperCase()));
			streamCountryAirports.forEach( airport -> { 
				setSurface.addAll(runways.stream()
						.filter(runway -> runway.getAirport_ident().equals(airport.getIdent()) && !runway.getSurface().equals(""))
						.map(runway -> runway.getSurface().toUpperCase())
						.collect(Collectors.toSet()));	
			});
			sb.append("\t["+code+"]"+ country.getName() +" : "+setSurface.toString()+"\n");
		});
		return sb.toString();
	}

	private String displayTopTenMostCommonRunway() {
		StringBuilder sb = new StringBuilder();
		TreeMap<Long, String> numberCommonRunways = new TreeMap<>();
		Set<String> le_idents = new HashSet<>(); 
		runways.stream().forEach( runway -> le_idents.add(runway.getLe_ident().toUpperCase()));
		le_idents.stream().forEach(le_ident -> {
			long count = runways.stream().filter( runway -> le_ident.equals(runway.getLe_ident().toUpperCase())).count();
			String oldValue = numberCommonRunways.getOrDefault(count, "");
			if(oldValue.equals(""))
				numberCommonRunways.put(count, le_ident);
			else
				numberCommonRunways.put(count, oldValue+","+le_ident);
		});
		int i = 10;
		sb.append("\nTop 10 of Most Common Runway :\n");
		for(Long count : numberCommonRunways.descendingKeySet())
			for(String name : numberCommonRunways.get(count).split(","))
				if(i-->0)
					sb.append("\t"+name+":"+count+"\n");
				else
					break;
		return sb.toString();
	}

	private String displayLessTenCountriesAirports() {

		StringBuilder sb = new StringBuilder();
		TreeMap<Long, String> numbersOfCountriesAirports = new TreeMap<>();
		countries.stream().map(x -> x.getCode().toUpperCase()).forEach( code -> {
			long count = airports.stream()
					.filter(x -> code.equals(x.getIso_country().toUpperCase()))
					.count();
			String oldCode = numbersOfCountriesAirports.getOrDefault(count, "");
			if(oldCode.equals(""))
				numbersOfCountriesAirports.put(count, code);
			else
				numbersOfCountriesAirports.put(count, oldCode+","+code);
		});

		int i = 10;
		sb.append("\nTop 10 of countries with lowest number of airports :\n");
		for(Long numbersOfCountryAirports : numbersOfCountriesAirports.keySet())
			for(String code : numbersOfCountriesAirports.get(numbersOfCountryAirports).split(","))
				if(i-- > 0)
					sb.append("\t"+code+":"+numbersOfCountryAirports+"\n");
				else
					break;
		return sb.toString();
	}

	private String displayTopTenCountriesAirports() {
		StringBuilder sb = new StringBuilder();

		TreeMap<Long, String> numbersOfCountriesAirports = new TreeMap<>();
		countries.stream().map(country -> country.getCode().toUpperCase()).forEach( code -> {
			long count = airports.stream()
					.filter(airport -> code.equals(airport.getIso_country().toUpperCase()))
					.count();
			String oldCode = numbersOfCountriesAirports.getOrDefault(count, "");
			if(oldCode.equals(""))
				numbersOfCountriesAirports.put(count, code);
			else
				numbersOfCountriesAirports.put(count, oldCode+","+code);
		});

		int i = 10;

		sb.append("Top 10 of countries with highest number of airports :\n");
		for(Long numbersOfCountryAirports : numbersOfCountriesAirports.descendingKeySet())
			for(String code : numbersOfCountriesAirports.get(numbersOfCountryAirports).split(","))
				if(i-- > 0)
					sb.append("\t"+code+":"+numbersOfCountryAirports+"\n");
				else
					break;
		return sb.toString();
	}

	private String displayTopTenCountriesAirportsPublic() {
		StringBuilder sb = new StringBuilder();

		TreeMap<Long, String> numbersOfCountriesAirports = new TreeMap<>();
		countries.stream().map(country -> country.getCode().toUpperCase()).forEach( code -> {
			long count = airports.stream()
					.filter(airport -> code.equals(airport.getIso_country().toUpperCase()))
					.count();
			String oldCode = numbersOfCountriesAirports.getOrDefault(count, "");
			if(oldCode.equals(""))
				numbersOfCountriesAirports.put(count, code);
			else
				numbersOfCountriesAirports.put(count, oldCode+","+code);
		});

		int i = 10;
		sb.append("Top 10 of countries with highest number of airports :\n");
		for(Long numbersOfCountryAirports : numbersOfCountriesAirports.descendingKeySet())
			for(String code : numbersOfCountriesAirports.get(numbersOfCountryAirports).split(","))
				if(i-- > 0)
					sb.append("\t"+code+":"+numbersOfCountryAirports+"\n");
				else
					break;
		return sb.toString();
	}


}
