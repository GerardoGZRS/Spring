/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
   $scope.enviar = function (){
       $http({
    method : "GET",
      url : "http://localhost:8080/profesores/checkrest"
  })
  .then(function(response) {
    // First function handles success
    $scope.content = response.data;
    console.log(response.data);
    
  }, function(response) {
    // Second function handles error
    $scope.content = "Error no se pudo encontrar!!!";
    
    console.log($scope.content);
  });
   };
   
   $scope.idContacto = function (employee){
     
       $http({method : "PUT",
    url : "addProfesores",
    data : angular.toJson($scope.contacto),
    headers : {
        'Content-Type' : 'application/json'
    }
}).then(function(response) {
    // First function handles success
    $scope.contacto = response.data;
    console.log("El registro se ha insertado con exito");
    
  }, function(response) {
    // Second function handles error
    $scope.contacto = "Something went wrong";
    
    console.log($scope.contacto);
  });
   };
   
   
   
   
   $scope.save = function (){
     
       $http({method : "POST",
    url : "addProfesores",
    data : angular.toJson($scope.contacto),
    headers : {
        'Content-Type' : 'application/json'
    }
}).then(function(response) {
    // First function handles success
    $scope.contacto = response.data;
    console.log("El registro se ha insertado con exito");
    
  }, function(response) {
    // Second function handles error
    $scope.contacto = "Something went wrong";
    
    console.log($scope.contacto);
  });
   };
});
