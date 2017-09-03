var app = angular.module('app', [ 'ui.utils', "720kb.datepicker", ]);
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
	// $scope.getUsers = function() {
	$scope.$watch('$viewContentLoaded', function() {
		var url = $location.absUrl();
		console.log("Sekhar----1");
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		$http.get(url + "getallUsers", config).then(function(response) {
			$scope.visitors = response.data;
			console.log("Values: [" + $scope.visitors + "]");

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

		$http.get(url + "getIBXInfo", config).then(function(response) {
			$scope.IbsVals = response.data;
			console.log("Values: [" + $scope.IbsVals + "]");

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	});

	$scope.getCage = function() {
		if ($scope.ibx != null) {
			console.log("ibxVal:" + $scope.ibx.ibx);
			var ibx = $scope.ibx.ibx;
			var url = $location.absUrl();
			console.log("Sekhar----1");
			var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				},
				params : {
					'ibx' : ibx
				}
			}

			$http.get(url + "getByIbx", config).then(function(response) {
				$scope.cageList = response.data;
				console.log("Values: [" + $scope.cageList + "]");

			}, function(response) {
				$scope.getResultMessage = "Fail!";
			});
		} else {
			$scope.cageList = null;
		}
	};

	$scope.getCabinet = function() {
		if ($scope.cage != null) {
			console.log("CageValue:" + $scope.cage.cage);
			var cage = $scope.cage.cage;
			var url = $location.absUrl();
			console.log("Sekhar----1");
			var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				},
				params : {
					'cage' : cage
				}
			}

			$http.get(url + "getByCage", config).then(function(response) {
				$scope.cabinetList = response.data;
				console.log("Values: [" + $scope.cabinetList + "]");

			}, function(response) {
				$scope.getResultMessage = "Fail!";
			});
		} else {
			$scope.cabinetList = null;
		}
	};

	/*
	 * $scope.subjects = [ { name : "option1", marks : "1" }, { name :
	 * "option2", marks : "2" }, { name : "option3", marks : "3" } ];
	 */
	$scope.selVisitors = [];
	
	$scope.wvSelected = function(my_visitor) {
		$scope.selVisitors.push(my_visitor);
		console.log($scope.selVisitors);
	};

	$scope.remove = function() {
		var newDataList = [];
		$scope.selectedAll = false;
		angular.forEach($scope.selVisitors, function(selected) {
			if (!selected.selected) {
				newDataList.push(selected);
			}
		});
		$scope.selVisitors = newDataList;
	};

	$scope.submitForm = function() {
		var url = $location.absUrl() + "postWorkVisit";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		var data = {
				ibx : $scope.ibx,
				cage : $scope.cage,
				cabinet : $scope.cabinet
//				workVisitUsers : $scope.selVisitors
		};

		$http.post(url, data, config).then(function(response) {
			$scope.postResultMessage = "Sucessful!";
		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

		$scope.firstname = "";
		$scope.lastname = "";
	}
});

app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function() {
		var url = $location.absUrl() + "getallcustomer";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			$scope.response = response.data
		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
});