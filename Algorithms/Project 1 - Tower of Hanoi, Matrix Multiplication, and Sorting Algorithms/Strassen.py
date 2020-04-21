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
def twoByTwo (A,B): ## Compute 2x2 X 2x2 Matrix Multiplication in an O(1) operation
    if (len(A)==2 and len(B)==2):
        return([[A[0][0]*B[0][0]+A[0][1]*B[1][0], A[0][0]*B[0][1]+A[0][1]*B[1][1]],
        [A[1][0]*B[0][0]+A[1][1]*B[1][0], A[1][0]*B[0][1]+A[1][1]*B[1][1]]])
def add (A,B): ## Add Two Matrices of the Same Size
    sum = []
    for x in range(0,len(A)): # Construct Rows
        sum.append([])
        for y in range(0,len(A)): # Add Elements in Matrices and Append to New Matrix
            sum[x].append(A[x][y]+B[x][y])
    return (sum)
def subtract (A,B): ## Subtract Two Matrices of the Same Size
    difference = []
    for x in range(0,len(A)):
        difference.append([]) # Construct Rows
        for y in range(0,len(A)):
            difference[x].append(A[x][y]-B[x][y]) # Take the Difference of Elements and Append to New Matrix
    return (difference)
def quadrants (matrix): ## Divide Matrix of Even Length into Four Quadrants
    mid = len(matrix)/2
    q1 = [[matrix[i][j] for j in range(mid, len(matrix))] for i in range(mid)] # Create a N/2 Matrix of the Upper Right Quadrant
    q2 = [[matrix[i][j] for j in range(mid)] for i in range(mid)] # Create a N/2 Matrix of the Upper Left Quadrant
    q3 = [[matrix[i][j] for j in range(mid)] for i in range(mid, len(matrix))] # Create a N/2 Matrix of the Lower Left Quadrant
    q4 = [[matrix[i][j] for j in range(mid, len(matrix))] for i in range(mid, len(matrix))] # Create a N/2 Matrix of the Lower Right Quadrants
    return q1,q2,q3,q4
def strassen (A,B): ## Perform Strassen Method on Two Matrices
    if (len(A)==2 and len (A[0])==2) and (len(B)==2 and len(B[0])==2): ## Base Case, Size == 2x2
        return twoByTwo(A,B)

    m1,m2,m3,m4 = quadrants(A) # Divide Each Array into Sub-matrices
    n1,n2,n3,n4 = quadrants(B)

    sub1 = strassen(m1,subtract(n2,n4)) #Recursively Perform Strassen Method on 7 Sub-matrices
    sub2 = strassen(add(m1,m2),n4)
    sub3 = strassen(add(m3,m4),n1)
    sub4 = strassen(m4,subtract(n3,n1))
    sub5 = strassen(add(m1,m4),add(n1,n4))
    sub6 = strassen(subtract(m2,m4),add(n3,n4))
    sub7 = strassen(subtract(m1,m3),add(n1,n2))

    Q1 = add(sub1,sub2)  # Reassemble Matrices into 4 Quadrants
    Q2 = add(subtract(add(sub5,sub4),sub2),sub6)
    Q3 = add(sub3,sub4)
    Q4 = subtract(subtract(add(sub1,sub5),sub3),sub7)

    product = [] #Create Final Matrix
    for x in range(0,len(Q1)):
        product.append(Q1[x]+Q2[x])
    for y in range (0,len(Q4)):
        product.append(Q3[x]+Q4[x])
    return(product)

def main(): ## Driver Program
    testCase = [2,4,8,16,32,64,128,256]
    times = []
    for x in testCase:
        arr1 = populateMatrices(x)
        arr2 = populateMatrices(x)
        start = time.time()
        product = strassen(arr1,arr2)
        excTime = round(time.time() - start,3)
        times.append(excTime)
        print("\nExecution Time for %dx%d Matrix Multiplication is %f seconds\n" % (x,x,float(excTime)))
    pp.plot(testCase,times)
    pp.xlabel("Size of Array")
    pp.ylabel("Seconds to Execute")
    pp.show()

main()
