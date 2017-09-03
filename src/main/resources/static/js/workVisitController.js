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
		if ($scope.wv.ibx != null) {
			console.log("ibxVal:" + $scope.wv.ibx.ibx);
			var ibx = $scope.wv.ibx.ibx;
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
		if ($scope.wv.cage != null) {
			console.log("CageValue:" + $scope.wv.cage.cage);
			var cage = $scope.wv.cage.cage;
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

	$scope.remove = function(removeUsr) {
		var newDataList = [];
		console.log("Raaaaaaaaaaaaaahul");
		$scope.selectedAll = false;
		angular.forEach($scope.selVisitors, function(selected) {
			console.log("----"+selected);
			console.log("--====--"+removeUsr);
			if (selected != removeUsr) {
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
		console.log("ibxVal:" + $scope.wv.ibx.ibx);
		var ibxVal = $scope.wv.ibx.ibx;
		var cageVal = $scope.wv.cage.cage;
		var cabinetVal = $scope.wv.cabinet.cabinet;

		var data = {
			ibx : $scope.wv.ibx.ibx,
			cage : $scope.wv.cage.cage,
			cabinet : $scope.wv.cabinet.cabinet,
			workVisitUsers : $scope.selVisitors
		};

		
		// switch flag
		$scope.switchBool = function(value) {
		   $scope[value] = !$scope[value];
		};
		
		
		console.log("data:" + data);
		$http.post(url, data, config).then(function(response) {
			$scope.postResultMessage = "Sucessful!";
			$scope.successTextAlert = "Some content";
			$scope.showSuccessAlert = true;
		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

		$scope.wv.ibx.ibx = null;
		$scope.wv.cage.cage = "";
		$scope.wv.cabinet.cabinet = "";
		$scope.selVisitors = "";
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