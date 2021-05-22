package com.example.viewbindingsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingsample.databinding.RvRowViewBinding

class RVAdapter(private val list: ArrayList<UserModel>) : RecyclerView.Adapter<RVAdapter.RVViewHolder>() {

    class RVViewHolder(binding: RvRowViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        return RVViewHolder(
            RvRowViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        RvRowViewBinding.bind(holder.itemView).apply {
            nameTextView.text = list[position].name
            designationTextView.text = list[position].designation
        }
    }

    override fun getItemCount() = list.count()
}