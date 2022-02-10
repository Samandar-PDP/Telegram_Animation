package com.example.telegramanimation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramanimation.model.User

class RecyclerviewAdapter(context: Context, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapter.MyViewHolder, position: Int) {
        val user = userList[position]

        holder.apply {
            roundImage.setImageResource(user.roundImage)
            nickName.text = user.nickName
            msgText.text = user.message
            if (user.countMsg > 0) {
                countMsg.text = user.countMsg.toString()
            } else {
                countMsg.visibility = View.GONE
            }
            if (user.isOnline) {
                isOnlineView.setBackgroundResource(R.drawable.is_online_view)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val roundImage: ImageView = view.findViewById(R.id.item_round_img)
        val nickName: TextView = view.findViewById(R.id.item_nickname)
        val msgText: TextView = view.findViewById(R.id.item_message)
        val countMsg: TextView = view.findViewById(R.id.text_count)
        val isOnlineView: View = view.findViewById(R.id.is_online_view)
        private val timeText: TextView = view.findViewById(R.id.item_time)

        init {
            timeText.text = Time.timeStamp()
        }
    }
}