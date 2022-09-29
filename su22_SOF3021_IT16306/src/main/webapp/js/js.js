var app=angular.module("myapp",['ngRoute']);
app.config(function($routeProvider,$locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider
    .when('/1',{
        templateUrl:'html2.html',
    });
})