@carperdev
Feature: Navigate to Carper dev web

 Background: Open ToDoList page
   Given the user navigate to todolist page


  @TodoListOneTask
  Scenario: User can access to TodoListPage and attach items
    When enter simple task
     And complete last task
   Then check all task completed