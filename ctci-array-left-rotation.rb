#!/bin/ruby

#
# https://www.hackerrank.com/challenges/ctci-array-left-rotation
#

n, d = gets.split.map{|x| x.to_i}
buf = Array.new(d)
gets.split(' ').map(&:to_i).each_with_index do |i, idx|
  if idx < d
    buf[idx] = i
  else
    print "#{i} "
  end
end
buf.each { |i| print "#{i} "}
