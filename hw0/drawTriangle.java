/*  CS61B - HW 0 (optional)
	print out triganle like the following :
*
**
***
****
*****
*/

public class drawTriangle {
public static void main(String[] args){

/*for(int row=0;row<=5;row++){
	for(int col=0;col<row;col++){
		System.out.print("*");
	}
	System.out.println(" ");
}

*/

int row=0;
int size=5;
while(row<=size){
	int col=0;
		while(col<row){
		System.out.print("*");
		col=col+1;
	}
	row=row+1;
	System.out.println(" ");
	}

	}
}
