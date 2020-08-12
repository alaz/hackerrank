#!/bin/ruby
# https://www.hackerrank.com/challenges/abbr/problem

class String
  def upper?
    upcase == to_s
  end

  def lower?
    !upper?
  end
end

def abbr(a, b)
  m = Array.new(b.length+1) { Array.new(a.length+1, false) }
  m[b.length][a.length] = true
  (a.length-1).downto(0).each do |i|
    m[b.length][i] = a[i].lower? && m[b.length][i+1]
  end

  (a.length - 1).downto(0).each do |i|
    (b.length - 1).downto(0).each do |j|
      if a[i] == b[j]
        m[j][i] = m[j+1][i+1]
      elsif a[i].upper?
        m[j][i] = false
      elsif a[i].upcase == b[j]
        m[j][i] = m[j+1][i+1] || m[j][i+1]
      else
        m[j][i] = m[j][i+1]
      end
    end
  end
  m[0][0]
end

fout = File.open(ENV['OUTPUT_PATH'], 'w')

n = gets.to_i
n.times do
  a = gets.to_s.rstrip
  b = gets.to_s.rstrip
  fout.write(abbr(a, b) ? 'YES' : 'NO')
  fout.write "\n"
end
fout.close()
