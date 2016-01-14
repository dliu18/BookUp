var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Book Up' });
});

// accept POST request on the homepage
router.post('/', function (req, res) {
  res.send('Got a POST request');
  });

module.exports = router;
