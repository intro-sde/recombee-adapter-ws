# Recombee recommendation adapter service
RESTful adapter service based that connects with the Recombee API. Responses in JSON.

How to use? 
- for item-based recommendation: http://{base_url}/recommendation/item_based?itemId=002i&count=1&userId=001u
	- response: [{"id":"002i","values":{"itemId":"002i","item-name":"other-item"}}]
- for user-based recommendation: http://{base_url}/recommendation/user_based?userId=001u&count=1
	- response: [{"id":"002i","values":{"itemId":"002i","item-name":"other-item"}}]



