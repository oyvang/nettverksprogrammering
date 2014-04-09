app.controller('WhiteboardController', function($scope, daoWhiteboard) {
  var chatVindu = document.getElementById('chatVindu');

  $scope.colors = [
    {name: 'red', value: '#FF0000'},
    {name: 'green', value: '#00FF00'},
    {name: 'blue', value: '#0000FF'}
  ];
  $scope.color = $scope.colors[0];

  daoWhiteboard.setStatusCallback(function(status) {
    if (status == 0) {
      $scope.status = "Not connected";
    }
    else if (status == 1) {
      $scope.status = "Connected";
    }
    else {
      $scope.status = "Connection error";
    }
  });

daoWhiteboard.onmessage(function(object) {
    chatVindu.value += object.chat.melding + "\n";
  });

  var sendMelding = function(txt) {
    chatVindu.style.color=$scope.color.value;
    chatVindu.value += txt + "\n";
  };
  
  $scope.mouseClick = function($event) {
    var name = $scope.name;
    var msg = $scope.msg;
    var txt = name+": "+msg;
    
    sendMelding(txt);
    
    daoWhiteboard.send({
        "chat": {"melding": txt}
    });
  };
});