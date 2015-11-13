//Principal module
var app = angular.module("app", ["ngResource", "ngRoute"]);

app.config(["$routeProvider", "$locationProvider", function($routeProvider, $locationProvider){
	
	//List Persons
	$routeProvider.when("/persons", {
		templateUrl: "./person/view/persons.html",
		controller: "PersonsController"
	});
	
	//Detail person
	$routeProvider.when("/person/detail/:id", {
		templateUrl: "./person/view/update.html",
		controller: "PersonController"
	});	
	
	//Create Person
	$routeProvider.when("/person/create", {
		templateUrl: "./person/view/create.html",
		controller: "SaveController"
	});
	
	//Update Person
	$routeProvider.when("/person/update/:id", {
		templateUrl: "./person/view/update.html",
		controller: "PersonController"
	});
	
}]);

app.value("appValue", {
	baseUrl: "/JerseyGradle/rest"
});