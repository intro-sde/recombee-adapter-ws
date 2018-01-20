package rest.recommendation;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.ItemBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import rest.connection.Connection;

public class ItemBasedRec {
	static RecombeeClient client = Connection.createRecombeeClient();
	
	
	public static Recommendation[] recommend(String itemId, int count, String targetUserId, double userImpact, String filter, String[] includedProperties) throws ApiException {
		Recommendation[] result = client.send(new ItemBasedRecommendation(itemId, count)
				.setTargetUserId(targetUserId)
				.setFilter(filter)
				.setUserImpact(userImpact)
				.setScenario("item-based")
				.setReturnProperties(true)
				.setIncludedProperties(includedProperties));
		return result;	
	}
	
	public static Recommendation[] recommend(String itemId, int count, String targetUserId) throws ApiException {
		Recommendation[] result = client.send(new ItemBasedRecommendation(itemId, count)
				.setTargetUserId(targetUserId)
				.setScenario("item-based")
				.setReturnProperties(true));
		return result;	
	}
}
