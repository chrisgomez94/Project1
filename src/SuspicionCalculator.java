import java.util.Scanner;


public class SuspicionCalculator {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello and welcome to the UF suspect suspicion calculator." + "\n");

        System.out.println("Please enter the time of the crime: ");
        int timeCrime = scan.nextInt();

        System.out.println("Please enter the latitude of the crime: ");
        double latiCrime = scan.nextDouble();

        System.out.println("Please enter the longitude of the crime: ");
        double longiCrime = scan.nextDouble();

        System.out.println("Please enter the student's UFID: ");
        int ufid = scan.nextInt();

        System.out.println("Please enter their last timestamp: ");
        int timeStud = scan.nextInt();

        System.out.println("Please enter the latitude of the student: ");
        double latiStud = scan.nextDouble();

        System.out.println("Please enter the longitude of the student: ");
        double longiStud = scan.nextDouble();

        System.out.println("Please enter their heart rate: ");
        int hrate = scan.nextInt();

        boolean moving = false;
        int timediff = (timeCrime-timeStud);
        double distance = Math.sqrt((latiStud-latiCrime)*(latiStud-latiCrime)+(longiStud-longiCrime)*(longiStud-longiCrime));
        int last2digits = Integer.parseInt((Integer.toString(ufid)).substring(6));
        String listStatus = (last2digits > 49) ? "unsafe" : "safe";


        if(hrate >= 100){

            moving = true;

        }

        else{

            moving = false;

        }


        System.out.println("Student " + ufid + " who is on the " + listStatus + " list, and was " + distance + " block units away, at location " +
                "(" + (int)latiStud + "," + (int)longiStud + ") " + "at " + timeCrime + " and determined to be " + activityLevel(moving) +
                " is " + threatLevel(timediff, distance, moving, last2digits) + " to be the Criminal.");
    }

    public static String activityLevel(boolean isActive){

        if(isActive){

            return "active";
        }

        else{

            return "sedentary";
        }

    }

    public static String threatLevel(int timeDiff, double distance, boolean active,int last2digits){

        if(last2digits >= 00 && last2digits <= 49){

            if(timeDiff <= 30 && distance == 1.0 && active){
                return "Highly Likely";
            }

            else if(timeDiff <= 60 && distance <= 1 && active){
                return "Likely";

            }

            else if(timeDiff <= 90 && distance > 3 && active){
                return "Unsure";

            }

            else if(timeDiff <= 120 && distance > 4 && !active){

                return "Unlikely";
            }

            else{

                return "Highly Unlikely";
            }

        }

        else {

            if(timeDiff <= 60 && distance <= 1){
                return "Highly Likely";
            }

            else if(timeDiff <= 90 && distance <= 2 && active){
                return "Likely";

            }

            else if(timeDiff <= 120 && distance > 2){
                return "Unsure";

            }

            else if(timeDiff <= 150 && distance > 3 && !active){

                return "Unlikely";
            }

            else{

                return "Highly Unlikely";
            }


        }


    }
}
