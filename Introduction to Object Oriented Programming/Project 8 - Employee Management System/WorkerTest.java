public class WorkerTest
{
   public static void main(String[] args)
   {
      ProductionWorker worker1 = new ProductionWorker
      ("John Smith","123-A","11-15-2005",1,23.50);
      System.out.println(worker1);
      ProductionWorker worker2 = new ProductionWorker();
      worker2.setName("Joan Jones");
      worker2.setId("222-L");
      worker2.setHire("12-12-2018");
      //Hired in the future. Impressive ¯\_(ツ)_/¯
      worker2.setShift(2);
      worker2.setPay(18.5);
      System.out.println(worker2);
      ProductionWorker worker3 = new ProductionWorker
      ("Tony Gaddis", "ABC-1", "1-23-2006", 3, 19.50);
      System.out.println(worker3);
   }
}