abstract class TeamMember {
    protected String name;
    
    public TeamMember (String name) {
        this.name = name;
        
    }
    public String getName(){
        return name;
    }
}

interface BonusEligible {
    void calculateBonus();
}


class StandardEmployee extends TeamMember implements BonusEligible {
    public StandardEmployee(String name) {
        super(name);
    }
    
    @Override
    public void calculateBonus(){
        System.out.println("Calculating standard employee bonus for " + name +"...");
    }
}

public class Main {
    public static void main(String[] args ){
        StandardEmployee employee = new StandardEmployee("Didar");
        System.out.println("Employee Name " + employee.getName());
        employee.calculateBonus();
    }
}
