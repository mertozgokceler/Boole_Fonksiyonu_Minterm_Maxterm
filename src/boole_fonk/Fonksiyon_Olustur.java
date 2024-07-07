package boole_fonk;

import java.util.ArrayList;
import java.util.Arrays;

public class Fonksiyon_Olustur {
	 public void dogruluk_tablo_olustur(String[] columnNames, String[] fonksiyonElemanlari, int[][] data, char[] sıralı_harfler,String fonksiyon_adi) {
	        
		 for (String columnName : columnNames) {        	
	            System.out.print(columnName + "\t");
	        }
	        System.out.println(fonksiyon_adi);
	           
	        String minterm_uzun = "";  
	        String maxterm_uzun = "";  
	        ArrayList<Integer> minterm = new ArrayList<>();
	        ArrayList<Integer> maxterm = new ArrayList<>();
	        for (int i = 0; i < data.length; i++) {
	            for (int j = 0; j < data[i].length; j++) {
	                System.out.print(data[i][j] + "\t");
	            }
	            
	            int functionValue = fonksiyonDegeriHesapla(fonksiyonElemanlari, sıralı_harfler, data[i]);
	            if(functionValue == 1) {	
	            	minterm.add(i);
	            	
	            	for(int k = 0;k<data[i].length;k++) {
	            		minterm_uzun += sıralı_harfler[k];
	            		if(data[i][k] == 0 ) {
	            			minterm_uzun+="'";
	            		}
	            		
	            	}
	            	
	            	minterm_uzun+=" + ";	            	
	            	
	            }
	            else {
	            	maxterm.add(i);
	            	maxterm_uzun += "(";
	            	for(int k = 0;k<data[i].length;k++) {
	            		maxterm_uzun += sıralı_harfler[k];
	            		if(data[i][k] == 1 ) {
	            			maxterm_uzun+="'";
	            		}
	            		if(k < data[i].length-1) {
	            			maxterm_uzun+=" + ";
	            		}
	            		
	            	}
	            	
	            	maxterm_uzun+=").";
	            		            	            	
	            }
	            System.out.println(functionValue);
	        }	 
	        
	        System.out.println("Fonksiyon İfadeleri: ");
	        System.out.println(fonksiyon_adi+" = "+minterm_uzun.substring(0,minterm_uzun.length()-2));
	        System.out.println(fonksiyon_adi+" = "+"Σ"+minterm.toString());
	        System.out.println(fonksiyon_adi+" = "+maxterm_uzun.substring(0,maxterm_uzun.length()-1));	        
	        System.out.println(fonksiyon_adi+" = "+"∏"+maxterm.toString());
	    }

	 private int fonksiyonDegeriHesapla(String[] fonksiyonElemanlari, char[] sıralı_harfler, int[] rowData) {
		 
			    int result = 0;
			    for (String element : fonksiyonElemanlari) {
			        boolean isTrue = true;
			        boolean isReversed = false; 
			        if (element.length() == 1 && !element.contains("'")) {
			           
			            int columnIndex = Arrays.binarySearch(sıralı_harfler, Character.toUpperCase(element.charAt(0)));
			            if (columnIndex >= 0 && rowData[columnIndex] == 1) {
			                
			                result = 1;
			                break;
			            }
			        } else {
			            for (int i = 0; i < element.length(); i++) {
			                char letter = element.charAt(i);			                
			                if (letter == '\'') {
			                    isReversed = true;
			                    char prev_letter = element.charAt(i-1);
			                    int columnIndex = Arrays.binarySearch(sıralı_harfler, Character.toUpperCase(prev_letter));			                   
			                    if (rowData[columnIndex] == 1) {			                    
			                    	isTrue = false;
				                    break;
				                }
			                    isReversed = false;
			                    continue;
			                }
			                int columnIndex = Arrays.binarySearch(sıralı_harfler, Character.toUpperCase(letter));
			                if (columnIndex < 0) {
			                    continue;
			                }
			                if( i < element.length()-1 && element.charAt(i+1) != '\'') {		                
			                if (!isReversed && rowData[columnIndex] == 0) {			                    
			                	isTrue = false;
			                    break;
			                }
			                
			                }
			                else if(i == element.length()-1) {
			                	if (!isReversed && rowData[columnIndex] == 0) {
				                    
				                	isTrue = false;
				                    break;
				                }
			                }
			            }
			            if (isTrue) {
			                result = 1;
			                break;
			            }
			        }
			    }
			    return result;			
	      }
	 } 
	

