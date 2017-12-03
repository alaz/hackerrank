# https://www.hackerrank.com/challenges/compare-the-triplets

defmodule Solution do
  def main() do
    {:ok, alice} = :io.fread('', '~d ~d ~d')
    {:ok, bob} = :io.fread('', '~d ~d ~d')
    Enum.zip(alice, bob) |> Enum.filter(fn {a,b} -> a != b end) |> Enum.partition(fn {a,b} -> a > b end) |> Tuple.to_list |> Enum.map(fn points -> length(points) end) |> Enum.join(" ") |> IO.puts
  end
end

Solution.main()
