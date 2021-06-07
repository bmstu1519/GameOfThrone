package ru.skillbranch.gameofthrones.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.adapters.CharactersAdapter
import ru.skillbranch.gameofthrones.ui.HouseViewModel
import ru.skillbranch.gameofthrones.util.HouseType


class HouseFragment : Fragment() {
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var viewModel: HouseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val houseName = arguments?.getString(HOUSE_NAME) ?: HouseType.STARK.title
        charactersAdapter = CharactersAdapter {  }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_house, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        with(charactersAdapter){
//            layoutManager = LinearLayoutManager(context)
//            adapter = recyclerAdapter
//        }
    }

    companion object {

        private const val HOUSE_NAME = "house_name"

        @JvmStatic
        fun newInstance(houseName: String) =
                HouseFragment().apply {
                    arguments = bundleOf(HOUSE_NAME to houseName)
                }
    }
}