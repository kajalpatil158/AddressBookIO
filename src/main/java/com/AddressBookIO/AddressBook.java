package com.AddressBookIO;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.FileReader;

public class AddressBook {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Shree\\eclipse-workspace\\AddressBookIO";
		System.out.println("Starting File writing :" + filePath);
		writeCsv(filePath);
		System.out.println("starting read file");
		readCsv(filePath);
	}

	public static void writeCsv(String filePath) {
		List<AddressBookCsv> Book = new ArrayList<AddressBookCsv>();
		AddressBookCsv Book1 = new AddressBookCsv(filePath, filePath, filePath, filePath, filePath, filePath, filePath,
				filePath, filePath);
		Book1.setfName("Kajal");
		Book1.setlName("Patil");
		Book1.setaddress("Ravet");
		Book1.setCity("pune");
		Book1.setState("Maharashtra");
		Book1.setZip("412101");
		Book1.setPhoneNumber("8208948038");
		Book1.setEmail("kajalpatil158@gmail.com");
		Book.add(Book1);
		FileWriter filewriter1 = null;
		try {
			filewriter1 = new FileWriter(filePath);
			filewriter1.append("fName,lName,address,City,State,Zip,PhoneNumber,Email");
			for (AddressBookCsv ad : Book) {
				filewriter1.append(String.valueOf(ad.getfName()));
				filewriter1.append(String.valueOf(ad.getlName()));
				filewriter1.append(String.valueOf(ad.getaddress()));
				filewriter1.append(String.valueOf(ad.getCity()));
				filewriter1.append(String.valueOf(ad.getState()));
				filewriter1.append(String.valueOf(ad.getZip()));
				filewriter1.append(String.valueOf(ad.getPhoneNumber()));
				filewriter1.append(String.valueOf(ad.getEmail()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				filewriter1.flush();
				filewriter1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void readCsv(String filePath) {
		BufferedReader reader = null;
		try {
			List<AddressBookCsv> Book = new ArrayList<AddressBookCsv>();
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			while (( reader.readLine() != null)) {
				String field = line.split(",");
				if (field.length() > 0) {
					AddressBookCsv Book1 = new AddressBookCsv(field, field, field, field, field, field, field, field,
							field);
					Book1.setfName("Kajal");
					Book1.setlName("Patil");
					Book1.setaddress("Ravet");
					Book1.setCity("pune");
					Book1.setState("Maharashtra");
					Book1.setZip("412101");
					Book1.setPhoneNumber("8208948038");
					Book1.setEmail("kajalpatil158@gmail.com");
					Book.add(Book1);
				}
			}
			for (AddressBookCsv ad : Book) {
				System.out.printf(
						"First Name = %s,Last Name = s, Address = %s, City = %s, State = %s,Zip = %s,Phone Number = %s,Email = %s",
						ad.getfName(), ad.getlName(), ad.getaddress(), ad.getCity(), ad.getState(), ad.getZip(),
						ad.getPhoneNumber(), ad.getEmail());
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
