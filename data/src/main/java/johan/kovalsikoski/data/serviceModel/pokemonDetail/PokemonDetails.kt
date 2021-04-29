package johan.kovalsikoski.data.serviceModel.pokemonDetail

data class PokemonDetails(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val species: Species,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)