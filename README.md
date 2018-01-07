# Recombee recommendation adapter service
RESTful adapter service based that connects with the Recombee API. Responses in JSON.

The following methods are available for http://{base_url}/recombee/recommendation/ endpoint:
- /item_based @GET | [itemId, count, userId, filter] | Returns a number of item based recommendation with respect to item with given id and considering filter, which is a ReQL query.
	- response: [{"id":"002i","values":{"itemId":"002i","item-name":"other-item"}}]
- /user-based @GET | [userId, count, filter] | Returns a number of user based recommendation with respect to user with given id and considering filter, which is a ReQL query. 
	- response: [{"id":"002i","values":{"itemId":"002i","item-name":"other-item"}}]


Reference:
Recombee API (version 1.6.0), Available at: https://docs.recombee.com/api.html.


