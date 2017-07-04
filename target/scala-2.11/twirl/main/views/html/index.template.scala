
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""
"""),_display_(/*2.2*/main("Welcome to Play")/*2.25*/ {_display_(Seq[Any](format.raw/*2.27*/("""
  """),format.raw/*3.3*/("""<h1>Choose between :</h1>

<body>
	<div>
		<p>
			<form method="post" action="query">
				<input type="text" name="code" value="Country Code or Name"/>
				<input type="submit" value="query"/>
			</form>
		</p>	
		<p> Or </p>
		<p>
			<form action="reports" method="get" >
				<button type="submit">Reports</button>
			</form>
		</p>
	</div>
</body>
""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Jul 03 16:57:08 PDT 2017
                  SOURCE: /home/ky/IdeaProjects/Untitled Folder/Lunatech/app/views/index.scala.html
                  HASH: 29c2cd8451d5750bacca3d9829239b50e15ed39d
                  MATRIX: 738->1|834->3|861->5|892->28|931->30|960->33|1341->384
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|52->21
                  -- GENERATED --
              */
          