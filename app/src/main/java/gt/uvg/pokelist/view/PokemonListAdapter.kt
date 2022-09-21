package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>()
{
    /* Binding settings */
    inner class PokemonListHolder(val binding: pokemonBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder
    {
        val binding = pokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    /* Holder */
    override fun onBindViewHolder(holder: PokemonListHolder, position: Int)
    {
        /* Gets & sets of each pokemon to the object + picasso */
        val item = pokemonList[position]
        holder.binding.pokemonName.text = item.name
        Picasso.get().load(item.imageUrlFront).into(holder.binding.pokemonPhoto)

        /* Action that implements the directions of the main fragment */
        val action = mainDirections.actionMainFragmentToDetailFragment(item)
        holder.binding.root.setOnClickListener{
            holder.itemView.findNavController().navigate(action)
        }
    }

    /* Item count + return of the list size */
    override fun getItemCount(): Int
    {
        return pokemonList.size
    }
}