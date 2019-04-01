/*
https://www.hackerrank.com/challenges/common-child
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
  const s1 = yield;
  const s2 = yield;
  ws.write(longest(s1, s2) + '\n');
  ws.end();
})

function longest(s1, s2) {
  const a = new Array(s1.length);
  for (let i = 0; i < s1.length; i++) {
    a[i] = new Array(s2.length);
  }

  for (let i = 0; i < s1.length; i++) {
    for (let j = 0; j < s2.length; j++) {
      if (s1[i] === s2[j]) {
        const x = i < 1 || j < 1 ? 0 : a[i-1][j-1];
        a[i][j] = x + 1;
      } else {
        const x = i < 1 ? 0 : a[i-1][j];
        const y = j < 1 ? 0 : a[i][j-1];
        a[i][j] = Math.max(x, y);
      }
    }
  }
  return a[s1.length-1][s2.length-1];
}
