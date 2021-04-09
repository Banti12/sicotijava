/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

import java.awt.Color;
import static java.awt.SystemColor.menu;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import rojeru_san.RSMPassView;
import rojeru_san.RSMTextFull;
import rojeru_san.RSPanelsSlider;

/**
 *
 * @author Brayan
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Color transparente;
    Color zesati;
    conectar dentro;
    int x;
    int y;
    public login() {
        initComponents();
        transparente= new Color(0,0,0,0);
        zesati= new Color(0,30,100,200);
        dentro= new conectar();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        iniciar();
    }
    public void iniciar(){
        RSMTextFull array[]= {usuario,nu,r1,nu1,r2};
        RSMPassView array2[]={contraseña,c1,c2,c3,c4};
        apagados();
        transparente(array);
        transparente2(array2);
        jFrame1.setBackground(transparente);
        pregunta.setColorFondo(zesati);
        pregunta.setBackground(transparente);
        pregunta.setColorBorde(zesati);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        encabezado.setBackground(zesati);
        this.setLocationRelativeTo(null);
        rSButtonRiple1.setBackground(transparente);
        rSButtonRiple1.setColorHover(zesati);
        rSButtonRiple4.setBackground(transparente);
        rSButtonRiple4.setColorHover(zesati);
        rSButton1.setBackground(transparente);
        rSButton1.setColorHover(new Color(255,255,255,150));
        rSButton2.setBackground(transparente);
        rSButton2.setColorHover(new Color(255,255,255,150));
        rSButton6.setBackground(transparente);
        rSButton6.setColorHover(new Color(255,255,255,150));
        rSButton3.setBackground(transparente);
        rSButton3.setColorHover(new Color(255,255,255,150));
        rSButton4.setBackground(transparente);
        rSButton4.setColorHover(new Color(255,255,255,150));
        rSButtonRiple2.setBackground(transparente);
        rSButtonRiple2.setColorHover(zesati);
        rSButtonRiple8.setBackground(transparente);
        rSButtonRiple8.setColorHover(zesati);
        rSButtonRiple7.setBackground(transparente);
        rSButtonRiple7.setColorHover(zesati);
        encabezado.setBackground(zesati);
        this.setBackground(transparente);
        l0.setVisible(false);
        inicio.setBackground(transparente);
        inicio.transferFocus();
        nuevacontraseña.setColorPrimario(transparente);
        nuevacontraseña.setColorSecundario(transparente);
        jPanel2.setBackground(zesati);
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public void transparente(RSMTextFull array[]){
        for(int i=0;i<array.length;i++){
            array[i].setColorTransparente(true);
        }
    }
    public void transparente2(RSMPassView array[]){
        for(int i=0;i<array.length;i++){
            array[i].setBackground(transparente);
        }
    }
    public void apagados(){
        JLabel array[]={l0,l1,l3,l4,l5,l9,l10,l7};
        for(int i=0;i<array.length;i++){
            array[i].setVisible(false);
        }
        nuevacontraseña.setVisible(false);
    }
    public void clean(){
        nu.setText("");
        c1.setText("");
        c2.setText("");
        r1.setText("");
        nu1.setText("");
        c4.setText("");
        c3.setText("");
        r2.setText("");
    }
            
    public String hash (String dato) throws NoSuchAlgorithmException{
        byte [] imput = dato.getBytes();
        MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
        SHA256.update(imput);
        byte [] digest = SHA256.digest();
        
        StringBuffer hexiDigest = new StringBuffer();
        
        for(int i=0; i < digest.length;i++)
        {
            hexiDigest.append(Integer.toString((digest[i]&0xff)+ 0x100,16).substring(1));
        }
        return hexiDigest.toString();
    }
    public boolean verificarcontraseña(String contraseña){
       char clave;
       
       byte  contNumero = 0, contLetraMay = 0, contLetraMin=0;
       for (byte i = 0; i < contraseña.length(); i++) {
               clave = contraseña.charAt(i);
               String passValue = String.valueOf(clave);
                if (passValue.matches("[A-Z]")) {
                    contLetraMay++;
                } else if (passValue.matches("[a-z]")) {
                    contLetraMin++;
                } else if (passValue.matches("[0-9]")) {
                    contNumero++;
                }
        }
       if(contLetraMay>0 && contNumero >0 && contraseña.length()>=8){
           return true;
       }else{
           return false;
       }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelRound2 = new zesatic.JPanelRound();
        rSButtonRiple5 = new rojeru_san.RSButtonRiple();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        encabezado = new javax.swing.JPanel();
        rSButton3 = new rojeru_san.RSButton();
        rSButton4 = new rojeru_san.RSButton();
        jPanel1 = new javax.swing.JPanel();
        inicio = new rojeru_san.RSPanelsSlider();
        login = new zesatic.JPanelRound();
        jLabel2 = new javax.swing.JLabel();
        usuario = new rojeru_san.RSMTextFull();
        contraseña = new rojeru_san.RSMPassView();
        rSButtonRiple1 = new rojeru_san.RSButtonRiple();
        rSButton1 = new rojeru_san.RSButton();
        rSButtonRiple2 = new rojeru_san.RSButtonRiple();
        l0 = new javax.swing.JLabel();
        candado = new javax.swing.JLabel();
        usuarioicon = new javax.swing.JLabel();
        registro = new zesatic.JPanelRound();
        nu = new rojeru_san.RSMTextFull();
        c1 = new rojeru_san.RSMPassView();
        rSButton2 = new rojeru_san.RSButton();
        rSButtonRiple4 = new rojeru_san.RSButtonRiple();
        l1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        c2 = new rojeru_san.RSMPassView();
        labelRegistro6 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        labelRegistro8 = new javax.swing.JLabel();
        pregunta = new rojerusan.RSComboMetro();
        r1 = new rojeru_san.RSMTextFull();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        labelRegistro9 = new javax.swing.JLabel();
        olvidaste = new zesatic.JPanelRound();
        nu1 = new rojeru_san.RSMTextFull();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        nuevacontraseña = new zesatic.JPanelRound();
        r2 = new rojeru_san.RSMTextFull();
        labelRegistro10 = new javax.swing.JLabel();
        labelRegistro11 = new javax.swing.JLabel();
        c3 = new rojeru_san.RSMPassView();
        l7 = new javax.swing.JLabel();
        labelRegistro7 = new javax.swing.JLabel();
        c4 = new rojeru_san.RSMPassView();
        rSButtonRiple7 = new rojeru_san.RSButtonRiple();
        l10 = new javax.swing.JLabel();
        rSButtonRiple8 = new rojeru_san.RSButtonRiple();
        rSButton6 = new rojeru_san.RSButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jFrame1.setMinimumSize(new java.awt.Dimension(312, 173));
        jFrame1.setUndecorated(true);
        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());

        rSButtonRiple5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple5.setText("Aceptar");
        rSButtonRiple5.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple5MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Operación exitosa.");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exito.png"))); // NOI18N

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(rSButtonRiple5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(33, 33, 33))
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addGroup(jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelRound2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(rSButtonRiple5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jFrame1.getContentPane().add(jPanelRound2, "card3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        rSButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-eliminar-con-linea-horizontal.png"))); // NOI18N
        rSButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton3MouseClicked(evt);
            }
        });

        rSButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        rSButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout encabezadoLayout = new javax.swing.GroupLayout(encabezado);
        encabezado.setLayout(encabezadoLayout);
        encabezadoLayout.setHorizontalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        encabezadoLayout.setVerticalGroup(
            encabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicio.setOpaque(false);

        login.setName("login"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Iniciar sesión");

        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        usuario.setBotonColor(new java.awt.Color(255, 255, 255));
        usuario.setColorTransparente(true);
        usuario.setNextFocusableComponent(contraseña);
        usuario.setPlaceholder("Usuario");
        usuario.setxDarkIcon(true);

        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        contraseña.setBotonColor(new java.awt.Color(255, 255, 255));
        contraseña.setNextFocusableComponent(rSButtonRiple2);
        contraseña.setPlaceholder("Contraseña");
        contraseña.setxDarkIcon(true);
        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaKeyPressed(evt);
            }
        });

        rSButtonRiple1.setBorder(null);
        rSButtonRiple1.setText("Regístrate");
        rSButtonRiple1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple1MouseClicked(evt);
            }
        });

        rSButton1.setText("¿Olvidaste tu contraseña?");
        rSButton1.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButton1.setNextFocusableComponent(rSButtonRiple1);
        rSButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton1MouseClicked(evt);
            }
        });

        rSButtonRiple2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple2.setText("Siguiente");
        rSButtonRiple2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSButtonRiple2.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple2.setNextFocusableComponent(rSButton1);
        rSButtonRiple2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple2MouseClicked(evt);
            }
        });
        rSButtonRiple2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rSButtonRiple2KeyPressed(evt);
            }
        });

        l0.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        l0.setForeground(new java.awt.Color(204, 0, 0));
        l0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l0.setText("El usuario y/o la contraseña son incorectos");

        candado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        candado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bloquear.png"))); // NOI18N

        usuarioicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarioicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/silueta-de-usuario.png"))); // NOI18N

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLayout.createSequentialGroup()
                            .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rSButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(69, 69, 69)))
                    .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(l0)
                        .addGroup(loginLayout.createSequentialGroup()
                            .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usuarioicon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(candado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(37, 37, 37))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioicon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(candado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        inicio.add(login, "card2");

        registro.setName("registro"); // NOI18N
        registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nu.setForeground(new java.awt.Color(255, 255, 255));
        nu.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        nu.setBotonColor(new java.awt.Color(255, 255, 255));
        nu.setNextFocusableComponent(c1);
        nu.setPlaceholder("Nombre de usuario");
        nu.setxDarkIcon(true);
        nu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nuMouseReleased(evt);
            }
        });
        registro.add(nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 85, 307, -1));

        c1.setForeground(new java.awt.Color(255, 255, 255));
        c1.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        c1.setBotonColor(new java.awt.Color(255, 255, 255));
        c1.setNextFocusableComponent(c2);
        c1.setPlaceholder("Contraseña");
        c1.setxDarkIcon(true);
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c1MouseReleased(evt);
            }
        });
        registro.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 152, 307, -1));

        rSButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-izquierda.png"))); // NOI18N
        rSButton2.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton2MouseClicked(evt);
            }
        });
        registro.add(rSButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 429, 40, -1));

        rSButtonRiple4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple4.setText("Ingresar");
        rSButtonRiple4.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple4MouseClicked(evt);
            }
        });
        registro.add(rSButtonRiple4, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 429, 100, -1));

        l1.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        l1.setForeground(new java.awt.Color(204, 0, 0));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setText("Faltan campos por llenar");
        registro.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 403, -1, -1));

        jLabel3.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Crea tu perfil y accede");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        registro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 7, -1, -1));

        jLabel7.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("al sistema.");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        registro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 46, -1, -1));

        c2.setForeground(new java.awt.Color(255, 255, 255));
        c2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        c2.setBotonColor(new java.awt.Color(255, 255, 255));
        c2.setNextFocusableComponent(r1);
        c2.setPlaceholder("Confirmar contraseña");
        c2.setxDarkIcon(true);
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c2MouseReleased(evt);
            }
        });
        registro.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 246, 307, -1));

        labelRegistro6.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro6.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro6.setText("Usa al menos una mayúscula y al menos un número ");
        labelRegistro6.setFocusable(false);
        registro.add(labelRegistro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 200, -1, -1));

        l3.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l3.setForeground(new java.awt.Color(204, 0, 0));
        l3.setText("El usuario ya existe");
        registro.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 62, -1, -1));

        labelRegistro8.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro8.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro8.setText("Selecciona una pregunta de seguridad");
        labelRegistro8.setFocusable(false);
        registro.add(labelRegistro8, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 294, -1, -1));

        pregunta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿Cuál el el nombre de tu primera mascota?", "¿Quién fue tu primer novi@?", "¿A cual país o ciudad te gustaría viajar?", "¿Cuál es tu equipo de fútbol favorito?", "¿Qué marca de ropa es tu preferida?" }));
        pregunta.setColorArrow(new java.awt.Color(0, 30, 100));
        pregunta.setColorBorde(new java.awt.Color(255, 255, 255));
        pregunta.setColorFondo(new java.awt.Color(0, 30, 100));
        registro.add(pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 317, 307, -1));

        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        r1.setBotonColor(new java.awt.Color(255, 255, 255));
        r1.setPlaceholder("Respuesta");
        r1.setxDarkIcon(true);
        r1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                r1MouseReleased(evt);
            }
        });
        registro.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 355, 307, -1));

        l4.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l4.setForeground(new java.awt.Color(204, 0, 0));
        l4.setText("Contraseña no valida");
        registro.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 133, -1, -1));

        l5.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l5.setForeground(new java.awt.Color(204, 0, 0));
        l5.setText("La contraseñas son diferentes");
        registro.add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 133, 179, -1));

        labelRegistro9.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro9.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro9.setText("La contraseña debe contener 8 caracteres.");
        labelRegistro9.setFocusable(false);
        registro.add(labelRegistro9, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 223, -1, -1));

        inicio.add(registro, "card2");

        olvidaste.setName("olvidaste"); // NOI18N

        nu1.setForeground(new java.awt.Color(255, 255, 255));
        nu1.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        nu1.setBotonColor(new java.awt.Color(255, 255, 255));
        nu1.setPlaceholder("Nombre de usuario");
        nu1.setxDarkIcon(true);
        nu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nu1MouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Crea una nueva contraseña");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel9.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("para poder iniciar.");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        l9.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l9.setForeground(new java.awt.Color(204, 0, 0));
        l9.setText("El usuario no existe");

        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        r2.setBotonColor(new java.awt.Color(255, 255, 255));
        r2.setPlaceholder("Respuesta");
        r2.setxDarkIcon(true);
        r2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                r2MouseReleased(evt);
            }
        });

        labelRegistro10.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro10.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro10.setText("Responde a tu pregunta de seguridad");

        labelRegistro11.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro11.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro11.setText("Nueva contraseña");

        c3.setForeground(new java.awt.Color(255, 255, 255));
        c3.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        c3.setBotonColor(new java.awt.Color(255, 255, 255));
        c3.setPlaceholder("Contraseña");
        c3.setxDarkIcon(true);
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c3MouseReleased(evt);
            }
        });

        l7.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l7.setForeground(new java.awt.Color(204, 0, 0));
        l7.setText("Respuesta incorrecta");

        labelRegistro7.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        labelRegistro7.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistro7.setText("Usa al menos una mayúscula y al menos un número ");

        c4.setForeground(new java.awt.Color(255, 255, 255));
        c4.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        c4.setBotonColor(new java.awt.Color(255, 255, 255));
        c4.setPlaceholder("Confirmar contraseña");
        c4.setxDarkIcon(true);
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c4MouseReleased(evt);
            }
        });

        rSButtonRiple7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple7.setText("Cambiar");
        rSButtonRiple7.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple7MouseClicked(evt);
            }
        });

        l10.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        l10.setForeground(new java.awt.Color(204, 0, 0));
        l10.setText("Contraseña no valida");

        javax.swing.GroupLayout nuevacontraseñaLayout = new javax.swing.GroupLayout(nuevacontraseña);
        nuevacontraseña.setLayout(nuevacontraseñaLayout);
        nuevacontraseñaLayout.setHorizontalGroup(
            nuevacontraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevacontraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nuevacontraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nuevacontraseñaLayout.createSequentialGroup()
                        .addComponent(labelRegistro11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(l7))
                    .addComponent(c3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(nuevacontraseñaLayout.createSequentialGroup()
                        .addComponent(labelRegistro7)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(nuevacontraseñaLayout.createSequentialGroup()
                        .addComponent(l10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonRiple7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelRegistro10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        nuevacontraseñaLayout.setVerticalGroup(
            nuevacontraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevacontraseñaLayout.createSequentialGroup()
                .addComponent(labelRegistro10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevacontraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l7)
                    .addComponent(labelRegistro11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRegistro7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevacontraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l10)
                    .addComponent(rSButtonRiple7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSButtonRiple8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple8.setText("Siguiente");
        rSButtonRiple8.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        rSButtonRiple8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple8MouseClicked(evt);
            }
        });

        rSButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-izquierda.png"))); // NOI18N
        rSButton6.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout olvidasteLayout = new javax.swing.GroupLayout(olvidaste);
        olvidaste.setLayout(olvidasteLayout);
        olvidasteLayout.setHorizontalGroup(
            olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(olvidasteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(olvidasteLayout.createSequentialGroup()
                        .addComponent(nuevacontraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, olvidasteLayout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(olvidasteLayout.createSequentialGroup()
                                    .addComponent(l9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rSButtonRiple8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nu1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(olvidasteLayout.createSequentialGroup()
                        .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, olvidasteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        olvidasteLayout.setVerticalGroup(
            olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(olvidasteLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(olvidasteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonRiple8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nuevacontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        inicio.add(olvidaste, "card2");

        jPanel1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 380, 480));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-cepaai.png"))); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zesati.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 80));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo_login.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonRiple1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple1MouseClicked
        // TODO add your handling code here:
        inicio.setPanelSlider(20, registro, RSPanelsSlider.DIRECT.DOWN);
        clean();
        apagados();

    }//GEN-LAST:event_rSButtonRiple1MouseClicked

    private void rSButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton1MouseClicked
        // TODO add your handling code here:
        nuevacontraseña.setVisible(false);
        r2.setText("");
        c3.setText("");
        c4.setText("");
        nu1.setText("");
        nu1.setEditable(true);
        inicio.setPanelSlider(20, olvidaste, RSPanelsSlider.DIRECT.DOWN);
    }//GEN-LAST:event_rSButton1MouseClicked

    private void rSButtonRiple2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple2MouseClicked
        try {
            try {
                // TODO add your handling code here:
                if(dentro.entrar(usuario.getText(), hash(contraseña.getText()))==true){
                    new Thread(new Runnable(){
                        @Override
                        public void run() {
                            principal gemelas= new principal(usuario.getText());
                            gemelas.setVisible(true);
                        }
                    }).start();
                    this.setVisible(false);
                    this.dispose();
                }else{
                    l0.setVisible(true);

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("dnfcksa");
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_rSButtonRiple2MouseClicked

    private void nuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuMouseReleased
        // TODO add your handling code here:
        apagados();
    }//GEN-LAST:event_nuMouseReleased

    private void c1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseReleased
        // TODO add your handling code here:
        apagados();
    }//GEN-LAST:event_c1MouseReleased

    private void rSButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton2MouseClicked
        // TODO add your handling code here:
        inicio.setPanelSlider(20, login, RSPanelsSlider.DIRECT.DOWN);
        apagados();

    }//GEN-LAST:event_rSButton2MouseClicked

    private void rSButtonRiple4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple4MouseClicked
        // TODO add your handling code here:
        int condiciones=0;
        try {
            if(dentro.search(nu.getText())==true){
                condiciones++;
            }else if(!nu.getText().equals("")){
                l3.setVisible(true);
            }else{
                l1.setVisible(true);
            }
            if(c1.getText().equals(c2.getText()) && !c1.getText().equals("")){
                condiciones++;
            }else if(!c1.getText().equals("") && !c2.getText().equals("")){
                l4.setVisible(true);
            }else{
                l5.setVisible(true);
            }
            if(verificarcontraseña(c1.getText()) && !c1.getText().equals("")){
                condiciones++;
            }else{
                l4.setVisible(true);
            }if(r1.getText().isEmpty()){
                l1.setVisible(true);
            }else{
                condiciones++;
            }
            if(condiciones==4){

                try {
                    dentro.insertarnuevousuario(nu.getText(),
                        hash(c1.getText()), hash(r1.getText()),pregunta.getSelectedItem().toString());
                    jFrame1.setVisible(true);
                    jFrame1.setLocationRelativeTo(null);
                    condiciones=0;
                    inicio.setPanelSlider(20, login, RSPanelsSlider.DIRECT.DOWN);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSButtonRiple4MouseClicked

    private void c2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseReleased
        // TODO add your handling code here:
        apagados();
    }//GEN-LAST:event_c2MouseReleased

    private void r1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r1MouseReleased
        // TODO add your handling code here:
        apagados();
    }//GEN-LAST:event_r1MouseReleased

    private void nu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nu1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nu1MouseReleased

    private void r2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_r2MouseReleased

    private void c3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_c3MouseReleased

    private void c4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_c4MouseReleased

    private void rSButtonRiple7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple7MouseClicked
        // TODO add your handling code here:
        if(c3.getText().equals(c4.getText()) && verificarcontraseña(c3.getText())== true )
        {
            try {
                try {
                    if(dentro.revisarcontrahash(nu1.getText(),hash(r2.getText())))
                    {
                        try {
                            dentro.combiocontraseña(c3.getText(),hash(c3.getText()));
                            jFrame1.setVisible(true);
                            jFrame1.setLocationRelativeTo(null);
                            inicio.setPanelSlider(20, login, RSPanelsSlider.DIRECT.DOWN);
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else
                    {
                        l7.setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            l10.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple7MouseClicked

    private void rSButtonRiple8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple8MouseClicked
        // TODO add your handling code here:
        apagados();
        if(!nu1.getText().equals("")){
            try {
                if (!dentro.search(nu1.getText()))
                {
                    nuevacontraseña.setVisible(true);
                    labelRegistro10.setText(dentro.regresarpregunta(nu1.getText()));
                    nu1.setEditable(false);
                }
                else
                {
                    l9.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            l9.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple8MouseClicked

    private void rSButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton6MouseClicked
        // TODO add your handling code here:
        inicio.setPanelSlider(20, login, RSPanelsSlider.DIRECT.DOWN);

    }//GEN-LAST:event_rSButton6MouseClicked

    private void rSButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton3MouseClicked
        // TODO add your handling code here:
        this.setState(principal.ICONIFIED);
    }//GEN-LAST:event_rSButton3MouseClicked

    private void rSButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton4MouseClicked
        // TODO add your handling code here:
        int mj= JOptionPane.YES_NO_OPTION;
        int message= JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir", mj);
        if(message==0){
            System.exit(0);
        }
    }//GEN-LAST:event_rSButton4MouseClicked

    private void rSButtonRiple5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple5MouseClicked
        jFrame1.dispose();
        jFrame1.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple5MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
         this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void rSButtonRiple2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSButtonRiple2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {            
             try {
                try {
                    // TODO add your handling code here:
                    if(dentro.entrar(usuario.getText(), hash(contraseña.getText()))==true){
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                principal gemelas= new principal(usuario.getText());
                                gemelas.setVisible(true);
                            }
                        }).start();
                        this.setVisible(false);
                        this.dispose();
                    }else{
                        l0.setVisible(true);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("dnfcksa");
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }//GEN-LAST:event_rSButtonRiple2KeyPressed

    private void contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {            
             try {
                try {
                    // TODO add your handling code here:
                    if(dentro.entrar(usuario.getText(), hash(contraseña.getText()))==true){
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                principal gemelas= new principal(usuario.getText());
                                gemelas.setVisible(true);
                            }
                        }).start();
                        this.setVisible(false);
                        this.dispose();
                    }else{
                        l0.setVisible(true);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("dnfcksa");
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }//GEN-LAST:event_contraseñaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSMPassView c1;
    private rojeru_san.RSMPassView c2;
    private rojeru_san.RSMPassView c3;
    private rojeru_san.RSMPassView c4;
    private javax.swing.JLabel candado;
    private rojeru_san.RSMPassView contraseña;
    private javax.swing.JPanel encabezado;
    private javax.swing.JLabel fondo;
    private rojeru_san.RSPanelsSlider inicio;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private zesatic.JPanelRound jPanelRound2;
    private javax.swing.JLabel l0;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel labelRegistro10;
    private javax.swing.JLabel labelRegistro11;
    private javax.swing.JLabel labelRegistro6;
    private javax.swing.JLabel labelRegistro7;
    private javax.swing.JLabel labelRegistro8;
    private javax.swing.JLabel labelRegistro9;
    private zesatic.JPanelRound login;
    private rojeru_san.RSMTextFull nu;
    private rojeru_san.RSMTextFull nu1;
    private zesatic.JPanelRound nuevacontraseña;
    private zesatic.JPanelRound olvidaste;
    private rojerusan.RSComboMetro pregunta;
    private rojeru_san.RSMTextFull r1;
    private rojeru_san.RSMTextFull r2;
    private rojeru_san.RSButton rSButton1;
    private rojeru_san.RSButton rSButton2;
    private rojeru_san.RSButton rSButton3;
    private rojeru_san.RSButton rSButton4;
    private rojeru_san.RSButton rSButton6;
    private rojeru_san.RSButtonRiple rSButtonRiple1;
    private rojeru_san.RSButtonRiple rSButtonRiple2;
    private rojeru_san.RSButtonRiple rSButtonRiple4;
    private rojeru_san.RSButtonRiple rSButtonRiple5;
    private rojeru_san.RSButtonRiple rSButtonRiple7;
    private rojeru_san.RSButtonRiple rSButtonRiple8;
    private zesatic.JPanelRound registro;
    private rojeru_san.RSMTextFull usuario;
    private javax.swing.JLabel usuarioicon;
    // End of variables declaration//GEN-END:variables
}
