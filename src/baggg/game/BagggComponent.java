package baggg.game;

import java.util.HashMap;
import java.util.Map;

public class BagggComponent {

	private String name; 
	private long basePrice; 
	private long pricePerUpgrade; 
	private double pricePerUpgradeModifier; 
	private long baseSpeed; 
	private long speedPerUpgrade; 
	private long baseAmount; 
	private long amountPerUpgrade;
	private long level = 0L;
	
	public BagggComponent(String name, long basePrice, long pricePerUpgrade, double pricePerUpgradeModifier, long baseSpeed, long speedPerUpgrade, long baseAmount, long amountPerUpgrade) {
		this.name = name;
		this.basePrice = basePrice;
		this.pricePerUpgrade = pricePerUpgrade;
		this.pricePerUpgradeModifier = pricePerUpgradeModifier;
		this.baseSpeed = baseSpeed;
		this.speedPerUpgrade = speedPerUpgrade;
		this.baseAmount = baseAmount;
		this.amountPerUpgrade = amountPerUpgrade;
	}

	public BagggComponent() {
	}

	public String getName() {
		return name;
	}

	public long getBasePrice() {
		return basePrice;
	}

	public long getPricePerUpgrade() {
		return pricePerUpgrade;
	}

	public double getPricePerUpgradeModifier() {
		return pricePerUpgradeModifier;
	}

	public long getBaseSpeed() {
		return baseSpeed;
	}

	public long getSpeedPerUpgrade() {
		return speedPerUpgrade;
	}

	public long getBaseAmount() {
		return baseAmount;
	}

	public long getAmountPerUpgrade() {
		return amountPerUpgrade;
	}

	public long getLevel() {
		return level;
	}
	
	public void setLevel(long level) {
		if (level < 0)
			throw new IllegalArgumentException("level must be zero or positive");
		this.level = level;
	}

	public long getCurrentSpeed() {
		if (level == 0)
			return 0L;
		long speed = baseSpeed + speedPerUpgrade * level;
		if (speed < 1)
			speed = 1;
		return speed;
	}

	public long getCurrentAmount() {
		return level == 0 ? 0L : baseAmount + amountPerUpgrade * level;
	}

	// PRICE EQUATION BREAK DOWN
	public double getPercentage() {
		return Math.pow(pricePerUpgradeModifier, level + 1);
	}
	
	public double getRaw() {
		return basePrice + pricePerUpgrade * getPercentage();
	}
	
	public long getPriceNextUpgrade() {
		return (long) Math.ceil(getRaw());
	}
	
}
