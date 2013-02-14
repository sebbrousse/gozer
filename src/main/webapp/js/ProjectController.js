'use strict';

gozerApp.controller('ProjectController',
    function ProjectController($scope) {
        console.log("projectController")

        $scope.project = {"name" : "Gozer",
                            "artifactId" : "gozer",
                            "groupId" : "org.gozer",
                            "version" : "0.0.1"}

    });