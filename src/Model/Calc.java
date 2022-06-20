package Model;

public class Calc {
    private long nubmer;
    private double numberDegree;
    public Calc(long number, long degree) // Конструктор принимает число и степень в которую будем возвышать
    {
        this.nubmer = number;
        numberDegree = Math.pow(degree, number);
    }

    public String GetModel() {return nubmer+"       "+numberDegree;} //Метод который возврощает числе и его же в степени
}
