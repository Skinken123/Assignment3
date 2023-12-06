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
        return numbers.length;
    }

    // upperBound returns an upper bound for this sequence.
    public double upperBound ()
    {
        double biggestNumber = numbers[0];

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
         if (position < 0 || position > numbers.length)
        {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        double indexNumber = numbers[position];
        return indexNumber;
    }

    // positionOf returns the position of the first occurance of the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
    public int positionOf (double number)
    {
        int position = -1;
        
        for (int i = 0; i<numbers.length; i++) 
        {
            if (numbers[i] == number)
            {
                position = i;
                break;
            }
        }
        return position;
    }

    // isIncreasing returns true if this sequence is increasing, else false is returned.
    public boolean isIncreasing ()
    {
        boolean isIncrease = true;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i]>=numbers[i+1])
            {
                isIncrease = false;
                break;
            }
        }
        return isIncrease;   
    }

    // isDecreasing returns true if this sequence is decreasing, else false is returned.
    public boolean isDecreasing ()
    {
        boolean isDecrease = true;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i]<=numbers[i+1])
            {
                isDecrease = false;
                break;
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

    // add adds the specified number to the end of this array sequence.
    public void add (double number)
    {
        double[] newNumbers = new double[numbers.length +1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        newNumbers[numbers.length] = number;
        numbers = newNumbers;
    }

    // insert inserts the given number at the specified position in this array sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    public void insert (int position, double number) throws IndexOutOfBoundsException
    {
        if (position < 0 || position > numbers.length)
        {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        double[] newNumbers = new double[numbers.length + 1];

        for (int i = 0; i < position; i++)
        {
            newNumbers[i] = numbers[i];
        }

        newNumbers[position] = number;

        for (int i = position; i < numbers.length; i++)
        {
            newNumbers[i + 1] = numbers[i];
        }

        numbers = newNumbers;
    }

    // removeAt removes the number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    // The method throws IllegalStateException if there are just two numbers in the sequence.
    public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException
    {
        if (position < 0 || position > numbers.length)
        {
            throw new IndexOutOfBoundsException("Invalid position");
        }
         if (numbers.length <= 2)
        {
            throw new IllegalStateException("not a sequence");
        }
        
        double[] newNumbers = new double[numbers.length-1];
        for (int i = 0; i < position; i++)
        {
            newNumbers[i] = numbers[i];
        }
        for (int i = position; i < numbers.length-1; i++)
        {
            newNumbers[i] = numbers[i+1];
        }

        numbers = newNumbers;
    }

    // asArray returns an array containing all of the numbers in this sequence, in the same order as in the sequence.
    public double[] asArray ()
    {
        double[] newNumbers = new double[numbers.length];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        return newNumbers;
    }

    // toString returns the character string representing this sequence
    public String toString ()
    {
        String s = "";
        String s2;
        for (int i = 0; i < numbers.length; i++)
        {
            s = s + numbers[i] + ", ";
        }
        s2 = s.substring(0,s.length()-2);
        return s2;
    }
}
