package io.github.lucystudio.example

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    // MAIN INSTANCE
    companion object{
        lateinit var instance: Main
    }
    init {
        instance = this
    }

    override fun onEnable() {
        println("ExamplePlugin이 활성화되었습니다.")
    }

    override fun onDisable() {
        println("ExamplePlugin이 비활성화됩니다.")
    }
}