#!/bin/ruby

# https://www.hackerrank.com/challenges/alternating-characters

def alternatingCharacters(s)
  def expect(c)
    ('A'.ord + (c.ord - 'A'.ord + 1)%2).chr
  end

  return 0 unless s.length > 1

  a = s.each_char
  r = a.inject([0, a.peek]) do |(n, e), c|
    c == e ? [n, expect(c)] : [n + 1, e]
  end
  r[0]
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')
q = gets.to_i
q.times do |q_itr|
    s = gets.to_s.rstrip
    result = alternatingCharacters s
    fptr.write result
    fptr.write "\n"
end
fptr.close()
