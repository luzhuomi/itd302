public class HelloWorldN 
{
   public static void main(String[] args) 
   {
       if (args.length > 0) 
       {
           int n = Integer.parseInt(args[0]);
           for (int i=0; i<n; i++) 
           { 
              System.out.println("Hello World!"); 
           }
       } 
       else { System.out.println("Hello World!");  }
   }
}

