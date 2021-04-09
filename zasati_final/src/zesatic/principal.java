/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

import ecxel.Excel;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.black;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import rojeru_san.RSButton;
import rojeru_san.RSMTextFull;
import rojeru_san.RSPanelsSlider;
import rojerusan.RSComboMetro;
import rojerusan.RSTableMetro;
import rojerusan.necesario.RSScrollBar;

/**
 *
 * @author Brayan
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    String usuario;
    Color transparente;
    conectar dentro;
    Color zesati;
    int x;
    int y;
    alta altamenu;
    reportemenu reportemenu;
    bajamenu bajamenu;
    cambiomenu cambiomenu;
    
    public principal(String usuario) {
        initComponents();
        this.usuario=usuario;
        this.setLocationRelativeTo(null);
        transparente= new Color(0,0,0,0);
        zesati=new Color(0,30,100,200);
        dentro= new conectar();
        reportemenu = new reportemenu(usuario);
        cambiomenu= new cambiomenu(usuario);
        cambiomenu.setName("cambiomenu");
        reportemenu.setName("reportemenus");
        altamenu= new alta(usuario);
        altamenu.setName("altamenus");
        bajamenu= new bajamenu(usuario);
        bajamenu.setName("bajamenu");
        menuprincipal.add(reportemenu);
        menuprincipal.add(cambiomenu);
        menuprincipal.add(bajamenu);
        menuprincipal.setPanelSlider(reportemenu, RSPanelsSlider.DIRECT.RIGHT);
        menuprincipal.add(altamenu);
        
        iniciar();
        apagados();
        
    }

    public String verificarnombre(String contraseña){
       char clave;
       String password=contraseña;
       int jota=0;
       for (byte i = 0; i < contraseña.trim().length(); i++) {
               clave = contraseña.charAt(i);
               String passValue = String.valueOf(clave);
               if(passValue.matches("[\\+\\-\\*\\/\\=\\%\\&\\#\\!\\?\\^\\“\\'\\~\\ \\<\\>\\(\\[\\)\\]\\{\\}\\:\\;\\.\\,\"]") && !passValue.endsWith(" ")) {
                    if(!String.valueOf(contraseña.trim().charAt(i-1)).equals("\\")){
                        if(contraseña.trim().lastIndexOf(passValue)==contraseña.trim().length()-1){
                             String aux[]=contraseña.trim().split("\\"+passValue);
                             password="";
                             if(aux.length<=1){
                                  password+=aux[0]+"\\"+passValue;
                                  contraseña=password;
                             }else{
                                     for(int j=0; j<aux.length-1;j++){
                                         password+=aux[j]+"\\"+clave;
                                         jota=j;
                                     }
                                     contraseña=password+aux[jota+1]+"\\"+clave;
                             }
                     }else{
                         String aux[]=contraseña.trim().split("\\"+passValue);
                         password="";
                         if(aux.length<=1){
                              password+=aux[0]+"\\"+passValue;
                              contraseña=password;
                         }else{
                                 for(int j=0; j<aux.length-1;j++){
                                     password+=aux[j]+"\\"+clave;
                                     jota=j;
                                 }
                                 contraseña=password+aux[jota+1];
                         } 
                     }
                     System.out.println(contraseña);
                     jota=0;
                     i++; 
                     }else{
                        i++;
                    }         
            }
        }
       return contraseña;
    }
    public void apagados(){
        errorproyecto.setVisible(false);
        cambiomodelsocio3.setVisible(false);
        socio2p.setVisible(false);
        errorproyecto1.setVisible(false);
        errorproyecto2.setVisible(false);
    }          
    public boolean checadorerrores(String [] a){
        boolean si = true;
        int contador=0;
        if(a!=null){
            
            for (int i = 0 ; i<a.length;i++)
            {
                if(a[i] == null || a[i] ==""){
                    contador++;
                }
            }
            if(contador==a.length){
                si=true;
            }else{
                si=false;
            }
        }else{
            si=false;
        }
        return si;
    }
    
    public void actualizar_proyecto(){
        if(pv.getBackground().equals( new Color(0,30,100))){
            RSMTextFull array[]={buscarempresa2,bajaproyecto,idcliente,servicioproyecto,hp,socio1p,socio2p,buscarservicio2,buscarservicio1};
            limpiadorcajatexto(array);
            diaproyecto.setSelectedIndex(0);
            mesproyecto.setSelectedIndex(0);
            anoproyecto.setSelectedIndex(0);
            cambiomodelsocio3.setVisible(false);
            apagados();
            tablaempresa2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Inicio", "Fin", "Cliente", "Horas presupuestadas", "Horas trabajadas", "Resto", "Activo", "Ejercicio"
                }
            ));
            tablacliente1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Id", "Cliente", "Ingreso"
                }
            ));
            tablaservicio1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Id", "Servicio", "Descripción corta"
                }
            ));
        }
    }
    
    public void limpiadorcajatexto(RSMTextFull array[]){
        for (int i=0;i<array.length;i++){
            array[i].setText("");
        }
    }
    public void limpiadorbox(RSComboMetro array[]){
        for (int i=0;i<array.length;i++){
            array[i].setSelectedIndex(0);
        }
    }
    public void cambiarcolor(RSButton n , RSButton n1 , RSButton n2 , RSButton n3 , RSButton n4 , RSButton n5 ){
                n.setBackground(new Color(255, 255, 255));
                n.setColorText(new Color(0, 30, 100));
                n.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255,69,20)));
                n.setColorHover(new Color(255,255,255));
                n.setColorTextHover(new Color(0,30,100));
                
                RSButton menu[] = {n1,n2,n3,n4,n5};
                int i=0;
                for(i = 0;i<5;i++)
                {
                    menu[i].setBackground(new Color(0, 30, 100));
                    menu[i].setColorText(new Color(255, 255, 255));
                    menu[i].setBorder(null);
                }
            }
    public void cambiarcolorreporte(RSButton n , RSButton menu[]){
                n.setBackground(new java.awt.Color(255, 255, 255));
                n.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
                n.setColorText(new java.awt.Color(0, 30, 100));
                n.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,20)));
                n.setColorHover(new Color(255,255,255));
                n.setColorTextHover(new Color(0,30,100));
                n.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                for(int i =0;i< menu.length; i++)
                {
                    menu[i].setBackground(new java.awt.Color(0, 30, 100));
                    menu[i].setColorText(new java.awt.Color(255, 255, 255));
                    menu[i].setBorder(null);
                    menu[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
                    menu[i].setColorHover(new java.awt.Color(204, 204, 255));
                    menu[i].setColorTextHover(new java.awt.Color(0, 30, 100));
                }
            }
    public void iniciar(){
        
        selector.setBackground(new Color(255,255,255));
        tablaservicio1.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablacliente1.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablaempresa2.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        jScrollPane12.getVerticalScrollBar().setUI(new RSScrollBar());
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setBackground(transparente);
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
        jPanel1 = new javax.swing.JPanel();
        minimizar_principal = new rojeru_san.RSButton();
        cerrar_principal = new rojeru_san.RSButton();
        reporte = new rojeru_san.RSButton();
        sb = new rojeru_san.RSButton();
        pv = new rojeru_san.RSButton();
        alta = new rojeru_san.RSButton();
        baja = new rojeru_san.RSButton();
        cambio = new rojeru_san.RSButton();
        menuprincipal = new rojeru_san.RSPanelsSlider();
        subirexcel = new javax.swing.JPanel();
        selector = new javax.swing.JFileChooser();
        proyectovista = new javax.swing.JPanel();
        sliderejercicio = new rojeru_san.RSPanelsSlider();
        vista = new javax.swing.JPanel();
        jPanelRound18 = new zesatic.JPanelRound();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rSButtonRiple1 = new rojeru_san.RSButtonRiple();
        jPanelRound1 = new zesatic.JPanelRound();
        bajaproyecto = new rojeru_san.RSMTextFull();
        rSButtonRiple19 = new rojeru_san.RSButtonRiple();
        errorproyecto2 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaempresa2 = new rojerusan.RSTableMetro();
        buscarempresa2 = new rojeru_san.RSMTextFull();
        rSButton14 = new rojeru_san.RSButton();
        altaejercicio = new javax.swing.JPanel();
        jPanelRound10 = new zesatic.JPanelRound();
        jLabel79 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        servicioproyecto = new rojeru_san.RSMTextFull();
        rSButtonRiple10 = new rojeru_san.RSButtonRiple();
        errorproyecto = new javax.swing.JLabel();
        cambiomodelsocio2 = new rojerusan.RSComboMetro();
        fechainiciotexto9 = new javax.swing.JLabel();
        fechainiciotexto10 = new javax.swing.JLabel();
        rSButtonRiple12 = new rojeru_san.RSButtonRiple();
        rSButtonRiple13 = new rojeru_san.RSButtonRiple();
        cambiomodelsocio3 = new rojerusan.RSComboMetro();
        socio1p = new rojeru_san.RSMTextFull();
        socio2p = new rojeru_san.RSMTextFull();
        idcliente = new rojeru_san.RSMTextFull();
        hp = new rojeru_san.RSMTextFull();
        jLabel33 = new javax.swing.JLabel();
        diaproyecto = new rojerusan.RSComboMetro();
        mesproyecto = new rojerusan.RSComboMetro();
        anoproyecto = new rojerusan.RSComboMetro();
        errorproyecto1 = new javax.swing.JLabel();
        jPanelRound23 = new zesatic.JPanelRound();
        jScrollPane24 = new javax.swing.JScrollPane();
        tablaservicio1 = new rojerusan.RSTableMetro();
        rSButton18 = new rojeru_san.RSButton();
        buscarservicio1 = new rojeru_san.RSMTextFull();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacliente1 = new rojerusan.RSTableMetro();
        rSButton19 = new rojeru_san.RSButton();
        buscarservicio2 = new rojeru_san.RSMTextFull();
        rSButton20 = new rojeru_san.RSButton();
        jLabel1 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(1280, 700));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizar_principal.setBackground(new java.awt.Color(0, 30, 100));
        minimizar_principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-eliminar-con-linea-horizontal.png"))); // NOI18N
        minimizar_principal.setNextFocusableComponent(cerrar_principal);
        minimizar_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizar_principalMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 40, -1));

        cerrar_principal.setBackground(new java.awt.Color(0, 30, 100));
        cerrar_principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        cerrar_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrar_principalMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 40, -1));

        reporte.setBackground(new java.awt.Color(255, 255, 255));
        reporte.setBorder(null);
        reporte.setForeground(new java.awt.Color(0, 30, 100));
        reporte.setText("Reporte");
        reporte.setColorHover(new java.awt.Color(255, 255, 255));
        reporte.setColorText(new java.awt.Color(0, 30, 100));
        reporte.setColorTextHover(new java.awt.Color(0, 30, 100));
        reporte.setNextFocusableComponent(sb);
        reporte.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reporteMouseClicked(evt);
            }
        });
        jPanel1.add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        sb.setBackground(new java.awt.Color(0, 30, 100));
        sb.setText("Subir excel");
        sb.setColorHover(new java.awt.Color(255, 255, 255));
        sb.setColorTextHover(new java.awt.Color(0, 30, 100));
        sb.setNextFocusableComponent(pv);
        sb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbMouseClicked(evt);
            }
        });
        jPanel1.add(sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, -1));

        pv.setBackground(new java.awt.Color(0, 30, 100));
        pv.setText("Ejercicios");
        pv.setColorHover(new java.awt.Color(255, 255, 255));
        pv.setColorTextHover(new java.awt.Color(0, 30, 100));
        pv.setNextFocusableComponent(alta);
        pv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pvMouseClicked(evt);
            }
        });
        jPanel1.add(pv, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 140, -1));

        alta.setBackground(new java.awt.Color(0, 30, 100));
        alta.setText("Alta");
        alta.setColorHover(new java.awt.Color(255, 255, 255));
        alta.setColorTextHover(new java.awt.Color(0, 30, 100));
        alta.setNextFocusableComponent(baja);
        alta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                altaMouseClicked(evt);
            }
        });
        jPanel1.add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 140, -1));

        baja.setBackground(new java.awt.Color(0, 30, 100));
        baja.setText("Baja");
        baja.setColorHover(new java.awt.Color(255, 255, 255));
        baja.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja.setName(""); // NOI18N
        baja.setNextFocusableComponent(cambio);
        baja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bajaMouseClicked(evt);
            }
        });
        jPanel1.add(baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 140, -1));

        cambio.setBackground(new java.awt.Color(0, 30, 100));
        cambio.setText("Cambio");
        cambio.setColorHover(new java.awt.Color(255, 255, 255));
        cambio.setColorTextHover(new java.awt.Color(0, 30, 100));
        cambio.setNextFocusableComponent(reporte);
        cambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambioMouseClicked(evt);
            }
        });
        jPanel1.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 140, -1));

        menuprincipal.setOpaque(false);

        subirexcel.setName("subirexcel"); // NOI18N

        selector.setAcceptAllFileFilterUsed(false);
        selector.setFileFilter(new FileNameExtensionFilter("Excel(.xls)","xls"));
        selector.setFileFilter(new FileNameExtensionFilter("Excel(.xlsx)","xlsx"));
        selector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subirexcelLayout = new javax.swing.GroupLayout(subirexcel);
        subirexcel.setLayout(subirexcelLayout);
        subirexcelLayout.setHorizontalGroup(
            subirexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
            .addGroup(subirexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subirexcelLayout.createSequentialGroup()
                    .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        subirexcelLayout.setVerticalGroup(
            subirexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
            .addGroup(subirexcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(subirexcelLayout.createSequentialGroup()
                    .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        menuprincipal.add(subirexcel, "card3");

        proyectovista.setFocusable(false);
        proyectovista.setName("proyectovista"); // NOI18N
        proyectovista.setOpaque(false);

        sliderejercicio.setOpaque(false);

        vista.setName("vista"); // NOI18N
        vista.setOpaque(false);

        jLabel77.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Busca a uno ");
        jLabel77.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel77.setFocusable(false);
        jLabel77.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel77.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel78.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("de nuestros clientes.");
        jLabel78.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel78.setFocusable(false);
        jLabel78.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel78.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Aquí podrás ver las horas");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("trabajadas con cada cliente. En ");
        jLabel5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("caso de que las horas restantes ");
        jLabel6.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("sean menores a 5, se mostrarán");
        jLabel7.setFocusable(false);

        jLabel21.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("con color rojo. ");
        jLabel21.setFocusable(false);

        jLabel22.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(245, 245, 245));
        jLabel22.setText("Si deseas terminar algún ejercicio");
        jLabel22.setFocusable(false);

        jLabel23.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(245, 245, 245));
        jLabel23.setText("solo seleccionalo en la tabla y da ");
        jLabel23.setFocusable(false);

        jLabel24.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(245, 245, 245));
        jLabel24.setText("clic en el boton \"Terminar ");
        jLabel24.setFocusable(false);

        jLabel25.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(245, 245, 245));
        jLabel25.setText("ejercicio.\"");
        jLabel25.setFocusable(false);

        rSButtonRiple1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple1.setText("¿Quieres iniciar un nuevo ejercicio?");
        rSButtonRiple1.setColorHover(new java.awt.Color(153, 153, 153));
        rSButtonRiple1.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple1.setColorTextHover(new java.awt.Color(0, 0, 0));
        rSButtonRiple1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound18Layout = new javax.swing.GroupLayout(jPanelRound18);
        jPanelRound18.setLayout(jPanelRound18Layout);
        jPanelRound18Layout.setHorizontalGroup(
            jPanelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(rSButtonRiple1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRound18Layout.setVerticalGroup(
            jPanelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(rSButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        bajaproyecto.setEditable(false);
        bajaproyecto.setForeground(new java.awt.Color(255, 255, 255));
        bajaproyecto.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajaproyecto.setBotonColor(new java.awt.Color(0, 0, 0));
        bajaproyecto.setCaretColor(new java.awt.Color(255, 255, 255));
        bajaproyecto.setColorTransparente(true);
        bajaproyecto.setPlaceholder("Ejericicio");

        rSButtonRiple19.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple19.setText("Terminar ejercicio");
        rSButtonRiple19.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple19.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple19MouseClicked(evt);
            }
        });

        errorproyecto2.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        errorproyecto2.setForeground(new java.awt.Color(255, 0, 0));
        errorproyecto2.setText("¡Faltan campos por llenar!");
        errorproyecto2.setFocusable(false);

        tablaempresa2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Inicio", "Fin", "Cliente", "Horas presupuestadas", "Horas trabajadas", "Resto", "Activo", "Ejercicio"
            }
        ));
        tablaempresa2.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablaempresa2.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaempresa2.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablaempresa2.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablaempresa2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaempresa2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaempresa2.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaempresa2.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa2.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa2.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa2.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa2.setMultipleSeleccion(false);
        tablaempresa2.setRowSelectionAllowed(false);
        tablaempresa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaempresa2MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tablaempresa2);

        buscarempresa2.setForeground(new java.awt.Color(255, 255, 255));
        buscarempresa2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarempresa2.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarempresa2.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarempresa2.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarempresa2.setColorTransparente(true);
        buscarempresa2.setModoMaterial(true);
        buscarempresa2.setNextFocusableComponent(rSButtonRiple19);
        buscarempresa2.setPlaceholder("Buscar  cliente...");
        buscarempresa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarempresa2KeyReleased(evt);
            }
        });

        rSButton14.setBackground(new java.awt.Color(255, 255, 255));
        rSButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton14.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton14.setFocusable(false);
        rSButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound1Layout.createSequentialGroup()
                                .addComponent(bajaproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButtonRiple19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorproyecto2))
                            .addGroup(jPanelRound1Layout.createSequentialGroup()
                                .addComponent(buscarempresa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 209, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarempresa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bajaproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSButtonRiple19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorproyecto2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout vistaLayout = new javax.swing.GroupLayout(vista);
        vista.setLayout(vistaLayout);
        vistaLayout.setHorizontalGroup(
            vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaLayout.createSequentialGroup()
                .addComponent(jPanelRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        vistaLayout.setVerticalGroup(
            vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderejercicio.add(vista, "card2");

        altaejercicio.setName("altaejercicio"); // NOI18N
        altaejercicio.setOpaque(false);

        jPanelRound10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelRound10MouseMoved(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("¡Necesitaremos muchos datos!");
        jLabel79.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel79.setFocusable(false);
        jLabel79.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel79.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel28.setFont(new java.awt.Font("Open Sans Semibold", 1, 13)); // NOI18N
        jLabel28.setText("Usa las tablas de junto para buscar al cliente y el servicio.");
        jLabel28.setFocusable(false);

        servicioproyecto.setEditable(false);
        servicioproyecto.setForeground(new java.awt.Color(255, 255, 255));
        servicioproyecto.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        servicioproyecto.setBotonColor(new java.awt.Color(0, 0, 0));
        servicioproyecto.setCaretColor(new java.awt.Color(255, 255, 255));
        servicioproyecto.setColorTransparente(true);
        servicioproyecto.setPlaceholder("Servicio");

        rSButtonRiple10.setBackground(new java.awt.Color(0, 102, 0));
        rSButtonRiple10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple10.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple10.setText("Si");
        rSButtonRiple10.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple10MouseClicked(evt);
            }
        });

        errorproyecto.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorproyecto.setForeground(new java.awt.Color(255, 0, 0));
        errorproyecto.setText("¡Faltan campos por llenar!");

        cambiomodelsocio2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", " ", " ", " " }));
        cambiomodelsocio2.setColorArrow(new java.awt.Color(0, 30, 100));
        cambiomodelsocio2.setColorBorde(new java.awt.Color(0, 30, 100));
        cambiomodelsocio2.setColorFondo(new java.awt.Color(0, 30, 100));
        cambiomodelsocio2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiomodelsocio2ItemStateChanged(evt);
            }
        });

        fechainiciotexto9.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        fechainiciotexto9.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto9.setText("Socio:");

        fechainiciotexto10.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        fechainiciotexto10.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto10.setText("¿Habrá más de un socio?");

        rSButtonRiple12.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple12.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple12.setText("Registrar");
        rSButtonRiple12.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple12.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple12MouseClicked(evt);
            }
        });

        rSButtonRiple13.setBackground(new java.awt.Color(255, 0, 0));
        rSButtonRiple13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rSButtonRiple13.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple13.setText("No");
        rSButtonRiple13.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple13MouseClicked(evt);
            }
        });

        cambiomodelsocio3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -" }));
        cambiomodelsocio3.setColorArrow(new java.awt.Color(0, 30, 100));
        cambiomodelsocio3.setColorBorde(new java.awt.Color(0, 30, 100));
        cambiomodelsocio3.setColorFondo(new java.awt.Color(0, 30, 100));
        cambiomodelsocio3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambiomodelsocio3ItemStateChanged(evt);
            }
        });

        socio1p.setEditable(false);
        socio1p.setForeground(new java.awt.Color(255, 255, 255));
        socio1p.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        socio1p.setBotonColor(new java.awt.Color(0, 0, 0));
        socio1p.setCaretColor(new java.awt.Color(255, 255, 255));
        socio1p.setColorTransparente(true);
        socio1p.setPlaceholder("Socio 1");

        socio2p.setEditable(false);
        socio2p.setForeground(new java.awt.Color(255, 255, 255));
        socio2p.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        socio2p.setBotonColor(new java.awt.Color(0, 0, 0));
        socio2p.setCaretColor(new java.awt.Color(255, 255, 255));
        socio2p.setColorTransparente(true);
        socio2p.setPlaceholder("Socio 2");

        idcliente.setEditable(false);
        idcliente.setForeground(new java.awt.Color(255, 255, 255));
        idcliente.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        idcliente.setBotonColor(new java.awt.Color(0, 0, 0));
        idcliente.setCaretColor(new java.awt.Color(255, 255, 255));
        idcliente.setColorTransparente(true);
        idcliente.setPlaceholder("Cliente");

        hp.setForeground(new java.awt.Color(255, 255, 255));
        hp.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        hp.setBotonColor(new java.awt.Color(0, 0, 0));
        hp.setCaretColor(new java.awt.Color(255, 255, 255));
        hp.setColorTransparente(true);
        hp.setPlaceholder("Horas presupuestadas");
        hp.setSoloNumeros(true);

        jLabel33.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Inicio del ejercicio:");
        jLabel33.setFocusable(false);

        diaproyecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" }));
        diaproyecto.setColorArrow(new java.awt.Color(0, 30, 100));
        diaproyecto.setColorBorde(new java.awt.Color(0, 30, 100));
        diaproyecto.setColorFondo(new java.awt.Color(0, 30, 100));
        diaproyecto.setNextFocusableComponent(mesproyecto);

        mesproyecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        mesproyecto.setColorArrow(new java.awt.Color(0, 30, 100));
        mesproyecto.setColorBorde(new java.awt.Color(0, 30, 100));
        mesproyecto.setColorFondo(new java.awt.Color(0, 30, 100));
        mesproyecto.setNextFocusableComponent(anoproyecto);

        anoproyecto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081" }));
        anoproyecto.setColorArrow(new java.awt.Color(0, 30, 100));
        anoproyecto.setColorBorde(new java.awt.Color(0, 30, 100));
        anoproyecto.setColorFondo(new java.awt.Color(0, 30, 100));
        anoproyecto.setNextFocusableComponent(idcliente);

        errorproyecto1.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorproyecto1.setForeground(new java.awt.Color(255, 0, 0));
        errorproyecto1.setText("¡El socio 2 debe ser diferente!");

        javax.swing.GroupLayout jPanelRound10Layout = new javax.swing.GroupLayout(jPanelRound10);
        jPanelRound10.setLayout(jPanelRound10Layout);
        jPanelRound10Layout.setHorizontalGroup(
            jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound10Layout.createSequentialGroup()
                        .addComponent(socio2p, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorproyecto1))
                    .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(hp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound10Layout.createSequentialGroup()
                            .addComponent(rSButtonRiple12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(errorproyecto))
                        .addComponent(fechainiciotexto9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound10Layout.createSequentialGroup()
                            .addComponent(fechainiciotexto10)
                            .addGap(26, 26, 26)
                            .addComponent(rSButtonRiple10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rSButtonRiple13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cambiomodelsocio3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiomodelsocio2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound10Layout.createSequentialGroup()
                            .addComponent(diaproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mesproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(anoproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(socio1p, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idcliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servicioproyecto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanelRound10Layout.setVerticalGroup(
            jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addGap(10, 10, 10)
                .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servicioproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(socio1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(socio2p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorproyecto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fechainiciotexto9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cambiomodelsocio2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonRiple10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechainiciotexto10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cambiomodelsocio3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorproyecto))
                .addContainerGap())
        );

        tablaservicio1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Servicio", "Descripción corta"
            }
        ));
        tablaservicio1.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablaservicio1.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaservicio1.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablaservicio1.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablaservicio1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaservicio1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaservicio1.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaservicio1.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaservicio1.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaservicio1.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablaservicio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaservicio1MouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tablaservicio1);

        rSButton18.setBackground(new java.awt.Color(255, 255, 255));
        rSButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton18.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton18MouseClicked(evt);
            }
        });

        buscarservicio1.setBorder(null);
        buscarservicio1.setForeground(new java.awt.Color(255, 255, 255));
        buscarservicio1.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarservicio1.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarservicio1.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarservicio1.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarservicio1.setColorTransparente(true);
        buscarservicio1.setModoMaterial(true);
        buscarservicio1.setPlaceholder("Buscar servicio...");
        buscarservicio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarservicio1KeyReleased(evt);
            }
        });

        tablacliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Ingreso"
            }
        ));
        tablacliente1.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablacliente1.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablacliente1.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablacliente1.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablacliente1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablacliente1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablacliente1.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablacliente1.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablacliente1.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablacliente1.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablacliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacliente1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablacliente1);

        rSButton19.setBackground(new java.awt.Color(255, 255, 255));
        rSButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton19.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton19MouseClicked(evt);
            }
        });

        buscarservicio2.setBorder(null);
        buscarservicio2.setForeground(new java.awt.Color(255, 255, 255));
        buscarservicio2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarservicio2.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarservicio2.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarservicio2.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarservicio2.setColorTransparente(true);
        buscarservicio2.setModoMaterial(true);
        buscarservicio2.setPlaceholder("Buscar cliente...");
        buscarservicio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarservicio2KeyReleased(evt);
            }
        });

        rSButton20.setBackground(new java.awt.Color(255, 255, 255));
        rSButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechader.png"))); // NOI18N
        rSButton20.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound23Layout = new javax.swing.GroupLayout(jPanelRound23);
        jPanelRound23.setLayout(jPanelRound23Layout);
        jPanelRound23Layout.setHorizontalGroup(
            jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound23Layout.createSequentialGroup()
                        .addGroup(jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanelRound23Layout.createSequentialGroup()
                        .addComponent(buscarservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelRound23Layout.createSequentialGroup()
                        .addComponent(buscarservicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanelRound23Layout.setVerticalGroup(
            jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound23Layout.createSequentialGroup()
                .addGroup(jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound23Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarservicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rSButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout altaejercicioLayout = new javax.swing.GroupLayout(altaejercicio);
        altaejercicio.setLayout(altaejercicioLayout);
        altaejercicioLayout.setHorizontalGroup(
            altaejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaejercicioLayout.createSequentialGroup()
                .addComponent(jPanelRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        altaejercicioLayout.setVerticalGroup(
            altaejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaejercicioLayout.createSequentialGroup()
                .addGroup(altaejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRound23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sliderejercicio.add(altaejercicio, "card3");

        javax.swing.GroupLayout proyectovistaLayout = new javax.swing.GroupLayout(proyectovista);
        proyectovista.setLayout(proyectovistaLayout);
        proyectovistaLayout.setHorizontalGroup(
            proyectovistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyectovistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sliderejercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        proyectovistaLayout.setVerticalGroup(
            proyectovistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sliderejercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuprincipal.add(proyectovista, "card4");

        jPanel1.add(menuprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1240, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/fondo_principal.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 706));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void minimizar_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar_principalMouseClicked
        // TODO add your handling code here:
        this.setState(principal.ICONIFIED);
    }//GEN-LAST:event_minimizar_principalMouseClicked

    private void cerrar_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_principalMouseClicked
        // TODO add your handling code here:
        int mj= JOptionPane.YES_NO_OPTION;
        int message= JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir", mj);
        if(message==0){
            System.exit(0);
        }
    }//GEN-LAST:event_cerrar_principalMouseClicked

    private void reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reporteMouseClicked
        menuprincipal.setPanelSlider(25,5, reportemenu, RSPanelsSlider.DIRECT.RIGHT);  
        cambiarcolor(reporte,cambio, alta , baja,pv,sb); 
        if(reporte.getBackground().equals( new Color(0,30,100)))
        {
            reportemenu.limpiarsocio();
        }
        reportemenu.regresoreporte();
    }//GEN-LAST:event_reporteMouseClicked

    private void sbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbMouseClicked
        // TODO add your handling code here:
        cambiarcolor(sb,pv,cambio, alta , baja,reporte);
        menuprincipal.setPanelSlider(25,5, subirexcel, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_sbMouseClicked

    private void pvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pvMouseClicked
        // TODO add your handling code here:
        actualizar_proyecto();
        cambiarcolor(pv,cambio, alta , baja,reporte,sb);
        menuprincipal.setPanelSlider(25,5, proyectovista, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_pvMouseClicked

    private void altaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaMouseClicked
        altamenu.actualizarAlta(alta);
        cambiarcolor(alta , baja , cambio,reporte,pv,sb);
        menuprincipal.setPanelSlider(25,5,altamenu, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_altaMouseClicked

    private void bajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bajaMouseClicked
        // TODO add your handling code here:
        bajamenu.actuatizar_baja(baja);
        cambiarcolor(baja ,cambio,alta,reporte,pv,sb);
        menuprincipal.setPanelSlider(25,5, bajamenu, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_bajaMouseClicked

    private void cambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambioMouseClicked
        // TODO add your handling code here:
        cambiomenu.actualizar_cambio(cambio);
        cambiarcolor(cambio, alta , baja,reporte,pv,sb);
        menuprincipal.setPanelSlider(30,5, cambiomenu, RSPanelsSlider.DIRECT.RIGHT);
        
    }//GEN-LAST:event_cambioMouseClicked

    private void rSButtonRiple5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple5MouseClicked
        jFrame1.dispose();
        jFrame1.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple5MouseClicked

    private void buscarservicio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarservicio2KeyReleased
        try {
            // TODO add your handling code here:
            tablacliente1.setModel(dentro.buscarempresa(buscarservicio2.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarservicio2KeyReleased

    private void rSButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton19MouseClicked
        // TODO add your handling code here:
        buscarservicio2.requestFocus();
    }//GEN-LAST:event_rSButton19MouseClicked

    private void tablacliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacliente1MouseClicked
        // TODO add your handling code here:
        idcliente.setText(tablacliente1.getValueAt(tablacliente1.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tablacliente1MouseClicked

    private void buscarservicio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarservicio1KeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablaservicio1.setModel(dentro.buscarserviciotabla(buscarservicio1.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarservicio1KeyReleased

    private void rSButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton18MouseClicked
        // TODO add your handling code here:
        buscarservicio1.requestFocus();
    }//GEN-LAST:event_rSButton18MouseClicked

    private void tablaservicio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaservicio1MouseClicked
        // TODO add your handling code here:
        servicioproyecto.setText(tablaservicio1.getValueAt(tablaservicio1.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tablaservicio1MouseClicked

    private void jPanelRound10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRound10MouseMoved
        // TODO add your handling code here:
        if(socio1p.getText().equals("")){
            try {
                cambiomodelsocio2.setModel(dentro.obtenersocios());
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(socio2p.isVisible()){
            try {
                if(socio2p.getText().equals(""))
                cambiomodelsocio3.setModel(dentro.obtenersocios());
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPanelRound10MouseMoved

    private void cambiomodelsocio3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiomodelsocio3ItemStateChanged
        // TODO add your handling code here:
        String [] id= cambiomodelsocio3.getSelectedItem().toString().split(" ");
        socio2p.setText(id[id.length-1]);
    }//GEN-LAST:event_cambiomodelsocio3ItemStateChanged

    private void rSButtonRiple13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple13MouseClicked
        // TODO add your handling code here:
        cambiomodelsocio3.setVisible(false);
        socio2p.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple13MouseClicked

    private void rSButtonRiple12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple12MouseClicked
        // TODO add your handling code here:
        if(!idcliente.getText().equals("") && !hp.getText().equals("")
            &&diaproyecto.getSelectedIndex()>0 &&mesproyecto.getSelectedIndex()>0
            &&anoproyecto.getSelectedIndex()>0 && !socio1p.getText().equals("") &&!socio2p.getText().equals("")
            &&!servicioproyecto.getText().equals("")&& socio2p.isVisible()){
            if(Integer.parseInt(socio1p.getText())!= Integer.parseInt(socio2p.getText())){
                RSMTextFull array[]={idcliente,hp,servicioproyecto,socio1p,socio2p};
                String dia= "";
                String mes= "";
                if(Integer.parseInt(diaproyecto.getSelectedItem().toString())<10){
                    dia="0"+diaproyecto.getSelectedItem().toString();
                }else{
                    dia=diaproyecto.getSelectedItem().toString();
                }
                if(mesproyecto.getSelectedIndex()<10){
                    mes="0"+Integer.toString(mesproyecto.getSelectedIndex());
                }else{
                    mes=Integer.toString(mesproyecto.getSelectedIndex());
                }
                String fecha=anoproyecto.getSelectedItem().toString()+"-"+mes+"-"+dia;
                try {
                    dentro.insertarproyecto(idcliente.getText(), fecha,hp.getText(),servicioproyecto.getText(),
                        socio1p.getText(),socio2p.getText(),usuario);
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                diaproyecto.setSelectedIndex(0);
                mesproyecto.setSelectedIndex(0);
                anoproyecto.setSelectedIndex(0);
                limpiadorcajatexto(array);
                errorproyecto.setVisible(false);
                errorproyecto1.setVisible(false);
                sliderejercicio.setPanelSlider(20,vista, RSPanelsSlider.DIRECT.RIGHT);
            }else{
                errorproyecto1.setVisible(true);
            }
        }else if(!idcliente.getText().equals("") && !hp.getText().equals("")
            &&diaproyecto.getSelectedIndex()>0 &&mesproyecto.getSelectedIndex()>0
            &&anoproyecto.getSelectedIndex()>0 && !socio1p.getText().equals("")
            &&!servicioproyecto.getText().equals("")&& !socio2p.isVisible()){
            RSMTextFull array[]={idcliente,hp,servicioproyecto,socio1p,socio2p};
            String dia= "";
            String mes= "";
            if(Integer.parseInt(diaproyecto.getSelectedItem().toString())<10){
                dia="0"+diaproyecto.getSelectedItem().toString();
            }else{
                dia=diaproyecto.getSelectedItem().toString();
            }
            if(mesproyecto.getSelectedIndex()<10){
                mes="0"+Integer.toString(mesproyecto.getSelectedIndex());
            }else{
                mes=Integer.toString(mesproyecto.getSelectedIndex());
            }
            String fecha=anoproyecto.getSelectedItem().toString()+"-"+mes+"-"+dia;
            try {
                dentro.insertarproyecto2(idcliente.getText(), fecha,hp.getText(),servicioproyecto.getText(),
                    socio1p.getText(),usuario);
                jFrame1.setVisible(true);
                jFrame1.setBackground(transparente);
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            diaproyecto.setSelectedIndex(0);
            mesproyecto.setSelectedIndex(0);
            anoproyecto.setSelectedIndex(0);
            limpiadorcajatexto(array);
            errorproyecto.setVisible(false);
            errorproyecto1.setVisible(false);
        }else{
            errorproyecto.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple12MouseClicked

    private void cambiomodelsocio2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambiomodelsocio2ItemStateChanged
        // TODO add your handling code here:
        String [] id= cambiomodelsocio2.getSelectedItem().toString().split(" ");
        socio1p.setText(id[id.length-1]);
    }//GEN-LAST:event_cambiomodelsocio2ItemStateChanged

    private void rSButtonRiple10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple10MouseClicked
        // TODO add your handling code here:
        cambiomodelsocio3.setVisible(true);
        socio2p.setVisible(true);
    }//GEN-LAST:event_rSButtonRiple10MouseClicked

    private void rSButtonRiple19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple19MouseClicked
        try {
            // TODO add your handling code here:
            if(!bajaproyecto.getText().equals("")){
                int mj= JOptionPane.YES_NO_OPTION;
                int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
                if(message==0){
                    dentro.cambioproyecto(bajaproyecto.getText(), usuario);
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                    bajaproyecto.setText("");
                    tablaempresa2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null, null, null, null, null}
                        },
                        new String [] {
                            "Inicio", "Fin", "Cliente", "Horas presupuestadas", "Horas trabajadas", "Resto", "Activo", "Ejercicio"
                        }
                    ));
                }
            }else{
                errorproyecto2.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSButtonRiple19MouseClicked

    private void rSButtonRiple1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple1MouseClicked
        // TODO add your handling code here:
        sliderejercicio.setPanelSlider(20, altaejercicio, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_rSButtonRiple1MouseClicked

    private void rSButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton14MouseClicked
        // TODO add your handling code here:
        buscarempresa2.requestFocus();
    }//GEN-LAST:event_rSButton14MouseClicked

    private void buscarempresa2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarempresa2KeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablaempresa2.setModel(dentro.buscarempresapantalla(buscarempresa2.getText()));
            tablaempresa2.setDefaultRenderer (Object.class,  new RenderCelda());
            tablaempresa2.setColorSelBackgound(new Color(51,153,255));
            tablaempresa2.setColorSelForeground(Color.white);

        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarempresa2KeyReleased

    private void tablaempresa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaempresa2MouseClicked
        // TODO add your handling code here:
        bajaproyecto.setText(tablaempresa2.getValueAt(tablaempresa2.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tablaempresa2MouseClicked

    private void selectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorActionPerformed
        // TODO add your handling code here:
        String comando = evt.getActionCommand();
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archivo = selector.getSelectedFile();
            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "", JOptionPane.ERROR_MESSAGE);
            }else{
                Excel uno = new Excel(archivo.getAbsolutePath());
                jFrame2 errores= new jFrame2();
                try {
                    if(uno.leerbd()){
                        if (!checadorerrores(uno.errores()))
                        {
                            String [] nuevo=uno.errores();
                            String viejo="";
                            for(int i=0; i<nuevo.length;i++){
                                if(nuevo[i] !=null && nuevo[i] != ""){
                                    viejo= errores.filaerror.getText();
                                    errores.filaerror.setText(viejo+nuevo[i]);
                                }
                            }
                            viejo="";
                            errores.setVisible(true);
                            errores.setLocationRelativeTo(null);
                            errores.setBackground(transparente);

                        }else
                        {                           
                            jFrame1.setLocationRelativeTo(null);
                            jFrame1.setBackground(transparente);
                            jFrame1.setVisible(true);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Archivo Inválido", "", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_selectorActionPerformed

    private void rSButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton20MouseClicked
        // TODO add your handling code here:
        sliderejercicio.setPanelSlider(20,vista, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_rSButton20MouseClicked

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    rojeru_san.RSButton alta;
    javax.swing.JPanel altaejercicio;
    rojerusan.RSComboMetro anoproyecto;
    rojeru_san.RSButton baja;
    rojeru_san.RSMTextFull bajaproyecto;
    rojeru_san.RSMTextFull buscarempresa2;
    rojeru_san.RSMTextFull buscarservicio1;
    rojeru_san.RSMTextFull buscarservicio2;
    rojeru_san.RSButton cambio;
    rojerusan.RSComboMetro cambiomodelsocio2;
    rojerusan.RSComboMetro cambiomodelsocio3;
    rojeru_san.RSButton cerrar_principal;
    rojerusan.RSComboMetro diaproyecto;
    javax.swing.JLabel errorproyecto;
    javax.swing.JLabel errorproyecto1;
    javax.swing.JLabel errorproyecto2;
    javax.swing.JLabel fechainiciotexto10;
    javax.swing.JLabel fechainiciotexto9;
    rojeru_san.RSMTextFull hp;
    rojeru_san.RSMTextFull idcliente;
    javax.swing.JFrame jFrame1;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel21;
    javax.swing.JLabel jLabel22;
    javax.swing.JLabel jLabel23;
    javax.swing.JLabel jLabel24;
    javax.swing.JLabel jLabel25;
    javax.swing.JLabel jLabel28;
    javax.swing.JLabel jLabel33;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel77;
    javax.swing.JLabel jLabel78;
    javax.swing.JLabel jLabel79;
    javax.swing.JPanel jPanel1;
    zesatic.JPanelRound jPanelRound1;
    zesatic.JPanelRound jPanelRound10;
    zesatic.JPanelRound jPanelRound18;
    zesatic.JPanelRound jPanelRound2;
    zesatic.JPanelRound jPanelRound23;
    javax.swing.JScrollPane jScrollPane12;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane24;
    rojeru_san.RSPanelsSlider menuprincipal;
    rojerusan.RSComboMetro mesproyecto;
    rojeru_san.RSButton minimizar_principal;
    javax.swing.JPanel proyectovista;
    rojeru_san.RSButton pv;
    rojeru_san.RSButton rSButton14;
    rojeru_san.RSButton rSButton18;
    rojeru_san.RSButton rSButton19;
    rojeru_san.RSButton rSButton20;
    rojeru_san.RSButtonRiple rSButtonRiple1;
    rojeru_san.RSButtonRiple rSButtonRiple10;
    rojeru_san.RSButtonRiple rSButtonRiple12;
    rojeru_san.RSButtonRiple rSButtonRiple13;
    rojeru_san.RSButtonRiple rSButtonRiple19;
    rojeru_san.RSButtonRiple rSButtonRiple5;
    rojeru_san.RSButton reporte;
    rojeru_san.RSButton sb;
    javax.swing.JFileChooser selector;
    rojeru_san.RSMTextFull servicioproyecto;
    rojeru_san.RSPanelsSlider sliderejercicio;
    rojeru_san.RSMTextFull socio1p;
    rojeru_san.RSMTextFull socio2p;
    javax.swing.JPanel subirexcel;
    rojerusan.RSTableMetro tablacliente1;
    rojerusan.RSTableMetro tablaempresa2;
    rojerusan.RSTableMetro tablaservicio1;
    javax.swing.JPanel vista;
    // End of variables declaration//GEN-END:variables
}
