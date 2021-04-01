package com.me.mygithubuserapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.me.mygithubuserapp.databinding.GithubUserDetailBinding


class GithubUserDetailAdapter : AppCompatActivity() {

    private lateinit var binding: GithubUserDetailBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GithubUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar = supportActionBar
        actionbar!!.title = "User Details"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as GithubUser
        binding.name.text = dataUser.name.toString()
        binding.username.text = dataUser.username.toString()
        binding.company.text = dataUser.company.toString()
        binding.location.text = dataUser.location.toString()
        binding.repo.text = dataUser.repository.toString()
        binding.followerss.text = dataUser.followers.toString()
        binding.followings.text = dataUser.following.toString()
        binding.avatars.setImageResource(dataUser.avatar)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}