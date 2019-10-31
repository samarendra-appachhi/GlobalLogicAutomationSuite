Feature: Discovery WebSite
  GlobalLogic custom flow 

  Background: User in Discovery HomePage
    Given User navigates to discovery go website

  Scenario: Task 1
    And User clicks on the Select See All Shows available in Shows tab
    And User click on select the shows which contain APOLLO
    Then Verify the Favorites icon status.
    And Store all the favorite or unfavorite done titles in list.
    And Once favorite or unfavorite is done, goto My Videos.
    Then Validate the favorite or unfavorite titles under FAVORITE SHOWS”

  Scenario: Task 2
    And Scroll down to popular shows
    And Go to the last video by pressing the icon >
    Then click on EXPLORE THE SHOW
    And User Click on SHOW MORE and you will see the list of shows and again Click on SHOW MORE and few shows will be added
    Then Create a new file and write all the show titles and duration into it.
