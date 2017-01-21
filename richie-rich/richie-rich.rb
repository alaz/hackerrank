#!/bin/ruby

#
# https://www.hackerrank.com/challenges/richie-rich
#

def fn(k, s)
  n = s.length
  m = n/2

  d = (0...m).map do |i|
    if s[i] == s[n-i-1]
      s[i] == '9' ? 0 : 2
    else
      1
    end
  end

  ke = k - d.select { |i| i == 1 }.count

  if ke < 0
    return -1
  end

  d.each_with_index { |e,i|
    if e == 2
      if ke > 1
        s[i] = s[n-i-1] = '9'
        ke -= 2
        k -= 2
      end
    elsif e == 1
      if ke > 0 && s[i] != '9' && s[n-i-1] != '9'
        s[i] = s[n-i-1] = '9'
        ke -= 1
        k -= 2
      else
        s[i] = s[n-i-1] = [s[i], s[n-i-1]].max
        k -= 1
      end
    end
  }

  if k > 0 && m*2 < n && s[m] != '9'
    s[m] = '9'
    k -= 1
  end

  return s
end

n,k = gets.strip.split(' ')
n = n.to_i
k = k.to_i
number = gets.strip

print fn(k, number)
