package com.wolken.wolkenapp;

import java.util.Scanner;

import com.wolken.wolkenapp.dao.PrisonDAO;
import com.wolken.wolkenapp.dao.PrisonDAOImpl;
import com.wolken.wolkenapp.dto.PrisonDTO;
import com.wolken.wolkenapp.service.PrisonService;
import com.wolken.wolkenapp.service.PrisonServiceImpl;

public class PrisonUtil {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		PrisonService ps = new PrisonServiceImpl();
		PrisonDAO pd = new PrisonDAOImpl();
		PrisonDTO pdto = new PrisonDTO();

		while (true) {
			System.out.println("\nPrison Details");
			System.out.println("\nSelect a number");
			System.out.println("1=Insert prison details\n2=Display details\n3=UpdateById\n4=DeleteById\n");
			System.out.println("....................................................................");
			Scanner sc = new Scanner(System.in);
			try{int opt = sc.nextInt();
			
			try {
				switch (opt) {
				case 1:
					try {
					System.out.println("enter id");
					pdto.setId(sc.nextInt());
					System.out.println("enter name");
					pdto.setName(sc.next());
					System.out.println("enter place");
					pdto.setPlace(sc.next());
					System.out.println(" enter no  of prisoners");
					pdto.setNo_of_prisoners(sc.nextInt());
					boolean b = ps.validateInputAndInsert(pdto);
					if (b)
						System.out.println("data added ");
					break;
				} catch (Exception e) {
						// TODO: handle exception
					System.out.println("No such entity in db to update");
					}
				case 2:
					pd.display();
					break;
				case 3:
					System.out.println("Enter id to be updated ");
					int i = sc.nextInt();
					System.out.println("Enter the new");
					String name = sc.next();
					ps.validateAndUpdate(i, name);
					break;
				case 4:
					System.out.println("Enter the id");
					int id = sc.nextInt();
					boolean vad = ps.validateAndDelete(id);
					if(vad) {
						System.out.println("Deleted sucessfully");
					}
					else {
						System.out.println("Enter another id");
					}
					break;
				default:
					System.out.println("Invalid Entry");

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Enter valid option");
			}
		}

//		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("enter id");
//			pdto.setId(sc.nextInt());
//			System.out.println("enter name");
//			pdto.setName(sc.next());
//			System.out.println("enter place");
//			pdto.setPlace(sc.next());
//			System.out.println(" enter no  of prisoners");
//			pdto.setNo_of_prisoners(sc.nextInt());
//			boolean b = ps.validateInputAndInsert(pdto);
//			if (b)
//				System.out.println("data added ");
//			// ps.validateAndUpdate(65, "nagesh");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		//ps.validateAndDelete(65);
//		// pd.display();
//		// pd.updatebyId(pdto.getId(), pdto.getName());
//		// pd.deletebyId(12);
////		pd.display();
//
//	}

	}
}
