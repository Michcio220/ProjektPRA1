package Copolminuty;

//Klasa ktora ma w sobie dwa parametry wiążące numer zadsnia i tresc polecenia
public class SqlAns implements Comparable<SqlAns> {

    public int number; //numer zadania
    public String ciagPolecen; // polecenie

    public SqlAns(){}

    public SqlAns(int number, String ciagPolecen) {
        this.number = number;
        this.ciagPolecen = ciagPolecen;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCiagPolecen() {
        return ciagPolecen;
    }

    public void setCiagPolecen(String ciagPolecen) {
        this.ciagPolecen = ciagPolecen;
    }


    @Override
    public int compareTo(SqlAns o) {
        return Integer.compare(this.number,o.number);
    } //funkcja pozwalajaca posortowac tablice na podstawie numeru zadania

}
