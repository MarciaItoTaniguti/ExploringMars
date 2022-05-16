The API is configured at GET http://localhost:8080/exploreMars.
Following payload can be used as a template request:

```json
{
  "mars": {
    "borderX": 5,
    "borderY": 5
  },
  "probes": [
    {
      "locationX": 1,
      "locationY": 2,
      "direction": "N",
      "instructions": "LMLMLMLMM"
    },
    {
      "locationX": 3,
      "locationY": 3,
      "direction": "E",
      "instructions": "MMRMMRMRRM"
    }
  ]
}
```

Using the given request, output will be: 
```json
{
  "mars": {
    "borderX": 5,
    "borderY": 5
  },
  "probes": [
    {
      "locationX": 1,
      "locationY": 3,
      "direction": "N"
    },
    {
      "locationX": 5,
      "locationY": 1,
      "direction": "E"
    }
  ]
}
```
