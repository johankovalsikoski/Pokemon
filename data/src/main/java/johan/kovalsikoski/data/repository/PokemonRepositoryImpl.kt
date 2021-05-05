package johan.kovalsikoski.data.repository

import johan.kovalsikoski.core.helpers.Resource
import johan.kovalsikoski.data.service.PokemonService
import johan.kovalsikoski.data.serviceModel.pokemonDetail.PokemonDetails
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonMinimalInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepositoryImpl(
    private val service: PokemonService,
) : PokemonRepository {

    override fun getPokemonList(offset: Int): Flow<Resource<List<PokemonMinimalInfo>>> {
        return flow<Resource<List<PokemonMinimalInfo>>> {
            emit(Resource.loading())

            val response = service.getPokemonList(offset * 20)

            if (response.isSuccessful) {
                emit(Resource.success(response.body()?.results ?: listOf()))
            } else {
                emit(Resource.failure("HTTP Code: ${response.code()}\nMessage:${response.message()}"))
            }

        }.flowOn(Dispatchers.IO)

    }

    override fun getPokemon(pokemon: String): Flow<Resource<PokemonDetails?>> {
        return flow<Resource<PokemonDetails?>> {
            emit(Resource.loading())

            val response = service.getPokemonDetail(pokemon)


            if (response.isSuccessful) {
                emit(Resource.success(response.body()))
            } else {
                emit(Resource.failure("HTTP Code: ${response.code()}\nMessage:${response.message()}"))
            }

        }.flowOn(Dispatchers.IO)

    }

    override fun getPokemon(pokemon: Int): Flow<Resource<PokemonDetails?>> {
        return flow<Resource<PokemonDetails?>> {
            emit(Resource.loading())

            val response = service.getPokemonDetail(pokemon)

            if (response.isSuccessful) {
                emit(Resource.success(response.body()))
            } else {
                emit(Resource.failure("HTTP Code: ${response.code()}\nMessage:${response.message()}"))
            }

        }.flowOn(Dispatchers.IO)

    }

}