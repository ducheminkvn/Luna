
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ky/Dropbox/GitHub/LunatechProject/conf/routes
// @DATE:Tue Jul 04 04:47:33 PDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:7
  ControllerQuery_0: controllers.ControllerQuery,
  // @LINE:8
  ControllerReports_3: controllers.ControllerReports,
  // @LINE:14
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:7
    ControllerQuery_0: controllers.ControllerQuery,
    // @LINE:8
    ControllerReports_3: controllers.ControllerReports,
    // @LINE:14
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_1, ControllerQuery_0, ControllerReports_3, Assets_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, ControllerQuery_0, ControllerReports_3, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """query""", """controllers.ControllerQuery.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reports""", """controllers.ControllerReports.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ControllerQuery_index1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("query")))
  )
  private[this] lazy val controllers_ControllerQuery_index1_invoker = createInvoker(
    ControllerQuery_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ControllerQuery",
      "index",
      Nil,
      "POST",
      """""",
      this.prefix + """query"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ControllerReports_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reports")))
  )
  private[this] lazy val controllers_ControllerReports_index2_invoker = createInvoker(
    ControllerReports_3.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ControllerReports",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """reports"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:7
    case controllers_ControllerQuery_index1_route(params) =>
      call { 
        controllers_ControllerQuery_index1_invoker.call(ControllerQuery_0.index)
      }
  
    // @LINE:8
    case controllers_ControllerReports_index2_route(params) =>
      call { 
        controllers_ControllerReports_index2_invoker.call(ControllerReports_3.index)
      }
  
    // @LINE:14
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
