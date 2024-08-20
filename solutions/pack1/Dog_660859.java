package solutions.pack1;

import java.util.HashSet;

public class Dog_660859 {
    Breed b;
    int weight;

    public Dog_660859(Breed brb, int w) {
        b = brb;
        weight = w;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog_660859 other = (Dog_660859) obj;
        if (b != other.b)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dog [Breed =" + b + ", weight =" + weight + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + weight;
        return result;
    }


    public Breed getB() {
        return b;
    }


    public int getWeight() {
        return weight;
    }

    
}
