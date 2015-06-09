package baggg.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<BagggComponent> components = new ArrayList<>();
	private long elapsedTime;
	private long currentBitCoins = 0L;
	
	public long getCurrentAmount() {
		long amount = 0L;
		for (BagggComponent c : components)
			amount += c.getCurrentAmount();
		return amount;
	}

	public long getCurrentSpeed() {
		long speed = 0L;
		for (BagggComponent c : components)
			speed += c.getCurrentSpeed();
		return speed;
	}

	public BagggComponent getComponentById(String id) {
		if (id == null || (id = id.trim()).isEmpty())
			return null;
		for (BagggComponent c : components)
			if (c.getName().equals(id))
				return c;
		return null;
	}
	
	public boolean addComponent(String id) {
		BagggComponent c = getComponentById(id);
		if (c != null) {
			c.setLevel(c.getLevel() + 1);
			return true;
		}
		return false;
	}

	public void registerComponent(BagggComponent bagggComponent) {
		if (getComponentById(bagggComponent.getName()) == null)
			components.add(bagggComponent);
		else 
			throw new RuntimeException("Component already registered");
	}
	
	public List<BagggComponent> getComponents() {
		return components;
	}

	public long getBitCoinsMined(long deltaTime) {
		if (deltaTime < 0)
			throw new IllegalArgumentException("deltaTime must be >= 0");
		
		long result = 0L;
		if (deltaTime > 0) {
			long speed = getCurrentSpeed();
			if (speed > 0) {
				long n = deltaTime / getCurrentSpeed();
				if (n > 0) {
					result = n * getCurrentAmount();
				}
			}
		}
		return result;
	}
	
	public void update(long deltaTime) {
		if (deltaTime < 0)
			throw new IllegalArgumentException("deltaTime must be >= 0");
		elapsedTime += deltaTime;
		long speed = getCurrentSpeed();
		while (elapsedTime > speed) {
			elapsedTime -= speed;
			currentBitCoins += getCurrentAmount();
		}
	}
	
	public long getElapsedTime() {
		return elapsedTime;
	}

	public long getCurrentBitCoins() {
		return currentBitCoins;
	}
}

