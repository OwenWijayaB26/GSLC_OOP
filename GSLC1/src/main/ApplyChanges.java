package main;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ApplyChanges {
	public static void toTeam() {
		String filePath = System.getProperty("user.dir")+"/Database/teams.csv";
		try(BufferedWriter br = new BufferedWriter(new FileWriter(filePath,false))){
			for(String team : LoadData.listTeam) {
				br.write(""+team+"");
				br.write("\n");
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Error Team");
		}
	}
	public static void toUser() {
		String filePath = System.getProperty("user.dir")+"/Database/user.csv";
		try(BufferedWriter br = new BufferedWriter(new FileWriter(filePath,false))){
			for(String user : LoadData.listUser) {
				br.write(""+user+"");
				br.write("\n");
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Error User");
		}
	}
	
}
