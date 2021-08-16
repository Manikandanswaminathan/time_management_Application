package time_management_application.com;

public class event {

    String name;
    String date;
    String time;

    public event(String name,String date,String time){
        this.name=name;
        this.date=date;
        this.time=time;
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
