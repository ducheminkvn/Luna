package utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import webapps.Airport;
import webapps.Country;
import webapps.Runway;

public class Parse {
	/**
	 * Extract the data in the file path in parameter to a String with this data
	 * @param pathFile
	 * @return String with this data contend in the file target by pathFile
	 * @throws IOException
	 */
	public static String parseFileToString(Path pathFile) throws IOException{
		StringBuilder sb = new StringBuilder();
		try(Stream<String> lines = Files.lines(pathFile)){
			lines.forEach(x -> sb.append(x+"\n"));
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	/**
	 * Extract the data in the url path construct with the urlName in parameter to a String with this data
	 * @param urlName
	 * @return String
	 * @throws IOException
	 */
	public static String parseFileToURL(String urlName) throws IOException{
		StringBuilder sb = new StringBuilder();
		int value;
		InputStream stream = new URL(urlName).openStream();
		while((value = stream.read()) != -1)
			sb.append((char)value);
		stream.close();
		return sb.toString();
	}
	/**
	 * Parse all airports data From one String contained this data
	 * @param data
	 * @return List<Airport>
	 * @throws IOException
	 */
	public static List<Airport> parseAirports(String data) throws IOException{

		boolean isFirst = true;
		data = data.replaceAll("\"", "");
		ArrayList<Airport> list = new ArrayList<>();
		String[] tokens = data.split("\n");
		for(String str : tokens) {
			if(isFirst) {
				isFirst = false;
				continue;
			}
			String[] values = str.split(",",18);
			list.add(new Airport(values[0],values[1],values[2],values[3],
					values[4],values[5],values[6],values[7],
					values[8],values[9],values[10],values[11],
					values[12],values[13],values[14],values[15],
					values[16],values[17]));
		}
		return list;
	}
	/**
	 * Parse all countries data From one String contained this data
	 * @param data
	 * @return List<Country>
	 * @throws IOException
	 */
	public static List<Country> parseCountries(String data) throws IOException{

		boolean isFirst = true;
		data = data.replaceAll("\"", "");
		ArrayList<Country> list = new ArrayList<>();
		String[] tokens = data.split("\n");
		for(String str : tokens) {
			if(isFirst) {
				isFirst = false;
				continue;
			}
			String[] values = str.split(",",6);
			list.add(new Country(values[0],values[1],values[2],values[3],
					values[4],values[5]));
		}
		return list;
	}
	/**
	 * Parse all runways data From one String contained this data
	 * @param data
	 * @return List<Runway>
	 * @throws IOException
	 */
	public static List<Runway> parseRunways(String data) throws IOException{

		boolean isFirst = true;
		data = data.replaceAll("\"", "");
		ArrayList<Runway> list = new ArrayList<>();
		String[] tokens = data.split("\n");
		for(String str : tokens) {
			if(isFirst) {
				isFirst = false;
				continue;
			}
			String[] values = str.split(",",20);
			list.add(new Runway(values[0],values[1],values[2],values[3],
					values[4],values[5],values[6],values[7],
					values[8],values[9],values[10],values[11],
					values[12],values[13],values[14],values[15],
					values[16],values[17],values[18],values[19]));
		}
		return list;
	}

}

