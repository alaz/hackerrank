#!/bin/ruby

# https://www.hackerrank.com/challenges/sherlock-and-anagrams

class Array
  # A Binary Index Tree storing the number of occurences of
  # every character. The storage size is always 26 bytes.
  def bit_hash
    h = Array.new(26, 0)
    each do |c|
      i = c.ord - 'a'.ord + 1
      while i <= 26
        h[i-1] += 1
        i += i & -i
      end
      h
    end
    h
  end
end

def Math.nCr(n,r)
  a, b = r+1, n-r
  numer = (a..n).inject(:*) || 1
  denom = (1..b).inject(:*) || 1
  numer / denom
end

gets.to_i.times do
  a = gets.rstrip.chars
  total = (a.length-1).times.map do |l|
    word_counts = Hash.new { 0 }
    a.each_cons(l+1).each { |w| word_counts[w.bit_hash] += 1 }
    word_counts.values.select { |v| v > 1 }.map { |v| Math.nCr(v, 2) }.sum
  end.sum
  print "#{total}\n"
end
