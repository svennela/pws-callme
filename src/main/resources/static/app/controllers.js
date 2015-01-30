(function(angular) {
  var AppController = function($scope, HelpRequest,$http) {
	  HelpRequest.query(function(response) {
      $scope.helprequests = response ? response : [];
    });
    
    $scope.callHelprequest = function(helprequest) {
     console.log(helprequest);
     $http({
         url: 'callme',
         method: "POST",
         data: helprequest,
         headers: {'token': 'pwstoken'}
     }).success(function (data) {
    	 	console.log(data);
    	 	$scope.message=data.message;
            // $scope.message = data.message; // assign  $scope.persons here as promise is resolved here 
    	 	 HelpRequest.query(function(response) {
    	 	      $scope.helprequests = response ? response : [];
    	 	    });
    	 	 
         }).error(function (data) {
             //$scope.status = status;
         });
     
     
    };
    
    $scope.mailHelprequest = function(helprequest) {
        console.log(helprequest);
       };
    

  };
  
  AppController.$inject = ['$scope', 'HelpRequest','$http'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));