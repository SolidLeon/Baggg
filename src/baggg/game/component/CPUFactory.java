package baggg.game.component;

import baggg.game.BagggComponent;

/**
 * <table>
 * 	<tr>
 * 		<th>ID</th>
 * 		<th>Base Price</th>
 * 		<th>Price per upgrade</th>
 * 		<th>Price Modifier</th>
 * 		<th>Base speed</th>
 * 		<th>Speed per upgrade</th>
 * 		<th>Base amount</th>
 * 		<th>Amount per upgrade</th>
 * 	</tr>
 *  <tr>
 *    	<td>CPU</td>
 *    	<td>BC 100.00</td>
 *    	<td>BC 25.00</td>
 *    	<td>110%</td>
 *    	<td>60,000 ms</td>
 *    	<td>-2,000 ms</td>
 *    	<td>BC 8,192.-</td>
 *    	<td>BC 8,192.-</td>
 *  </tr>
 * </table>
 * @author SolidLeon
 *
 */
public class CPUFactory implements IComponentFactory {
	@Override
	public BagggComponent create() {
		BagggComponent c = new BagggComponent("CPU", 100_00L, 25_00L, 1.10, 60_000L, -2000L, 8 * 1024L, 8 * 1024L);
		return c;
	}
}
