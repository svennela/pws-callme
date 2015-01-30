(function(angular) {
  var HelpRequestFactory = function($resource) {
    return $resource('/helprequests/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  HelpRequestFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("HelpRequest", HelpRequestFactory);
}(angular));