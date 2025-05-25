public class Location implements IPrintable {

    private String name;
    private String description;
    private boolean locked;

    public Location (String name, String description, boolean locked){
        this.name = name;
        this.description = description;
        this.locked = locked;
    } 

    public void unlock (){
        this.locked = true;
    }

    public boolean isOpen (){
        return locked;
    }

    public String getDescription (){
        return description;
    }

    @Override
    public String getPrintableText(){
        return locked ? "O" : "X";
    }
}