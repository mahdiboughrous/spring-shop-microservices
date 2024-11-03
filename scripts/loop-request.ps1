# RateLimitTest.ps1
# This script sends multiple requests to a specified endpoint to test rate limiting

# Define the target URL
$uri = "http://localhost:7004/products"  # Replace with your actual endpoint

# Define the number of requests to send
$numRequests = 20

# Send requests in a loop
for ($i = 1; $i -le $numRequests; $i++) {
    try {
        # Send a GET request to the target URL
        $response = Invoke-RestMethod -Uri $uri -Method Get -ErrorAction Stop

        # Display the response status code
        Write-Host "Request ${i}: Success - Status 200"
    }
    catch {
        # Check if the exception contains a status code, specifically 429 for rate limiting
        if ($_.Exception.Response.StatusCode.Value__ -eq 429) {
            Write-Host "Request ${i}: Rate limit exceeded - Status 429"
        } else {
            Write-Host "Request ${i}: Error - $($_.Exception.Message)"
        }
    }

    # Optional: Add a short delay between requests
    Start-Sleep -Milliseconds 100
}