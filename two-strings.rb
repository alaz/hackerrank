#!/bin/ruby

# https://www.hackerrank.com/challenges/two-strings

def shash(s)
  s.each_char.reduce(0) { |n,c| n |= 1 << (c.ord - 'a'.ord) }
end

gets.to_i.times do
  print "%s\n" % ((shash(gets.rstrip) & shash(gets.rstrip)).zero? ? 'NO' : 'YES')
end
