#!/bin/ruby
# https://www.hackerrank.com/challenges/counting-valleys

def count_valleys(stream)
  stream.reduce([0, 0]) do |(valleys, h), c|
    case c
    when 'D'
      [valleys, h-1]
    when 'U'
      [(h == -1 ? valleys + 1 : valleys), h+1]
    else
      [valleys, h]
    end
  end[0]
end

fout = File.open(ENV['OUTPUT_PATH'], 'w')

n = gets.to_i
# Enumerator#produce only starting from Ruby 2.7
stream = Enumerator.new do |yielder|
  loop { yielder << ARGF.getc }
end.take(n)
fout.write count_valleys(stream)
fout.write "\n"
fout.close()
