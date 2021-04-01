package com.me.mygithubuserapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.me.mygithubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<GithubUser> = ArrayList()
    private var title: String = "Github users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        setActionBarTitle(title)
        binding.rvHeroes.setHasFixedSize(true)
        binding.rvHeroes.addItemDecoration(
            DividerItemDecoration(
                binding.rvHeroes.context,
                DividerItemDecoration.HORIZONTAL
            )
        )
        list.addAll(GithubUserData.listData)
        showRecycleList()


    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    private fun showRecycleList() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val githubUserAdapter = GithubUserAdapter(list)
        binding.rvHeroes.adapter=githubUserAdapter

        githubUserAdapter.setOnItemClickCallback(object : GithubUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedData(data)
            }
        })

    }
    private fun showSelectedData(data: GithubUser) {
        val dataUser = GithubUser(
            data.username,
            data.name,
            data.avatar,
            data.company,
            data.location,
            data.repository,
            data.followers,
            data.following
        )

        val intentDetail = Intent(this@MainActivity, GithubUserDetailAdapter::class.java)
        intentDetail.putExtra(GithubUserDetailAdapter.EXTRA_DATA, dataUser)
        startActivity(intentDetail)
    }


}