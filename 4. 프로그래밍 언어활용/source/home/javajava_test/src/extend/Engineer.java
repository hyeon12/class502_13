package extend;

public class Engineer extends Employee {
    private String skillSet;

    public Engineer(String name) {
        super(name);
    }

    public String getSkillSet(){
        return skillSet;
    }

    public void setSkillSet(String skellSet){
        this.skillSet = skillSet;
    }
}
