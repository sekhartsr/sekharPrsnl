var app = angular.module('app', [ 'ui.utils', 'moment-picker', 'ngMaterial', 'ngMessages', 'ngMaterialDatePicker' ]);
app.controller('postcontroller',
	function($scope, $rootScope, $timeout, $http, $location, $window) {

		// Get all the visitors and IBX List for Select IBX OnLoad from DB
		$scope.$watch('$viewContentLoaded', function() {
			var url = new $window.URL($location.absUrl()).origin;
			/*var url = $location.absUrl();*/
			var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				}
			}
			$http.get(url + "/getAllUsers", config).then(function(response) {
				console.log("getting All users");
				$scope.visitors = response.data;
				$rootScope.totalVisitors = response.data;

			}, function(response) {
				$scope.getResultMessage = "Fail!";
			});

			$http.get(url + "/getIBXInfo", config).then(function(response) {
				console.log("getting All IBX");
				$scope.IbsVals = response.data;

			}, function(response) {
				$scope.getResultMessage = "Fail!";
			});
		});

		// get Cage List when select value of IBX  (ng-change)
		$scope.getCage = function() {
			if ($scope.ibx != null) {
				var ibx = $scope.ibx.ibx;
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

		//		get Cabinet List when select value of Cage (ng-change)
		$scope.getCabinet = function() {
			if ($scope.cage != null) {
				var cage = $scope.cage.cage;
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

		$scope.getEndMinDate = function() {
			var minEndDate = new Date($scope.startDate);
			console.log("minEndDate: " + minEndDate);
			$scope.minEndDate = minEndDate;
		}

		//		select visitor from the list of visitors
		$scope.selVisitors = [];
		$scope.wvSelected = function(my_visitor) {
			$scope.selVisitors.push(my_visitor);
			var index = $scope.visitors.indexOf(my_visitor);
			$scope.visitors.splice(index, 1);
		};

		//		remove from the list of Specified
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
		};

		//		Submit the form and call to backend service to store the data
		$scope.submitForm = function() {
			$scope.submitted = true;
			var url = $location.absUrl() + "postWorkVisit";
			var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				}
			}

			if ($scope.workVisitForm.$valid) {
				var startDate = new Date($scope.startDate);
				var endDate = new Date($scope.endDate);
				var startTime = $scope.startTime;
				var endTime = $scope.endTime;

				console.log("startDate: ["+startDate+"]");
				console.log("endDate: ["+endDate+"]");
				
				console.log("STime: ["+startTime+"]");
				console.log("ETime: ["+endTime+"]");
				var strTime = startTime.toLocaleTimeString();
				var enTime = endTime.toLocaleTimeString();
				console.log("Start Hour: "+strTime);
				console.log("End Hour: "+enTime);
				if (startDate > endDate) {
					$scope.endDateValid = true;
					$scope.errMessage = 'End Date should be greate than start date';
					return false;
				}

				if (startDate == endDate) {
					if (strTime > enTime) {
						console.log("Time Error");
						$scope.endTimeValid = true;
						$scope.errTimeMessage = 'End Time should be greate than start Time';
						return false;
					}
					console.log("Time Without Error");
				}
				console.log("startDate: ["+startDate+"]");
				console.log("endDate: ["+endDate+"]");
				if (confirm("Do u want to continue?")) {
					var data = {
						ibx : $scope.ibx.ibx,
						cage : $scope.cage.cage,
						cabinet : $scope.cabinet.cabinet,
						workVisitUsers : $scope.selVisitors,
						startDate : startDate,
						endDate : endDate,
						startTime : strTime,
						endTime : enTime
					};

					$http.post(url, data, config).then(function(response) {
						$scope.postResultMessage = "Successfully Submitted Visitor(s)";
						$scope.showSuccessAlert = true;
						$timeout(function() {
							$scope.showSuccessAlert = true;
							window.location.reload();
						}, 5000);
					}, function(response) {
						$scope.postResultMessage = "Fail!";
					});
				} else {

				}
			} else {
				console.log("Validation Failed---------------");
				return false;
			}
		}
		// A function to convert your 12-hour clock in to a 24-hour one
		function convertTime(t) {
			var time = new Date("0001-01-01 " + t);
			var formatted = time.getHours() + ':' + ('0' + time.getMinutes()).slice(-2);
			return formatted;
		}

		$scope.reloadPage = function() {
			window.location.reload();
		}

		$scope.getfunction = function(visitor) {
			var lastName = visitor.lastName;
			$scope.visitorView = visitor;
			$rootScope.$broadcast('viewVisitorShar', $scope.visitorView);
		}

	});

app.controller('getUserController', function($scope, $rootScope, $http, $location) {
	$rootScope.$on('viewVisitorShar', function(event, obj) {
		$scope.isViewVisitor = true;
		$scope.viewVisitor = obj;

	});
});