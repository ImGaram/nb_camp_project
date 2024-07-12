package com.example.applemarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.provider.Settings
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarket.adapter.GoodsAdapter
import com.example.applemarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val onBackPressedCallback: OnBackPressedCallback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // dialog 열기.
            AlertDialog.Builder(this@MainActivity)
                .setIcon(R.drawable.ic_chatting)
                .setTitle("종료")
                .setMessage("정말로 종료하시겠습니까?")
                .setPositiveButton("확인") { dialog, _ ->
                    finish()
                    dialog.dismiss()
                }
                .setNeutralButton("취소") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }
    companion object {
        const val CHANNEL_ID = "AppleMarketNotification"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
        initNotificationPermission()

        val goodsRecyclerView = binding.mainRecyclerViewGoods
        goodsRecyclerView.layoutManager = LinearLayoutManager(this)
        goodsRecyclerView.adapter = GoodsAdapter(this)

        binding.mainImageNotification.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        val channel = NotificationChannel(CHANNEL_ID, "apple market channel", NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = "apple market channel description"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 도착했습니다!!")
        }

        notificationManager.notify(11, builder.build())
    }

    private fun initNotificationPermission() {
        if (VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {
            if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                }
                startActivity(intent)
            }
        }
    }
}