package johan.kovalsikoski.data.service

import johan.kovalsikoski.data.serviceModel.pokemonDetail.PokemonDetails
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<PokemonList>

    @GET("pokemon/{pokemon}")
    suspend fun getPokemonDetail(@Path("pokemon") pokemonName: String): Response<PokemonDetails>

    @GET("pokemon/{pokemon}")
    suspend fun getPokemonDetail(@Path("pokemon") pokemonIndex: Int): Response<PokemonDetails>

}