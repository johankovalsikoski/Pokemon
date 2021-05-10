package johan.kovalsikoski.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import johan.kovalsikoski.core.helpers.Resource
import johan.kovalsikoski.core.helpers.Status
import johan.kovalsikoski.data.repository.PokemonRepository
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonMinimalInfo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PokemonRepository) : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _pokemonList = MutableLiveData<List<PokemonMinimalInfo>>()
    val pokemonList: LiveData<List<PokemonMinimalInfo>>
        get() = _pokemonList

    private val _failure = MutableLiveData(false)
    val failure: LiveData<Boolean>
        get() = _failure

    private var nextPage = 0

    init {
        fetchPokemonList()
    }

    fun fetchPokemonList() {
        viewModelScope.launch {
            repository.getPokemonList(nextPage).collect {
                handlePokemonListFetchStatus(it)
            }
        }
    }

    private fun handlePokemonListFetchStatus(resource: Resource<List<PokemonMinimalInfo>>) {
        when (resource.status) {
            Status.LOADING -> {
                handleLoadingState()
            }

            Status.SUCCESS -> {
                handlePokemonListFetchState(resource)
            }

            Status.FAILURE -> {
                handleFailureState()
            }
        }
    }

    private fun handlePokemonListFetchState(resource: Resource<List<PokemonMinimalInfo>>) {
        _loading.value = false
        _pokemonList.value = resource.data!!
        nextPage++
    }

    private fun handleFailureState() {
        _loading.value = false
        _failure.value = true
    }

    private fun handleLoadingState() {
        _loading.value = true
        _failure.value = false
    }

}