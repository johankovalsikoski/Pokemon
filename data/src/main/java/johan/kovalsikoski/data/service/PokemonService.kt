package johan.kovalsikoski.data.service

import johan.kovalsikoski.data.serviceModel.pokemonDetail.PokemonDetails
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon?offset={offset}&limit=20")
    suspend fun getPokemonList(@Path("offset") offset: Int): Response<PokemonList>

    @GET("pokemon/{pokemon}")
    suspend fun getPokemonDetail(@Path("pokemon") pokemonName: String): Response<PokemonDetails>

    @GET("pokemon/{pokemon}")
    suspend fun getPokemonDetail(@Path("pokemon") pokemonIndex: Int): Response<PokemonDetails>

}