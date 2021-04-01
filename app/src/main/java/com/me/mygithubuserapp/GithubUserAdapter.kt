package com.me.mygithubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.me.mygithubuserapp.databinding.GithubUserListBinding
import de.hdodenhof.circleimageview.CircleImageView

class GithubUserAdapter(private val listData: ArrayList<GithubUser>) :
    RecyclerView.Adapter<GithubUserAdapter.ListDataHolder>() {
    inner class ListDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GithubUserListBinding.bind(itemView)

        var imageAvatar: CircleImageView = binding.avatar
        var name: TextView = binding.userName
        var username: TextView = binding.username
        var followers: TextView = binding.followers
        var following: TextView = binding.following
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUser)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListDataHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.github_user_list, viewGroup, false)
        return ListDataHolder(view)
    }

    override fun getItemCount(): Int = listData.size


    override fun onBindViewHolder(holder: ListDataHolder, position: Int) {
        val data = listData[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.imageAvatar)
        holder.name.text = data.name
        holder.username.text = data.username
        holder.followers.text = data.followers.toString().trim()
        holder.following.text = data.following.toString().trim()
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
        }


    }


}