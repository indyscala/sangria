import sangria.schema._

/**
 * GraphQL schema for our demo vehicle API.
 */
object SchemaDefinition {
  val CountryType = ObjectType(
    "Country",
    "Country might be where a Make is headquartered or where a vehicle is manufactured.",

    fields[Unit, Country](
      Field("name", StringType, resolve = _.value.name),
    )
  )
}
