package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class miniproject {
	static String dirName = "D:\\javastudy\\names";
	static String filename = dirName + "\\info.txt";

	public static void main(String[] args) {
		System.out.println("*******************************");
		System.out.println("*       전화번호 관리 프로그램            *");
		System.out.println("*******************************");
		
		
		List<Phone> list = new ArrayList<>();
		try {
			File file = new File(filename);
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
		
            String line = "";
            while((line = br.readLine()) != null){
            	Phone phone = new Phone();
            	String[] tokens = line.split(",");
            	phone.setName(tokens[0]);
            	phone.setHp(tokens[1]);
            	phone.setTel(tokens[2]);
            	list.add(phone); 
             } 
			
	            br.close();
			}catch (IOException e) {
	        	e.printStackTrace();
	        }
			
				
			while(true) {
				System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
				System.out.println("-------------------------------");
				System.out.println("메뉴번호:");
			
				Scanner scanner = new Scanner(System.in);
				int num = scanner.nextInt();
				
				if (num == 1) {
					System.out.println("<1.리스트>"); 
		
					for(int i = 0; i < list.size(); i++) {
					System.out.print(i+1);
					System.out.println("."+list.get(i));
				
						}
				
				}
			
				else if (num == 2) {
					System.out.println("<2.등록>");
					try {
						
						Phone phone = new Phone();

							System.out.print(">이름:");
							String name = scanner.next();
							System.out.print(">휴대전화:");
							String hp = scanner.next();
						    System.out.print(">집전화:");
						    String tel = scanner.next();
						    
						    phone.setName(name);
			            	phone.setHp(hp);
			            	phone.setTel(tel);
			            	list.add(phone);
						} catch (Exception e) {
						    e.printStackTrace();
						}
					}		
				else if(num == 3) {
					
					System.out.println("<3.삭제>");
					System.out.println(">번호:");
					int m = scanner.nextInt();
					list.remove(m-1);
					System.out.println("[삭제되었습니다.]");
					
					
						}
				
				else if(num ==4) {
				
	            	
					System.out.println("<4.검색>");
					System.out.println(">이름");
					String n = scanner.next();
				
						for(Phone e : list){
							if (e.getName().contains(n)) {
							   System.out.println(e);
							}
					}
						}
				
			
				else if(num == 5) {
					System.out.println("*******************************");
					System.out.println("*       감사합니다            *");
					System.out.println("*******************************");
					break;
					
				} 
				else if(num !=1 || num !=2 || num !=3 || num !=4 || num !=5){
					try {
						System.out.println("[다시입력해주세요]");
								
					}catch (Exception e) {
					    e.printStackTrace();
								
							}
						}
					
						}
				}
	}		
		
//try {
//File file = new File(filename);
//FileWriter fw = new FileWriter(file);
//BufferedWriter bw = new BufferedWriter(fw);
//
//bw.write(list+"\r\n");
//bw.flush();
//bw.close();System.out.println("[등록되었습니다]");
//} catch (IOException e) {
//e.printStackTrace();
//}	
