package AddSicle;

import java.util.Scanner;

//문제: 사용자로부터 자연수 n을 입력받아, 다음과 같은 모양을 출력하는 프로그램을 작성하세요.
//예시: n=5인 경우
//
//*
//**
//***
//****
//*****
//****
//***
//**
//*

public class For6 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		 System.out.println("자연수 n을 입력하세요: ");
	        int n = scan.nextInt();
	        
	        for(int i=1; i<=n; i++) {
	            for(int j=1; j<=i; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	        for(int i=n-1; i>=1; i--) {
	        	  for(int j=1; j<=i; j++) {
	        	  System.out.print("*");
            }
            System.out.println();
        }
	}
}