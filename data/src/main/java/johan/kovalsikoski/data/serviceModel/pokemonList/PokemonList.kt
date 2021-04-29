package johan.kovalsikoski.data.serviceModel.pokemonList

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonMinimalInfo>
)