Feature: User Registration
  I want to check that the user can register in our e-commerce website

  Scenario Outline: User Registration
    Given: The user in the home page

    When I click on reigster link
    And I entered "<firstname>", "<lastname>", "<email>", "<password>"
    Then The registration page displayed successfully
    
    Examples:
      | firstname | lastname | email           | password |
      | ahmed     | mohamed  | ahmeaaasaa@home.test | password |
