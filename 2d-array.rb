#!/bin/ruby

#
# https://www.hackerrank.com/challenges/2d-array/problem
#

Offsets = [
  [0,0], [0,1], [0,2],
         [1,1],
  [2,0], [2,1], [2,2]
].freeze

arr = Array.new(6) { gets.rstrip.split(' ').map(&:to_i) }

def arr.lens_sum(i,j)
  Offsets.map { |offset| self[offset[0]+i][offset[1]+j] }.sum
end

print 16.times.map { |i| arr.lens_sum(i/4, i%4) }.max
