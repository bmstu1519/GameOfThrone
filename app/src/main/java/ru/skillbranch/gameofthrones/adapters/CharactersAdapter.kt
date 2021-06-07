package ru.skillbranch.gameofthrones.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.character_item.view.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem

class CharactersAdapter(private val listener: (CharacterItem)-> Unit) : RecyclerView.Adapter<CharactersAdapter.CharacterVH>(){

    var items: List<CharacterItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterVH {
        val containerView = LayoutInflater.from(parent.context).inflate(
                R.layout.character_item,parent,false
        )
        return CharacterVH(containerView)
    }

    override fun onBindViewHolder(holder: CharacterVH, position: Int) =
            holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    class CharacterVH(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    fun bind(
            item: CharacterItem,
            listener: (CharacterItem) -> Unit
    ){
        item.name.also {
            containerView.char_name.text = if (it.isBlank()) "Information is unknown" else it
        }

        item.titles
                .plus(item.aliases)
                .filter { it.isNotBlank() }
                .also {
                    containerView.char_titles.text = if (it.isEmpty()) "Information is unknown"
                    else it.joinToString { " + " }
                }
//        containerView.house_icon.setImageResource(item.house.icon)

        itemView.setOnClickListener { listener(item) }
    }
    }
}