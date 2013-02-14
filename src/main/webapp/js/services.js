'use strict';


//angular.module('TimerService', [], function ($provide) {
//    $provide.factory('CurrentTime', function () {
//        var onOpenCB, onCloseCB, onMessageCB;
//        var location = "ws://localhost:8888/api/timer"
//        var ws = new WebSocket(location);
//        ws.onopen = function () {
//            if(onOpenCB !== undefined)
//            {
//                onOpenCB();
//            }
//        };
//        ws.onclose = function () {
//            if(onCloseCB !== undefined)
//            {
//                onCloseCB();
//            }
//        };
//        ws.onmessage = function (m) {
//            console.log(m);
//            onMessageCB(m);
//        };
//
//        return{
//            setOnOpenCB: function(cb){
//                onOpenCB = cb;
//            },
//            setOnCloseCB: function(cb){
//                onCloseCB = cb;
//            },
//            setOnMessageCB: function(cb){
//                onMessageCB = cb;
//            }
//        };
//    })});

    gozerApp.factory('$websocket', function () {
        var websocket = new WebSocket("ws://localhost:8080/gozer/console");

        return websocket;

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