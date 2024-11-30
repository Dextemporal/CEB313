public class IntegerSet {
    private boolean[] set;
    //no argument constructor
    public IntegerSet(){
        set = new boolean[101];//initialize array with size 101(0-100)
    }
    //to insert integer into the set array
    public void insert(int integer){
        if(integer>= 0 && integer <=100){
            set[integer] = true;
        }
    }
    //to delete integer
    public void delete(int integer){
        if(integer>= 0 && integer <=100){
            set[integer] = false;
        }
    }
    //to check if integer is in the set
    public boolean contain(int integer){
        if(integer>= 0 && integer <=100){
            return set[integer];
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for(int i=0; i<set.length;i++){
            if (set[i]) {
                sb.append(i).append(", ");
            }
        }
        if(sb.length()>1){
            sb.delete(sb.length()-2,sb.length());
        }
        sb.append("}");
        return sb.toString();
    }
}

