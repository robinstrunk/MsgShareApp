package com.greemand.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.greemand.msgshareapp.models.Hobby
import com.greemand.msgshareapp.R
import com.greemand.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {

            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " " + context.resources.getString(R.string.clicked))
                }

                }

            itemView.imgShare.setOnClickListener{
                currentHobby?.let {
                    val message: String = context.resources.getString(R.string.my_hobby_is) + currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/Plain"

                    context.startActivity(Intent.createChooser(intent, context.resources.getString(R.string.share_msg_dialog)))
                }


            }
        }
        fun setData(hobby: Hobby?, position: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title

                this.currentHobby = hobby
                this.currentPosition = position
            }

        }
    }
}
