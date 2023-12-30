package utils;

public enum Columns {
    address(4),
    name(3),
    score(5);
    private int index;
    Columns(int index){
        this.index=index;
    }
    public int getIndex(){
        return index;
    }
}
