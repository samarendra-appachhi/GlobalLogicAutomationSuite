$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/FeaturesFiles/discovery.feature");
formatter.feature({
  "line": 1,
  "name": "Discovery WebSite",
  "description": "GlobalLogic custom flow",
  "id": "discovery-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5821447573,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "User in Discovery HomePage",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User navigates to discovery go website",
  "keyword": "Given "
});
formatter.match({
  "location": "DiscoveryStepDef.user_navigates_to_discovery_go_website()"
});
formatter.result({
  "duration": 12278359314,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Task 1",
  "description": "",
  "id": "discovery-website;task-1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User clicks on the Select See All Shows available in Shows tab",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User click on select the shows which contain APOLLO",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Verify the Favorites icon status.",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Store all the favorite or unfavorite done titles in list.",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Once favorite or unfavorite is done, goto My Videos.",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Validate the favorite or unfavorite titles under FAVORITE SHOWS”",
  "keyword": "Then "
});
formatter.match({
  "location": "DiscoveryStepDef.user_clicks_on_the_Select_See_All_Shows_available_in_Shows_tab()"
});
formatter.result({
  "duration": 1315109422,
  "status": "passed"
});
formatter.match({
  "location": "DiscoveryStepDef.user_click_on_select_the_shows_which_contain_APOLLO()"
});
formatter.result({
  "duration": 4062865062,
  "status": "passed"
});
formatter.match({
  "location": "DiscoveryStepDef.verify_the_Favorites_icon_status()"
});
formatter.result({
  "duration": 4515677676,
  "status": "passed"
});
formatter.match({
  "location": "DiscoveryStepDef.store_all_the_favorite_or_unfavorite_done_titles_in_list()"
});
formatter.result({
  "duration": 335321386,
  "status": "passed"
});
formatter.match({
  "location": "DiscoveryStepDef.once_favorite_or_unfavorite_is_done_goto_My_Videos()"
});
formatter.result({
  "duration": 422523815,
  "status": "passed"
});
formatter.match({
  "location": "DiscoveryStepDef.validate_the_favorite_or_unfavorite_titles_under_FAVORITE_SHOWS()"
});
formatter.result({
  "duration": 2727643435,
  "status": "passed"
});
formatter.after({
  "duration": 4455199427,
  "status": "passed"
});
});