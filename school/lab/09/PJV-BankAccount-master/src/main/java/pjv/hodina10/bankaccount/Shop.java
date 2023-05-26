
package pjv.hodina10.bankaccount;

import java.util.LinkedList;
import java.util.List;


public class Shop {
    
    List<Person> customers;
    double [] bills;
    LinkedList<Thread> list = new LinkedList<Thread>();
    
    public Shop(List<Person> customers, double [] bills){
        this.customers = customers;
        this.bills = bills;
    }
    
    public void makeCustomersPayBills() throws InterruptedException{
         for(Person customer : customers) {
            for(double payment : bills) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println( "Shop start" );
                        try {
                            customer.removeAmountFromBankAccount(payment);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println( "Shop end" );
                    }
                });
                list.add( t );
                t.start();
            }
        }
         // bariera
         for( Thread t : list ) {
             t.join();
         }
    }
    
}
