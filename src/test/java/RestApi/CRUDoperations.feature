Feature: Perform CRUD Operations

  Scenario Outline: To Perform the GET Operation on Employe DB
    Given The "<Base_URI>" for Get Operation
    When User poerform the Get Operation
    Then Resonse should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                        | Response_Code |
      | http://localhost:8088/employees |           200 |

  Scenario Outline: To Perform the GET Operation on GitHub
    Given The "<Base_URI>" for Get Operation
    When User poerform the Get Operation
    Then Resonse should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                   | Response_Code |
      | https://api.github.com/users/rajgout/repos |           200 |

  Scenario Outline: To Perform the PATCH Operation on GitHub
    Given The "<Base_URI>" for PATCH Operation and token is "<Token>"
    When User poerform the PATCH Operation
    Then Resonse should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                            | Response_Code | Token                                    |
      | https://api.github.com/repos/rajgout/PostmanEclipse |           200 | 108181c4b461ea321d51e6f211a6321e2460d0f1 |
