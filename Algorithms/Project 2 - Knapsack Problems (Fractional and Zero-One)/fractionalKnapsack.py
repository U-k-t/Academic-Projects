import os,sys
## Item Class
class Item:
    def __init__(self,itemNum,weight,profit):
        self.itemNum = itemNum
        self.weight = weight
        self.profit = profit
        self.unitCost = profit//weight

    def __lt__(self, comparison): ## Comparison Method for Comparing Two Items
        return self.unitCost < comparison.unitCost


class fractionalKnapsack:
    @staticmethod
    def maximizeProfit (items,size): #Takes a list of items and capacity of Knapsack to Maxmize Profit
        items.sort(reverse = True) # Sort Items By unitCost
        knapsack = []
        for x in items:
            itemWeight = x.weight
            itemProfit = x.profit

            if size-itemWeight >=0: # Since the list is sorted, if the knapsack can fit an item, it will accept it
                size -= itemWeight
                knapsack.append(x)
            else: # Otherwise, take a portion of the first item that the knapsack cant fit, therefore filling it
                portion = size/itemWeight
                print("\nTaking %.3f percent of item %d"%(portion*100,x.itemNum))
                size = int(size - itemWeight*portion)
                x.weight = itemWeight*portion
                x.profit = portion * itemProfit
                knapsack.append(x)
                break
        return (knapsack)

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



def main():
    items = generateItems()
    print("Please Enter Knapsack Capacity. Enter an Integer")
    capacity = input()
    knapsack = fractionalKnapsack.maximizeProfit(items,int(capacity))
    totalProfit = 0
    print("\nFinal Items in Knapsack are:")
    print("\nItem    Weight   Profit")
    for y in knapsack:
        totalProfit += y.profit
        print("\n  %d      %d         %.0f"%(y.itemNum,y.weight,y.profit))
    print("\nTotal Knapsack Value is %.2f"%totalProfit)

main()
