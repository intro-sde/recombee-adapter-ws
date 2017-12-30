package rest.recommendation;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import rest.connection.Connection;

public class UserBasedRec {
	static Connection conn = new Connection();
	static RecombeeClient client = conn.createRecombeeClient();
	
	public static Recommendation[] recommend(String userId, int count, String filter, boolean returnProperties) throws ApiException {
		Recommendation [] result = client.send(new UserBasedRecommendation(userId, count)
			  .setFilter(filter)
			  .setScenario("user-based")
			  .setReturnProperties(returnProperties));
		return result;
	}
}


