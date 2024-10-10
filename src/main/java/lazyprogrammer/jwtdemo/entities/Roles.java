package lazyprogrammer.jwtdemo.entities;

public enum Roles {

    ADMIN("ADMIN"), NORMAL("NORMAL");

    private final String value;

    Roles(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
