#!/bin/ruby

# https://www.hackerrank.com/challenges/ctci-bubble-sort

def countSwaps(a)
  swaps = 0
  a.each do |i|
    a.take(a.length-1).each_index do |j|
      next if a[j] < a[j+1]
      a[j], a[j+1] = a[j+1], a[j]
      swaps += 1
    end
  end
  puts "Array is sorted in #{swaps} swaps."
  puts "First Element: #{a.first}"
  puts "Last Element: #{a.last}"
end

n = gets.to_i
a = gets.rstrip.split(' ').map(&:to_i)

countSwaps a
