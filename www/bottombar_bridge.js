/**
 * Bottom Bar bridge plugin for Cordova
 * Copyright (c) Sungjoon Kim 2016
  */
 (function(cordova){
 	
    var BottombarBridge = function() {};

    // WebIntent.prototype.ACTION_SENDTO = "android.intent.action.SENDTO";

    BottombarBridge.prototype.changeTab = function(idx, url, success, fail) {
	var params = url==null?[idx]:[idx, url];
        return cordova.exec(
        	function(args) {
	            success(args);
	        }, function(args) {
	            fail(args);
	        }, 'BottombarBridge', 'changeTab', params);
    };

    window.bottombarBridge = new BottombarBridge();
    
    // backwards compatibility
    window.plugins = window.plugins || {};
    window.plugins.bottombarBridge = window.bottombarBridge;
})(window.PhoneGap || window.Cordova || window.cordova);
