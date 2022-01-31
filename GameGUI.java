import java.awt.*;
import java.awt.event.*;


public class GameGUI extends Frame 
{

  // GameBoard properties (square dimension)
  private final int RIGHE = 10;
  private final int COL = 10;
  private final int SQUARE_SIZE = 34; // = 32px +2 di bordi
  //private final Nave n = new Nave(RIGHE,COL);
  
  private final static Color mare = new Color(38, 162, 255);

  // 
  private final Button gameFieldGUI[][] = new Button[RIGHE][COL];
  private final Panel gamePanel = new Panel();

  private Nave campo;
  
  public GameGUI(){ 
    initComponents();
    initGriglia();
  }
  
  private void initGriglia(){
   campo = new Nave();
   campo.creaNavi(3,1);
   campo.creaNavi(5,5);
   campo.creaNavi(2,0);
    //System.out.println(campo.toString());
  }

 private void initComponents(){
    gamePanel.setLayout(new GridBagLayout());
    gamePanel.setPreferredSize(new Dimension(SQUARE_SIZE * RIGHE, SQUARE_SIZE * COL));
    gamePanel.setBackground(mare);    
    createGrid();
    this.add(gamePanel);
    
    this.setTitle("Battleship");
    this.setPreferredSize(new Dimension(SQUARE_SIZE * RIGHE + 60, SQUARE_SIZE * COL + 60));
    this.setResizable(true);
    this.setLocation(500,300);
    this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        
    this.pack();
    this.setVisible(true);
 }
 
 private void createGrid(){
        
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    
    for (int col = 0; col < RIGHE; col++)
    {
      for (int row = 0; row < COL; row++)
      {
        Button button = new Button();
        button.setBackground(Color.green);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
        button.addMouseListener(new MouseAdapter()
        {
          public void mousePressed(MouseEvent event)
          {
            Button button = (Button) event.getSource();
            button.setBackground(Color.WHITE);
            Rectangle rectangle = button.getBounds();
            Point point = button.getLocation();
            
            // calculate field position
            int row = point.y / rectangle.height;
            int col = point.x / rectangle.width;
            
            // shoot on field
            shoot(col, row);
          }
        });
        
        // add button to GUI grid-manager
        gameFieldGUI[col][row] = button;
        
        // set field position into grid layout
        c.gridx = col;
        c.gridy = row;
        
        // add field to the grid
        gamePanel.add(button, c);
      }
    }
  }


  private Button getField(int x, int y){
    return gameFieldGUI[y][x];
  }
  
   public void displayStrike(int x, int y){
    Button field = getField(x, y);
    field.setBackground(Color.RED);
  }

  public void displayMissed(int x, int y){
    Button field = getField(x, y);
    field.setBackground(new Color(85, 185, 218));
  }
  
   private boolean shoot(int x, int y){
    return  false;//gameField.shoot(x, y);
  }
 
  public static void main(String[] args){
    GameGUI g =  new GameGUI();
    Nave n = new Nave();
    System.out.println(n.toString());
    System.out.println("Battleship avviato.");
  }

}
