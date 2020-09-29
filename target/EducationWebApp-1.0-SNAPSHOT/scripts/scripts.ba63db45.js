function configState($stateProvider, $urlRouterProvider, $httpProvider) {
    $httpProvider.defaults.withCredentials = true;
    $urlRouterProvider.when("/", "/h").otherwise("/h/global");

    $stateProvider.state("home", {
        url: "/h",
        templateUrl: "./views/home.html",
        controller: function($scope, $rootScope, $state, $location, $timeout, $window) {

        }
    }).state("home.global", {
        url: "/global",
        templateUrl: "./views/partials/global.html",
        controller: function($scope, $rootScope, $state, $location, $timeout, $window) {

        }
    }).state("home.student", {
        url: "/student",
        templateUrl: "./views/partials/student.html",
        resolve: {
            students_list: function(appFactory) {
                return appFactory.getAllStudents();
            }
        },
        controller: function($scope, $rootScope, $state, $location, $timeout, $window, utilityService, liteService, appFactory, students_list) {
            $scope.students = students_list;

            $scope.new_student = {};
            $scope.addStudent = function() {
                console.log($scope.new_student);

                liteService.set($scope.new_student, "api/records/student").then(function(resp) {
                    utilityService.notifySuccess(resp.data.response_msg);
                    $scope.getStudentResp();
                }).catch(function(resp) {

                });
            };

            $scope.getStudentResp = function() {
                appFactory.getAllStudents().then(function(resp) {
                    $scope.students = resp;
                });
            };

            $scope.reverse_students_list = true;


        }
    }).state("home.course", {
        url: "/course",
        templateUrl: "./views/partials/course.html",
        resolve: {
            courses_list: function(appFactory) {
                return appFactory.getAllCourses();
            }
        },
        controller: function($scope, $rootScope, $state, $location, $timeout, $window, utilityService, liteService, appFactory, courses_list) {
            $scope.courses = courses_list;

            $scope.new_course = {};
            $scope.addCourse = function() {
                console.log($scope.new_course);

                liteService.set($scope.new_course, "api/records/course").then(function(resp) {
                    utilityService.notifySuccess(resp.data.response_msg);
                    $scope.getCourseResp();
                }).catch(function(resp) {

                });
            };

            $scope.getCourseResp = function() {
                appFactory.getAllCourses().then(function(resp) {
                    $scope.courses = resp;
                });
            };

            $scope.reverse_courses_list = true;

        }
    }).state("home.institution", {
        url: "/institution",
        templateUrl: "./views/partials/institution.html",
        resolve: {
            institutions_list: function(appFactory) {
                return appFactory.getAllInstitutions();
            }
        },
        controller: function($scope, $rootScope, $state, $location, $timeout, $window, utilityService, liteService, appFactory, institutions_list) {
            $scope.institutions = institutions_list;

            $scope.new_institution = {};
            $scope.addInstitution = function() {
                console.log($scope.new_institution);

                liteService.set($scope.new_institution, "api/records/institution").then(function(resp) {
                    utilityService.notifySuccess(resp.data.response_msg);
                    $scope.getUniversities();
                }).catch(function(resp) {

                });
            };

            $scope.getUniversities = function() {
                appFactory.getAllInstitutions().then(function(resp) {
                    $scope.institutions = resp;
                });
            };

            $scope.reverse_institutions_list = true;
        }
    }).state("home.institution.singleinstitution", {
        url: "/singleinstitution/:index",
        templateUrl: "./views/partials/singleinst.html",
        controller: function($scope, $rootScope, $state, $stateParams, $location, $timeout, $window, utilityService, liteService, appFactory) {
            $scope.passed_index = $stateParams.index;

            console.log("child state: ", $scope.institutions);
        }
    }).state("home.analytics", {
        url: "/analytics",
        templateUrl: "./views/partials/analytics.html",
        controller: function($scope, $rootScope, $state, $location, $timeout, $window) {

        }
    });
}

$(document).ready(function() {
    fixWrapperHeight(), setBodySmall()
});
$(window).bind("load", function() {
    $(".splash").css("display", "none")
});
$(window).bind("resize click", function() {
        setBodySmall(), setTimeout(function() {
            fixWrapperHeight()
        }, 300)
    }),
    function() {
        angular.module("homer", ["ui.router", "ngSanitize", "ui.bootstrap", "angular-flot", "angles", "angular-peity", "cgNotify", "angles", "ngAnimate", "ui.map", "ui.calendar", "summernote", "ngGrid", "ui.tree", "bm.bsTour", "datatables", "xeditable", "ui.select", "ui.sortable", "ui.footable", "angular-chartist", "ui.codemirror"])
    }();

angular.module("homer").config(configState);
angular.module("homer").run(function($rootScope, $state, editableOptions) {
    $rootScope.$state = $state;
    editableOptions.theme = "bs3";
});
angular.module("homer").filter("propsFilter", propsFilter);
angular.module("homer").directive("pageTitle", pageTitle);
angular.module("homer").directive("sideNavigation", sideNavigation);
angular.module("homer").directive("minimalizaMenu", minimalizaMenu);
angular.module("homer").directive("sparkline", sparkline);
angular.module("homer").directive("icheck", icheck);
angular.module("homer").directive("panelTools", panelTools);
angular.module("homer").directive("panelToolsFullscreen", panelToolsFullscreen);
angular.module("homer").directive("smallHeader", smallHeader);
angular.module("homer").directive("animatePanel", animatePanel);
angular.module("homer").directive("landingScrollspy", landingScrollspy);
angular.module("homer").controller("appCtrl", appCtrl);
angular.module("homer").factory("sweetAlert", sweetAlert);
angular.module("homer").directive("touchSpin", touchSpin);