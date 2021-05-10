package johan.kovalsikoski.data.di

import johan.kovalsikoski.data.repository.PokemonRepository
import johan.kovalsikoski.data.repository.PokemonRepositoryImpl
import johan.kovalsikoski.data.service.PokemonServiceImpl
import johan.kovalsikoski.data.service.RetrofitImpl
import org.koin.dsl.module

private val retrofitModule = module {
    single { RetrofitImpl.provideOkHttpClient() }
    single { RetrofitImpl.provideRetrofit(get()) }
}

private val pokemonServiceModule = module {
    single { PokemonServiceImpl.providePokemonService(get()) }
}

private val pokemonRepository = module {
    factory<PokemonRepository> { PokemonRepositoryImpl(get()) }
}

val dataModules = retrofitModule +
        pokemonServiceModule +
        pokemonRepository