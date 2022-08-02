public class Matrix {
    /**
     *
     * ID of the neighborhood and the body of the vertex
     */
    private int id;
    private int[][] body;

    /**
     * default constructor
     * @param id the neighborhood id
     * @param size dimension of one side of the vertex
     */
    public Matrix (int id, int size){

        body = new int[size][size];
        this.id = id;
    }

    public int[][] getBody() {
        return body;
    }
}
