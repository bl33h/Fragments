package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import gt.uvg.pokelist.repository.PokemonRepository
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R

/* Main class */
class MainFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        /* Main fragment with containers */
        return inflater.inflate(R.layout.mainFrag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        /* Gets the pokemon list from API in the repository */
        val pokemonFinalList = PokemonRepository().getPokemonList()
        /* Recycler view implementation */
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = PokemonListAdapter(pokemonFinalList)
        /* Elements for a better view */
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                view.context,
                /* Vertical settings */
                DividerItemDecoration.VERTICAL
            )
        )
    }

}