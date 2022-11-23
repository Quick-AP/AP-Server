# AP-Server

All APIs used in this app.

# API Document

**Baseurl**:  https://{SERVER_ROOT}

# 1 QueryFoodMenu

## URL

/queryFoodMenu?queryString={QUERY_STRING}

## Description

Query the food menu

## Request

- query string (String)

## Response

### Example

```json
{
        "response" : [
            {
                "foodID" : "PR01",
								"foodType" : "Pasta & Risotto",
                "name" : "Pasta 1",
                "price" : 36.0,
                "imageURL" : "https://5b0988e595225.cdn.sohucs.com/images/20180723/5c9272dc8a28431ebea05e028ccaecf1.jpeg"
            },
            {
                "foodID" : "PR02",
								"foodType" : "Pasta & Risotto",
                "name" : "Pasta 2",
                "price" : 42.0,
                "imageURL" : "https://5b0988e595225.cdn.sohucs.com/images/20180723/5c9272dc8a28431ebea05e028ccaecf1.jpeg"
            }
        ]
}
```

# 2 RegisterQueue

## URL

[/queue/register](http://localhost:8081/queue/query?phoneNumber=15006165582)

## Description

Apply for queuing

## Request (POST)

- phone number (string)

## Response

- rank (How many people are in front of you) (int)

# 3 QueryQueue

## URL

[/queue/query?phoneNumber=](http://localhost:8081/queue/query?phoneNumber=15006165582){phoneNumber}

## Description

Query the queue status

## Request (GET)

- phone number (string)

### Example

```cpp
http://localhost:8081/queue/query?phoneNumber=15006165582
```

## Response

- rank (How many people are in front of you) (int)

# 4 RegisterTable

## URL

/table/register

## Description

Register the table (mark it as Not Available) and remove the phoneNumber from the queue

## Request (POST)

- table id (int)
- phoneNumber (string)



## Response

- If the table is not available, the status will be -1, otherwise 0.

# 5 QueryTable

### URL

/table/query?tableId={tableId}

## Description

Query the status of a table

## Request (GET)

- table id (int)

## Response

- isAvailable (boolean)

# 6 OrderFood

## Url

HTTP POST /orderFood

## Description

Add all food in order under the Cannot resolve symbol 'io’

corresponding table.

## Request

- table_id (int)
- food_id list (List<string>)

## Response

## 

### Example

POST content Json:

```json
{
	"TableID" : 5,
	"foodIDList" : [
			"PR01",
			"PR01",
			"PR02"
	]
}
```

# 7 QueryOrder

## Url

HTTP GET /queryOrder?tableID={TABLE_ID}

## Description

## Request

- table_id (int)

## Response

- food_id list (List<string>)
- total price (double)

### Example

Response Json:

```json
{
	"foodIDList" : [
			"PR01",
			"PR01",
			"PR02"
	],
  "totalPrice" : 114.0
}
```

# 8 CheckOut

## Description

Check out the given table’s orders. (mark table as available and delete the related records)

## Request

- table_id (int)

## Response

- total price (double)