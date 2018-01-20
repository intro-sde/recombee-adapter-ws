package rest.recommendation;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import rest.connection.Connection;

public class UserBasedRec {
	static RecombeeClient client = Connection.createRecombeeClient();
	
	public static Recommendation[] recommend(String userId, int count, String filter,  String[] includedProperties) throws ApiException {
		Recommendation [] result = client.send(new UserBasedRecommendation(userId, count)
			  .setFilter(filter)
			  .setScenario("user-based")
			  .setReturnProperties(true)
			  .setIncludedProperties(includedProperties));
		return result;
	}

	public static Recommendation[] recommend(String userId, int count) throws ApiException {
		Recommendation [] result = client.send(new UserBasedRecommendation(userId, count)
				  .setReturnProperties(true)
				  .setScenario("user-based"));
		return result;
	}
}


