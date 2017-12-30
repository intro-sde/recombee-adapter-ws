package rest.connection;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.ItemBasedRecommendation;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.bindings.Recommendation;

public class Connection {
	private final String DB_ID = "sde-final-assignment";
	private final String SECRET_TOKEN = "LeDMWIM05dYcFydwyKTxJnJbsfwOE7kieL6Hk0oB9VGqzJ3rYCBjhAcV3AMQhpQo";

	public RecombeeClient createRecombeeClient() {
		RecombeeClient client = new RecombeeClient(DB_ID, SECRET_TOKEN);
		return client;
	}
	
}
