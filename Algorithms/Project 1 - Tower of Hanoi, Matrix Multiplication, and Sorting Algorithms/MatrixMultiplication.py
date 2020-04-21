import random,time,sys,matplotlib.pyplot as pp

def populateMatrices(size): ##Generate NxN Matrix of Random Elements Between 0 and 9 where N == size
    list = []
    for x in range(0,size):
        list.append([]) #Create n rows where n == size
        for y in range(0,size):
            list[x].append(random.randint(0,9)) # Create n columns where n == size
            random.shuffle(list[x]) # Just Extra Random Shuffling of Numbers for Fun
    random.shuffle(list)
    return list
def multiply(matrix1,matrix2): ## Multiply Two Square Matrices
    product = []
    for x in range (0,len(matrix1)):
        product.append([])
        for y in range (0,len(matrix2)):
            product[x].append(0)
            for z in range(0,len(matrix1)): # At Each Index, Add the Product of Correlating Row/Column Factors
                product[x][y]+= matrix1[x][z] * matrix2[z][y]
    return (product)

def main(): ## Driver Program
    testCase = [2,4,8,16,32,64,128,256,512]
    times = []
    for x in testCase:
        arr1 = populateMatrices(x)
        arr2 = populateMatrices(x)
        start = time.time()
        product = multiply(arr1,arr2)
        excTime = round(time.time() - start,3)
        times.append(excTime)
        print("\nExecution Time for %dx%d Matrix Multiplication is %f seconds\n" % (x,x,float(excTime)))
    pp.plot(testCase,times)
    pp.xlabel("Size of Array")
    pp.ylabel("Seconds to Execute")
    pp.show()

main()
