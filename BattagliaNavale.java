public class BattagliaNavale{

  private final static int  RIGA = 10;
  private final static int COL = 10;
  private final static char nave = 'x';
  private final static char acqua = 'm';
  private final char matriceNave[][] = new char[RIGA][COL];
  private int contatore= 0; 
  
  public BattagliaNavale(){
    for(int rig = 0; rig < RIGA; rig++)
      for(int col = 0; col < COL; col++)
        matriceNave[rig][col] = acqua;
  }

  private boolean isLibero(int r ,int c){
    if(matriceNave[r][c] == nave  &&  matriceNave[r-1][c-1] == nave && matriceNave[r-1][c] == nave && matriceNave[r-1][c+1] == nave && matriceNave[r][c+1] == nave && matriceNave[r+1][c+1] == nave 
    && matriceNave[r+1][c] == nave && matriceNave[r+1][c-1] == nave && matriceNave[r][c-1] == nave )
      return false;
    else 
      return true;
 }
 
 private boolean controllo(int r, int c, int lung, boolean dado){
   if(dado){
   if(r+lung < RIGA){
     for(int i = 0; i < lung; i++){
       if(!isLibero(r+i,c))
        return false;
     }
     return true;
   }
   else 
     return false;
   }
   else{
     if(c+lung < COL){
       for(int i = 0; i < lung; i++){
         if(!isLibero(r,c+i))
          return false;
       }
       return true;
     }
     else 
       return false ; 
   }
 }
 
 // true = orizzontale  false = verticale 
 private boolean orientamento(){ 
   if(((int)(Math.random()*3))% 2 == 0 )
     return true;
   else
     return false;
 }
 
 private void piazzaNave(boolean dado, int r, int c , int lung){
   if(dado){ 
     for(int i = r; i < r+lung; i++)
       matriceNave[i][c] = nave;
   }
   else{
     for(int i = c; i  < c+lung; i++)
       matriceNave[r][i] = nave;
   }
 }
 
  public void creaNavi(int n,int lung){
    boolean dado;
    int r,c;
    int cont = 0;
      while (cont < n ){
        dado = orientamento();
        r = (int)((Math.random()*11)%10);
        c = (int)((Math.random()*21)%21);
        if(controllo(r,c,lung,dado)){
          piazzaNave(dado,r,c,lung);
          cont++;
        }
      } 
  }
  
  public String haiVinto(){
    if(contatore == 22)
      return "HAI VINTO";
    else 
      return null;
  }
  
  public char spara(int r , int c ){
    if(matriceNave[r][c] == nave)
      contatore++;
    return matriceNave[r][c] ;
  }
  
  public String toString(){
    String s = "";
    for(int rig = 0; rig < RIGA; rig++){
      for(int col = 0; col < COL; col++)
        s+=matriceNave[rig][col];
      s+="\n";
    }
    return s;
  }
  
}
