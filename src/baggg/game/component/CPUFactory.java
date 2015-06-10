package baggg.game.component;

import baggg.game.BagggComponent;

public class CPUFactory implements IComponentFactory {
	@Override
	public BagggComponent create() {
		BagggComponent c = new BagggComponent("CPU", 100_00L, 25_00L, 1.10, 60_000L, -2000L, 8 * 1024L, 8 * 1024L);
		return c;
	}
}
