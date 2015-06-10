package test;

import static org.junit.Assert.*;

import org.junit.Test;

import baggg.game.BagggComponent;
import baggg.game.component.CPUFactory;

public class TestComponent {

	@Test
	public void testEmptyConstructor() {
		BagggComponent c = new BagggComponent();
		assertNull(c.getName());
		assertEquals(0L, c.getAmountPerUpgrade());
		assertEquals(0L, c.getBaseAmount());
		assertEquals(0L, c.getBasePrice());
		assertEquals(0L, c.getBaseSpeed());
		assertEquals(0L, c.getPricePerUpgrade());
		assertEquals(0.0, c.getPricePerUpgradeModifier(), 0.0);
		assertEquals(0L, c.getSpeedPerUpgrade());
		assertEquals(0L, c.getLevel());
	}
	
	@Test
	public void testFullConstructor() {
		BagggComponent c = new BagggComponent("CPU", 100_00L, 25_00L, 1.10, 60_000L, -2000L, 8 * 1024L, 8 * 1024L);
		assertEquals("CPU", c.getName());
		assertEquals(8 * 1024L, c.getAmountPerUpgrade());
		assertEquals(8 * 1024L, c.getBaseAmount());
		assertEquals(100_00L, c.getBasePrice());
		assertEquals(60_000L, c.getBaseSpeed());
		assertEquals(25_00L, c.getPricePerUpgrade());
		assertEquals(1.10, c.getPricePerUpgradeModifier(), 0.0);
		assertEquals(-2_000L, c.getSpeedPerUpgrade());
		assertEquals(0L, c.getLevel());
	}

	@Test
	public void testGetCurrentSpeed() {
		BagggComponent c = new CPUFactory().create();
		assertEquals(0, c.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentSpeedAfterUpgrade() {
		BagggComponent c = new CPUFactory().create();
		c.setLevel(5);
		assertEquals(60_000L + 5L * -2000L, c.getCurrentSpeed());
	}

	@Test
	public void testGetCurrentAmount() {
		BagggComponent c = new CPUFactory().create();
		assertEquals(0, c.getCurrentAmount());
	}

	@Test
	public void testGetCurrentAmountAfterUpgrade() {
		BagggComponent c = new CPUFactory().create();
		c.setLevel(5);
		assertEquals((8 * 1024L) + (8 * 1024) * 5, c.getCurrentAmount());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetLevel() {
		BagggComponent c = new BagggComponent();
		c.setLevel(-100);
	}
	
	@Test
	public void testGetPriceNextUpgrade() {
		BagggComponent c = new CPUFactory().create();
		c.setLevel(5);
		assertEquals(1.771561, c.getPercentage(), 0.0000001);
		assertEquals(14428.9025, c.getRaw(), 0.0001);
		assertEquals(14429L, c.getPriceNextUpgrade());
	}
}
