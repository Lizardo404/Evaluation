@DemoTest
Feature:  SwagLabs
  Rule : Objetivo: Evaluar los conocimientos y habilidades prácticas en automatización de pruebas.

  Background: Open sauce demo page
        When the user navigate to saucedemo page

#@loginDemoPage
#  Scenario Outline: Login page with diferents users and passwords
#      Given add <user> and <password> to login saucedemo
#    Examples:
#    | user                  | password      |
#    |standard_user          | secret_sauce  |
#    |locked_out_user        | secret_sauce  |
#    |problem_user           | secret_sauce1 |
#    |performance_glitch_user| secret_sauce  |
#    |error_user             | secret_sauce  |
#    |visual_user            | secret_sauce  |

#  @searchFiltersDemo
#  Scenario: Product Filter
#    Given user login to Swag labs page
#    When filter products by different methods

  @addShoppingItem
  Scenario: Product Filter
     Given user login to Swag labs page
      When filter products by low price methods
       And add first Item filter to shopping cart
    # Then verify shopping cart

#  @buyItem
#    Scenario: Product Filter
#      Given user login to Swag labs page
#      When filter products by different methods
#      And add first Item filter to shopping car
#      Then verify shopping car
#      And complet shopping






