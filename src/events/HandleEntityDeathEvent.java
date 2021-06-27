package events;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/*
 * Class that handles what happens when an entity dies and triggers the new death effect.
 */
public class HandleEntityDeathEvent implements Listener {
	
	/**
	 * Handles what happens as an entity dies. Cancels the default death effect and replaces it with new particles. Mob drops are unchanged/unaffected.
	 * @param event the event that occurred
	 */
	@EventHandler
	public static void OnEntityDeath(EntityDeathEvent event)  {
		
		// use this line to only change the death effect for certain entity types
		// the enderdragon death effect is also kept as the MC default
		if (!event.getEntityType().equals(EntityType.ENDER_DRAGON)/* && event.getEntityType().equals(EntityType.VILLAGER)*/) {
			// get entity that was killed
			LivingEntity killedEntity = (LivingEntity) event.getEntity();
			// get location of entity
			Location entityLocation = killedEntity.getLocation();
			// spawn 1000 particles where the entity died
			// force parameter is set to true, so particles will render at larger distances
			killedEntity.getWorld().spawnParticle(
					Particle.DRIP_LAVA,
					entityLocation.getX(),
					entityLocation.getY()+killedEntity.getHeight()/2,
					entityLocation.getZ(),
					1000,
					killedEntity.getWidth()/2,
					killedEntity.getHeight()/4,
					killedEntity.getWidth()/2,
					5,
					null,
					true
			);
			// remove the entity - also cancels the default death effect
			killedEntity.remove();
			return;
		}
	}
	
}
