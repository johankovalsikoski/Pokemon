package johan.kovalsikoski.data.serviceModel.pokemonList

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonMinimalInfo>
)