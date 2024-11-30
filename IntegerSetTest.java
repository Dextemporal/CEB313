public static void main(String[] args){
    IntegerSet set = new IntegerSet();
    System.out.println("Initial set:" + set);
    set.insert(10);
    set.insert(30);
    set.insert(25);
    System.out.println("After insertion" + set);
    set.delete(25);
    System.out.println("Set after deletion"+ set);

}
