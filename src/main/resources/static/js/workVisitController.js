var app = angular.module('app', [ 'ui.utils', 'moment-picker' ]);
app.controller('postcontroller',
	function($scope, $rootScope, $timeout, $http, $location) {

		// Get all the visitors and IBX List for Select IBX OnLoad from DB
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

		//		min Date to select StartDate
		$scope.minDateString = moment().subtract(0, 'day').format('YYYY/MM/DD');

		//		min Date to select End Date
		$scope.endDateSet = function() {
			var diffDays;
			var startDate = new Date($scope.startDate);
			diffDays = startDate.diff(new Date(), 'days');
			$scope.minEndDateString = moment().subtract(diffDays, 'day').format('YYYY/MM/DD');
		}
		$scope.minEndDateString = moment().subtract(0, 'day').format('YYYY/MM/DD');

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
				if (startDate > endDate) {
					$scope.endDateValid = true;
					$scope.errMessage = 'End Date should be greate than start date';
					return false;
				}
				if (confirm("Do u want to continue?")) {
					var data = {
						ibx : $scope.ibx.ibx,
						cage : $scope.cage.cage,
						cabinet : $scope.cabinet.cabinet,
						workVisitUsers : $scope.selVisitors,
						startDate : startDate,
						endDate : endDate,
						startTime : $scope.startTime,
						endTime : $scope.endTime
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