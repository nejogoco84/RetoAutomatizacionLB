Feature: employee
  As a consumer, I want to consult, create and delete employees from the system.

  Scenario: list the total number of employees, validate the status and
  the successful operation message.

    When the user search all employees
    Then the list of employees is presented successfully

  Scenario Outline: employee search by id
    When the user searches the employee with <id>
    Then employee with <id> is queried successfully

    Examples:
      | id |
      | 23 |
      | 24 |

  Scenario: Delete the employee by id
    When the user delete the employee with Id 6
    Then the employee with id 6 was successfully deleted

  Scenario Outline: Create a new employee
    When the user creates a new employee
      | name   | <name>   |
      | salary | <salary> |
      | age    | <age>    |
    Then the creation of the new employee is successful

    Examples:
      | name | salary | age |
      | test | 123    | 23  |