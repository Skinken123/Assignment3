
public class Test2 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello WOrld");
        double[] numbers = {2.3,4.5,7.2};
        double[] newArray = asArray(numbers);
        System.out.println(newArray.toString());
    }

    public static double[] asArray (double[] numbers)
    {
        double[] newNumbers = new double[numbers.length];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        return newNumbers;
    }
}
