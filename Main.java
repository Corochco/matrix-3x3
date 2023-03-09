class Matrix{
    int[][] Array = new int[3][3];
    public Matrix(int[] list){
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                Array[i][j] = list[i*3 + j];
            }
        }
    }
    public int get(int i, int j){
        return Array[i][j];
    }
    public int trace(){
        return Array[0][0] + Array[1][1] + Array[2][2];
    }
    public int det(){
        return Array[0][0] * Array[1][1] * Array[2][2] + Array[1][0] * Array[2][1] * Array[0][2] + Array[0][1] * Array[1][2] * Array[2][0] - Array[2][0] * Array[1][1] * Array[0][2] - Array[1][0] * Array[0][1] * Array[2][2] - Array[1][2] * Array[2][1] * Array[0][0];

    }
    public Matrix add(Matrix Bobik){
        int[] list = new int [9];
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                list[i*3 + j] = Array[i][j] + Bobik.get(i, j);
            }
        }
        Matrix Result = new Matrix(list);
        return Result;
    }
    public Matrix subtract(Matrix Bobik){
        int[] list = new int [9];
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                list[i*3 + j] = Array[i][j] - Bobik.get(i, j);
            }
        }
        Matrix Result = new Matrix(list);
        return Result;
    }
    public Matrix multiply(Matrix Bobik){
        int[] list = new int [9];
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                list[i*3 + j] = Array[i][0] * Bobik.get(0, j) + Array[i][1] * Bobik.get(1, j)  + Array[i][2] * Bobik.get(2, j) ;
            }
        }
        Matrix Result = new Matrix(list);
        return Result;
    }
    public String toString(){
        return "[[" + Array[0][0] + ", " + Array[0][1] + ", " + Array[0][2] + "], [" + Array[1][0] + ", " + Array[1][1] + ", " + Array[1][2] + "], [" + Array[2][0] + ", " + Array[2][1] + ", " + Array[2][2] + "]]";
    }
    //public boolean equals(Matrix obj) {
    //    if (!(obj instanceof Matrix)) return false;
    //    Matrix lst = (Matrix)obj;
    //    return this.Array.equals(lst.Array);
    //}
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Matrix matrix = (Matrix) obj;
            for (int i = 0; i <= 2; i++){
                for (int j = 0; j <= 2; j++){
                    if (this.get(i, j) != matrix.get(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public int hashCode() {
        ///int dnaCode = Array[0][0] * 9 + Array[0][1] * 11 + Array[0][2] * 21 + Array[1][0] * 7 + Array[1][1] * 3 + Array[1][2] * 8 + Array[2][0] * 5 + Array[2][1] * 9 + Array[2][2] * 15;
        return 10 * Array.hashCode() + 1;
    }
}