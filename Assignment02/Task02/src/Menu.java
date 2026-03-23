/// Remember to push to origin

public class Menu implements MenuChoice{
    /// Fields
    private String title;

    public Menu() {
    }

    /// Class Methods



    public void addChoice(MenuChoice choice){

    }

    protected void displayChoices(){

    }

    protected int obtainChoice(){
        return 0;
    }

    protected void processChoice(int choice){
    }
    /// Interface Methods
    @Override
    public String getText() {
        return title;
    }

    @Override
    public void run(){}
}
