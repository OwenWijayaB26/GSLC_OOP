package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadData.ReadTeam();
		LoadData.ReadUser();
		Scanner userInput = new Scanner(System.in);
		int menu = 0, select = 0;
		
		while(menu != 4) {
			System.out.println("1. Add/Insert\n2. Show\n3. Delete\n4. Exit");
			menu = userInput.nextInt();
			switch(menu) {
			case 1:
				//Insert Data
				System.out.println("What you want to add? 1. User 2. Team");
				select = userInput.nextInt();
				
				if(select == 1) {
					System.out.print("add nim : ");
					String nim = userInput.next();
					System.out.print("add name : ");
					userInput.nextLine();
					String name = userInput.nextLine();
					System.out.print("add team : ");
					String team = userInput.next();
					//Here need to check if team is full or not
					if(TeamCheck.CheckFull(team)) {
						String result = nim+","+name+","+LoadData.RetrieveTeamID(team);
						LoadData.listUser.add(result);
						System.out.println("User added successfully");
					}else {
						System.out.println("Team is full");
					}
				}
				else if(select == 2) {
					System.out.print("add name : ");
					String name = userInput.next();
					//Check if that team already exist or not
					if(TeamCheck.Exist(name)){//exist or true then don't add
						System.out.println("That team already exist");
					}else {
						String result = LoadData.AssignTeamID()+","+name; //assign an id for it
						LoadData.listTeam.add(result);
						System.out.println("Team successfully added");
					}
				}
				else {
					System.out.println("Please enter 1 or 2");
				}
				
				break;
			case 2:
				//Show Data
				System.out.println("Which one? 1. User 2. Team");
				select = userInput.nextInt();
				if(select == 1) {
					LoadData.PrintUser();
				}else if(select == 2){
					LoadData.PrintTeam();
				}else {
					System.out.println("Please enter 1 or 2");
				}
				break;
			case 3:
				//Delete Data
				System.out.println("What you want to delete? 1. User 2. Team");
				select = userInput.nextInt();
				if(select == 1) {
					System.out.println("Delete based on? 1. NIM 2. Name 3. TeamID");
					int choice = userInput.nextInt();
					userInput.nextLine();
					if(choice == 1 || choice == 2 || choice == 3) {
						System.out.print("Enter the data : ");
						String constrain = userInput.nextLine();
						LoadData.DeleteData(constrain,choice,select);
					}else {
						System.out.println("Please enter 1, 2 or 3");
					}
				}
				else if(select == 2) {
					System.out.println("Delete based on? 1. TeamID 2. Team Name");
					int choice = userInput.nextInt();
					if(choice == 1 || choice == 2) {
						System.out.print("Enter the data : ");
						String constrain = userInput.next();
						LoadData.DeleteData(constrain, choice, select);
					}else {
						System.out.println("Please enter 1 or 2");
					}
					
				}
				else {
					System.out.println("Please enter 1 or 2");
				}
				break;
			case 4:
				//Save all changes
				ApplyChanges.toTeam();
				ApplyChanges.toUser();
			}
		}
		userInput.close();
	}

}
