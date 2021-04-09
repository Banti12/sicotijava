/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import rojeru_san.RSButton;
import rojeru_san.RSMTextFull;
import rojeru_san.RSPanelsSlider;
import rojerusan.RSComboMetro;
import rojerusan.necesario.RSScrollBar;

/**
 *
 * @author Brayan
 */
public class alta extends javax.swing.JPanel {

    /**
     * Creates new form alta
     */
    conectar dentro;
    String usuario;
    Color transparente;
    public alta(String usuario) {
        dentro = new conectar();
        transparente= new Color(0,0,0,0);
        this.usuario=usuario;
        initComponents();
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setBackground(transparente);
        iniciar();
        apagados();
    }
    public void apagados(){
        errorjefe.setVisible(false);
        errorhnc1.setVisible(false);
        errorhnc2.setVisible(false);
        errorhnc7.setVisible(false);
        errorhnc8.setVisible(false);
        errorhnc3.setVisible(false);
        errorhnc4.setVisible(false);
        errorEmpresa.setVisible(false);
        errorempleado.setVisible(false);
        
    }
    public void limpiadorbox(RSComboMetro array[]){
        for (int i=0;i<array.length;i++){
            array[i].setSelectedIndex(0);
        }
    }
    public void actualizarAlta(RSButton alta){
        if(alta.getBackground().equals(new Color(0,30,100))){
            RSMTextFull array[]={nombrejefe,apjefe,amjefe,nomhnc1,nomEmpresa,nomEmpresa1,nomEmpresa2,nomEmpresa3,
            nombreempleado,apempleado,amempleado,idjefeempleado,buscarsocio2,nomhnc,nomhnc3};
            RSComboMetro array1[]={diaEmpresa,mesEmpresa,anoEmpresa,puesto,nivel,horario,diaempleado,mesempleado,anoempleado};
            limpiadorcajatexto(array);
            limpiadorbox(array1);
            jTextArea1.setText("");
            jTextArea2.setText("");
            apagados();
            tablasocio4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {"4", "Sin grupo"},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "IdGrupo", "Grupo"
                }
            ));
            tablasocio2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "Nombre", "Apellido paterno", "Apellido Materno", "Iniciales", "IdSocio"
                }
            ));
        }
    }
    public void iniciar(){
        
        
        baja_socio1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,0)));
        tablasocio4.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablasocio2.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));

        jScrollPane3.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane1.getVerticalScrollBar().setUI(new RSScrollBar());



        nombrejefe.setColorTransparente(true);
        apjefe.setColorTransparente(true);
        amjefe.setColorTransparente(true);
        nomhnc1.setColorTransparente(true);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setBackground(transparente);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        
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
        altamenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        baja_socio1 = new rojeru_san.RSButton();
        baja_cliente1 = new rojeru_san.RSButton();
        baja_colaborador1 = new rojeru_san.RSButton();
        baja_servicio1 = new rojeru_san.RSButton();
        slideralta = new rojeru_san.RSPanelsSlider();
        socio1 = new javax.swing.JPanel();
        jPanelRound7 = new zesatic.JPanelRound();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nombrejefe = new rojeru_san.RSMTextFull();
        apjefe = new rojeru_san.RSMTextFull();
        amjefe = new rojeru_san.RSMTextFull();
        rSButtonRiple6 = new rojeru_san.RSButtonRiple();
        errorjefe = new javax.swing.JLabel();
        jPanelRound8 = new zesatic.JPanelRound();
        jLabel29 = new javax.swing.JLabel();
        nomhnc1 = new rojeru_san.RSMTextFull();
        errorhnc4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        des = new javax.swing.JLabel();
        des1 = new javax.swing.JLabel();
        rSButtonRiple9 = new rojeru_san.RSButtonRiple();
        errorhnc3 = new javax.swing.JLabel();
        cliente1 = new javax.swing.JPanel();
        jPanelRound9 = new zesatic.JPanelRound();
        nomEmpresa = new rojeru_san.RSMTextFull();
        nomEmpresa1 = new rojeru_san.RSMTextFull();
        nomEmpresa3 = new rojeru_san.RSMTextFull();
        fechainiciotexto2 = new javax.swing.JLabel();
        diaEmpresa = new rojerusan.RSComboMetro();
        mesEmpresa = new rojerusan.RSComboMetro();
        anoEmpresa = new rojerusan.RSComboMetro();
        rSButtonRiple4 = new rojeru_san.RSButtonRiple();
        errorEmpresa = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanelRound1 = new zesatic.JPanelRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablasocio4 = new rojerusan.RSTableMetro();
        rSButton2 = new rojeru_san.RSButton();
        nomEmpresa2 = new rojeru_san.RSMTextFull();
        colaborador1 = new javax.swing.JPanel();
        jPanelRound11 = new zesatic.JPanelRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nombreempleado = new rojeru_san.RSMTextFull();
        apempleado = new rojeru_san.RSMTextFull();
        amempleado = new rojeru_san.RSMTextFull();
        rSButtonRiple2 = new rojeru_san.RSButtonRiple();
        errorempleado = new javax.swing.JLabel();
        puestos = new javax.swing.JLabel();
        puesto = new rojerusan.RSComboMetro();
        nivel = new rojerusan.RSComboMetro();
        Puesto1 = new javax.swing.JLabel();
        horario = new rojerusan.RSComboMetro();
        fechainiciotexto3 = new javax.swing.JLabel();
        diaempleado = new rojerusan.RSComboMetro();
        mesempleado = new rojerusan.RSComboMetro();
        anoempleado = new rojerusan.RSComboMetro();
        idjefeempleado = new rojeru_san.RSMTextFull();
        jPanelRound3 = new zesatic.JPanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablasocio2 = new rojerusan.RSTableMetro();
        rSButton1 = new rojeru_san.RSButton();
        buscarsocio2 = new rojeru_san.RSMTextFull();
        servicio1 = new javax.swing.JPanel();
        jPanelRound13 = new zesatic.JPanelRound();
        jLabel27 = new javax.swing.JLabel();
        nomhnc = new rojeru_san.RSMTextFull();
        rSButtonRiple7 = new rojeru_san.RSButtonRiple();
        errorhnc2 = new javax.swing.JLabel();
        errorhnc1 = new javax.swing.JLabel();
        jPanelRound14 = new zesatic.JPanelRound();
        errorhnc7 = new javax.swing.JLabel();
        errorhnc8 = new javax.swing.JLabel();
        rSButtonRiple8 = new rojeru_san.RSButtonRiple();
        nomhnc3 = new rojeru_san.RSMTextFull();
        jLabel41 = new javax.swing.JLabel();

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

        setOpaque(false);

        altamenu.setOpaque(false);

        jPanel4.setPreferredSize(new java.awt.Dimension(150, 600));

        baja_socio1.setBackground(new java.awt.Color(255, 255, 255));
        baja_socio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
        baja_socio1.setText("Socio, servicio");
        baja_socio1.setColorHover(new java.awt.Color(255, 255, 255));
        baja_socio1.setColorText(new java.awt.Color(0, 30, 100));
        baja_socio1.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_socio1.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        baja_socio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_socio1.setIconTextGap(20);
        baja_socio1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        baja_socio1.setName("baja_socio1"); // NOI18N
        baja_socio1.setNextFocusableComponent(baja_cliente1);
        baja_socio1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_socio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_socio1MouseClicked(evt);
            }
        });

        baja_cliente1.setBackground(new java.awt.Color(0, 30, 100));
        baja_cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_cliente1.setText("Cliente");
        baja_cliente1.setColorHover(new java.awt.Color(204, 204, 255));
        baja_cliente1.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_cliente1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_cliente1.setIconTextGap(20);
        baja_cliente1.setName("baja_cliente1"); // NOI18N
        baja_cliente1.setNextFocusableComponent(baja_colaborador1);
        baja_cliente1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_cliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_cliente1MouseClicked(evt);
            }
        });

        baja_colaborador1.setBackground(new java.awt.Color(0, 30, 100));
        baja_colaborador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_colaborador1.setText("Colaborador");
        baja_colaborador1.setColorHover(new java.awt.Color(204, 204, 255));
        baja_colaborador1.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_colaborador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_colaborador1.setIconTextGap(20);
        baja_colaborador1.setName("baja_colaborador1"); // NOI18N
        baja_colaborador1.setNextFocusableComponent(baja_servicio1);
        baja_colaborador1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_colaborador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_colaborador1MouseClicked(evt);
            }
        });

        baja_servicio1.setBackground(new java.awt.Color(0, 30, 100));
        baja_servicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_servicio1.setText("Hora no cargable, grupo");
        baja_servicio1.setColorHover(new java.awt.Color(204, 204, 255));
        baja_servicio1.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_servicio1.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        baja_servicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_servicio1.setIconTextGap(20);
        baja_servicio1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        baja_servicio1.setName("baja_servicio1"); // NOI18N
        baja_servicio1.setNextFocusableComponent(baja_socio1);
        baja_servicio1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_servicio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_servicio1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baja_socio1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(baja_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(baja_colaborador1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(baja_servicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(baja_socio1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_colaborador1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_servicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slideralta.setOpaque(false);

        socio1.setName("socio1"); // NOI18N
        socio1.setOpaque(false);

        jLabel26.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 30, 100));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("¡Ingresa los datos de nuestro ");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel26.setFocusable(false);
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel30.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 30, 100));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("nuevo socio! ");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel30.setFocusable(false);
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel30.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        nombrejefe.setForeground(new java.awt.Color(0, 0, 0));
        nombrejefe.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nombrejefe.setBotonColor(new java.awt.Color(0, 0, 0));
        nombrejefe.setColorTransparente(true);
        nombrejefe.setNextFocusableComponent(apjefe);
        nombrejefe.setPlaceholder("Nombre(s)");

        apjefe.setForeground(new java.awt.Color(0, 0, 0));
        apjefe.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        apjefe.setBotonColor(new java.awt.Color(0, 0, 0));
        apjefe.setColorTransparente(true);
        apjefe.setNextFocusableComponent(amjefe);
        apjefe.setPlaceholder("Apellido paterno");

        amjefe.setForeground(new java.awt.Color(0, 0, 0));
        amjefe.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        amjefe.setBotonColor(new java.awt.Color(0, 0, 0));
        amjefe.setColorTransparente(true);
        amjefe.setNextFocusableComponent(rSButtonRiple6);
        amjefe.setPlaceholder("Apellido materno");

        rSButtonRiple6.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple6.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple6.setText("Registrar");
        rSButtonRiple6.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple6.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple6.setFocusCycleRoot(true);
        rSButtonRiple6.setNextFocusableComponent(nomhnc1);
        rSButtonRiple6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple6MouseClicked(evt);
            }
        });

        errorjefe.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorjefe.setForeground(new java.awt.Color(255, 0, 0));
        errorjefe.setText("¡Faltan campos por llenar!");
        errorjefe.setFocusable(false);

        javax.swing.GroupLayout jPanelRound7Layout = new javax.swing.GroupLayout(jPanelRound7);
        jPanelRound7.setLayout(jPanelRound7Layout);
        jPanelRound7Layout.setHorizontalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(nombrejefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apjefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amjefe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelRound7Layout.createSequentialGroup()
                        .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(jPanelRound7Layout.createSequentialGroup()
                                .addComponent(rSButtonRiple6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorjefe)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound7Layout.setVerticalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(32, 32, 32)
                .addComponent(nombrejefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(apjefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(amjefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorjefe))
                .addGap(229, 229, 229))
        );

        jPanelRound8.setFocusable(false);

        jLabel29.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 30, 100));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("¡Ingresa el nombre del nuevo servicio!");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel29.setFocusable(false);
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        nomhnc1.setForeground(new java.awt.Color(0, 0, 0));
        nomhnc1.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomhnc1.setBotonColor(new java.awt.Color(0, 0, 0));
        nomhnc1.setColorTransparente(true);
        nomhnc1.setNextFocusableComponent(jTextArea1);
        nomhnc1.setPlaceholder("Servicio");

        errorhnc4.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc4.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc4.setText("¡Ya éxiste el servicio!");
        errorhnc4.setFocusable(false);

        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Open Sans Semibold", 1, 13)); // NOI18N
        jTextArea1.setRows(7);
        jTextArea1.setBorder(null);
        jTextArea1.setNextFocusableComponent(jTextArea2);
        jScrollPane4.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Open Sans Semibold", 1, 13)); // NOI18N
        jTextArea2.setRows(7);
        jTextArea2.setBorder(null);
        jTextArea2.setFocusTraversalPolicyProvider(true);
        jTextArea2.setNextFocusableComponent(rSButtonRiple9);
        jScrollPane5.setViewportView(jTextArea2);

        des.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        des.setText("Descripción corta.");
        des.setFocusable(false);

        des1.setFont(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        des1.setText("Descripción larga.");
        des1.setFocusable(false);

        rSButtonRiple9.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple9.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple9.setText("Registrar");
        rSButtonRiple9.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple9.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple9.setNextFocusableComponent(nombrejefe);
        rSButtonRiple9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple9MouseClicked(evt);
            }
        });

        errorhnc3.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc3.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc3.setText("¡Faltan campos por llenar!");
        errorhnc3.setFocusable(false);

        javax.swing.GroupLayout jPanelRound8Layout = new javax.swing.GroupLayout(jPanelRound8);
        jPanelRound8.setLayout(jPanelRound8Layout);
        jPanelRound8Layout.setHorizontalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                        .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound8Layout.createSequentialGroup()
                                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addGroup(jPanelRound8Layout.createSequentialGroup()
                                        .addComponent(nomhnc1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(errorhnc4))
                                    .addComponent(des1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 244, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4))
                        .addContainerGap())
                    .addGroup(jPanelRound8Layout.createSequentialGroup()
                        .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(des)
                            .addGroup(jPanelRound8Layout.createSequentialGroup()
                                .addComponent(rSButtonRiple9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorhnc3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRound8Layout.setVerticalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomhnc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorhnc4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(des1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRound8Layout.createSequentialGroup()
                        .addComponent(des)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonRiple9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorhnc3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout socio1Layout = new javax.swing.GroupLayout(socio1);
        socio1.setLayout(socio1Layout);
        socio1Layout.setHorizontalGroup(
            socio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(socio1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        socio1Layout.setVerticalGroup(
            socio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slideralta.add(socio1, "card2");

        cliente1.setName("cliente1"); // NOI18N
        cliente1.setOpaque(false);

        jPanelRound9.setFocusable(false);

        nomEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa.setColorTransparente(true);
        nomEmpresa.setNextFocusableComponent(nomEmpresa1);
        nomEmpresa.setPlaceholder("Cliente");

        nomEmpresa1.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa1.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa1.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa1.setColorTransparente(true);
        nomEmpresa1.setNextFocusableComponent(nomEmpresa2);
        nomEmpresa1.setPlaceholder("RFC");

        nomEmpresa3.setEditable(false);
        nomEmpresa3.setForeground(new java.awt.Color(0, 0, 0));
        nomEmpresa3.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa3.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa3.setColorTransparente(true);
        nomEmpresa3.setFocusable(false);
        nomEmpresa3.setPlaceholder("IdGrupo");
        nomEmpresa3.setEditable(false);

        fechainiciotexto2.setFont(new java.awt.Font("Open Sans Semibold", 0, 18)); // NOI18N
        fechainiciotexto2.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto2.setText("Fecha de inicio:");
        fechainiciotexto2.setFocusable(false);

        diaEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" }));
        diaEmpresa.setColorArrow(new java.awt.Color(0, 30, 100));
        diaEmpresa.setColorBorde(new java.awt.Color(0, 30, 100));
        diaEmpresa.setColorFondo(new java.awt.Color(0, 30, 100));

        mesEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        mesEmpresa.setColorArrow(new java.awt.Color(0, 30, 100));
        mesEmpresa.setColorBorde(new java.awt.Color(0, 30, 100));
        mesEmpresa.setColorFondo(new java.awt.Color(0, 30, 100));

        anoEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081" }));
        anoEmpresa.setColorArrow(new java.awt.Color(0, 30, 100));
        anoEmpresa.setColorBorde(new java.awt.Color(0, 30, 100));
        anoEmpresa.setColorFondo(new java.awt.Color(0, 30, 100));

        rSButtonRiple4.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple4.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple4.setText("Registrar");
        rSButtonRiple4.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple4.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple4.setNextFocusableComponent(nomEmpresa);
        rSButtonRiple4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple4MouseClicked(evt);
            }
        });

        errorEmpresa.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorEmpresa.setForeground(new java.awt.Color(255, 0, 0));
        errorEmpresa.setText("¡Faltan campos por llenar!");
        errorEmpresa.setFocusable(false);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("¡Ingresa los datos de nuestro ");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel14.setFocusable(false);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel18.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("nuevo cliente! ");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel18.setFocusable(false);
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel18.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel15.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Para evitar errores, busca el id del grupo");
        jLabel15.setFocusable(false);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel16.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("correspondiente en la tabla de junto y da clic");
        jLabel16.setFocusable(false);
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel17.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("cuando lo hayas encontrado. Si el cliente no");
        jLabel17.setFocusable(false);
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel19.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("tiene grupo, selecciona \"Sin grupo\" en la tabla.");
        jLabel19.setFocusable(false);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanelRound9Layout = new javax.swing.GroupLayout(jPanelRound9);
        jPanelRound9.setLayout(jPanelRound9Layout);
        jPanelRound9Layout.setHorizontalGroup(
            jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound9Layout.createSequentialGroup()
                        .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nomEmpresa1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(nomEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(nomEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)))
                    .addGroup(jPanelRound9Layout.createSequentialGroup()
                        .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechainiciotexto2)
                            .addGroup(jPanelRound9Layout.createSequentialGroup()
                                .addComponent(diaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound9Layout.createSequentialGroup()
                                .addComponent(rSButtonRiple4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorEmpresa)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRound9Layout.setVerticalGroup(
            jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(nomEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomEmpresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRound9Layout.createSequentialGroup()
                        .addComponent(nomEmpresa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechainiciotexto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonRiple4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorEmpresa))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tablasocio4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"4", null},
                {null, null},
                {null, null}
            },
            new String [] {
                "IdGrupo", "Grupo"
            }
        ));
        tablasocio4.setCellSelectionEnabled(true);
        tablasocio4.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablasocio4.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablasocio4.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablasocio4.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablasocio4.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablasocio4.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablasocio4.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablasocio4.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablasocio4.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablasocio4.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablasocio4.setMinimumSize(new java.awt.Dimension(0, 0));
        tablasocio4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasocio4MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablasocio4);

        rSButton2.setBackground(new java.awt.Color(255, 255, 255));
        rSButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton2.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton2MouseClicked(evt);
            }
        });

        nomEmpresa2.setForeground(new java.awt.Color(255, 255, 255));
        nomEmpresa2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        nomEmpresa2.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        nomEmpresa2.setBotonColor(new java.awt.Color(0, 0, 0));
        nomEmpresa2.setCaretColor(new java.awt.Color(255, 255, 255));
        nomEmpresa2.setColorTransparente(true);
        nomEmpresa2.setModoMaterial(true);
        nomEmpresa2.setNextFocusableComponent(tablasocio4);
        nomEmpresa2.setPlaceholder("Buscar grupo...");
        nomEmpresa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomEmpresa2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addComponent(nomEmpresa2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomEmpresa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cliente1Layout = new javax.swing.GroupLayout(cliente1);
        cliente1.setLayout(cliente1Layout);
        cliente1Layout.setHorizontalGroup(
            cliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        cliente1Layout.setVerticalGroup(
            cliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slideralta.add(cliente1, "card3");

        colaborador1.setName("colaborador1"); // NOI18N
        colaborador1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("¡Ingresa los datos de nuestro ");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel9.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("nuevo colaborador! ");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel11.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Para evitar errores, busca el id del socio ");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel12.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("correspondiente en la tabla de junto y da clic");
        jLabel12.setFocusable(false);
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel13.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("cuando lo hayas encontrado.");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        nombreempleado.setForeground(new java.awt.Color(0, 0, 0));
        nombreempleado.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nombreempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        nombreempleado.setColorTransparente(true);
        nombreempleado.setNextFocusableComponent(apempleado);
        nombreempleado.setPlaceholder("Nombre(s)");

        apempleado.setForeground(new java.awt.Color(0, 0, 0));
        apempleado.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        apempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        apempleado.setColorTransparente(true);
        apempleado.setNextFocusableComponent(amempleado);
        apempleado.setPlaceholder("Apellido paterno");

        amempleado.setForeground(new java.awt.Color(0, 0, 0));
        amempleado.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        amempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        amempleado.setColorTransparente(true);
        amempleado.setNextFocusableComponent(buscarsocio2);
        amempleado.setPlaceholder("Apellido materno");

        rSButtonRiple2.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple2.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple2.setText("Registrar");
        rSButtonRiple2.setColorHover(new java.awt.Color(0, 30, 100));
        rSButtonRiple2.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple2.setNextFocusableComponent(nombreempleado);
        rSButtonRiple2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple2MouseClicked(evt);
            }
        });

        errorempleado.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorempleado.setForeground(new java.awt.Color(255, 0, 0));
        errorempleado.setText("¡Faltan campos por llenar!");
        errorempleado.setFocusable(false);

        puestos.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        puestos.setForeground(new java.awt.Color(255, 255, 255));
        puestos.setText("Puesto");
        puestos.setFocusable(false);

        puesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "Gerente", "Supervisor", "Encargado", "Ayudante" }));
        puesto.setColorArrow(new java.awt.Color(0, 30, 100));
        puesto.setColorBorde(new java.awt.Color(0, 30, 100));
        puesto.setColorFondo(new java.awt.Color(0, 30, 100));

        nivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "A", "B", "C" }));
        nivel.setColorArrow(new java.awt.Color(0, 30, 100));
        nivel.setColorBorde(new java.awt.Color(0, 30, 100));
        nivel.setColorFondo(new java.awt.Color(0, 30, 100));

        Puesto1.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        Puesto1.setForeground(new java.awt.Color(255, 255, 255));
        Puesto1.setText("Horario");
        Puesto1.setFocusable(false);

        horario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- - -", "Tiempo Completo", "Medio Tiempo" }));
        horario.setColorArrow(new java.awt.Color(0, 30, 100));
        horario.setColorBorde(new java.awt.Color(0, 30, 100));
        horario.setColorFondo(new java.awt.Color(0, 30, 100));

        fechainiciotexto3.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        fechainiciotexto3.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto3.setText("Fecha de inicio:");
        fechainiciotexto3.setFocusable(false);

        diaempleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" }));
        diaempleado.setColorArrow(new java.awt.Color(0, 30, 100));
        diaempleado.setColorBorde(new java.awt.Color(0, 30, 100));
        diaempleado.setColorFondo(new java.awt.Color(0, 30, 100));

        mesempleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        mesempleado.setColorArrow(new java.awt.Color(0, 30, 100));
        mesempleado.setColorBorde(new java.awt.Color(0, 30, 100));
        mesempleado.setColorFondo(new java.awt.Color(0, 30, 100));

        anoempleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081" }));
        anoempleado.setColorArrow(new java.awt.Color(0, 30, 100));
        anoempleado.setColorBorde(new java.awt.Color(0, 30, 100));
        anoempleado.setColorFondo(new java.awt.Color(0, 30, 100));

        idjefeempleado.setEditable(false);
        idjefeempleado.setForeground(new java.awt.Color(0, 0, 0));
        idjefeempleado.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        idjefeempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        idjefeempleado.setColorTransparente(true);
        idjefeempleado.setEnabled(false);
        idjefeempleado.setFocusable(false);
        idjefeempleado.setPlaceholder("IdSocio");
        idjefeempleado.setEditable(false);

        javax.swing.GroupLayout jPanelRound11Layout = new javax.swing.GroupLayout(jPanelRound11);
        jPanelRound11.setLayout(jPanelRound11Layout);
        jPanelRound11Layout.setHorizontalGroup(
            jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)))
                    .addGroup(jPanelRound11Layout.createSequentialGroup()
                        .addComponent(puestos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound11Layout.createSequentialGroup()
                        .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amempleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanelRound11Layout.createSequentialGroup()
                        .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(horario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelRound11Layout.createSequentialGroup()
                                    .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(errorempleado))
                                .addComponent(Puesto1)
                                .addGroup(jPanelRound11Layout.createSequentialGroup()
                                    .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelRound11Layout.createSequentialGroup()
                                .addComponent(diaempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mesempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anoempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idjefeempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechainiciotexto3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRound11Layout.setVerticalGroup(
            jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(apempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(amempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puestos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Puesto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRound11Layout.createSequentialGroup()
                        .addComponent(idjefeempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechainiciotexto3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diaempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorempleado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablasocio2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido paterno", "Apellido Materno", "Iniciales", "IdSocio"
            }
        ));
        tablasocio2.setCellSelectionEnabled(true);
        tablasocio2.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablasocio2.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablasocio2.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablasocio2.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablasocio2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablasocio2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablasocio2.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablasocio2.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablasocio2.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablasocio2.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablasocio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasocio2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablasocio2);

        rSButton1.setBackground(new java.awt.Color(255, 255, 255));
        rSButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton1.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton1.setFocusPainted(false);
        rSButton1.setFocusable(false);
        rSButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton1MouseClicked(evt);
            }
        });

        buscarsocio2.setForeground(new java.awt.Color(255, 255, 255));
        buscarsocio2.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarsocio2.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarsocio2.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarsocio2.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarsocio2.setColorTransparente(true);
        buscarsocio2.setModoMaterial(true);
        buscarsocio2.setNextFocusableComponent(tablasocio2);
        buscarsocio2.setPlaceholder("Buscar socio...");
        buscarsocio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarsocio2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(buscarsocio2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarsocio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout colaborador1Layout = new javax.swing.GroupLayout(colaborador1);
        colaborador1.setLayout(colaborador1Layout);
        colaborador1Layout.setHorizontalGroup(
            colaborador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colaborador1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        colaborador1Layout.setVerticalGroup(
            colaborador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colaborador1Layout.createSequentialGroup()
                .addGroup(colaborador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jPanelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        slideralta.add(colaborador1, "card4");

        servicio1.setName("servicio1"); // NOI18N
        servicio1.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 30, 100));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("¡Ingresa la nueva hora no cargable! ");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel27.setFocusable(false);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        nomhnc.setForeground(new java.awt.Color(0, 0, 0));
        nomhnc.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomhnc.setBotonColor(new java.awt.Color(0, 0, 0));
        nomhnc.setColorTransparente(true);
        nomhnc.setNextFocusableComponent(rSButtonRiple7);
        nomhnc.setPlaceholder("Nueva hora no cargable");

        rSButtonRiple7.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple7.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple7.setText("Registrar");
        rSButtonRiple7.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple7.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple7.setNextFocusableComponent(nomhnc3);
        rSButtonRiple7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple7MouseClicked(evt);
            }
        });

        errorhnc2.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc2.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc2.setText("¡Ya éxiste la hora no cargable!");
        errorhnc2.setFocusable(false);

        errorhnc1.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc1.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc1.setText("¡Faltan campos por llenar!");
        errorhnc1.setFocusable(false);

        javax.swing.GroupLayout jPanelRound13Layout = new javax.swing.GroupLayout(jPanelRound13);
        jPanelRound13.setLayout(jPanelRound13Layout);
        jPanelRound13Layout.setHorizontalGroup(
            jPanelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorhnc1)
                        .addComponent(nomhnc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRound13Layout.createSequentialGroup()
                        .addComponent(rSButtonRiple7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorhnc2)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanelRound13Layout.setVerticalGroup(
            jPanelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(43, 43, 43)
                .addComponent(nomhnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorhnc2))
                .addGap(18, 18, 18)
                .addComponent(errorhnc1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRound14.setPreferredSize(new java.awt.Dimension(530, 600));

        errorhnc7.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc7.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc7.setText("¡Faltan campos por llenar!");
        errorhnc7.setFocusable(false);

        errorhnc8.setFont(new java.awt.Font("Open Sans Semibold", 1, 14)); // NOI18N
        errorhnc8.setForeground(new java.awt.Color(255, 0, 0));
        errorhnc8.setText("¡Ya éxiste el grupo!");
        errorhnc8.setFocusable(false);

        rSButtonRiple8.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple8.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonRiple8.setText("Registrar");
        rSButtonRiple8.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple8.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple8.setNextFocusableComponent(nomhnc);
        rSButtonRiple8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple8MouseClicked(evt);
            }
        });

        nomhnc3.setForeground(new java.awt.Color(0, 0, 0));
        nomhnc3.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        nomhnc3.setBotonColor(new java.awt.Color(0, 0, 0));
        nomhnc3.setColorTransparente(true);
        nomhnc3.setNextFocusableComponent(rSButtonRiple8);
        nomhnc3.setPlaceholder("Grupo");

        jLabel41.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 30, 100));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("¡Ingresa el nombre del nuevo grupo! ");
        jLabel41.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel41.setFocusable(false);
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel41.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanelRound14Layout = new javax.swing.GroupLayout(jPanelRound14);
        jPanelRound14.setLayout(jPanelRound14Layout);
        jPanelRound14Layout.setHorizontalGroup(
            jPanelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nomhnc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRound14Layout.createSequentialGroup()
                        .addComponent(rSButtonRiple8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorhnc8))
                    .addComponent(errorhnc7))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanelRound14Layout.setVerticalGroup(
            jPanelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(39, 39, 39)
                .addComponent(nomhnc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorhnc8))
                .addGap(18, 18, 18)
                .addComponent(errorhnc7)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout servicio1Layout = new javax.swing.GroupLayout(servicio1);
        servicio1.setLayout(servicio1Layout);
        servicio1Layout.setHorizontalGroup(
            servicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicio1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound14, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
        );
        servicio1Layout.setVerticalGroup(
            servicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(servicio1Layout.createSequentialGroup()
                .addComponent(jPanelRound14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        slideralta.add(servicio1, "card5");

        javax.swing.GroupLayout altamenuLayout = new javax.swing.GroupLayout(altamenu);
        altamenu.setLayout(altamenuLayout);
        altamenuLayout.setHorizontalGroup(
            altamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altamenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(slideralta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        altamenuLayout.setVerticalGroup(
            altamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altamenuLayout.createSequentialGroup()
                .addGroup(altamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addGroup(altamenuLayout.createSequentialGroup()
                        .addComponent(slideralta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(altamenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(altamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
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
    public void limpiadorcajatexto(RSMTextFull array[]){
        for (int i=0;i<array.length;i++){
            array[i].setText("");
        }
    }
    private void baja_socio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_socio1MouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_cliente1,baja_colaborador1, baja_servicio1};
        cambiarcolorreporte(baja_socio1,menu);
        slideralta.setPanelSlider(20, socio1, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_socio1MouseClicked

    private void baja_cliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_cliente1MouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_socio1,baja_colaborador1, baja_servicio1};
        cambiarcolorreporte(baja_cliente1,menu);
        slideralta.setPanelSlider(20, cliente1, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_cliente1MouseClicked

    private void baja_colaborador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_colaborador1MouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_cliente1,baja_socio1, baja_servicio1};
        cambiarcolorreporte(baja_colaborador1,menu);
        slideralta.setPanelSlider(20, colaborador1, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_colaborador1MouseClicked

    private void baja_servicio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_servicio1MouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_cliente1,baja_colaborador1, baja_socio1};
        cambiarcolorreporte(baja_servicio1,menu);
        slideralta.setPanelSlider(20, servicio1, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_servicio1MouseClicked

    private void rSButtonRiple6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple6MouseClicked
        // TODO add your handling code here:
        if(!nombrejefe.getText().equals("") && !apjefe.getText().equals("") && !amjefe.getText().equals("")){
            RSMTextFull array[]={nombrejefe,apjefe,amjefe};
            try {
                dentro.insertarnuevojefe(nombrejefe.getText(), apjefe.getText(), amjefe.getText(),usuario);
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            jFrame1.setVisible(true);
            jFrame1.setBackground(transparente);
            limpiadorcajatexto(array);
            errorjefe.setVisible(false);
        }else{
            errorjefe.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple6MouseClicked

    private void rSButtonRiple9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple9MouseClicked
        // TODO add your handling code here:
        if(!nomhnc1.getText().equals("")&& !jTextArea1.getText().equals("") && !jTextArea2.getText().equals(""))
        {
            try {
                if(dentro.buscarservicio(nomhnc1.getText().trim())==true)
                {
                    dentro.insertarservicio(nomhnc1.getText().trim(),jTextArea1.getText(),jTextArea2.getText(),usuario);
                    nomhnc1.setText("");
                    jTextArea1.setText("");
                    jTextArea2.setText("");
                    errorhnc3.setVisible(false);
                    errorhnc4.setVisible(false);
                    jFrame1.setVisible(true);
                }
                else{
                    errorhnc4.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            errorhnc3.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple9MouseClicked

    private void rSButtonRiple4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple4MouseClicked
        // TODO add your handling code here:
        String nombre;
        String fecha;
        String dia;
        String mes;
        String ano;

        if (!nomEmpresa.getText().equals("")&& mesEmpresa.getSelectedIndex()!=0 && diaEmpresa.getSelectedIndex()!=0
            && anoEmpresa.getSelectedIndex()!=0 && !nomEmpresa1.getText().equals(""))
        {
            if(mesEmpresa.getSelectedIndex()  < 10)
            {
                mes = "0" +  Integer.toString(mesEmpresa.getSelectedIndex());
            }else
            {
                mes =  Integer.toString(mesEmpresa.getSelectedIndex());
            }
            if(diaEmpresa.getSelectedIndex() < 10)
            {
                dia = "0" +  Integer.toString(diaEmpresa.getSelectedIndex());
            }else
            {
                dia =  Integer.toString(diaEmpresa.getSelectedIndex() );
            }
            ano =  anoEmpresa.getSelectedItem().toString();

            fecha = ano +"-"+mes+"-"+dia;
            nombre = verificarnombre(nomEmpresa.getText());
            try {
                dentro.insertarnuevaempresa(nombre, fecha,nomEmpresa1.getText(),nomEmpresa3.getText(), usuario);
                jFrame1.setVisible(true);
                diaEmpresa.setSelectedIndex(0);
                mesEmpresa.setSelectedIndex(0);
                anoEmpresa.setSelectedIndex(0);
                RSMTextFull array[]={nomEmpresa,nomEmpresa1,nomEmpresa2,nomEmpresa3};
                limpiadorcajatexto(array);
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            errorEmpresa.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple4MouseClicked

    private void nomEmpresa2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomEmpresa2KeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablasocio4.setModel(dentro.buscargrupotabla(nomEmpresa2.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nomEmpresa2KeyReleased

    private void rSButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton2MouseClicked
        // TODO add your handling code here:
        nomEmpresa2.requestFocus();
    }//GEN-LAST:event_rSButton2MouseClicked

    private void tablasocio4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasocio4MouseClicked
        // TODO add your handling code here:
        nomEmpresa3.setText(tablasocio4.getValueAt(tablasocio4.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tablasocio4MouseClicked

    private void rSButtonRiple2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple2MouseClicked
        // TODO add your handling code here:
        if(!idjefeempleado.getText().equals("") && !nombreempleado.getText().equals("") && !apempleado.getText().equals("") && !amempleado.getText().equals("")
            &&diaempleado.getSelectedIndex()>0 &&mesempleado.getSelectedIndex()>0 &&anoempleado.getSelectedIndex()>0 && puesto.getSelectedIndex()>0
            && horario.getSelectedIndex()>0){
            RSMTextFull array[]={nombreempleado,apempleado,amempleado,idjefeempleado,buscarsocio2};
            String dia= "";
            String mes= "";
            if(Integer.parseInt(diaempleado.getSelectedItem().toString())<10){
                dia="0"+diaempleado.getSelectedItem().toString();
            }else{
                dia=diaempleado.getSelectedItem().toString();
            }
            if(mesempleado.getSelectedIndex()<10){
                mes="0"+Integer.toString(mesempleado.getSelectedIndex());
            }else{
                mes=Integer.toString(mesempleado.getSelectedIndex());
            }
            String fecha=anoempleado.getSelectedItem().toString()+"-"+mes+"-"+dia;
            if(puesto.getSelectedIndex()>1 && nivel.getSelectedIndex()>0){
                try {
                    dentro.insertarnuevoempleado(nombreempleado.getText(), apempleado.getText(), amempleado.getText(), fecha,idjefeempleado.getText(),
                        puesto.getSelectedItem().toString()+" "+nivel.getSelectedItem().toString(),horario.getSelectedItem().toString(),usuario);
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                diaempleado.setSelectedIndex(0);
                mesempleado.setSelectedIndex(0);
                anoempleado.setSelectedIndex(0);
                puesto.setSelectedIndex(0);
                nivel.setSelectedIndex(0);
                horario.setSelectedIndex(0);
                limpiadorcajatexto(array);
                errorempleado.setVisible(false);

            }else if(puesto.getSelectedIndex()==1){
                try {
                    dentro.insertarnuevoempleado(nombreempleado.getText(), apempleado.getText(), amempleado.getText(), fecha,idjefeempleado.getText(),
                        puesto.getSelectedItem().toString(),horario.getSelectedItem().toString(),usuario);
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                diaempleado.setSelectedIndex(0);
                mesempleado.setSelectedIndex(0);
                anoempleado.setSelectedIndex(0);
                limpiadorcajatexto(array);
                errorempleado.setVisible(false);
            }else{
                errorempleado.setVisible(true);
            }
        }else{
            errorempleado.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple2MouseClicked

    private void tablasocio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasocio2MouseClicked
        // TODO add your handling code here:
        idjefeempleado.setText(tablasocio2.getValueAt(tablasocio2.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tablasocio2MouseClicked

    private void rSButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton1MouseClicked
        // TODO add your handling code here:
        buscarsocio2.requestFocus();
    }//GEN-LAST:event_rSButton1MouseClicked

    private void buscarsocio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarsocio2KeyReleased
        try {
            // TODO add your handling code here:
            tablasocio2.setModel(dentro.buscarjefetabla3(buscarsocio2.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarsocio2KeyReleased

    private void rSButtonRiple7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple7MouseClicked
        // TODO add your handling code here:
        if(!nomhnc.getText().equals(""))
        {
            try {
                if(dentro.buscarhnc(nomhnc.getText())==true)
                {
                    dentro.insertarhnc(nomhnc.getText(),usuario);
                    jFrame1.setVisible(true);
                    nomhnc.setText("");
                    errorhnc1.setVisible(false);
                    errorhnc2.setVisible(false);
                }
                else{
                    errorhnc2.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            errorhnc1.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple7MouseClicked

    private void rSButtonRiple8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple8MouseClicked
        // TODO add your handling code here:
        if(!nomhnc3.getText().equals(""))
        {
            try {
                if(dentro.buscargrupo(nomhnc3.getText())==true)
                {
                    dentro.insertargrupo(nomhnc3.getText(),usuario);
                    jFrame1.setVisible(true);
                    nomhnc3.setText("");
                    errorhnc7.setVisible(false);
                    errorhnc8.setVisible(false);
                }
                else{
                    errorhnc8.setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            errorhnc7.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonRiple8MouseClicked

    private void rSButtonRiple5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple5MouseClicked
        jFrame1.dispose();
        jFrame1.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puesto1;
    private javax.swing.JPanel altamenu;
    private rojeru_san.RSMTextFull amempleado;
    private rojeru_san.RSMTextFull amjefe;
    private rojerusan.RSComboMetro anoEmpresa;
    private rojerusan.RSComboMetro anoempleado;
    private rojeru_san.RSMTextFull apempleado;
    private rojeru_san.RSMTextFull apjefe;
    private rojeru_san.RSButton baja_cliente1;
    private rojeru_san.RSButton baja_colaborador1;
    private rojeru_san.RSButton baja_servicio1;
    private rojeru_san.RSButton baja_socio1;
    private rojeru_san.RSMTextFull buscarsocio2;
    private javax.swing.JPanel cliente1;
    private javax.swing.JPanel colaborador1;
    private javax.swing.JLabel des;
    private javax.swing.JLabel des1;
    private rojerusan.RSComboMetro diaEmpresa;
    private rojerusan.RSComboMetro diaempleado;
    private javax.swing.JLabel errorEmpresa;
    private javax.swing.JLabel errorempleado;
    private javax.swing.JLabel errorhnc1;
    private javax.swing.JLabel errorhnc2;
    private javax.swing.JLabel errorhnc3;
    private javax.swing.JLabel errorhnc4;
    private javax.swing.JLabel errorhnc7;
    private javax.swing.JLabel errorhnc8;
    private javax.swing.JLabel errorjefe;
    private javax.swing.JLabel fechainiciotexto2;
    private javax.swing.JLabel fechainiciotexto3;
    private rojerusan.RSComboMetro horario;
    private rojeru_san.RSMTextFull idjefeempleado;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private zesatic.JPanelRound jPanelRound1;
    private zesatic.JPanelRound jPanelRound11;
    private zesatic.JPanelRound jPanelRound13;
    private zesatic.JPanelRound jPanelRound14;
    private zesatic.JPanelRound jPanelRound2;
    private zesatic.JPanelRound jPanelRound3;
    private zesatic.JPanelRound jPanelRound7;
    private zesatic.JPanelRound jPanelRound8;
    private zesatic.JPanelRound jPanelRound9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private rojerusan.RSComboMetro mesEmpresa;
    private rojerusan.RSComboMetro mesempleado;
    private rojerusan.RSComboMetro nivel;
    private rojeru_san.RSMTextFull nomEmpresa;
    private rojeru_san.RSMTextFull nomEmpresa1;
    private rojeru_san.RSMTextFull nomEmpresa2;
    private rojeru_san.RSMTextFull nomEmpresa3;
    private rojeru_san.RSMTextFull nombreempleado;
    private rojeru_san.RSMTextFull nombrejefe;
    private rojeru_san.RSMTextFull nomhnc;
    private rojeru_san.RSMTextFull nomhnc1;
    private rojeru_san.RSMTextFull nomhnc3;
    private rojerusan.RSComboMetro puesto;
    private javax.swing.JLabel puestos;
    private rojeru_san.RSButton rSButton1;
    private rojeru_san.RSButton rSButton2;
    private rojeru_san.RSButtonRiple rSButtonRiple2;
    private rojeru_san.RSButtonRiple rSButtonRiple4;
    private rojeru_san.RSButtonRiple rSButtonRiple5;
    private rojeru_san.RSButtonRiple rSButtonRiple6;
    private rojeru_san.RSButtonRiple rSButtonRiple7;
    private rojeru_san.RSButtonRiple rSButtonRiple8;
    private rojeru_san.RSButtonRiple rSButtonRiple9;
    private javax.swing.JPanel servicio1;
    private rojeru_san.RSPanelsSlider slideralta;
    private javax.swing.JPanel socio1;
    private rojerusan.RSTableMetro tablasocio2;
    private rojerusan.RSTableMetro tablasocio4;
    // End of variables declaration//GEN-END:variables
}