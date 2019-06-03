class CountriesRepository {
  private val Countries = List(
    Country("United States"),
    Country("Japan"),
    Country("Germany"),
  )

  def countries: List[Country] = Countries
}
