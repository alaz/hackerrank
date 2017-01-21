# https://www.hackerrank.com/challenges/journey-to-the-moon

require 'set'

N, I = gets.split.map{|x| x.to_i}

def deref(g, n)
  g[n] = deref(g, g[n]) if g[n] != n
  g[n]
end

graph = (0...N).to_a
I.times do
  a, b = gets.split.map{|x| x.to_i}
  graph[deref(graph,a)] = deref(graph,b)
end

depth = Array.new(N, 0)
graph.map { |n| deref(graph,n) }.each { |n| depth[n] = depth[n]+1 }

result = 0
sum = 0
depth.reject {|x| x == 0}.each { |x|
  result = result + sum*x
  sum = sum + x
}

puts result
