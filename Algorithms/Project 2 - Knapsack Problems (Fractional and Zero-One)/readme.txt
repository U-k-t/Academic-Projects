To execute, either launch the files as a python executable or open your terminal and run "python <filepath>"

"fractionalKnapsack.py" will return a greedy approach to the knapsack problem operating in O(nlog(n)).

"zeroOneKnapsack.py" will return a 0-1 dynamic approach to the knapsack problem operating in O(nW).

Inputs to the problems can either be provided manually or through "input.txt" being included in the same directory as the program.
"input.txt" should be formatted as tuples of (weight,profit) seperated by line breaks.
An example has been included. Additionally you may run "inputGenerator.py" as an executable or in the terminal to apppend more values to "input.txt".

"inputGenerator.py" can be modified on line 3 to adjust how many entries are added to the new file. Additionally random ranges of weights and profits can be adjusted on line 8.
