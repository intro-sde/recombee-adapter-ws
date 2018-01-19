# Recombee recommendation adapter service
RESTful adapter service based that connects with the Recombee API. Responses in JSON.

The following methods are available for https://sde-recombee-adapter-ws.herokuapp.com/recombee/recommendation/ endpoint:
- /item_based @GET | [itemId, count, userId, userImpact, filter] | Returns a number of item based recommendation with respect to item with given id and considering filter, which is a ReQL query.
- /user-based @GET | [userId, count, filter] | Returns a number of user based recommendation with respect to user with given id and considering filter, which is a ReQL query. 


Reference:
Recombee API (version 1.6.0), Available at: https://docs.recombee.com/api.html.


