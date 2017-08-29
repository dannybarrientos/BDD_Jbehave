Meta:

Narrative:
As a user of viajala
I want to search a flight with my specifications
So that I can choose the best option for me

Scenario: search flight with same origin and destiny
Given I am on viajala.com.co home's page
When I fill search fields
|from                  |to                    |
|Bogotá, Colombia (BOG)|Bogotá, Colombia (BOG)|
And click on search button
Then system show a same city error notification below destiny field

Scenario: search flight without origin
Given I am on viajala.com.co home's page
When I fill search fields
|from|to                    |
|    |Bogotá, Colombia (BOG)|
And click on search button
Then system show a origin is empty error notification below origin field

Scenario: search flight without destiny
Given I am on viajala.com.co home's page
When I fill search fields
|from                  |to                    |
|Bogotá, Colombia (BOG)|                      |
And click on search button
Then system show a destiny is empty error notification below origin field