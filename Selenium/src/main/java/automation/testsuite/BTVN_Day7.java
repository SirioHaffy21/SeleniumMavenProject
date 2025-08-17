package automation.testsuite;

import java.util.Scanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BTVN_Day7 {
	//@Test
	private void NhanVien() {
		Scanner scanner = new Scanner(System.in);
		Scanner scanName = new Scanner(System.in);
		System.out.print("Nhập số lượng tên nhân viên: ");
		int size = scanner.nextInt();
		String[] arrayName = new String[size];
		for (int i = 0; i < arrayName.length; i++) {
			System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
			arrayName[i] = scanName.nextLine();
		}
		System.out.println("==============================");
		System.out.println("In ra danh sách tên nhân viên.");
		for (String name : arrayName) {
			System.out.print(name + " | ");
		}
	}
}
