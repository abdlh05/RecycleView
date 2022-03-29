package com.blogspot.codesgram.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.codesgram.recycleview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //private var rvHeroes : RecyclerView? = null
    private lateinit var binding : ActivityMainBinding
    var list: ArrayList<Hero> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHero.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecyclerList();

    }

    private fun showRecyclerList() {
        binding.rvHero.setLayoutManager(LinearLayoutManager(this))
        val listHeroAdapter = ListHeroAdapter(list)
        binding.rvHero.setAdapter(listHeroAdapter)
    }

    private fun showRecyclerGrid() {
        binding.rvHero.setLayoutManager(GridLayoutManager(this, 2))
        val gridHeroAdapter = GridHeroAdapter(list)
        binding.rvHero.setAdapter(gridHeroAdapter)
    }

    private fun showRecyclerCard() {
        binding.rvHero.setLayoutManager(LinearLayoutManager(this))
        val cardHeroAdapter = CardHeroAdapter(list)
        binding.rvHero.setAdapter(cardHeroAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }


    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
              showRecyclerList()
            }


            R.id.action_grid -> {
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                showRecyclerCard()
            }
        }
    }


}