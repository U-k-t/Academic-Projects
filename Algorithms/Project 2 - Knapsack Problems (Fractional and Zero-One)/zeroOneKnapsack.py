import os,sys
## Item Class
class Item:
    def __init__(self,itemNum,weight,profit):
        self.itemNum = itemNum
        self.weight = weight
        self.profit = profit

def generateItems(): ## Generate Items for Knapsack Algorithm to Select From
    items = []
    print("Do you have an input.txt? (y/n)") # Check for File Input
    fromFile = input()
    if fromFile == 'y':
        file = open(os.path.join(sys.path[0],"input.txt"), 'r') # input.txt can be filled using inputGenerator.py
        textInput = file.readlines()
        file.close()
        n = len(textInput)
        for x in range(n):
            it = eval(textInput[x])
            items.append(Item(x,it[0],it[1])) # Read file as tuples of items, then convert them into Item objects
    else: #If File Input Doesn't Exist, Take Raw Input
        print("\nHow Many Items are There to Choose From? Enter an Integer")
        n = input()
        for x in range(int(n)):
            print("Enter Item %d's Weight"%x)
            wt = input()
            print("Enter Item %d's Profit"%x)
            pf = input()
            items.append(Item(x,int(wt),int(pf)))
    print("\nItem    Weight   Profit")
    for x in items: #Print Items To Choose From
        print("  %d      %d         %d"%(x.itemNum,x.weight,x.profit))
    return items

class zeroOne:
    @staticmethod
    def knapsack(items,size): ##Calculates Matrix of N+1 Rows X W+1 Columns (Rightmost Entry of Last Row is Max Profit)
        n = len(items)
        knapsack = [[0 for x in range(size + 1)] for x in range(n + 1)] # Construct a 2D Array
        for item in range(n + 1):
            for weight in range(size + 1):
                if item == 0 or weight == 0:
                    knapsack[item][weight] = 0 # Set the First Row and Column to Zeroes
                elif items[item-1].weight <= weight: # Changes Knapsack Profit
                    knapsack[item][weight] = max(items[item-1].profit + knapsack[item-1][weight-items[item-1].weight],  knapsack[item-1][weight])
                else: # Knapsack Profit Does Not Change With New Object at Same Weight
                    knapsack[item][weight] = knapsack[item-1][weight]
        return knapsack

def findItems(knapsack,items,n,capacity): ## Finds which items were added to the knapsack
    output = []
    maximum = knapsack[n][capacity]
    x=n
    y=capacity
    while(knapsack[x][y]!=0 and x>0): #Continues Until It Hits a Zero
        if knapsack[x-1][y]!=maximum: #Finds Which Object Incites the Knapsack Profit to Change
            output.append(items[x-1])
            y-=items[x-1].weight #Shifts Left W Columns, Where W is the Item's Weight
            if y<0:
                y=0
            x-=1
            maximum = knapsack[x][y]
        else:
            x-=1
    return output



def main():
    items = generateItems()
    print("Please Enter Knapsack Capacity. Enter an Integer")
    capacity = input()
    knapsack = zeroOne.knapsack(items,int(capacity))
    maxProfit = knapsack[len(items)][int(capacity)]
    output = findItems(knapsack,items,len(items),int(capacity))
    print("\nFinal Items in Knapsack are:")
    print("\nItem    Weight   Profit")
    for y in output:
        print("\n  %d      %d         %d"%(y.itemNum,y.weight,y.profit))
    print("\nTotal Knapsack Value is %d"%maxProfit)

main()
