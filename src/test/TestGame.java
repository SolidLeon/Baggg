package test;

import static org.junit.Assert.*;

import org.junit.Test;

import baggg.game.BagggComponent;
import baggg.game.Game;
import baggg.game.component.CPUFactory;
import baggg.game.component.RAMFactory;

public class TestGame {

	@Test
	public void testGetCurrentAmount() {
		Game game = new Game();
		assertEquals(0L, game.getCurrentAmount());
	}

	@Test
	public void testGetCurrentSpeed() {
		Game game = new Game();
		assertEquals(0L, game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentSpeedOneComponent() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.addComponent("CPU");
		assertEquals(game.getComponentById("CPU").getCurrentSpeed(), game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentSpeedTwoComponent() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(game.getComponentById("CPU").getCurrentSpeed(), game.getCurrentSpeed());
	}

	@Test
	public void testRegisterComponent() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertEquals(3, game.getComponents().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void testRegisterComponentDuplicate() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
	}
	
	@Test
	public void testGetComponentById() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertEquals(expected, game.getComponentById("GPU"));
	}
	
	@Test
	public void testGetComponentByIdNull() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById(null));
	}
	
	@Test
	public void testGetComponentByIdEmpty() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById(""));
	}

	
	@Test
	public void testGetComponentByIdTrimEmpty() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById("    "));
	}

	
	@Test
	public void testGetComponentByIdNotFound() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById("FOO"));
	}

	@Test
	public void testAddComponent() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(2, game.getComponents().size());
	}
	
	@Test
	public void testComponentLevel() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(3, game.getComponentById("CPU").getLevel());
	}
	
	@Test
	public void testGetCurrentSpeed1() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(game.getComponentById("CPU").getCurrentSpeed(), game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentSpeed2() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(game.getComponentById("CPU").getCurrentSpeed(), game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentAmount1() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(game.getComponentById("RAM").getCurrentAmount() + game.getComponentById("CPU").getCurrentAmount(), game.getCurrentAmount());
	}

	@Test
	public void testGetCurrentAmount2() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("RAM");
		game.addComponent("RAM");
		game.addComponent("RAM");
		game.addComponent("RAM");
		assertEquals(50L + 4 * 10L, game.getCurrentAmount());
	}
	
	@Test
	public void testGetBitCoinsMined_Min() {
		Game game = new Game();
		assertEquals(0, game.getBitCoinsMined(0L));
	}
	
	@Test
	public void testGetBitCoinsMined_FullCycle() {
		Game game = new Game();
		assertEquals(0, game.getBitCoinsMined(60_000L));
	}

	@Test
	public void testGetBitCoinsMined_NoFullCycle() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		assertEquals(0, game.getBitCoinsMined(30_000L));
	}

	@Test
	public void testGetBitCoinsMined() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new RAMFactory().create());
		game.addComponent("RAM");
		long elapsed = 60_000L;
		double updates = elapsed / game.getCurrentSpeed();
		int iu = (int) updates;
		assertEquals(game.getCurrentAmount() * iu, game.getBitCoinsMined(elapsed));
	}

	/**
	 * <h3>Test {@link Game#getBitCoinsMined(long)}</h3>
	 * <p>
	 * Setup:
	 * <ul>
	 * 	<li>x1 {@link CPUFactory#create()}</li>
	 * 	<li>x1 RAM</li>
	 * 	<li>120,001 ms elapsed time -> current speed should be 60,000 ms due to CPU, so we have two bitcoin gains</li>
	 * </ul>
	 * </p>
	 * <p>
	 * The combined {@link BagggComponent#getCurrentAmount()} times 2 of both components should be returned from {@link Game#getBitCoinsMined(long)}
	 * </p> 
	 */
	@Test
	public void testGetBitCoinsMined5() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		long earningsCPU = game.getComponentById("CPU").getCurrentAmount();
		long earningsRAM = game.getComponentById("RAM").getCurrentAmount();
		assertEquals(2 * (earningsCPU + earningsRAM), game.getBitCoinsMined(120_001L));
	}

	@Test
	public void testGetBitCoinsMined6() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(0L, game.getBitCoinsMined(25_000L));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testGetBitCoinsMinedInvalid() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getBitCoinsMined(-1L);
	}

	@Test
	public void testGetElapsedTime() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(0L, game.getElapsedTime());
	}
	
	@Test
	public void testGetElapsedTime2() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(5000L);
		assertEquals(5000L, game.getElapsedTime());
	}
	
	@Test
	public void testGetElapsedTimeWithUpdate() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(60_000L); //remain: 30_000 because update immediatly subtract current speed and does an mining update
		assertEquals(60_000L - game.getCurrentSpeed(), game.getElapsedTime());
	}

	@Test
	public void testUpdate() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(60_000L); // 1 update
		assertEquals(game.getComponentById("CPU").getCurrentAmount() + game.getComponentById("RAM").getCurrentAmount(), game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate2() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(game.getCurrentSpeed()); //this call does not generate an update, since the elapsed time is <= speed and not > speed
		game.update(100); // some arbritary number to issue an update
		long earningsPerUpdate = game.getCurrentAmount();
		assertEquals(earningsPerUpdate, game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate3() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(1_000); // 0 updates
		game.update(1_000L); // 0 updates
		assertEquals(0, game.getCurrentBitCoins());
	}
	@Test
	public void testUpdate4() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(30_000L); // 0 updates
		assertEquals(0, game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate5() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		int updates = 1;
		game.update(updates * game.getCurrentSpeed() + 1); // 2 updates
		long earningsPerUpdate = game.getCurrentAmount();
		assertEquals(updates * earningsPerUpdate, game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate6() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		int updates = 2;
		game.update(updates * game.getCurrentSpeed() + 1); // 2 updates
		long earningsPerUpdate = game.getCurrentAmount();
		assertEquals(updates * earningsPerUpdate, game.getCurrentBitCoins());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUpdateNegative() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(-1); // exact one update
	}
	
	@Test
	public void testSetCurrentBitCoinsMin() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(0);
		assertEquals(0, game.getCurrentBitCoins());
	}

	@Test
	public void testSetCurrentBitCoinsMid() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(100);
		assertEquals(100, game.getCurrentBitCoins());
	}

	@Test
	public void testSetCurrentBitCoinsMax() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(Long.MAX_VALUE);
		assertEquals(Long.MAX_VALUE, game.getCurrentBitCoins());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSetCurrentBitCoins() {
		Game game = new Game();
		game.registerComponent(new CPUFactory().create());
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(-500);
	}

	@Test
	public void testBuyUpgradeInsufficientBC() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(0);
		assertFalse(game.buyUpgrade("CPU"));
	}

	@Test
	public void testBuyUpgradeOK() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.setCurrentBitCoins(14429L);
		assertTrue(game.buyUpgrade("CPU"));
	}
	@Test
	public void testBuyUpgradeOKLevel() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getComponentById("CPU").setLevel(5);
		game.setCurrentBitCoins(14429L);
		game.buyUpgrade("CPU");
		assertEquals(6L, game.getComponentById("CPU").getLevel());
	}

	@Test
	public void testBuyUpgradeOKBitCoins() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getComponentById("CPU").setLevel(5);
		game.setCurrentBitCoins(14429L);
		game.buyUpgrade("CPU");
		assertEquals(0L, game.getCurrentBitCoins());
	}
	
	@Test
	public void testBuyUpgradeInvalidID() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getComponentById("CPU").setLevel(5);
		game.setCurrentBitCoins(14429L);
		assertFalse(game.buyUpgrade("FOO"));
	}
	

	@Test
	public void testBuyUpgradeInvalidID2() {
		BagggComponent c = new CPUFactory().create();
		Game game = new Game();
		game.registerComponent(c);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getComponentById("CPU").setLevel(5);
		game.setCurrentBitCoins(14429L);
		assertFalse(game.buyUpgrade(null));
	}

}
