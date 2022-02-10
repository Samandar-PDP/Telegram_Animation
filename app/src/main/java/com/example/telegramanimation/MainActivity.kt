package com.example.telegramanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieAnimationView
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var lottieAnim: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val dots: WormDotsIndicator = findViewById(R.id.dots)
        val startText: TextView = findViewById(R.id.start_text_main)
        lottieAnim = findViewById(R.id.lottie_anim)
        startText.setOnClickListener {
            intent()
            finish()
        }
        val titles = listOf(
            "Telegram X",
            "Fast",
            "Free",
            "Powerful",
            "Secure",
            "Cloud-Based"
        )
        val contents = listOf(
            "The world's fastest messaging app.\nIt is free and secure",
            "Telegram delivers messages faster than any other application.",
            "Telegram is free forever. No ads. No subscription fees.",
            "Telegram has no limits on the size of your media and chats",
            "Telegram keeps your messages safe from hacker attacks.",
            "Telegram lets you access your messages from multiple devices."
        )

        val adapter = MyAdapter(this, titles, contents)
        viewPager.adapter = adapter
        dots.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                when (position) {
                    0 -> {
                        lottieAnim.setAnimation(R.raw.telegram_icon)

                    }
                    1 -> {
                        lottieAnim.setAnimation(R.raw.speedometer)

                    }
                    2 -> {
                        lottieAnim.setAnimation(R.raw.gift)

                    }
                    3 -> {
                        lottieAnim.setAnimation(R.raw.powerful)

                    }
                    4 -> {
                        lottieAnim.setAnimation(R.raw.security)

                    }
                    5 -> {
                        lottieAnim.setAnimation(R.raw.cloud_bases)

                    }
                }
                lottieAnim.playAnimation()
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
    private fun intent() {
        val intent = Intent(this,UserActivity::class.java)
        startActivity(intent)
    }
}