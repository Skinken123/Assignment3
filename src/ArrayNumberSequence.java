// ArrayNumberSequence.java
/****************************************************************
ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.
Author
Fadil Galjic
****************************************************************/
public class ArrayNumberSequence implements NumberSequence
{
    // numbers in the sequence
    private double[] numbers;
    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
        if (numbers.length < 2)
        {
            throw new IllegalArgumentException("not a sequence");
        }
        this.numbers = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++)
        {
            this.numbers[i] = numbers[i];
        }
    }

    // length returns the number of numbers in this sequence.
    public int length ()
    {
        int length = numbers.length;
        return length;
    }

    // upperBound returns an upper bound for this sequence.
    public double upperBound ()
    {
        double biggestNumber = 0;

        for (double d : numbers) 
        {
            if (d>biggestNumber)
            {
                biggestNumber = d;
            }
        }
        return biggestNumber;
    }
    
    // lowerBound returns a lower bound for this sequence.
    public double lowerBound ()
    {
        double samllestNumber = numbers[0];

        for (double d : numbers) 
        {
            if (samllestNumber>d)
            {
                samllestNumber = d;
            }
        }
        return samllestNumber;
    }

    // numberAt returns the number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    public double numberAt (int position) throws IndexOutOfBoundsException
    {
        if (position>numbers.length)
        {
            throw new IndexOutOfBoundsException("Position does not exist in current sequence");
        }
        double indexNumber = numbers[position];
        return indexNumber;
    }

    // positionOf returns the position of the first occurance of the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
    public int positionOf (double number)
    {
        boolean foundNumber = true;
        int position = 0;
        int position2 = 0;

        while (foundNumber && position< numbers.length) 
        {
            for (double d : numbers) 
            {
                if (d == number)
                {
                    position = position2;
                    foundNumber = false;
                    break;
                }
                else
                {
                  position = -1;  
                }
                position2++;
            }
        }
        return position;
    }

    // isIncreasing returns true if this sequence is increasing, else false is returned.
    public boolean isIncreasing ()
    {
        boolean isIncrease = true;

        while (isIncrease) 
        {
            for (int i = 0; i < numbers.length; i++)
            {
                if (numbers[i]>numbers[i+1])
                {
                    isIncrease = false;
                    break;
                }
            }
        }
        return isIncrease;   
    }

    // isDecreasing returns true if this sequence is decreasing, else false is returned.
    public boolean isDecreasing ()
    {
        boolean isDecrease = true;

        while (isDecrease) 
        {
            for (int i = 0; i < numbers.length; i++)
            {
                if (numbers[i]<numbers[i+1])
                {
                    isDecrease = false;
                    break;
                }
            }
        }
        return isDecrease;   
    }

    // contains returns true if this sequence contains the specified number, else false is returned.
    public boolean contains (double number)
    {
        boolean contains = true;
        if (positionOf(number) == -1)
        {
            contains = false;
        }
        return contains;
    }

    // add adds the specified number to the end of this sequence.
    public void add (double number)
    {
        
    }

    // insert inserts the given number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    public void insert (int position, double number) throws IndexOutOfBoundsException
    {

    }

    // removeAt removes the number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    // The method throws IllegalStateException if there are just two numbers in the sequence.
    public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException
    {

    }

    // asArray returns an array containing all of the numbers in this sequence, in the same order as in the sequence.
    public double[] asArray ()
    {
        return d;
    }

    // toString returns the character string representing this
    // sequence
    public String toString ()
    {
        String s = "";
        for (int i = 0; i < numbers.length - 1; i++)
        {
            s = s + numbers[i] + ", ";
            s = s + numbers[numbers.length - 1];
        }
        return s;
    }
    // add code here
}
