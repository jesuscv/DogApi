package com.jecruzv.dogapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jecruzv.dogapi.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var adapter: CharactersAdapter
    private lateinit var _characters:Characters

    private val binding get() = _binding!!
    private fun loadBreedsList() {
        GlobalScope.launch(Dispatchers.Main) {
            val webResponse = RetrofitClient.clientApi.charactersAsync().await()

            if (webResponse.isSuccessful) {
                val charactersList : Characters? = webResponse.body()
                charactersList?.toString()?.let { Log.d("LIST", it) }

                adapter= CharactersAdapter(charactersList!!)

                if (charactersList != null) {
                    adapter.partItemList = charactersList
                    _characters=charactersList

                }
                binding.rvParts.adapter = adapter
                adapter.notifyDataSetChanged()
            } else {
                Log.d("error", "Error ${webResponse.code()}")
                Toast.makeText(context, "Error ${webResponse.code()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.rvParts.layoutManager = LinearLayoutManager(context)
        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        binding.rvParts.setHasFixedSize(true)

        // Create the PartAdapter
        // 1st parameter: our generated testData. listOf() generates empty list with correct type
        // 2nd parameter: item click handler function (implemented below) as function parameter
        //adapter = CharactersAdapter(). { partItem: Characters -> partItemClicked(partItem) }
        loadBreedsList()

    }

    private fun partItemClicked(partItem : Characters) {
        // Test code to add a new item to the list
        // Will be replaced with UI function soon
        //val newPart = PartData(Random.nextLong(0, 999999), "Infrared sensor")
        //addPart(newPart)
        //return

        Toast.makeText(context, "Clicked: ${partItem.info}", Toast.LENGTH_LONG).show()

        // Launch second activity, pass part ID as string parameter
        //val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
        //showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
        //showDetailActivityIntent.putExtra("ItemId", partItem.id)
        //showDetailActivityIntent.putExtra("ItemName", partItem.itemName)
        //startActivity(showDetailActivityIntent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}