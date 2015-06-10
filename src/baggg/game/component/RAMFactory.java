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
 *    	<td>RAM</td>
 *    	<td>BC 0.00</td>
 *    	<td>BC 0.00</td>
 *    	<td>0%</td>
 *    	<td>0 ms</td>
 *    	<td>-0 ms</td>
 *    	<td>BC 50</td>
 *    	<td>BC 10</td>
 *  </tr>
 * </table>
 * @author SolidLeon
 *
 */
public class RAMFactory implements IComponentFactory {

	@Override
	public BagggComponent create() {
		return new BagggComponent("RAM", 0, 0, 0.0, 0L, 0L, 50L, 10L);
	}

}
