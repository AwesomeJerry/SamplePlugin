var samplePlugin = {
    openIntent: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'SamplePlugin', 'openIntent',[{}]);
    }
}

module.exports = samplePlugin;