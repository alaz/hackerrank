#!/bin/ruby

# https://www.hackerrank.com/challenges/ctci-ransom-note

m, n = gets.split.map{|x| x.to_i}

magazine = Hash.new { 0 }
note = Hash.new { 0 }

gets.split.each { |w| magazine[w] += 1 }
gets.split.each { |w| note[w] += 1 }

oops = note.any? { |w, k| !magazine.key?(w) || magazine[w] < k }
print (oops ? 'No' : 'Yes')
