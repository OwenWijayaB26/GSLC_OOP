package main;

public class TeamCheck {
	//Check capacity for Team
	public static boolean CheckFull(String teamName) {
		int count=0;
		String temp[];
		String teamID = "";
		for(int i=0;i<LoadData.listTeam.size();i++) { //Convert nama team jadi team id
			temp = LoadData.listTeam.get(i).split(",");
			for(String tp : temp) {
				if(tp.trim().equalsIgnoreCase(teamName.trim())) { //need to change the teamID system
					teamID = temp[0];
				}
			}
		}
		for(int i=0;i<LoadData.listUser.size();i++) { //Cek apakah user dengan Jumlah teamId == 3
			temp = LoadData.listUser.get(i).split(",");
			for(String tp : temp) {
				if(tp.trim().equalsIgnoreCase(teamID.trim())) {
					count++;
				}
			}
		}
		
		if(count<3 && count != 0) { //if team is not full
			return true;
		}else if(count == 0){ //if team doesn't exist
			String result = LoadData.AssignTeamID()+","+teamName;
			LoadData.listTeam.add(result);
			System.out.println("New team created");
			return true; //add the team into the list then return true
		}else {
			return false; //team is full
		}
	}
	//Check if team exist or not
	public static boolean Exist(String teamname) {
		String temp[];
		int x = 0;
		for(int i=0;i<LoadData.listTeam.size();i++) {
			temp = LoadData.listTeam.get(i).split(",");
			for(String tp : temp) {
				if(tp.trim().equalsIgnoreCase(teamname.trim())) {
					x = 1;
				}
			}
		}
		if(x == 1) {
			return true;
		}else {
			return false;
		}
	}
}
