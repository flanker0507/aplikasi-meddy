package com.example.aplikasimeddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.aplikasimeddy.R.id.view_pager

class OnboardingActivity : AppCompatActivity() {
    private val onboardContents = listOf(
        IntroSlide(
            R.drawable.img_onboard_1,
            "Pahami ragam obat dan cara pakainya sesuai dengan dosis demi kesehatan anda."
        ),
        IntroSlide(
            R.drawable.img_onboard_2,
            "Tetap jaga konsistensi konsumsi obatmu sesuai dengan anjuran."
        ),
        IntroSlide(
            R.drawable.img_onboard_3,
            "Cari informasi apotek yang terdekat denganmu."
        ),
        IntroSlide(
            R.drawable.img_onboard_4,
            "Konsultasikan kepada kami tentang obat yang ingin Anda Konsumsi."
        )
    )
    private val introSliderAdapter = IntroSliderAdapter(
        onboardContents
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // call view pager layout
        val container: ViewPager2 = findViewById(view_pager)
        // end

        val indicatorContainer: RecyclerView = findViewById(R.id.indicatorRv)
        container.adapter = introSliderAdapter
        indicatorContainer.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        indicatorContainer.adapter = OnBoardIndicatorAdapter(onboardContents.size,
            movePageHandler = {position -> container.setCurrentItem(position)})
        setupIndicators()
        moveLoginActivity()
    }
    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
    }

    private fun moveLoginActivity(){
        val image_view = findViewById<ImageView>(R.id.img_next_btn)
        image_view.setOnClickListener{
            val move = Intent(this, LoginActivity::class.java)
            startActivity(move)
        }
    }
}