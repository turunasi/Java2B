import java.util.Scanner;

class zeller {

  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Input Year");
    int y = scanner.nextInt();
    System.out.println("Input Month");
    int m = scanner.nextInt();
    System.out.println("Input Date");
    int d = scanner.nextInt();
    
    Day InputedDay = new Day(y,m,d);
    System.out.println("the day is "+InputedDay.dayOfWeek());
  }
}
class Day {

  private int year;
  private int month;
  private int date;
  
  public String[] days = {"日","月","火","水","木","金","土"};

  public Day (int year,int month,int date) {
    this.setDays (year,month,date);
  }

  public int getYear() {
    return this.year;
  }

  public int getMonth() {
    return this.month;
  }

  public int getDate () {
    return this.date;
  }

  public void setDays (int year,int month,int date) {
    
    this.year = year;
    this.month = month;
    this.date = date;
  
  }

  public String dayOfWeek () {
    int y = this.getYear();
    int m = this.getMonth();
    int d = this.getDate();

    if ( m == 1 || m ==2 ) {
      y = y - 1;
      m = m + 12;
    }
    
    int h = (y+(y/4)-(y/100)+(y/400)+((13*m+8)/5)+d)%7;
    
    return this.days[h];
  }

}
