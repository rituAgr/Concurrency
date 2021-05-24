public class PrimeNumberUtils {

    public int getPrimeNumberCounts(int limit){
        if(limit ==0)
            return 0;

        int count = 0;
        for (int isPrime=1;isPrime<=limit;isPrime++)
        {
            int divisibleCount=0;
            for (int num = 1; num<=isPrime; num++){
                if(isPrime%num==0)
                    divisibleCount++;
            }
            if(divisibleCount<=2)
                count++;
        }
        return count;
    }
}
