/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.03.2015
  * @author 
  */

public class Morsecodierer {
  
  
  private BinaryTree<Character> zeichenBaum;
  private BinaryTree<Character> ltb, rtb, tb1, tb2, tb, tbI, tbA, tbN, tbM, tbT, tbE;
  private int counter = 0;
  
  /** Konstruktor */
  
  public Morsecodierer() {
    Character ch = new Character('#');       // Ersatzzeichen für Wurzel
    zeichenBaum = new BinaryTree<Character>(ch);
    
    // Teilaufgabe 1: Erledigt!
    baumAufbauen();
    
    // Uebungsaufgabe
    // baumErstellen();
    
    // Uebungsaufgabe
    baumAnzeigen();
    
    // Uebungsaufgabe 6
    System.out.println (anzahlBuchstaben(zeichenBaum));  
  }
  
  // Anfang Methoden
  
  // Teilaufgabe 1
  
  private void baumAufbauen() {
    
    ltb = new BinaryTree<Character> (new Character('H'));
    rtb = new BinaryTree<Character> (new Character('V'));
    tb1 = new BinaryTree<Character> (new Character('S'), ltb, rtb);
    
    ltb = new BinaryTree<Character> (new Character('F'));
    rtb = new BinaryTree<Character>();
    tb2 = new BinaryTree<Character> (new Character('U'), ltb, rtb);
    
    tbI = new BinaryTree<Character> (new Character('I'), tb1, tb2);
    
    ltb = new BinaryTree<Character> (new Character('L'));
    rtb = new BinaryTree<Character>();
    tb1 = new BinaryTree<Character> (new Character('R'), ltb, rtb);
    
    ltb = new BinaryTree<Character> (new Character('P'));
    rtb = new BinaryTree<Character> (new Character('J'));
    tb2 = new BinaryTree<Character> (new Character('W'), ltb, rtb);
    
    tbA = new BinaryTree<Character> (new Character('A'), tb1, tb2);
    
    tbE = new BinaryTree<Character> (new Character('E'), tbI, tbA);
    
    ltb = new BinaryTree<Character> (new Character('B'));
    rtb = new BinaryTree<Character> (new Character('X'));
    tb1 = new BinaryTree<Character> (new Character('D'), ltb, rtb);
    
    ltb = new BinaryTree<Character> (new Character('C'));
    rtb = new BinaryTree<Character> (new Character('Y'));
    tb2 = new BinaryTree<Character> (new Character('K'), ltb, rtb);
    
    tbN = new BinaryTree<Character> (new Character('N'), tb1, tb2);
    
    ltb = new BinaryTree<Character> (new Character('Z'));
    rtb = new BinaryTree<Character> (new Character('Q'));
    tb1 = new BinaryTree<Character> (new Character('G'), ltb, rtb);
    
    rtb = new BinaryTree<Character> (new Character('O'));
    
    tbM = new BinaryTree<Character> (new Character('M'), tb1, rtb);
    
    tbT = new BinaryTree<Character> (new Character('T'), tbN, tbM);
    
    zeichenBaum = new BinaryTree<Character> (new Character('#'), tbE, tbT);
    
    
  } 
  
  // Teilaufgabe 2
  
  public String decodiereText (String pText) {   
    
    String[] morsecodes = pText.split("/");
    String klartext = "";
    
    for (int cnt=0; cnt<morsecodes.length; cnt++) {
      
      klartext += decodiereZeichen(morsecodes[cnt]);
      
    } // end of for
    
    return klartext;   // Dummywert, damit komplierbar
  }
  
  private BinaryTree<Character> findNode(String pMorsecode)
  {
    String tmp = pMorsecode;
    BinaryTree<Character> aktNode = zeichenBaum;
    
    while (tmp.length()>0) {
      
      if (tmp.substring(0,1).equals(".")) {
        //links abbiegen
        aktNode = aktNode.getLeftTree();
        
      } else  //rechts abbiegen
      aktNode = aktNode.getRightTree();
      
      if(tmp.length()==1)
      {
        tmp = "";
      } else {
        tmp = tmp.substring(1, tmp.length());    
      } // end of if-else
      
      
    } // end of while
    
    return aktNode;
    
  }
  
  private char decodiereZeichen (String pMorsecode) {
    //Erwartet den Morsecode ohne führende oder folgende Trennzeichen.
    
    return findNode(pMorsecode).getContent();
    
  }
  
  // Teilaufgabe 3
  
  public void anhaengen (char pZeichen, String pCode) {
    
    //Vorbedingung: Der Morsecode muss muss mit den linken n-1 Zeichen
    //bereits im Baum existieren. Fehlerfälle werden nicht abgefangen
    //und führen zu einem zerstörten Baum.
    
    BinaryTree<Character> tmp, newNode;
    newNode = new BinaryTree<Character>(pZeichen);   //Ein Blatt erzeugen
    
    tmp = findNode(pCode.substring(0,pCode.length()-1));
    
    //In tmp steht nun der Code der die ersten n-1 Zeichen codiert. Das nächste Zeichen muss nun
    //passend angehängt werden:
    
    if (pCode.substring(pCode.length()).equals(".")) {
      //Der Punkt muss links angehängt werden.
      tmp.setLeftTree(newNode);
    } else {
      //Der Strich rechts.
      tmp.setRightTree(newNode);
    } // end of if-else
    
  }  
  
  // Hilfreich für Tests: Baumanzeige durch Inorder-Durchlauf
  
  public void baumAnzeigen() {
    inorder (zeichenBaum);
    // inorder (zeichenBaum, 0); 
  }  
  
  private void inorder (BinaryTree<Character> baum) {
    if (baum.isEmpty()) 
    return;
    else {
      inorder (baum.getRightTree());
      System.out.println(baum.getContent().toString());
      inorder (baum.getLeftTree());
    } 
  }
  
  // Uebungsaufgabe 5
  
  public void baumErstellen() {
    zeichenBaum = new BinaryTree<Character>(new Character('#'));
    anhaengen ('E', ".");
    anhaengen ('T', "-");
    anhaengen ('I', "..");
    anhaengen ('M', "--");  
    
    // usw.  
    
  }  
  
  // Uebungsaufgabe 6
  
  private int anzahlBuchstaben (BinaryTree<Character> baum) {
    
    if (!baum.isEmpty()) {
      
      anzahlBuchstaben(baum.getLeftTree());
      anzahlBuchstaben(baum.getRightTree());
      counter++;
    } // end of if
    
    
    
    return counter-1;   //Den leeren Knoten an der Baumspitze nicht mitzählen.
  }  
  
  // Uebungsaufgabe 7
  
  private void inorder (BinaryTree<Character> baum, int tiefe) {
    if (baum.isEmpty()) return;
    inorder (baum.getRightTree(), tiefe+1);
    for (int i = 0; i < tiefe; i++) {
      System.out.print ("    ");
    }
    System.out.println(baum.getContent().toString());
    inorder(baum.getLeftTree(), tiefe+1);
  }
  
  // Uebungsaufgabe 8 ... fehlt!
  
  public void anhaengenRekursiv () {
    
  }
  
  
  // Uebungsaufgabe 9.c)
  
  public String encodiereText (String pText) {
    return "";   // Dummy...
  }
  
  // Uebungsaufgabe 9.b)
  
  private String encodiereZeichen (char pZeichen, BinaryTree<Character> pBaum, String pTeilcode) {
    return "";   // Dummy...               
  }
  
  
  public BinaryTree<Character> getBaum() {  //fuer  Baumzeichner
    return zeichenBaum;
  }  
  // Ende Methoden 
  
} // end of Morsecodierer
