package com.example.telegramanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramanimation.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    private lateinit var recyclerviewAdapter: RecyclerviewAdapter
    private lateinit var recyclerView: RecyclerView
    private val userList: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        initViews()

    }

    private fun initViews() {
        val floatingFab: FloatingActionButton = findViewById(R.id.floating_fab)
        recyclerView = findViewById(R.id.recyclerview_user)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerviewAdapter = RecyclerviewAdapter(this, userList())
        recyclerView.adapter = recyclerviewAdapter
        floatingFab.setOnClickListener {
            val snackBar = Snackbar.make(it,"It's Telegram!",Snackbar.LENGTH_LONG)
                snackBar.show()
        }
    }

    private fun userList(): ArrayList<User> {
        userList.add(User(R.drawable.kane, "Kane", "Hello", 8, true))
        userList.add(User(R.drawable.holland, "Holland", "Hallo", 0, false))
        userList.add(User(R.drawable.benzema, "Benzema", "Banjour", 2, false))
        userList.add(User(R.drawable.messi, "Messi", "Uno", 3, true))
        userList.add(User(R.drawable.mpabbe, "Mbappe", "Banjour", 1, false))
        userList.add(User(R.drawable.son_, "Son", "Annyong", 5, true))
        userList.add(User(R.drawable.ronaldo, "Ronaldo", "Una", 0, false))
        userList.add(User(R.drawable.salah, "Salah", "Assalamu Alaykum", 2, true))
        userList.add(User(R.drawable.neymar, "Neymar", "Uno", 0, true))

        return userList
    }
}