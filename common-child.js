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
  const n = s1.length;
  const ai_1 = new Array(n);
  for (let j = 0; j < n; j++) {
    ai_1[j] = 0;
  }

  for (let i = 0; i < n; i++) {
    let aj_1 = 0;
    for (let j = 0; j < n; j++) {
      let temp = 0;
      if (s1[i] === s2[j]) {
        temp = 1 + (j < 1 ? 0 : ai_1[j-1]);
      } else {
        temp = Math.max(aj_1, ai_1[j]);
      }
      if (j > 0) {
        ai_1[j-1] = aj_1;
      }
      aj_1 = temp;
    }
    ai_1[n-1] = aj_1;
  }
  return ai_1[n-1];
}
