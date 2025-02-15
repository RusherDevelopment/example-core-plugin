package org.example;

import org.rusherhack.client.api.plugin.Plugin;

/**
 * Example rusherhack plugin
 *
 * @author John200410
 */
public class ExamplePlugin extends Plugin {
	
	public static long minecraftInitTime = 0L;
	public static ExamplePlugin INSTANCE;
	
	@Override
	public void onLoad() {
		INSTANCE = this;
		
		this.getLogger().info("Loading example core plugin");
		
		//do stuff like registering modules here
		
	}
	
	@Override
	public void onUnload() {
		this.getLogger().info("Example core plugin unloaded!");
	}
	
}