package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import baggg.game.BagggComponent;
import baggg.game.component.CPUFactory;
import baggg.game.component.IComponentFactory;
import baggg.game.component.RAMFactory;

public class TestComponentFactory {

	@Test
	public void testCPU() {
		IComponentFactory factory = new CPUFactory();
		BagggComponent c = factory.create();
		assertEquals(8 * 1024L, c.getAmountPerUpgrade());
		assertEquals(8 * 1024L, c.getBaseAmount());
		assertEquals(100_00L, c.getBasePrice());
		assertEquals(60_000L, c.getBaseSpeed());
		assertEquals(0L, c.getCurrentAmount());
		assertEquals(0L, c.getCurrentSpeed());
		assertEquals(0L, c.getLevel());
		assertEquals("CPU", c.getName());
		assertEquals(1.10, c.getPercentage(), 0.0);
		assertEquals(127_50L, c.getPriceNextUpgrade());
		assertEquals(25_00L, c.getPricePerUpgrade());
		assertEquals(1.10, c.getPricePerUpgradeModifier(), 0.0);
		assertEquals(127_50.0, c.getRaw(), 0.0);
		assertEquals(-2000L, c.getSpeedPerUpgrade());
	}
	@Test
	public void testRAM() {
		IComponentFactory factory = new RAMFactory();
		BagggComponent c = factory.create();
		assertEquals(10, c.getAmountPerUpgrade());
		assertEquals(50, c.getBaseAmount());
		assertEquals(0, c.getBasePrice());
		assertEquals(0, c.getBaseSpeed());
		assertEquals(0L, c.getCurrentAmount());
		assertEquals(0L, c.getCurrentSpeed());
		assertEquals(0L, c.getLevel());
		assertEquals("RAM", c.getName());
		assertEquals(0.0, c.getPercentage(), 0.0);
		assertEquals(0, c.getPriceNextUpgrade());
		assertEquals(0, c.getPricePerUpgrade());
		assertEquals(0.0, c.getPricePerUpgradeModifier(), 0.0);
		assertEquals(0.0, c.getRaw(), 0.0);
		assertEquals(0, c.getSpeedPerUpgrade());
	}

}
