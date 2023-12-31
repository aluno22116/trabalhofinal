package com.example.trabalhofinal

import android.os.Bundle
import com.example.trabalhofinal.databinding.ActivityPerfilBinding
import com.google.android.material.navigation.NavigationView

class Tarefas : TesteMenu() {
    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            handleMenuItemClick(menuItem.itemId)
        }
    }
}
