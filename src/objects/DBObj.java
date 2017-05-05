package objects;

/**
 * Class handles a database object
 * Created by mikaelhorvath on 2017-05-04.
 */
public class DBObj {
    private String name, desc, email, date;
    private int sum;

    /**
     * Constructor
     * @param n = name
     * @param d = description
     * @param e = email
     * @param da = date
     * @param s = sum
     */
    public DBObj(String n, String d, String e, String da, int s){
        this.name = n;
        this.desc = d;
        this.email = e;
        this.date = da;
        this.sum = s;
    }

    /**
     * Returns the name
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the description
     * @return desc
     */
    public String getDesc(){
        return this.desc;
    }

    /**
     * Returns the email
     * @return email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Returns the date
     * @return date
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Returns the sum (Expense)
     * @return sum
     */
    public int getSum(){
        return this.sum;
    }

    public String toString(){
        return this.date+": "+this.name + " " +"-"+" "+this.desc+" "+"-"+" "+this.sum+" "+"SEK";
    }
}
