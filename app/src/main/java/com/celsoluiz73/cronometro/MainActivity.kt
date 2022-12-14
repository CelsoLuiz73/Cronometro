package com.celsoluiz73.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.celsoluiz73.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            iniciarCronometro()
        }

        binding.btnPausar.setOnClickListener {
            pausarCronometro()
        }

        binding.btnZerar.setOnClickListener {
            zerarCronometro()
        }
    }

    private fun iniciarCronometro() {
        if (!running) {
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true
        }
    }
    private fun pausarCronometro() {
        if (running) {
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun zerarCronometro() {
            binding.cronometro.base = SystemClock.elapsedRealtime()
            pause = 0
    }
}