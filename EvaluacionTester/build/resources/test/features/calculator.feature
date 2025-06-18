Feature: Basic Calculator page
Rule: Add 2 to integer numbers and make simple math operation

  Background: Open Basic Calculator page
    When the user navigate to calculator page

@calculator
Scenario: Make a math Operation
  Given select only integers number checkbox
    And add <firstnumber> and <secondnumber> on each textbox
  Given select all math operation by dropdown
 #   And click on calculate button
    Then clear formulary

