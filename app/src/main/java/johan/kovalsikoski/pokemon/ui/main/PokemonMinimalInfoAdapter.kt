package johan.kovalsikoski.pokemon.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import johan.kovalsikoski.data.serviceModel.pokemonList.PokemonMinimalInfo
import johan.kovalsikoski.pokemon.databinding.ItemPokemonMinimalDetailBinding

class PokemonMinimalInfoAdapter :
    RecyclerView.Adapter<PokemonMinimalInfoAdapter.PokemonMinimalInfoViewHolder>() {

    private val pokemonList = mutableListOf<PokemonMinimalInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonMinimalInfoViewHolder {
        return PokemonMinimalInfoViewHolder(
            ItemPokemonMinimalDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun addPokemonList(pokemonList: List<PokemonMinimalInfo>) {
        this.pokemonList.addAll(pokemonList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PokemonMinimalInfoViewHolder, position: Int) {
        holder.bindView(pokemonList[position])
    }

    override fun getItemCount() = pokemonList.size

    inner class PokemonMinimalInfoViewHolder(private val binding: ItemPokemonMinimalDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bindView(pokeInfo: PokemonMinimalInfo) {
                binding.apply {
                    pokemonName.text = pokeInfo.name
                }
            }
    }

}