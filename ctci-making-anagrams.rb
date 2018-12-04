#!/bin/ruby

# https://www.hackerrank.com/challenges/ctci-making-anagrams

class String
  def histogram
    h = Array.new 26, 0
    each_char do |c|
      h[c.ord - 'a'.ord] +=1
    end
    h
  end
end

def makeAnagram(a, b)
  ah = a.histogram
  bh = b.histogram

  ah.zip(bh).map { |l, r| (l-r).abs }.sum
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')
a = gets.to_s.rstrip
b = gets.to_s.rstrip

res = makeAnagram a, b

fptr.write res
fptr.write "\n"

fptr.close()
