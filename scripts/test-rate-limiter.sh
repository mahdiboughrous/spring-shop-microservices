#!/bin/bash

# Define the target URL
uri="http://localhost:9000/products"  # Replace with your actual endpoint

# Define the number of requests to send
numRequests=20

# Loop to send requests
for ((i=1; i<=numRequests; i++)); do
    # Send a GET request and capture the HTTP status code
    response=$(curl -s -o /dev/null -w "%{http_code}" "$uri")

    # Check the response status code
    if [ "$response" -eq 200 ]; then
        echo "Request ${i}: Success - Status 200"
    elif [ "$response" -eq 429 ]; then
        echo "Request ${i}: Rate limit exceeded - Status 429"
    else
        echo "Request ${i}: Error - Status $response"
    fi

    # Optional: Add a short delay between requests
    sleep 0.1
done