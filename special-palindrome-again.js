/*
https://www.hackerrank.com/challenges/special-palindrome-again
*/
'use strict';

const fs = require('fs');

function readLines(stream, gen) {
  stream.resume();
  stream.setEncoding('utf-8');

  let g = gen();
  let input = "";
  stream.on('data', data => { input += data.toString(); })
        .on('end', () => {
          g.next();
          input.split("\n").forEach(x => g.next(x));
        });
}

const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
readLines(process.stdin, function* main() {
  const n = parseInt(yield, 10);
  const s = yield;
  ws.write(count(n, s) + '\n');
  ws.end();
})

function count(n, s) {
  let retval = 0;
  const singles = [];
  const a = s.split('');

  for (let i = 0; i < n;) {
    let j = i;
    for (; j < n && a[j] === a[i]; j++) ;
    const stride = j - i;
    if (stride === 1) {
      singles.push(i);
      retval ++;
    } else {
      retval += (stride+1)*stride/2;
    }
    i = j;
  }

  return singles.reduce((acc, i) => {
    let j = 1;
    for (; i-j >= 0 && i+j < n && a[i-j] === a[i+j] && a[i-j] === a[i-1]; j++) ;
    return acc + j - 1;
  }, retval);
}
