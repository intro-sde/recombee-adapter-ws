package rest.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import rest.recommendation.ItemBasedRec;
import rest.recommendation.UserBasedRec;

@Stateless
@LocalBean
@Path("/recombee/recommendation")
public class RecommendationResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	//User based recommendation
	@GET
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/user_based")
	public Recommendation[] userBasedRecommendation(@DefaultValue("")@QueryParam("userId") String userid, @DefaultValue("")@QueryParam("count") String count, @DefaultValue("")@QueryParam("filter") String filter,@QueryParam("properties") String properties) throws ApiException {
		System.out.println("--> RecommendationResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String[] includedProperties = properties.split(",");
		Recommendation[] recommendations =UserBasedRec.recommend(userid, Integer.parseInt(count), filter, includedProperties);
		return recommendations;
	}
	
	//item based recommendation
	@GET
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/item_based")
	public Recommendation[] itemBasedRecommendation(@DefaultValue("")@QueryParam("itemId") String itemId, @DefaultValue("")@QueryParam("count") String count, @QueryParam("userId") String targetUserId, @QueryParam("userImpact") String userImpact, @QueryParam("filter") String filter, @QueryParam("properties") String properties) throws ApiException {
		System.out.println("--> RecommendationResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String[] includedProperties = properties.split(",");
		Recommendation[] recommendations =ItemBasedRec.recommend(itemId, Integer.parseInt(count) , targetUserId, Double.parseDouble(userImpact), filter, includedProperties);
		return recommendations;
	}
}
