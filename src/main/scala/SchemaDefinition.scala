import sangria.schema._

import sangria.macros.derive._

/**
 * GraphQL schema for our demo vehicle API.
 */
object SchemaDefinition {
  implicit val CountryType = ObjectType(
    "Country",
    "Country might be where a Make is headquartered or where a vehicle is manufactured.",

    fields[Unit, Country](
      Field("name", StringType, resolve = _.value.name),
    ),
  )

  val IdentifiableType = InterfaceType(
    "Identifiable",
    "Entity that can be identified",

    fields[Unit, Identifiable](
      Field("id", StringType, resolve = _.value.id),
    ),
  )

  val MakeType = deriveObjectType[Unit, Make](
    Interfaces(IdentifiableType),
    ObjectTypeDescription("The vehicle manufacturer"),
    DocumentField("name", "Name of the manufacturer"),
  )

  val QueryType = ObjectType("Query", fields[CountriesRepository, Unit](
    Field("countries", ListType(CountryType),
      description = Some("Returns a list of all available countries."),
      resolve = _.ctx.countries),
    )
  )

  val schema = Schema(QueryType)
}
