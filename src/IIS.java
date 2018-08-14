import java.util.ArrayList;
import java.util.Scanner;

public class IIS {
    ArrayList<Subject> tours;
    ArrayList<String> regions = new ArrayList<String>();
    ArrayList<String> placements = new ArrayList<String>();
    ArrayList<String> goals = new ArrayList<String>();
    ArrayList<String> confirms = new ArrayList<String>();

    public static void main(String[] args){
        IIS starter = new IIS();
        starter.run();
    }

    public void run(){
        regions.add("Азия");
        regions.add("Европа");
        regions.add("Африка и АЭ");
        regions.add("Другой регион");

        placements.add("Остров");
        placements.add("Материк");

        goals.add("Достопримечательности");   //0
        goals.add("Музыка и танцы");          //1
        goals.add("Курорты");                 //2
        goals.add("Альпинизм");               //3
        goals.add("Правостороннее движение"); //4
        goals.add("Яркие праздники");         //5
        goals.add("Снимают кино");            //6

        confirms.add("Высокие технологии");   //0
        confirms.add("Необычная одежда");     //1
        confirms.add("Богатая мифология");    //2
        confirms.add("Изысканная кухня");     //3
        confirms.add("Связано с футболом");   //4
        confirms.add("Коммунизм");            //5
        confirms.add("Связано с пингвинами"); //6
        confirms.add("Родина Олипийских игр");//7
        confirms.add("Напоминает сапог");     //8
        confirms.add("Романтика");            //9

        Subject britain = new Subject("Британия", "Европа", "Остров");
        britain.goal.add(goals.get(0));
        britain.goal.add(goals.get(4));
        britain.confirmation.add(confirms.get(0));
        britain.confirmation.add(confirms.get(4));

        Subject japan = new Subject("Япония", "Азия", "Остров");
        japan.goal.add(goals.get(3));
        japan.goal.add(goals.get(4));
        japan.confirmation.add(confirms.get(0));

        Subject egypt = new Subject("Египет", "Африка и АЭ", "Материк");
        egypt.goal.add(goals.get(0));
        egypt.goal.add(goals.get(2));
        egypt.confirmation.add(confirms.get(2));

        Subject uar = new Subject("ЮАР", "Африка и АЭ", "Материк");
        uar.goal.add(goals.get(3));
        uar.confirmation.add(confirms.get(4));

        Subject china = new Subject("Китай", "Азия", "Материк");
        china.goal.add(goals.get(0));
        china.goal.add(goals.get(5));
        china.confirmation.add(confirms.get(1));
        china.confirmation.add(confirms.get(5));

        Subject greece = new Subject("Греция", "Европа", "Материк");
        greece.goal.add(goals.get(0));
        greece.goal.add(goals.get(2));
        greece.confirmation.add(confirms.get(7));
        greece.confirmation.add(confirms.get(2));

        Subject italy = new Subject("Италия", "Европа", "Материк");
        italy.goal.add(goals.get(0));
        italy.goal.add(goals.get(2));
        italy.confirmation.add(confirms.get(8));
        italy.confirmation.add(confirms.get(3));
        italy.confirmation.add(confirms.get(2));

        Subject france = new Subject("Франция", "Европа", "Материк");
        france.goal.add(goals.get(0));
        france.confirmation.add(confirms.get(9));
        france.confirmation.add(confirms.get(3));

        Subject mexic = new Subject("Мексика", "Другой регион", "Материк");
        mexic.goal.add(goals.get(1));
        mexic.confirmation.add(confirms.get(1));
        mexic.confirmation.add(confirms.get(3));

        Subject usa = new Subject("США", "Другой регион", "Материк");
        usa.goal.add(goals.get(0));
        usa.goal.add(goals.get(6));
        usa.confirmation.add(confirms.get(0));

        Subject brasil = new Subject("Бразилия", "Другой регион", "Материк");
        brasil.goal.add(goals.get(1));
        brasil.goal.add(goals.get(5));
        brasil.confirmation.add(confirms.get(1));
        brasil.confirmation.add(confirms.get(4));

        Subject india = new Subject("Индия", "Азия", "Материк");
        india.goal.add(goals.get(0));
        india.goal.add(goals.get(6));
        india.confirmation.add(confirms.get(2));

        Subject madagascar = new Subject("Мадагаскар", "Африка и АЭ", "Остров");
        madagascar.goal.add(goals.get(2));
        madagascar.confirmation.add(confirms.get(6));

        Subject iceland = new Subject("Исландия", "Европа", "Остров");
        iceland.goal.add(goals.get(3));
        iceland.confirmation.add(confirms.get(6));

        Subject kuba = new Subject("Куба", "Другой регион", "Остров");
        kuba.goal.add(goals.get(1));
        kuba.confirmation.add(confirms.get(5));

        tours = new ArrayList<Subject>();
        tours.add(britain);
        tours.add(japan);
        tours.add(egypt);
        tours.add(uar);
        tours.add(china);
        tours.add(greece);
        tours.add(italy);
        tours.add(france);
        tours.add(mexic);
        tours.add(usa);
        tours.add(brasil);
        tours.add(india);
        tours.add(madagascar);
        tours.add(iceland);
        tours.add(kuba);

        System.out.println("Курсовая работа не тему:");
        System.out.println("\"Авиарейсы\"");
        chooseRegion(0);
    }

    public boolean chooseRegion(int regionIndex){
        if(regionIndex >= regions.size()){
            System.out.println("Нет результатов!");
            return false;
        }
        System.out.println(regions.get(regionIndex) + "?");
        System.out.print("y/n: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.compareTo("y") == 0){
            ArrayList<Subject> posRegion = new ArrayList<Subject>();
            for(Subject s : tours)
                if(s.region.compareTo(regions.get(regionIndex)) == 0)
                    posRegion.add(s);
            choosePlacement(regions.get(regionIndex), 0, posRegion);
        }
        else if(choice.compareTo("n") == 0){
            chooseRegion(++regionIndex);
        }
        return true;
    }

    public boolean choosePlacement(String region, int placementIndex, ArrayList<Subject> posRegion){
        if(placementIndex >= placements.size()){
            chooseRegion(regions.indexOf(region) + 1);
            //System.out.println("Нет результатов!");
            return false;
        }
        System.out.println(placements.get(placementIndex) + "?");
        System.out.print("y/n: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.compareTo("y") == 0){
            ArrayList<Subject> posPlacement = new ArrayList<Subject>();
            for(Subject s : posRegion)
                if(s.placement.compareTo(placements.get(placementIndex)) == 0)
                    posPlacement.add(s);
            chooseGoal(region, placements.get(placementIndex), 0, posRegion, posPlacement);
        }
        else if(choice.compareTo("n") == 0){
            choosePlacement(region, ++placementIndex, posRegion);
        }
        return true;
    }

    public boolean chooseGoal(String region, String placement, int goalIndex, ArrayList<Subject> posRegion, ArrayList<Subject> posPlacement){
        ArrayList<String> newGoals = new ArrayList<String>();
        for(Subject s : posPlacement){
            for(String st : s.goal){
                if(!newGoals.contains(st))
                    newGoals.add(st);
            }
        }
        if(goalIndex >= newGoals.size()){
            choosePlacement(region, placements.indexOf(placement) + 1, posRegion);
            return false;
        }
        System.out.println(newGoals.get(goalIndex) + "?");
        System.out.print("y/n: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.compareTo("y") == 0){
            ArrayList<Subject> posGoal = new ArrayList<Subject>();
            for(Subject s : posPlacement){
                if(s.goal.contains(newGoals.get(goalIndex)))
                    posGoal.add(s);
            }
            confirmTour(region, placement, newGoals.get(goalIndex), goalIndex, 0, posRegion, posPlacement, posGoal);
        }
        else if(choice.compareTo("n") == 0){
            chooseGoal(region, placement, ++goalIndex, posRegion, posPlacement);
        }
        return true;
    }

    public boolean confirmTour(String region, String placement, String goal, int goalIndex, int confirmIndex, ArrayList<Subject> posRegion, ArrayList<Subject> posPlacement, ArrayList<Subject> posGoal){
        if(confirmIndex >= posGoal.size()){
            chooseGoal(region, placement, ++goalIndex, posRegion, posPlacement);
            return false;
        }
        Subject confirming = posGoal.get(confirmIndex);
        for (String c : confirming.confirmation){
            System.out.println(c + "?");
            System.out.print("y/n: ");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            if(choice.compareTo("n") == 0){
                confirmTour(region, placement, goal, goalIndex, ++confirmIndex, posRegion, posPlacement, posGoal);
            }
        }
        System.out.println("Ваш рейс: " + confirming.name);
        System.out.println("Повторить?");
        System.out.print("y/n: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.compareTo("y") == 0){
            chooseRegion(0);
        }
        return true;
    }
}
