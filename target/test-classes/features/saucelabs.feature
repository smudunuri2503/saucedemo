Feature: Sauce labs login

  Scenario: Launch sauce demo and login
    Given the url is launched
    When I login with valid user "standard_user" and "secret_sauce" 
    Then the search results should contain "Products"
