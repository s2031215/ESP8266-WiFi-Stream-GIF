import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


class ReadImageFile {

	public int page = 0;
	public int  getpagenum() throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("bytefile.txt")));
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().trim().split(",");
			if(line.length==16){
				page = page +16;
			}
		}
		return page;
	}

   	public byte[][] getarray() throws Exception{
	  getpagenum();
	  Scanner sc = new Scanner(new BufferedReader(new FileReader("bytefile.txt")));
	  int i=0;
	  int j=0;
	  int rows = page/2048;
      int columns = 2048;
   	  byte [][] myArray = new byte[rows+1][columns];
      while(sc.hasNextLine()) {
		String[] line = sc.nextLine().trim().split(",");
		//System.out.println(line.length);
		if(line.length==16){
			for(int k = 0;k<16;k++){
			    //System.out.println(k);
				myArray[i][j] = (byte)Integer.parseInt(line[k].replaceAll("0x", "").trim(),16);
				j++;
				if(j==2048){
					j=0;
					i++;
				}
			}
		}
      }
	   System.out.println("Sucess Load frame "+i);
       return myArray.clone();
	}

}