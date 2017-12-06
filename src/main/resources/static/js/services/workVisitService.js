(function() {
  "use strict";
 var myApp = angular.module("app");
 
 var myApp.constant("globalConfig", {
      apiAddress: "http://localhost:8080/"
    });
  myApp.factory("workVisitService", Service);

  Service.$inject = ["$http", "globalConfig"];

  function Service($http, globalConfig) {
    var url = "";
    return {
      getUsers: function() {
        url = globalConfig.apiAddress + "/user";
        return $http.get(url);
      },
    };
  }
})();
