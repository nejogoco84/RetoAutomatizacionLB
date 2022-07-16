Feature: employee
  As a consumer, I want to consult, create and delete employees from the system.

  Scenario: list the total number of employees, validate the status and
  the successful operation message.

    When the user search all employees
    Then the list of employees is presented successfully