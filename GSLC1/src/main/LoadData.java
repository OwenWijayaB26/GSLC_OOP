package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData{
	static ArrayList<String> listTeam = new ArrayList<>();
	static ArrayList<String> listUser = new ArrayList<>();
	
	//ReadFile and Store it
	public static void ReadTeam() {
		String tempS;
		String filePath = System.getProperty("user.dir")+"/Database/teams.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			while((tempS = br.readLine())!= null) {
				listTeam.add(tempS);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void ReadUser() {
		String tempS;
		String filePath = System.getProperty("user.dir")+"/Database/user.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			while((tempS = br.readLine())!= null) {
				listUser.add(tempS);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Team ID Management
	public static String RetrieveTeamID(String teamname) {
		String temp[];										
		String teamID="";
		for(int i=0;i<listTeam.size();i++) {
			temp = listTeam.get(i).split(",");
			for(String tp : temp) {
				if(tp.trim().equalsIgnoreCase(teamname.trim())) {
					teamID = temp[0];
				}
			}
		}
		return teamID;
		
	}
	public static String AssignTeamID() {
		String temp[] = listTeam.get(listTeam.size()-1).split(",");
		int id = Integer.parseInt(temp[0]);
		String newID = ""+(id+1);
		return newID;
	}
	
	//Print Data
	public static void PrintUser() {
		for(String user : listUser) {
			System.out.println(user.replace(",", "\t"));
		}
	}
	public static void PrintTeam() {
		for(String team : listTeam) {
			System.out.println(team.replace(",", "\t"));
		}
	}
	
	//Delete Data from Team or User
	public static void DeleteData(String constrain, int option, int select) {
		String temp[];
		int x = 0;
		switch(select) {
		case 1:
			switch(option) {
			case 1:
				for(int i = 1;i<listUser.size();i++) {
					temp = listUser.get(i).split(",");
					if(temp[0].trim().equalsIgnoreCase(constrain.trim())) {
						listUser.remove(i);
						x++;
					}
				}
				if(x==0) {
					System.out.println("No matching User with that NIM");
				}else {
					System.out.println("User is/are deleted successfully");
				}
				break;
			case 2:
				for(int i = 1;i<listUser.size();i++) {
					temp = listUser.get(i).split(",");
					if(temp[1].trim().equalsIgnoreCase(constrain.trim())) {
						listUser.remove(i);
						x++;
					}
				}
				if(x==0) {
					System.out.println("No matching User with that Name");
				}else {
					System.out.println("User is/are deleted successfully");
				}
				break;
			case 3:
				for(int i=1;i<listUser.size();i++) {
					temp = listUser.get(i).split(",");
					if(temp[2].trim().equalsIgnoreCase(constrain.trim())) {
						listUser.remove(i);
						i = i-1;
						x++;
					}
				}
				if(x==0) {
					System.out.println("No matching User with that Team ID");
				}else {
					System.out.println("User is/are deleted successfully");
				}
				break;
			}
			break;
		case 2:
			switch(option) {
			case 1:
				for(int i=1;i<listTeam.size();i++) {
					temp = listTeam.get(i).split(",");
					if(temp[0].trim().equalsIgnoreCase(constrain.trim())) {
						listTeam.remove(i);
						x++;
					}
				}
				if(x==0) {
					System.out.println("No matching Team with that Team ID");
				}else {
					System.out.println("Team is deleted successfully");
				}
				break;
			case 2:
				for(int i=1;i<listTeam.size();i++) {
					temp = listTeam.get(i).split(",");
					if(temp[1].trim().equalsIgnoreCase(constrain.trim())) {
						listTeam.remove(i);
						x++;
					}
				}
				if(x==0) {
					System.out.println("No matching Team with that Team ID");
				}else {
					System.out.println("Team is deleted successfully");
				}
				break;
			}
			break;	
		}
	}
}