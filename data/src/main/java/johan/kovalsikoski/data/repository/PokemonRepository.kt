package johan.kovalsikoski.data.repository

import johan.kovalsikoski.core.helpers.Resource
import johan.kovalsikoski.data.serviceModel.pokemonDetail.PokemonDetails
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonList
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonMinimalInfo
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(offset: Int): Flow<Resource<List<PokemonMinimalInfo>>>

    fun getPokemon(pokemon: String): Flow<Resource<PokemonDetails?>>

    fun getPokemon(pokemon: Int): Flow<Resource<PokemonDetails?>>

}