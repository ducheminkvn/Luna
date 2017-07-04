package controllers;

import play.mvc.*;
import play.data.DynamicForm;
import play.data.Form;
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
import java.util.Objects;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import codejava.Luna;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ControllerQuery extends Controller {

	/**
	 * Display the query result in application page
	 * @return ok HTTP Code with the result of the query request
	 */
	public Result index() {
		DynamicForm input = Form.form();
	   	input = input.bindFromRequest();
		
	   	String code = input.get("code");
		Luna luna; 
		try{
			luna = new Luna("https://s3-eu-west-1.amazonaws.com/lunatechassessments");
		} catch (IOException io) {
			return ok(io.toString());
			
		}
		return ok(luna.query(code));
	}

}
