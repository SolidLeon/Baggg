package test;

import static org.junit.Assert.*;

import org.junit.Test;

import baggg.game.BagggComponent;
import baggg.game.Game;

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
	public void testRegisterComponent() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertEquals(3, game.getComponents().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void testRegisterComponentDuplicate() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
	}
	
	@Test
	public void testGetComponentById() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertEquals(expected, game.getComponentById("GPU"));
	}
	
	@Test
	public void testGetComponentByIdNull() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
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
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById("    "));
	}

	
	@Test
	public void testGetComponentByIdNotFound() {
		Game game = new Game();
		BagggComponent expected = new BagggComponent("GPU", 0, 0, 0.0, 100L, 0L, 0L, 0L);
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(expected);
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		assertNull(game.getComponentById("FOO"));
	}

	@Test
	public void testAddComponent() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(2, game.getComponents().size());
	}
	
	@Test
	public void testComponentLevel() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(3, game.getComponentById("CPU").getLevel());
	}
	
	@Test
	public void testGetCurrentSpeed1() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(100L, game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentSpeed2() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, -10L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("CPU");
		assertEquals(100L + -10L * 3, game.getCurrentSpeed());
	}
	
	@Test
	public void testGetCurrentAmount1() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 0L, 50L));
		game.addComponent("CPU");
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(50L, game.getCurrentAmount());
	}

	@Test
	public void testGetCurrentAmount2() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 100L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("RAM");
		game.addComponent("RAM");
		game.addComponent("RAM");
		game.addComponent("RAM");
		assertEquals(50L + 4 * 10L, game.getCurrentAmount());
	}
	
	@Test
	public void testGetBitCoinsMined() {
		Game game = new Game();
		assertEquals(0, game.getBitCoinsMined(0L));
	}
	
	@Test
	public void testGetBitCoinsMined2() {
		Game game = new Game();
		assertEquals(0, game.getBitCoinsMined(60_000L));
	}

	@Test
	public void testGetBitCoinsMined3() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		assertEquals(0, game.getBitCoinsMined(60_000L));
	}

	@Test
	public void testGetBitCoinsMined4() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("RAM");
		assertEquals(0, game.getBitCoinsMined(60_000L));
	}

	@Test
	public void testGetBitCoinsMined5() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(120L, game.getBitCoinsMined(60_000L));
	}

	@Test
	public void testGetBitCoinsMined6() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(0L, game.getBitCoinsMined(25_000L));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testGetBitCoinsMinedInvalid() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.getBitCoinsMined(-1L);
	}

	@Test
	public void testGetElapsedTime() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		assertEquals(0L, game.getElapsedTime());
	}
	
	@Test
	public void testGetElapsedTime2() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(5000L);
		assertEquals(5000L, game.getElapsedTime());
	}
	
	@Test
	public void testGetElapsedTimeWithUpdate() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(60_000L); //remain: 30_000 because update immediatly subtract current speed and does an mining update
		assertEquals(30_000L, game.getElapsedTime());
	}

	@Test
	public void testUpdate() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(60_000L); // 1 update
		assertEquals(60, game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate2() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(60_000L); // 2 updates
		game.update(1_000L); // 2 updates
		assertEquals(120, game.getCurrentBitCoins());
	}

	@Test
	public void testUpdate3() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
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
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(30_000L); // 0 updates
		assertEquals(0, game.getCurrentBitCoins());
	}
	
	@Test
	public void testUpdate5() {
		Game game = new Game();
		game.registerComponent(new BagggComponent("CPU", 0, 0, 0.0, 30_000L, 0L, 0L, 0L));
		game.registerComponent(new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L));
		game.addComponent("CPU");
		game.addComponent("RAM");
		game.update(30_001L); // exact one update
		assertEquals(60, game.getCurrentBitCoins());
	}
}
