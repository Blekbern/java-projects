
package pjv.hodina10;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        //controller
        Controller control = new Controller(model);
    }
    
}
