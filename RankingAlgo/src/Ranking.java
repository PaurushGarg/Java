import java.util.Scanner;

public class Ranking {

	public static void main(String[] args) {

		// Creating Scanner Object
		Scanner keyboard = new Scanner(System.in);
		// Creating 2D array
		int[][] teams_scores = new int[3][6];

		System.out.println("Enter the scores of all 6 players of team 1, followed by team 2 Maths Olympiad");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				teams_scores[i][j] = keyboard.nextInt();
			}
		}

		// Printing Input array
		System.out.println("\t" + "P1" + "\t" + "P2" + "\t" + "P3" + "\t" + "P4" + "\t" + "P5" + "\t" + "P6");
		System.out.print("Team1\t");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(teams_scores[i][j] + "\t");
			}
			if (i < 2) {
				System.out.println();
				System.out.print("Team" + (i + 2) + "\t");
			}
		}
		// Raking array- separate array containing rank of each player
		int[][] ranking = new int[3][6];

		// Trying to find the largest score by any player
		int largest;
		int rank = 1, rankRep=0;
		// int k = 0, l = 0;
		int check = 0, num;
		while (check == 0) {
			largest = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					if (teams_scores[i][j] > largest && teams_scores[i][j] != 51) {
						largest = teams_scores[i][j];
						// k = i;
						// l = j;
					}
				}
			}
			//System.out.println(largest);

			// ranking[k][l] = rank;
			rank++;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					if (teams_scores[i][j] == largest) {
						ranking[i][j] = rank;
						
						teams_scores[i][j] = 51;
					}
				}
			}
			num = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					if (teams_scores[i][j] == 51) {
						num++;
					}
				}
			}
			//System.out.println("Stopping Condition = " + num);
			if (num == 18) {

				check = 1;
			}
		}
		System.out.println();
		System.out.println("\nRanking array is: ");
		System.out.println("\t" + "P1" + "\t" + "P2" + "\t" + "P3" + "\t" + "P4" + "\t" + "P5" + "\t" + "P6");
		System.out.print("Team1\t");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(ranking[i][j] + "\t");
			}
			if (i < 2) {
				System.out.println();
				System.out.print("Team" + (i + 2) + "\t");
			}
		}
	
		keyboard.close();
	}
}
