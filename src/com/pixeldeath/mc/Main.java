package com.pixeldeath.mc;

import org.bukkit.plugin.java.JavaPlugin;

import events.HandleEntityDeathEvent;

/**
 * Class that registers the plugin event and sends message that plugin is working.
 */
public class Main extends JavaPlugin {
	
	/**
	 * Method that runs once MC server is started.
	 */
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new HandleEntityDeathEvent(), this);
		getServer().getConsoleSender().sendMessage("Death animations are now epic!");
	}
	
}
