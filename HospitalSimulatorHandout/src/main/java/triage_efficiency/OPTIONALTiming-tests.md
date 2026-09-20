OPTIONAL WORK

Number of Patients  Linear Search (ns)  Binary Search (ns)  Jump Search (ns)	
100	                     99977	            53750	            57287
1,000                    1331995            10520               18845
10,000                   1161307            13274               12102
100,000                  11272436           18444               107260

1. With more patients, linear search time on average goes up a lot, and at times can be a very high amount if the target index is near the end of the array. Binary search time typically decreases, or doesn't really change much as more patients are added. This is because binary search splits it in half everytime and can deal with large quantites of patients. Jump search time typically decreased, but for 100,000 patients had a big increase as there are a lot of blocks for it to check.
2. I would recommend binary search. This search had low numbers across all sizes, and is usually best for dealing with very large arrays. Splitting the array in half and checking if the index is above or below is a lot faster than doing jumps or checking every index 1 by 1. This is because no matter the size, every check you do with binary search ALWAYS eliminates half of the indexes. So, it's going to be quick.
3. It can possibly be helpful, but it is not the best way. Run time in nanoseconds also depends on how fast/how good of quality your pc is. Results can also be inconsistent with looking at nanoseconds, so it's not the most accurate. A better way to assess algorithm efficiency is by counting how many steps/indexes the algorithm takes to get to the target. This truly shows how fast it is.

https://medium.com/karuna-sehgal/a-simplified-explanation-of-the-big-o-notation-82523585e835
and https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/AnalLower.html were key sources

The Big O theory predicts that as an input size for arrays or anything that holds data increases, 
the runtime or memory of an algorithm changes based on what type of Big O is present. For example,
O(n) which is linear, is going to grow directly in proportion to whatever the input size is. It has
to check every single index one by one. For binary search, which is O(logn), the runtime grows
very slowly as the input increases a lot, because it gets to still eliminate half of the data at 
every check for the target. Right in between binary and linear is jump search which is 
O(square root of n). It's better than linear because it gets to skip in blocks and doesn't
have to check every index, but it's not a strong as binary because it still has to go through a good
chunk of the array in the blocks, rather than eliminating halves. The Big O theory prediction was
right and supports the data as the best runtime was binary, second was jump search, and last was linear.