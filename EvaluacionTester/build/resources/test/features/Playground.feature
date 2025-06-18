@playground
Feature: Navigation to Testing Playground page

  Rule: Navigation to Testing playground

Background: Open Testing playground
  When the user navigate to Testing Playground
  Given user Hoover over with all topics

@hooverElements
#Scenario Outline: hover over by Testing playground topics
  And search <topics> on textbox
#  Examples:
#    | topics     |
#    | Add/Remove |
#    | Checkbox   |
#    | Sliders    |
#    |Notification|
#    |Tooltips    |
#    |Inputs      |
#    |Login       |


 @addItems
 #Scenario Outline: Open page to add/remove elements
 #  When the user navigate to Testing Playground
  # Given user Hoover over with all topics
 #   And search <topics> on textbox
 #  Then open first option
 Given Add <number> elements
 #  Then remove all items
 # Examples:
 #   | topics     |
 #   | Add/Remove |

  @checkBox
  Scenario Outline: Open checkbox page
     When the user navigate to Testing Playground
      And search <topics> on textbox
     Then open first option
 #   Given click on checkbox form
     Then click on checkbox icons
      And return to main page
    Examples:
      | topics     |
      | Checkbox   |

