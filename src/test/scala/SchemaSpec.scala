import org.scalatest._
import io.circe.Json
import sangria.execution._
import sangria.macros._
import sangria.marshalling.circe._
import sangria.renderer.SchemaRenderer

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class SchemaSpec extends FlatSpec with Matchers {
  "schema definition" should "be renderable" in {
    println(SchemaRenderer.renderSchema(SchemaDefinition.schema))
  }

  "countries query" should "list countries" in {
    val query = graphql"""
      query AllCountries {
        countries {
          name
        }
      }"""

    val f: Future[Json] = Executor.execute(SchemaDefinition.schema, query, new CountriesRepository)

    val json = Await.result(f, 2 seconds)
    println(json)
  }
}
