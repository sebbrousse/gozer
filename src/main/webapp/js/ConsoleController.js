'use strict';

gozerApp.controller('ConsoleController', function ConsoleController($scope, $websocket) {
    console.log("consoleController")

    $websocket.onopen = function(event) {
        console.log("open", event);
    };
    $websocket.onmessage = function(event) {
        console.log("message", event);
        var $console = $('#console');
        $console.append(event.data+"<br/>");
    };
    $websocket.onerror = function(event) {
        console.log("error", event);
    };
    $websocket.onclose = function(event) {
        console.log("close", event);
    };

    $scope.start = function() {
        $websocket.send("Click !");
    }

//    socket.on('user:join', function (data) {
//        $scope.messages.push({
//            user: 'chatroom',
//            text: 'User ' + data.name + ' has joined.'
//        });
//        $scope.users.push(data.name);
//    });
//
//    webSocket.onopen = function(event) {
//        console.log("open", event);
//    };
//    webSocket.onmessage = function(event) {
//        console.log("message", event);
//        var $console = $('#console');
//        $console.append(event.data+"\n");
//    };
//    webSocket.onerror = function(event) {
//        console.log("error", event);
//    };
//    webSocket.onclose = function(event) {
//        console.log("close", event);
//    };

});
