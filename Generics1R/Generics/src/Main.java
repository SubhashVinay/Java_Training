interface Player{
    String name();
}

record BaseBallPlayer(String name,String position) implements Player{}

record FootballPlayer(String name,String position) implements Player{}

record VolleyballPlayer(String name,String position) implements Player{}

public class Main {

    public static void main(String[] args) {

        var philly=new Affiliation("city","Philadelphia ,PA","US");
        BaseballTeam phillies1=new BaseballTeam("Philladelphia Phillies");
        BaseballTeam astros1=new BaseballTeam("Houston Astros");
        scoreResult(phillies1,3,astros1,5);

        SportsTeam phillies2=new SportsTeam("Philladelphia Phillies");
        SportsTeam astros2=new SportsTeam("Houston Astros");
        scoreResult(phillies2,3,astros2,5);

        Team<BaseBallPlayer,Affiliation> phillies=new Team<>("Philladelphia Phillies",philly);
        Team<BaseBallPlayer,Affiliation> astros=new Team<>("Houston Astros");
        scoreResult(phillies,3,astros,5);

        phillies.addTeamMember(new BaseBallPlayer("B Harper","Right Fielder"));
        phillies.addTeamMember(new BaseBallPlayer("B Marsh","Right Fielder"));
        var gutherie=new BaseBallPlayer("D Gutherie","Center Fielder");
        phillies.addTeamMember(gutherie);
        phillies.listTeamMembers();

        SportsTeam afc1=new SportsTeam("Adelaide Crows");
        Team<FootballPlayer,String> afc=new Team<>("Adelaide Crows","City of Adelaide,South Australia,in AU");
        var tex=new FootballPlayer("Tex Walker","Centre Half Forward");
        afc.addTeamMember(tex);

        var rory=new FootballPlayer("Rory Laird","Mid Fielder");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer,Affiliation> adelaide=new Team<>("Adelaide Storms");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts","Setter"));
        adelaide.listTeamMembers();

        var canberra=new Team<VolleyballPlayer,Affiliation>("Canberrs Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black","Opposite"));
        canberra.listTeamMembers();

        scoreResult(canberra,0,adelaide,1);
    }

    public static void scoreResult(BaseballTeam team1,int t1_score,BaseballTeam team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void scoreResult(SportsTeam team1,int t1_score,SportsTeam team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void scoreResult(Team team1,int t1_score,Team team2,int t2_score){
        String message=team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
}