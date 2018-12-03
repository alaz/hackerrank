#!/bin/ruby

# https://www.hackerrank.com/challenges/frequency-queries

def freqQuery(queries)
  answer = []
  cnt = Hash.new 0
  hist = Array.new queries.length+1, 0

  queries.each_with_index do |q, idx|
    case q[0]
    when 1
      hist[c1 = cnt[q[1]]] -= 1
      hist[cnt[q[1]] = c1 + 1] += 1

    when 2
      c1 = cnt[q[1]]
      if c1 > 0
        hist[c1] -= 1
        hist[cnt[q[1]] = c1 - 1] += 1
      end

    when 3
      answer << (q[1] > idx ? 0 : hist[q[1]] > 0 ? 1 : 0)
    end
  end

  answer
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')

q = gets.strip.to_i

queries = Array.new(q)

q.times do |i|
    queries[i] = gets.rstrip.split.map(&:to_i)
end

ans = freqQuery queries

fptr.write ans.join "\n"
fptr.write "\n"

fptr.close()
