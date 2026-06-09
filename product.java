public class product
{
int pcode;
String pname;
int price;
 public product(int pcode, String pname, int price){
 this.pcode=pcode;
 this.pname=pname;
 this.price=price;
 }
 product(){
 pcode=0;
 pname="undefined";
 price=0;
 }
 public static void main(String[] args) {
 product p1=new product(1, "Table", 1500);
 product p2=new product(2, "Chair", 1600);
 product p3=new product(3, "Fan", 1000);
 if(p1.price<p2.price && p1.price<p3.price){
 System.out.println(p1.pname+" Product1 have lowest price");
 }
 else if(p2.price<p3.price){
 System.out.println(p2.pname+" product2 have lowest price");
 }
 else{
 System.out.println(p3.pname+" Product3 have lowest price");
 }
 }
}