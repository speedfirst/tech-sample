var connect = require('connect');
var app = connect();
app.use(connect.logger())
   .use(connect.static(__dirname));
app.listen(4081);

console.log('listen on 4081');
