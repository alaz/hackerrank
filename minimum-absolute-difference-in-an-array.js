/*
https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
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
  const arr = (yield).split(' ').map((s) => parseInt(s, 10));
  ws.write(calc(arr) + '\n');
  ws.end();
})

function calc(arr) {
  arr.sort();

  const f = arr.shift();
  const r = arr.reduce(([acc, p], n) => {
      const d = Math.abs(n-p);
      return [Math.min(acc, d), n];
    }, [2000000001, f]);
  return r[0];
}
