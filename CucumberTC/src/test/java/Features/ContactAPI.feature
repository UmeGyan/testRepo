Feature: Create POST request from CSV file

  Scenario: Create REST request payload from CSV file
    Given the CSV file is generated with randomly generated data
    When I read the CSV file and create contacts using the REST API
    Then the response status code should be 201 for each POST request