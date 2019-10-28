// Partner: Taylor

import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
	    if(a.isPlayoffTeam() && !b.isPlayoffTeam()) {
            return -1;
        }
        else if(!a.isPlayoffTeam() && b.isPlayoffTeam()) {
            return 1;
        }
        else {
            if(a.getSalaryInMillions()<b.getSalaryInMillions()) {
                return -1;
            }
            else if(a.getSalaryInMillions()==b.getSalaryInMillions()) {
                return 0;
            }
            return 1; 
        }
        
    }
	public static void main(String Args[]) {
	    CompareByPlayoffsAndSalary c = new CompareByPlayoffsAndSalary();
	    System.out.println(c instanceof Comparator);
	}
		
	}

