package johan.kovalsikoski.pokemon.ui.main

import android.graphics.Rect
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import johan.kovalsikoski.core.helpers.MarginItemDecoration
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonMinimalInfo
import johan.kovalsikoski.pokemon.R
import johan.kovalsikoski.pokemon.databinding.ActivityMainBinding
import johan.kovalsikoski.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter: PokemonMinimalInfoAdapter by lazy { PokemonMinimalInfoAdapter() }

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val loadingObserver = Observer<Boolean> { isLoading ->
        if (isLoading) Toast.makeText(this, "Loading data", Toast.LENGTH_SHORT).show()
    }

    private val failureObserver = Observer<Boolean> { errorOccurred ->
        if (errorOccurred) Toast.makeText(this, "Failed to obtain data", Toast.LENGTH_LONG).show()
    }

    private val pokemonListObserver = Observer<List<PokemonMinimalInfo>> { dataset ->
        adapter.addPokemonList(dataset)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        startObservers()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setupList() {
        binding.pokemonMinimalInfo.adapter = adapter
        binding.pokemonMinimalInfo.addItemDecoration(MarginItemDecoration(this, Rect(0,0,0,2)))
    }

    private fun startObservers() {
        viewModel.loading.observe(this, loadingObserver)
        viewModel.failure.observe(this, failureObserver)
        viewModel.pokemonList.observe(this, pokemonListObserver)
    }
}