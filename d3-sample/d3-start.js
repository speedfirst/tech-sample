var connect = require('connect');
var app = connect();
app.use(connect.static(__dirname + '/public'));
var port = 3000;
app.listen(port);
console.log('listen to ' + port + '...');
