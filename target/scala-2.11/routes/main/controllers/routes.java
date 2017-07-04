
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ky/Dropbox/GitHub/LunatechProject/conf/routes
// @DATE:Mon Jul 03 22:32:29 PDT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseControllerReports ControllerReports = new controllers.ReverseControllerReports(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseControllerQuery ControllerQuery = new controllers.ReverseControllerQuery(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseControllerReports ControllerReports = new controllers.javascript.ReverseControllerReports(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseControllerQuery ControllerQuery = new controllers.javascript.ReverseControllerQuery(RoutesPrefix.byNamePrefix());
  }

}
