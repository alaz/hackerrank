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
  function fn(acc, i1, i2) {
    if (i1 >= s1.length || i2 >= s2.length) {
      return acc;
    } else if (s1[i1] === s2[i2]) {
      return fn(acc+1, i1+1, i2+1);
    }

    function fmax(s, c, j, f) {
      let n = acc;
      while (true) {
        j = s.indexOf(c, j+1);
        if (j < 0) {
          break;
        }
        n = Math.max(n, f(j));
      }
      return n;
    }

    return Math.max(
      fn(acc, i1+1, i2+1),
      fmax(s1, s2[i2], i1, (j) => fn(acc+1, j+1, i2+1)),
      fmax(s2, s1[i1], i2, (j) => fn(acc+1, i1+1, j+1))
    );
  }

  return fn(0, 0, 0);
}
