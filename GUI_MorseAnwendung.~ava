import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.03.2015
  * @author 
  */

public class GUI_MorseAnwendung extends Frame {
  
  // Anfang Attribute
  private TextArea taKlartext = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  private TextArea taCode = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  private Button btEncodieren = new Button();
  private Button btDecodieren = new Button();
  private Button btKlartextLoeschen = new Button();
  private Button btCodeLoeschen = new Button();
  private Button btBaumZeichnen = new Button();
  // Ende Attribute
  
  private Morsecodierer hCodierer;
  
  /** Konstruktor GUI */
  
  public GUI_MorseAnwendung(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 578; 
    int frameHeight = 355;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    
    // Anfang Komponenten
    
    taKlartext.setBounds(16, 16, 369, 113);
    taKlartext.setFont(new Font("Courier", Font.BOLD, 16));
    cp.add(taKlartext);
    taCode.setBounds(16, 192, 369, 105);
    taCode.setFont(new Font("Courier", Font.BOLD, 15));
    cp.add(taCode);
   
    btEncodieren.setBounds(24, 144, 129, 33);
    btEncodieren.setLabel("Encodieren  v");
    btEncodieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btEncodieren_ActionPerformed(evt);
      }
    });
    cp.add(btEncodieren);
   
    btDecodieren.setBounds(248, 144, 129, 33);
    btDecodieren.setLabel("Decodieren  ^");
    btDecodieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btDecodieren_ActionPerformed(evt);
      }
    });
    cp.add(btDecodieren);
   
    btKlartextLoeschen.setBounds(400, 16, 145, 33);
    btKlartextLoeschen.setLabel("<  Loeschen");
    btKlartextLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btKlartextLoeschen_ActionPerformed(evt);
      }
    });
    cp.add(btKlartextLoeschen);
   
    btCodeLoeschen.setBounds(400, 192, 145, 33);
    btCodeLoeschen.setLabel("<  Loeschen");
    btCodeLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btCodeLoeschen_ActionPerformed(evt);
      }
    });
    cp.add(btCodeLoeschen);
   
    btBaumZeichnen.setBounds(400, 264, 145, 33);
    btBaumZeichnen.setLabel("Morsebaum zeichnen");
    btBaumZeichnen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btBaumZeichnen_ActionPerformed(evt);
      }
    });
    btBaumZeichnen.setEnabled(false);
    cp.add(btBaumZeichnen);
    
    // Ende Komponenten
    
    setVisible(true);
    hCodierer =  new Morsecodierer();
    
  } // end of public GUI_MorseAnwendung
  
  /* Ereignis-Methoden */
  
  // Anfang Methoden
    
  public void btEncodieren_ActionPerformed(ActionEvent evt) {
    String morsecode;
    morsecode = hCodierer.encodiereText (taKlartext.getText());
    taCode.setText (morsecode);
  } 
  
  public void btDecodieren_ActionPerformed(ActionEvent evt) {
    String klartext;
    if (!taCode.getText().equals("")) {
      klartext = hCodierer.decodiereText (taCode.getText());
      taKlartext.setText (klartext);  
    } // end of if   
  } 
     
  public void btKlartextLoeschen_ActionPerformed(ActionEvent evt) {
    taKlartext.setText("");
  } 
  
  public void btCodeLoeschen_ActionPerformed(ActionEvent evt) {
    taCode.setText("");
  } 

  public void btBaumZeichnen_ActionPerformed(ActionEvent evt) {
    // Verwende später Klasse Baumzeichner...
  }
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI_MorseAnwendung("Morsecodierer V. 1.0");
  } // end of main
  
} // end of class GUI_Morsecodierer

