#!/bin/ruby
# https://www.hackerrank.com/challenges/jumping-on-the-clouds

def j(n)
  (n-1) / 2 + (n-1) % 2
end

def jumps(seq)
  segments = seq.slice_when { |i,j| i != j }
                .select { |a| a[0] == 0 }
                .map(&:length)
                .map(&method(:j))
  segments.sum + segments.length - 1
end

fout = File.open(ENV['OUTPUT_PATH'], 'w')

n = gets.to_i
c = gets.rstrip.split(' ').map(&:to_i)
fout.write jumps(c)
fout.write "\n"
fout.close()
