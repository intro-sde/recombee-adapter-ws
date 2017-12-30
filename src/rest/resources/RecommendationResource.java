package rest.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
@Path("/recommendation")
public class RecommendationResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	//User based recommendation
	
	@GET
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/user_based")
	public Recommendation[] userBasedRecommendation(@PathParam("userId") String userid, @PathParam("count") int count, @PathParam("filter") String filter,@PathParam("prop") boolean returnProperties) throws ApiException {
		System.out.println("--> RecommendationResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		Recommendation[] recommendations =UserBasedRec.recommend(userid, count, filter, returnProperties);
		return recommendations;
	}
	
	//item based recommendation
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/item_based")
	public Recommendation[] itemBasedRecommendation(@PathParam("itemId") String itemId, @PathParam("userId") String targetUserId, @PathParam("count") int count, @PathParam("filter") String filter,@PathParam("prop") boolean returnProperties) throws ApiException {
		System.out.println("--> RecommendationResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		Recommendation[] recommendations =ItemBasedRec.recommend(itemId, count, targetUserId, filter, returnProperties);
		return recommendations;
	}
}
