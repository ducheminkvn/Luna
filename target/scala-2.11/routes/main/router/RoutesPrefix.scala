
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ky/Dropbox/GitHub/LunatechProject/conf/routes
// @DATE:Mon Jul 03 22:32:29 PDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
