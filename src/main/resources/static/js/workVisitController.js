var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	
	$scope.options = [ {
		label : "option1",
		value : "1"
	}, {
		label : "option2",
		value : "2"
	}, {
		label : "option3",
		value : "3"
	} ];

	console.log("Sekhar");
//	$scope.getUsers = function() {
		$scope.$watch('$viewContentLoaded', function(){
		var url = $location.absUrl() + "getallUsers";
		console.log("Sekhar----1");
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url, config).then(function(response) {
			$scope.visitors = response.data;
			console.log("Values: [" + $scope.visitors + "]");

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	});

	/*
	 * $scope.subjects = [ { name : "option1", marks : "1" }, { name :
	 * "option2", marks : "2" }, { name : "option3", marks : "3" } ];
	 */

	$scope.wvSelected = function(my_visitor) {
		$scope.selVisitors = my_visitor;
		console.log($scope.selVisitors);
	};

	
	$scope.submitForm = function(){
		var url = $location.absUrl() + "postcustomer";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		var data = {
            firstname: $scope.firstname,
            lastname: $scope.lastname
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Sucessful!";
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});
		
		$scope.firstname = "";
		$scope.lastname = "";
	}
});

app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "getallcustomer";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		$http.get(url, config).then(function (response) {
			$scope.response = response.data
		}, function (response) {
			$scope.getResultMessage = "Fail!";
		});
	}
});