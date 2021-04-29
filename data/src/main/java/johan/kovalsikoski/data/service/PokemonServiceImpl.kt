package johan.kovalsikoski.data.service

import retrofit2.Retrofit

class PokemonServiceImpl {

    companion object {
        fun providePokemonService(retrofit: Retrofit): PokemonService =
            retrofit.create(PokemonService::class.java)
    }

}