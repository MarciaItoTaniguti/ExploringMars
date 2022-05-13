The API is configured at GET http://localhost:8080/exploreMars.
Following payload can be used as a template request:

{
	"mars": {
		"x": 5,
		"y": 5
	},
	"probeList": [
		{
			"instructions": [ "L", "M", "M", "L", "M", "L","M" ],
			"location": {
 				"x": 2,
 				"y": 1
 			},
 			"currentDirection": "E"
		},
		{
			"instructions": ["M", "R", "R", "M", "M", "L", "M" ],
			"location": {
				"x": 0,
				"y": 3
			},
			"currentDirection": "E"
		}
	]
}


Using the given request, output will be: 
{
	"mars": {
		"x": 5,
		"y": 5
	},
	"probeList": [
		{
			"location": {
				"x": 1,
				"y": 2
			},
			"lastIndex": 3,
			"currentDirection": "S"
		},
		{
			"location": {
				"x": 0,
				"y": 3
			},
			"lastIndex": 3,
			"currentDirection": "W"
		}
	]
}