var app = angular.module('app', [ 'ui.utils', "720kb.datepicker", ]);
app.controller('postcontroller',
		function($scope, $rootScope, $http, $location) {

			$scope.$watch('$viewContentLoaded', function() {
				var url = $location.absUrl();
				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}
				$http.get(url + "getallUsers", config).then(function(response) {
					$scope.visitors = response.data;
					$rootScope.totalVisitors = response.data;

				}, function(response) {
					$scope.getResultMessage = "Fail!";
				});

				$http.get(url + "getIBXInfo", config).then(function(response) {
					$scope.IbsVals = response.data;

				}, function(response) {
					$scope.getResultMessage = "Fail!";
				});
			});

			$scope.getCage = function() {
				if ($scope.wv.ibx != null) {
					var ibx = $scope.wv.ibx.ibx;
					var url = $location.absUrl();
					var config = {
						headers : {
							'Content-Type' : 'application/json;charset=utf-8;'
						},
						params : {
							'ibx' : ibx
						}
					}

					$http.get(url + "getByIbx", config).then(
							function(response) {
								$scope.cageList = response.data;
							}, function(response) {
								$scope.getResultMessage = "Fail!";
							});
				} else {
					$scope.cageList = null;
				}
			};

			$scope.getCabinet = function() {
				if ($scope.wv.cage != null) {
					var cage = $scope.wv.cage.cage;
					var url = $location.absUrl();
					var config = {
						headers : {
							'Content-Type' : 'application/json;charset=utf-8;'
						},
						params : {
							'cage' : cage
						}
					}

					$http.get(url + "getByCage", config).then(
							function(response) {
								$scope.cabinetList = response.data;
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
				var index = $scope.visitors.indexOf(my_visitor);
				$scope.visitors.splice(index, 1);
			};

			$scope.remove = function(removeUsr) {
				var newDataList = [];
				$scope.selectedAll = false;
				angular.forEach($scope.selVisitors, function(selected) {
					if (selected != removeUsr) {
						newDataList.push(selected);
					}
				});
				$scope.selVisitors = newDataList;
				var removeIndx;
				angular.forEach($rootScope.totalVisitors, function(vistr) {
					if (vistr == removeUsr) {
						removeIndx = $rootScope.totalVisitors.indexOf(vistr);
					}
				});
				$scope.visitors.splice(removeIndx, 0, removeUsr);
				// $scope.visitors.push(removeUsr);
			};

			$scope.submitForm = function() {
				$scope.submitted = true;
				var url = $location.absUrl() + "postWorkVisit";
				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}

				var startDate = new Date($scope.wv.startDate);
				var endDate = new Date($scope.wv.endDate);

				var data = {
					ibx : $scope.wv.ibx.ibx,
					cage : $scope.wv.cage.cage,
					cabinet : $scope.wv.cabinet.cabinet,
					workVisitUsers : $scope.selVisitors,
					startDate : startDate,
					endDate : endDate
				};

				// switch flag
				$scope.switchBool = function(value) {
					$scope[value] = !$scope[value];
				};

				$http.post(url, data, config).then(function(response) {
					$scope.postResultMessage = "Sucessful!";
					$scope.successTextAlert = "Some content";
					$scope.showSuccessAlert = true;
					window.location.reload();
				}, function(response) {
					$scope.postResultMessage = "Fail!";
				});

				/*
				 * $scope.wv.ibx.ibx = null; $scope.wv.cage.cage = "";
				 * $scope.wv.cabinet.cabinet = ""; $scope.selVisitors = "";
				 */
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