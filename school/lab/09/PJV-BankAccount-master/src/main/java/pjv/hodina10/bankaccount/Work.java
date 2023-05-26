
package pjv.hodina10.bankaccount;

import java.util.LinkedList;
import java.util.List;


public class Work {    
    private List<Person> employees;
    private double [] payments;
    private LinkedList<Thread> list = new LinkedList<Thread>();
    
    public Work(List<Person> employees, double [] payments){
        this.employees = employees;
        this.payments = payments;
    }

    public void payPayments() throws InterruptedException{
        for(Person employee : employees){
            for(double payment : payments){
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println( "Work start" );
                        try {
                            employee.addAmountToBankAccount(payment);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println( "Work end" );
                    }
                });
                t.start();
            }
        }
    }

    public void workJoin() {
        for( Thread t : list ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
}
