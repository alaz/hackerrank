#!/bin/ruby

#
# https://www.hackerrank.com/challenges/sherlock-and-valid-string
#

def is_valid s
  freq = Array.new 26, 0
  s.each_char { |c| freq[c.ord - 'a'.ord] += 1 }

  freq.reject!(&:zero?)
  freq.sort!

  z = freq[0]
  freq.each_index { |i| freq[i] -= z }

  freq.first == freq.last || freq.last - freq.first == 1 && freq[-2,2] == [0,1] || z == 1 && freq[1] == freq.last
end

s = gets.to_s.rstrip
puts (is_valid(s) ? 'YES' : 'NO')
