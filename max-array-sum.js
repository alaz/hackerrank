/*
https://www.hackerrank.com/challenges/max-array-sum
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
  const [a0, a1, ...rest] = arr;
  return rest.reduce(([x0, x1], x) => {
    const max = Math.max(x, x1, x0+x);
    return [x1, max];
  }, [a0, Math.max(a0, a1)])[1];
}
