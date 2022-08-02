public class Cpsc_Ass1{
    /**
     *
     * calculates the nth fibonacci number using a dynamic array
     * @param n input size
     * @return nth fibonacci number
     */
    public int fibDyn(int n){
        int fibarr[] = new int[n + 1];
        fibarr[0] = 0;
        if(n > 0)
            fibarr[1] = 1;

        if(n <= 1){
            return fibarr[n];
        }
        for(int i = 2; i <= n; i++){
            fibarr[i] = fibarr[i - 1] + fibarr[i - 2];
        }
        return fibarr[n];
    }
    //Dynamic implementation

    /**
     *
     * Calculates the nth fibonacci number using an iterative method
     * @param n input size
     * @return nth fibonacci number
     */
    public int fibIt(int n){
        int newfib = 0;
        int before = 1;
        int temp = 0;

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        for(int i = 0; i < n - 1; i++){
            newfib = temp + before;
            temp = before;;
            before = newfib;
        }
        return newfib;
    }
    //iterative implementation

    /**
     *
     * Calculates the nth fibonacci number using recursion
     * @param n input size
     * @return nth fibonacci number
     */
    public int fibRec(int n){
        int fibn = 0;
        if(n <= 1) return n;
        else{
            fibn = fibRec(n - 1) + fibRec(n - 2);
        }
            return fibn;
    }
    //recursive implementation

    /**
     *
     * Calculates the nth fibonacci number using matrix exponentiation
     * @param n input size
     * @return nth fibonacci number
     */
    public int fibMat(int n){
        if(n == 0){
            return 0;
        }
        int[][] FM = {{1,1},{1,0}};
        matrixPower(n - 1, FM);
        return FM[0][0];
    }

    /**
     *
     * recurses to calculate the power of a matrix
     * @param n input size
     * @param FM
     */
    public void matrixPower(int n, int[][] FM){
        int[][] base = {{1,1}, {1, 0}};
        if(n > 1){
                matrixPower(n / 2, FM);
                //multiply the passed matrix by itself
                matrixMult(FM, FM);
            
            if(n%2 == 1){
                matrixMult(FM, base);
            }
        }
    }

    /**
     *
     * multiplies two matrices
     * @param a the first matrix to multiply
     * @param b the second matrix to multiply
     */
    public void matrixMult(int[][] a, int[][] b){
        int[][] temp = new int[2][2];
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    temp[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                a[i][j] = temp[i][j];
            }
        }
    }
    //Matrix implementation

    /**
     *
     * Calculates the nth fibonacci number using memoization
     * @param n input size
     * @param fibarr array used to store previously calculated recursions
     * @return nth fibonacci number
     */
    public int fibMem(int n, int fibarr[]){

        if(n <= 1) return n;
        else if(fibarr[n] != 0) return fibarr[n];
        else{
            fibarr[n] = fibMem(n-1, fibarr) + fibMem(n-2, fibarr);
            return fibarr[n];
        }
    }
    //Memoization implementation

    /**
     *
     * main method sets input value and loops method calls for the above methods
     * displays the input size, the nth fibonacci number, and the method runtime
     * @param args command line arguments (unused)
     */
    public static void main(String args[]){
        int n = 10;
        int fibarr[] = new int[n+1];
        long timeb;
        long timea;
        Cpsc_Ass1 algos = new Cpsc_Ass1();
        int fun;

        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i < n; i++) {
            timeb = System.nanoTime();
            fun = algos.fibRec(i);
            timea = System.nanoTime() - timeb;
            System.out.println("Recursion (algorithm 1): " + fun);
            System.out.println("input: " + i + " The excecution time for fibRec is:" + timea + " ns");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i < n; i++) {
            timeb = System.nanoTime();
            fun = algos.fibMem(n, fibarr);
            timea = System.nanoTime() - timeb;
            System.out.println("Memoization (algorithm 2: " + fun);
            System.out.println("input: " + i + " The excecution time for fibMem is:" + timea + " ns");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i < n; i++) {
            timeb = System.nanoTime();
            fun = algos.fibDyn(i);
            timea = System.nanoTime() - timeb;
            System.out.println("Dynamic (algorithm 3): " + fun);
            System.out.println("input: " + i + " The excecution time for fibDyn is:" + timea + " ns");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i < n; i++) {

            timeb = System.nanoTime();
            fun = algos.fibIt(i);
            timea = System.nanoTime() - timeb;
            System.out.println("Iterative (algorithm 4): " + fun);
            System.out.println("input: " + i + " The excecution time for fibIt is:" + timea + " ns");
        }
        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i < n; i++) {
            timeb = System.nanoTime();
            fun = algos.fibMat(i);
            timea = System.nanoTime() - timeb;
            System.out.println("Matrix (algorithm 5): " + fun);
            System.out.println("input: " + i + " The excecution time for fibMat is:" + timea + " ns");
        }



    }
}