package com.example.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.databinding.ItemRvBinding

class RvAdapter(val context:Context, val list:List<String> , val rvAction: RvAction) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(str:String){
            val animation = AnimationUtils.loadAnimation(context, R.anim.my_rv_anim)
            itemRvBinding.root.startAnimation(animation)
            itemRvBinding.tvItem.text = str
            itemRvBinding.root.setOnLongClickListener{
               rvAction.delateItem(position, str)
               true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size

    }
    interface RvAction {
        fun delateItem(position: Int, str: String)
    }
}
