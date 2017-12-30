package rest.recommendation;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.ItemBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import rest.connection.Connection;

public class ItemBasedRec {
	static Connection conn = new Connection();
	static RecombeeClient client = conn.createRecombeeClient();
	
	
	public static Recommendation[] recommend(String itemId, int count, String targetUserId, String filter, boolean returnProperties) throws ApiException {
		Recommendation[] result = client.send(new ItemBasedRecommendation(itemId, count)
				.setTargetUserId(targetUserId)
				.setFilter(filter)
				.setScenario("user-based")
				.setReturnProperties(returnProperties));
		return result;	
	}
}
