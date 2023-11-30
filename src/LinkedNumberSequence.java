// LinkedNumberSequence.java
/****************************************************************
LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.
Author
Fadil Galjic
****************************************************************/
public class LinkedNumberSequence implements NumberSequence
{
    private class Node
    {
        public double number;
        public Node next;
        public Node (double number)
        {
            this.number = number;
            next = null;
        }
    }
    // the first node in the node-sequence
    private Node first;
    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
        if (numbers.length < 2)
        {
             throw new IllegalArgumentException("not a sequence");
        }

        first = new Node(numbers[0]);
        Node n = first;
        for (int i = 1; i < numbers.length; i++)
        {
            n.next = new Node(numbers[i]);
            n = n.next;
        }
    }
    // toString returns the character string representing this
    // sequence
    public String toString ()
    {
        String s = "";
        Node n = first;
        while (n.next != null)
        {
            s = s + n.number + ", ";
            n = n.next;
        }
        s = s + n.number;
        return s;
    }
    
    // length returns the number of numbers in this sequence.
    public int length ()
    {
        int i = 0;
        Node n = first;
        while (n != null)
        {
            i++;
            n = n.next;
        }
        return i;
    }

    // upperBound returns an upper bound for this sequence.
    public double upperBound ()
    {
        Node n = first;
        double i = n.number;
        while (n != null)
        {
            if (i<n.number)
            {
                i = n.number;
            }
            n = n.next;
        }
        return i;
    }
    // lowerBound returns a lower bound for this sequence.
    public double lowerBound ()
    {
        Node n = first;
        double i = n.number;
        while (n.next != null)
        {
            if (i>n.number)
            {
                i = n.number;
            }
            n = n.next;
        }
        return i;
    }

    // numberAt returns the number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    public double numberAt (int position) throws IndexOutOfBoundsException
    {
        Node n = first;
        if ((position < 0) || (length() <= position))
        {
            throw new IndexOutOfBoundsException("This position does not exist in this sequence");
        }

        n = first;
        int currentPosition = 0;
        double posNumber = 0;
        while (n.next != null)
        {
            if (currentPosition == position)
            {
                posNumber = n.number;
                break;
            }
            n = n.next;
            currentPosition++;
        }
        return posNumber;
    }

    // positionOf returns the position of the first occurance of the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
    public int positionOf (double number)
    {
        Node n = first;
        int returnPos = -1;
        int currentPosition = 0;
        while (n.next != null)
        {
            if (n.number == number)
            {
                returnPos = currentPosition;
                break;
            }
            n = n.next;
            currentPosition++;
        }
        return returnPos;
    }

    // isIncreasing returns true if this sequence is increasing, else false is returned.
    public boolean isIncreasing ()
    {
        boolean increasing = true;
        Node n = first;
        while (n.next != null)
        {
            if (n.number>n.next.number)
            {
                increasing = false;
                break;
            }
            n = n.next;
        }
        return increasing;
    }
    // isDecreasing returns true if this sequence is decreasing, else false is returned.
    public boolean isDecreasing ()
    {
        boolean decreasing = true;
        Node n = first;
        while (n.next != null)
        {
            if (n.number<n.next.number)
            {
                decreasing = false;
                break;
            }
            n = n.next;
        }
        return decreasing;
    }

    // contains returns true if this sequence contains the specified number, else false is returned.
    public boolean contains (double number)
    {
        boolean contains = false;
        Node n = first;
        while (n.next != null)
        {
            if (n.number == number)
            {
                contains= true;
                break;
            }
            n = n.next;
        }
        return contains;
    }

    // add adds the specified number to the end of this sequence.
    public void add (double number)
    {
        Node newValue = new Node(number);
        if (first==null)
        {
            first = newValue;
        }
        else
        {
            Node n = first;
            while (n.next != null)
            {
                n = n.next;
            }
            n.next = newValue;
        }
    }

    // insert inserts the given number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    public void insert (int position, double number) throws IndexOutOfBoundsException
    {
        Node n = first;
        if ((position < 0) || (length() <= position))
        {
            throw new IndexOutOfBoundsException("This position does not exist in this sequence");
        }

        Node newNode = new Node(number);
        if (position ==0)
        {
            newNode.next = first;
            first = newNode;
        }
        else
        {
            n = first;
            for (int i = 1; i <= position-1 && n != null; i++)
            {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }     
    }

    // removeAt removes the number at the specified position in this sequence.
    // The method throws IndexOutOfBoundsException if the position is wrong.
    // The method throws IllegalStateException if there are just two numbers in the sequence.
    public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException
    {
        if (first == null)
        {
            throw new IllegalStateException("Sequence is null");
        }
        Node n = first;
        if ((position < 0) || (length() <= position))
        {
            throw new IndexOutOfBoundsException("This position does not exist in this sequence");
        }

        if (position == 0)
        {
            first = first.next;
        }
        else
        {
            n = first;
            for (int i = 1; i <= position-1 && n != null; i++)
            {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    // asArray returns an array containing all of the numbers in this sequence, in the same order as in the sequence.
    public double[] asArray ()
    {
        Node n = first;
        double[] array = new double[length()];
        n = first;
        int i = 0;
        while (n != null)
        {
            array[i] = n.number;
            n = n.next;
            i++;
        }
        return array;
    }
}

