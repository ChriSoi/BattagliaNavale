public class Nave{
  private final int RIGHE=10;
  private final int COL=10;
  private final char matriceNave[][]=new char[RIGHE][COL];
  
 public Nave(){
  for(int rig=0; rig<RIGHE; rig++)
  for(int col=0; col<COL; col++)
   matriceNave[rig][col]=' ';
  }

 public Nave(int RIGHE, int COL){
   int k=1;
   char n;
   for(int rig=0; rig<RIGHE; rig++)
   for(int col=0; col<COL; col++){
    int r=(int)(Math.random()*5);
    if(random())
     n='o';
    else
     n='m';
    while(k<=r){
     matriceNave[rig][col]=n;
     k++;
   }
   k=0;
   }
}
 public boolean random(){
  double r=Math.random();
  if(r>0.5)
   return true;
   return false;
  }
 public String toString(){
  String s="";
   for(int rig=0; rig<RIGHE; rig++){
    for(int col=0; col<COL; col++)
    s+=matriceNave[rig][col];
    s+="\n";
    }
    return s;
  }
}
