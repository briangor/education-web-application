angular.module("homer").factory("appFactory", function($http, utilityService) {
    var base_url = utilityService.getBaseUrl();
    var factory = {};

    factory.getAllInstitutions = function() {
        var k = $http.get(base_url + 'api/records/institutions', {}).then(function(resp) {
            return resp.data;
        }).catch(function(resp) {
            return undefined;
        });
        return k;
    };

    factory.getAllCourses = function() {
        var k = $http.get(base_url + 'api/records/courses', {}).then(function(resp) {
            return resp.data;
        }).catch(function(resp) {
            return undefined;
        });
        return k;
    };

    factory.getAllStudents = function() {
        var k = $http.get(base_url + 'api/records/students', {}).then(function(resp) {
            return resp.data;
        }).catch(function(resp) {
            return undefined;
        });
        return k;
    };

    return factory;
});