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
import javax.swing.JOptionPane;
import rojeru_san.RSButton;
import rojeru_san.RSMTextFull;
import rojeru_san.RSPanelsSlider;
import rojerusan.RSComboMetro;
import rojerusan.necesario.RSScrollBar;

/**
 *
 * @author Brayan
 */
public class bajamenu extends javax.swing.JPanel {

    /** Creates new form bajamenu */
    
    conectar dentro;
    String usuario;
    Color transparente= new Color(0,0,0,0);
    public bajamenu(String usuario) {
       
        initComponents();
        this.usuario=usuario;
        dentro= new conectar();
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setBackground(transparente);
        iniciar();
    }
    public void limpiadorcajatexto(RSMTextFull array[]){
        for (int i=0;i<array.length;i++){
            array[i].setText("");
        }
    }
    public void actuatizar_baja(RSButton baja){
        if(baja.getBackground().equals(new Color(0,30,100))){
            RSMTextFull array[]={buscarjefebaja,buscarhnc,buscarempresa,buscarempleado,bajaempleado,
                bajajefe,bajahnc,bajaempresa,buscarservicio,bajaservicio};
            limpiadorcajatexto(array);        
            tablajefebaja.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Id", "Nombre", "Socio"
                }
            ));
            tablahnc.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "Id", "Hora no cargable"
                }
            ));
            tablaempresa.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Id", "Nombre", "RFC", "Ingreso"
                }
            ));
            tablaempleado.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "Id", "Nombre", "IdSocio", "Nivel", "Ingreso"
                }
            ));
            tablaservicio.setModel(new javax.swing.table.DefaultTableModel(
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
        baja_socio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,0)));
        tablaempresa.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablajefebaja.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablaservicio.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablahnc.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablaempleado.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        jScrollPane7.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane8.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane9.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane10.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane6.getVerticalScrollBar().setUI(new RSScrollBar());
        jPanelRound4.setColorSecundario(new Color(0,30,100,200));
        jPanelRound3.setColorSecundario(new Color(0,30,100,200));
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelRound2 = new zesatic.JPanelRound();
        rSButtonRiple5 = new rojeru_san.RSButtonRiple();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bajamenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        baja_socio = new rojeru_san.RSButton();
        baja_cliente = new rojeru_san.RSButton();
        baja_colaborador = new rojeru_san.RSButton();
        baja_servicio = new rojeru_san.RSButton();
        sliderbaja = new rojeru_san.RSPanelsSlider();
        socio = new javax.swing.JPanel();
        jPanelRound3 = new zesatic.JPanelRound();
        buscarjefebaja = new rojeru_san.RSMTextFull();
        rSButton8 = new rojeru_san.RSButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablajefebaja = new rojerusan.RSTableMetro();
        bajajefe = new rojeru_san.RSMTextFull();
        rSButtonRiple16 = new rojeru_san.RSButtonRiple();
        jPanelRound4 = new zesatic.JPanelRound();
        buscarhnc = new rojeru_san.RSMTextFull();
        rSButton10 = new rojeru_san.RSButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablahnc = new rojerusan.RSTableMetro();
        bajahnc = new rojeru_san.RSMTextFull();
        rSButtonRiple17 = new rojeru_san.RSButtonRiple();
        cliente = new javax.swing.JPanel();
        jPanelRound1 = new zesatic.JPanelRound();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanelRound9 = new zesatic.JPanelRound();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaempresa = new rojerusan.RSTableMetro();
        buscarempresa = new rojeru_san.RSMTextFull();
        rSButton6 = new rojeru_san.RSButton();
        bajaempresa = new rojeru_san.RSMTextFull();
        rSButtonRiple15 = new rojeru_san.RSButtonRiple();
        colaborador = new javax.swing.JPanel();
        jPanelRound6 = new zesatic.JPanelRound();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanelRound7 = new zesatic.JPanelRound();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaempleado = new rojerusan.RSTableMetro();
        rSButton4 = new rojeru_san.RSButton();
        buscarempleado = new rojeru_san.RSMTextFull();
        rSButtonRiple14 = new rojeru_san.RSButtonRiple();
        bajaempleado = new rojeru_san.RSMTextFull();
        servicio = new javax.swing.JPanel();
        jPanelRound5 = new zesatic.JPanelRound();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanelRound8 = new zesatic.JPanelRound();
        bajaservicio = new rojeru_san.RSMTextFull();
        rSButtonRiple18 = new rojeru_san.RSButtonRiple();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaservicio = new rojerusan.RSTableMetro();
        rSButton12 = new rojeru_san.RSButton();
        buscarservicio = new rojeru_san.RSMTextFull();

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

        bajamenu.setName("bajamenu"); // NOI18N
        bajamenu.setOpaque(false);

        jPanel3.setNextFocusableComponent(baja_colaborador);
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 600));

        baja_socio.setBackground(new java.awt.Color(255, 255, 255));
        baja_socio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
        baja_socio.setText("Socio, hora no cargable");
        baja_socio.setColorHover(new java.awt.Color(255, 255, 255));
        baja_socio.setColorText(new java.awt.Color(0, 30, 100));
        baja_socio.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_socio.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        baja_socio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_socio.setIconTextGap(20);
        baja_socio.setMargin(new java.awt.Insets(2, 0, 2, 0));
        baja_socio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_socio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_socioMouseClicked(evt);
            }
        });

        baja_cliente.setBackground(new java.awt.Color(0, 30, 100));
        baja_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_cliente.setText("Cliente");
        baja_cliente.setColorHover(new java.awt.Color(204, 204, 255));
        baja_cliente.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_cliente.setIconTextGap(20);
        baja_cliente.setNextFocusableComponent(baja_socio);
        baja_cliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_clienteMouseClicked(evt);
            }
        });

        baja_colaborador.setBackground(new java.awt.Color(0, 30, 100));
        baja_colaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_colaborador.setText("Colaborador");
        baja_colaborador.setColorHover(new java.awt.Color(204, 204, 255));
        baja_colaborador.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_colaborador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_colaborador.setIconTextGap(20);
        baja_colaborador.setNextFocusableComponent(baja_cliente);
        baja_colaborador.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_colaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_colaboradorMouseClicked(evt);
            }
        });

        baja_servicio.setBackground(new java.awt.Color(0, 30, 100));
        baja_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        baja_servicio.setText("Servicio");
        baja_servicio.setColorHover(new java.awt.Color(204, 204, 255));
        baja_servicio.setColorTextHover(new java.awt.Color(0, 30, 100));
        baja_servicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baja_servicio.setIconTextGap(20);
        baja_servicio.setName(""); // NOI18N
        baja_servicio.setNextFocusableComponent(baja_socio);
        baja_servicio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        baja_servicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baja_servicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baja_socio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(baja_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(baja_colaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(baja_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(baja_socio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_colaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(baja_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sliderbaja.setOpaque(false);

        socio.setName("socio"); // NOI18N
        socio.setOpaque(false);

        jPanelRound3.setColorSecundario(new java.awt.Color(0, 30, 100));
        jPanelRound3.setPreferredSize(new java.awt.Dimension(524, 100));

        buscarjefebaja.setForeground(new java.awt.Color(255, 255, 255));
        buscarjefebaja.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarjefebaja.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarjefebaja.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarjefebaja.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarjefebaja.setColorTransparente(true);
        buscarjefebaja.setModoMaterial(true);
        buscarjefebaja.setNextFocusableComponent(bajajefe);
        buscarjefebaja.setPlaceholder("Buscar socio...");
        buscarjefebaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarjefebajaKeyReleased(evt);
            }
        });

        rSButton8.setBackground(new java.awt.Color(255, 255, 255));
        rSButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton8.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton8.setFocusPainted(false);
        rSButton8.setFocusable(false);
        rSButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton8MouseClicked(evt);
            }
        });

        tablajefebaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Socio"
            }
        ));
        tablajefebaja.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablajefebaja.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablajefebaja.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablajefebaja.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablajefebaja.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablajefebaja.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablajefebaja.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablajefebaja.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablajefebaja.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablajefebaja.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablajefebaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablajefebajaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablajefebaja);

        bajajefe.setEditable(false);
        bajajefe.setEditable(false);
        bajajefe.setForeground(new java.awt.Color(255, 255, 255));
        bajajefe.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajajefe.setBotonColor(new java.awt.Color(0, 0, 0));
        bajajefe.setCaretColor(new java.awt.Color(255, 255, 255));
        bajajefe.setColorTransparente(true);
        bajajefe.setNextFocusableComponent(rSButtonRiple16);
        bajajefe.setPlaceholder("Socio");

        rSButtonRiple16.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple16.setText("Dar de baja");
        rSButtonRiple16.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple16.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple16.setNextFocusableComponent(buscarhnc);
        rSButtonRiple16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound3Layout = new javax.swing.GroupLayout(jPanelRound3);
        jPanelRound3.setLayout(jPanelRound3Layout);
        jPanelRound3Layout.setHorizontalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(buscarjefebaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelRound3Layout.createSequentialGroup()
                        .addComponent(bajajefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButtonRiple16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanelRound3Layout.setVerticalGroup(
            jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarjefebaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bajajefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelRound4.setColorSecundario(new java.awt.Color(0, 30, 100));

        buscarhnc.setForeground(new java.awt.Color(255, 255, 255));
        buscarhnc.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarhnc.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarhnc.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarhnc.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarhnc.setColorTransparente(true);
        buscarhnc.setModoMaterial(true);
        buscarhnc.setNextFocusableComponent(bajahnc);
        buscarhnc.setPlaceholder("Buscar hora no cargable...");
        buscarhnc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarhncKeyReleased(evt);
            }
        });

        rSButton10.setBackground(new java.awt.Color(255, 255, 255));
        rSButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton10.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton10.setFocusPainted(false);
        rSButton10.setFocusable(false);
        rSButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton10MouseClicked(evt);
            }
        });

        tablahnc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Hora no cargable"
            }
        ));
        tablahnc.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablahnc.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablahnc.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablahnc.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablahnc.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablahnc.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablahnc.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablahnc.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablahnc.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablahnc.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablahnc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablahncMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablahnc);

        bajahnc.setEditable(false);
        bajahnc.setForeground(new java.awt.Color(255, 255, 255));
        bajahnc.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajahnc.setBotonColor(new java.awt.Color(0, 0, 0));
        bajahnc.setCaretColor(new java.awt.Color(255, 255, 255));
        bajahnc.setColorTransparente(true);
        bajahnc.setNextFocusableComponent(rSButtonRiple17);
        bajahnc.setPlaceholder("Hora no cargable");

        rSButtonRiple17.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple17.setText("Dar de baja");
        rSButtonRiple17.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple17.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound4Layout = new javax.swing.GroupLayout(jPanelRound4);
        jPanelRound4.setLayout(jPanelRound4Layout);
        jPanelRound4Layout.setHorizontalGroup(
            jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(jPanelRound4Layout.createSequentialGroup()
                        .addComponent(buscarhnc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelRound4Layout.createSequentialGroup()
                        .addComponent(bajahnc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonRiple17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanelRound4Layout.setVerticalGroup(
            jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarhnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bajahnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout socioLayout = new javax.swing.GroupLayout(socio);
        socio.setLayout(socioLayout);
        socioLayout.setHorizontalGroup(
            socioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(socioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        socioLayout.setVerticalGroup(
            socioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jPanelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderbaja.add(socio, "card2");

        cliente.setName("cliente"); // NOI18N
        cliente.setOpaque(false);

        jLabel50.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("3");

        jLabel51.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("pasos!");
        jLabel51.setFocusable(false);

        jLabel47.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("1.- Busca");
        jLabel47.setFocusable(false);

        jLabel60.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(255,255,255)));
        jLabel60.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        jLabel49.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("¡Hazlo en");
        jLabel49.setFocusable(false);

        jLabel52.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("2.- Selecciona");
        jLabel52.setFocusable(false);

        jLabel53.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("3.- ¡Y dalo de baja!");
        jLabel53.setFocusable(false);

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51))
                            .addComponent(jLabel47)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaempresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "RFC", "Ingreso"
            }
        ));
        tablaempresa.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablaempresa.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaempresa.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablaempresa.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablaempresa.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaempresa.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaempresa.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaempresa.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempresa.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablaempresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaempresaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaempresa);

        buscarempresa.setForeground(new java.awt.Color(255, 255, 255));
        buscarempresa.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarempresa.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarempresa.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarempresa.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarempresa.setColorTransparente(true);
        buscarempresa.setModoMaterial(true);
        buscarempresa.setNextFocusableComponent(bajaempresa);
        buscarempresa.setPlaceholder("Buscar cliente...");
        buscarempresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarempresaKeyReleased(evt);
            }
        });

        rSButton6.setBackground(new java.awt.Color(255, 255, 255));
        rSButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton6.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton6.setFocusable(false);
        rSButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton6MouseClicked(evt);
            }
        });

        bajaempresa.setEditable(false);
        bajaempresa.setForeground(new java.awt.Color(255, 255, 255));
        bajaempresa.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajaempresa.setBotonColor(new java.awt.Color(255, 255, 255));
        bajaempresa.setColorTransparente(true);
        bajaempresa.setNextFocusableComponent(rSButtonRiple15);
        bajaempresa.setPlaceholder("Cliente");
        bajaempresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bajaempresaKeyReleased(evt);
            }
        });

        rSButtonRiple15.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple15.setText("Dar de baja");
        rSButtonRiple15.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple15.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound9Layout = new javax.swing.GroupLayout(jPanelRound9);
        jPanelRound9.setLayout(jPanelRound9Layout);
        jPanelRound9Layout.setHorizontalGroup(
            jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanelRound9Layout.createSequentialGroup()
                        .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound9Layout.createSequentialGroup()
                                .addComponent(buscarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound9Layout.createSequentialGroup()
                                .addComponent(bajaempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButtonRiple15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound9Layout.setVerticalGroup(
            jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bajaempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout clienteLayout = new javax.swing.GroupLayout(cliente);
        cliente.setLayout(clienteLayout);
        clienteLayout.setHorizontalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        clienteLayout.setVerticalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderbaja.add(cliente, "card3");

        colaborador.setName("colaborador"); // NOI18N
        colaborador.setOpaque(false);

        jLabel59.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("¡Hazlo en");
        jLabel59.setFocusable(false);

        jLabel62.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("3");
        jLabel62.setFocusable(false);

        jLabel63.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("pasos!");
        jLabel63.setFocusable(false);

        jLabel64.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        jLabel65.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("1.- Busca");
        jLabel65.setFocusable(false);

        jLabel66.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("2.- Selecciona");
        jLabel66.setFocusable(false);

        jLabel67.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("3.- ¡Y dalo de baja!");
        jLabel67.setFocusable(false);

        javax.swing.GroupLayout jPanelRound6Layout = new javax.swing.GroupLayout(jPanelRound6);
        jPanelRound6.setLayout(jPanelRound6Layout);
        jPanelRound6Layout.setHorizontalGroup(
            jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRound6Layout.createSequentialGroup()
                .addGroup(jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelRound6Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel63))
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRound6Layout.setVerticalGroup(
            jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel67)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        tablaempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "IdSocio", "Nivel", "Ingreso"
            }
        ));
        tablaempleado.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablaempleado.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaempleado.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablaempleado.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablaempleado.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaempleado.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaempleado.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaempleado.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempleado.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaempleado.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablaempleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaempleadoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaempleado);

        rSButton4.setBackground(new java.awt.Color(255, 255, 255));
        rSButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton4.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton4.setFocusable(false);
        rSButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton4MouseClicked(evt);
            }
        });

        buscarempleado.setForeground(new java.awt.Color(255, 255, 255));
        buscarempleado.setAutoscrolls(false);
        buscarempleado.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarempleado.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarempleado.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarempleado.setColorTransparente(true);
        buscarempleado.setModoMaterial(true);
        buscarempleado.setNextFocusableComponent(bajaempleado);
        buscarempleado.setPlaceholder("Buscar colaborador...");
        buscarempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarempleadoKeyReleased(evt);
            }
        });

        rSButtonRiple14.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple14.setText("Dar de baja");
        rSButtonRiple14.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple14.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple14MouseClicked(evt);
            }
        });

        bajaempleado.setEditable(false);
        bajaempleado.setForeground(new java.awt.Color(255, 255, 255));
        bajaempleado.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajaempleado.setBotonColor(new java.awt.Color(0, 0, 0));
        bajaempleado.setCaretColor(new java.awt.Color(255, 255, 255));
        bajaempleado.setColorTransparente(true);
        bajaempleado.setNextFocusableComponent(rSButtonRiple14);
        bajaempleado.setPlaceholder("Colaborador");

        javax.swing.GroupLayout jPanelRound7Layout = new javax.swing.GroupLayout(jPanelRound7);
        jPanelRound7.setLayout(jPanelRound7Layout);
        jPanelRound7Layout.setHorizontalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanelRound7Layout.createSequentialGroup()
                        .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound7Layout.createSequentialGroup()
                                .addComponent(buscarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound7Layout.createSequentialGroup()
                                .addComponent(bajaempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButtonRiple14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound7Layout.setVerticalGroup(
            jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bajaempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonRiple14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buscarempleado.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout colaboradorLayout = new javax.swing.GroupLayout(colaborador);
        colaborador.setLayout(colaboradorLayout);
        colaboradorLayout.setHorizontalGroup(
            colaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        colaboradorLayout.setVerticalGroup(
            colaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderbaja.add(colaborador, "card4");

        servicio.setFocusable(false);
        servicio.setName("servicio"); // NOI18N
        servicio.setOpaque(false);

        jLabel54.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("¡Hazlo en");

        jLabel55.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("3");

        jLabel56.setFont(new java.awt.Font("Open Sans Semibold", 1, 36)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("pasos!");

        jLabel61.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        jLabel48.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("1.- Busca");
        jLabel48.setFocusable(false);

        jLabel57.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("2.- Selecciona");
        jLabel57.setFocusable(false);

        jLabel58.setFont(new java.awt.Font("Open Sans Semibold", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("3.- ¡Y dalo de baja!");
        jLabel58.setFocusable(false);

        javax.swing.GroupLayout jPanelRound5Layout = new javax.swing.GroupLayout(jPanelRound5);
        jPanelRound5.setLayout(jPanelRound5Layout);
        jPanelRound5Layout.setHorizontalGroup(
            jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRound5Layout.createSequentialGroup()
                .addGroup(jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56))
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelRound5Layout.setVerticalGroup(
            jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        bajaservicio.setEditable(false);
        bajaservicio.setForeground(new java.awt.Color(255, 255, 255));
        bajaservicio.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        bajaservicio.setBotonColor(new java.awt.Color(0, 0, 0));
        bajaservicio.setCaretColor(new java.awt.Color(255, 255, 255));
        bajaservicio.setColorTransparente(true);
        bajaservicio.setNextFocusableComponent(rSButtonRiple18);
        bajaservicio.setPlaceholder("Servicio");

        rSButtonRiple18.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSButtonRiple18.setText("Dar de baja");
        rSButtonRiple18.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple18.setColorText(new java.awt.Color(0, 0, 0));
        rSButtonRiple18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonRiple18MouseClicked(evt);
            }
        });

        tablaservicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Servicio", "Descripción corta"
            }
        ));
        tablaservicio.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablaservicio.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaservicio.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablaservicio.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablaservicio.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaservicio.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaservicio.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaservicio.setFuenteFilas(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaservicio.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold", 1, 12)); // NOI18N
        tablaservicio.setFuenteHead(new java.awt.Font("Open Sans Semibold", 1, 18)); // NOI18N
        tablaservicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaservicioMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tablaservicio);

        rSButton12.setBackground(new java.awt.Color(255, 255, 255));
        rSButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButton12.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton12.setFocusable(false);
        rSButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton12MouseClicked(evt);
            }
        });

        buscarservicio.setForeground(new java.awt.Color(255, 255, 255));
        buscarservicio.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarservicio.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarservicio.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarservicio.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarservicio.setColorTransparente(true);
        buscarservicio.setModoMaterial(true);
        buscarservicio.setNextFocusableComponent(bajaservicio);
        buscarservicio.setPlaceholder("Buscar servicio...");
        buscarservicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarservicioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound8Layout = new javax.swing.GroupLayout(jPanelRound8);
        jPanelRound8.setLayout(jPanelRound8Layout);
        jPanelRound8Layout.setHorizontalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanelRound8Layout.createSequentialGroup()
                        .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound8Layout.createSequentialGroup()
                                .addComponent(bajaservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSButtonRiple18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound8Layout.createSequentialGroup()
                                .addComponent(buscarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 234, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRound8Layout.setVerticalGroup(
            jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonRiple18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bajaservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout servicioLayout = new javax.swing.GroupLayout(servicio);
        servicio.setLayout(servicioLayout);
        servicioLayout.setHorizontalGroup(
            servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        servicioLayout.setVerticalGroup(
            servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sliderbaja.add(servicio, "card5");

        javax.swing.GroupLayout bajamenuLayout = new javax.swing.GroupLayout(bajamenu);
        bajamenu.setLayout(bajamenuLayout);
        bajamenuLayout.setHorizontalGroup(
            bajamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bajamenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sliderbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        bajamenuLayout.setVerticalGroup(
            bajamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bajamenuLayout.createSequentialGroup()
                .addGroup(bajamenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(bajamenuLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bajamenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bajamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void baja_socioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_socioMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_cliente,baja_colaborador, baja_servicio};
        cambiarcolorreporte(baja_socio,menu);
        sliderbaja.setPanelSlider(20, socio, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_socioMouseClicked

    private void baja_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_clienteMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_socio,baja_colaborador,baja_servicio};
        cambiarcolorreporte(baja_cliente,menu);
        sliderbaja.setPanelSlider(20, cliente, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_clienteMouseClicked

    private void baja_colaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_colaboradorMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_socio,baja_cliente,baja_servicio};
        cambiarcolorreporte(baja_colaborador,menu);
        sliderbaja.setPanelSlider(20, colaborador, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_colaboradorMouseClicked

    private void baja_servicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baja_servicioMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {baja_socio,baja_cliente,baja_colaborador};
        cambiarcolorreporte(baja_servicio,menu);
        sliderbaja.setPanelSlider(20, servicio, RSPanelsSlider.DIRECT.RIGHT);
    }//GEN-LAST:event_baja_servicioMouseClicked

    private void buscarjefebajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarjefebajaKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablajefebaja.setModel(dentro.buscarjefetabla1(buscarjefebaja.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarjefebajaKeyReleased

    private void rSButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton8MouseClicked
        // TODO add your handling code here:
        buscarjefebaja.requestFocus();
    }//GEN-LAST:event_rSButton8MouseClicked

    private void tablajefebajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablajefebajaMouseClicked
        // TODO add your handling code here:
        bajajefe.setText(tablajefebaja.getValueAt(tablajefebaja.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablajefebajaMouseClicked

    private void rSButtonRiple16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple16MouseClicked
        // TODO add your handling code here:
        if(!bajajefe.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
            if(message==0){
                try {
                    dentro.bajajefe(tablajefebaja.getValueAt(tablajefebaja.getSelectedRow(),0).toString(),usuario);
                    tablajefebaja.removeAll();
                    bajajefe.setText("");
                    buscarjefebaja.setText("");
                    tablajefebaja.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null}
                        },
                        new String [] {
                            "Id", "Nombre", "Socio"
                        }
                    ));

                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"¡Error!"," ", mj);
        }
    }//GEN-LAST:event_rSButtonRiple16MouseClicked

    private void buscarhncKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarhncKeyReleased
        // TODO add your handling code here:
        try {
            tablahnc.setModel(dentro.buscarhnctabla(buscarhnc.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarhncKeyReleased

    private void rSButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton10MouseClicked
        // TODO add your handling code here:
        buscarhnc.requestFocus();
    }//GEN-LAST:event_rSButton10MouseClicked

    private void tablahncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahncMouseClicked
        // TODO add your handling code here:
        bajahnc.setText(tablahnc.getValueAt(tablahnc.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablahncMouseClicked

    private void rSButtonRiple17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple17MouseClicked
        // TODO add your handling code here:
        if(!bajahnc.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
            if(message==0){
                try {
                    dentro.bajahnc(tablahnc.getValueAt(tablahnc.getSelectedRow(),0).toString(),usuario);
                    tablahnc.removeAll();
                    bajahnc.setText("");
                    buscarhnc.setText("");
                    tablahnc.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null}
                        },
                        new String [] {
                            "Id", "Hora no cargable"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"¡Error!"," ", mj);
        }
    }//GEN-LAST:event_rSButtonRiple17MouseClicked

    private void tablaempresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaempresaMouseClicked
        // TODO add your handling code here:
        bajaempresa.setText(tablaempresa.getValueAt(tablaempresa.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablaempresaMouseClicked

    private void buscarempresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarempresaKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablaempresa.setModel(dentro.buscarempresatabla(buscarempresa.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarempresaKeyReleased

    private void rSButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton6MouseClicked
        // TODO add your handling code here:
        buscarempresa.requestFocus();
    }//GEN-LAST:event_rSButton6MouseClicked

    private void bajaempresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bajaempresaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_bajaempresaKeyReleased

    private void rSButtonRiple15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple15MouseClicked
        // TODO add your handling code here:
        if(!bajaempresa.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
            if(message==0){
                try {
                    dentro.bajaempresa(tablaempresa.getValueAt(tablaempresa.getSelectedRow(),0).toString(),usuario);
                    tablaempresa.removeAll();
                    bajaempresa.setText("");
                    buscarempresa.setText("");
                    tablaempresa.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null}
                        },
                        new String [] {
                            "Id", "Nombre", "RFC", "Ingreso"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"¡Error!"," ", mj);
        }
    }//GEN-LAST:event_rSButtonRiple15MouseClicked

    private void tablaempleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaempleadoMouseClicked
        // TODO add your handling code here:
        bajaempleado.setText(tablaempleado.getValueAt(tablaempleado.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablaempleadoMouseClicked

    private void buscarempleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarempleadoKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablaempleado.setModel(dentro.buscarempleadotabla(buscarempleado.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarempleadoKeyReleased

    private void rSButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton4MouseClicked
        // TODO add your handling code here:
        buscarempleado.requestFocus();
    }//GEN-LAST:event_rSButton4MouseClicked

    private void rSButtonRiple14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple14MouseClicked
        // TODO add your handling code here:
        if(!bajaempleado.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
            if(message==0){
                try {
                    dentro.bajaempleado(tablaempleado.getValueAt(tablaempleado.getSelectedRow(),0).toString(),usuario);
                    tablaempleado.removeAll();
                    bajaempleado.setText("");
                    buscarempleado.setText("");
                    tablaempleado.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null}
                        },
                        new String [] {
                            "Id", "Nombre", "idSocio", "Ingreso"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"¡Error!"," ", mj);
        }
    }//GEN-LAST:event_rSButtonRiple14MouseClicked

    private void buscarservicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarservicioKeyReleased
        try {
            // TODO add your handling code here:
            tablaservicio.setModel(dentro.buscarserviciotabla(buscarservicio.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarservicioKeyReleased

    private void rSButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton12MouseClicked
        // TODO add your handling code here:
        buscarservicio.requestFocus();
    }//GEN-LAST:event_rSButton12MouseClicked

    private void tablaservicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaservicioMouseClicked
        bajaservicio.setText(tablaservicio.getValueAt(tablaservicio.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablaservicioMouseClicked

    private void rSButtonRiple18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple18MouseClicked
        // TODO add your handling code here:
        if(!bajaservicio.getText().equals("")){
            int mj= JOptionPane.YES_NO_OPTION;
            int message= JOptionPane.showConfirmDialog(this, "¿Dar de baja?", "", mj);
            if(message==0){
                try {
                    dentro.bajaservicio(tablaservicio.getValueAt(tablaservicio.getSelectedRow(),0).toString(),usuario);
                    tablaservicio.removeAll();
                    bajaservicio.setText("");
                    buscarservicio.setText("");
                    tablaservicio.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null}
                        },
                        new String [] {
                            "Id", "Servicio", "Descripción corta"
                        }
                    ));
                    jFrame1.setVisible(true);
                    jFrame1.setBackground(transparente);
                } catch (SQLException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"¡Error!"," ", mj);
        }
    }//GEN-LAST:event_rSButtonRiple18MouseClicked

    private void rSButtonRiple5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonRiple5MouseClicked
        jFrame1.dispose();
        jFrame1.setVisible(false);
    }//GEN-LAST:event_rSButtonRiple5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton baja_cliente;
    private rojeru_san.RSButton baja_colaborador;
    private rojeru_san.RSButton baja_servicio;
    private rojeru_san.RSButton baja_socio;
    private rojeru_san.RSMTextFull bajaempleado;
    private rojeru_san.RSMTextFull bajaempresa;
    private rojeru_san.RSMTextFull bajahnc;
    private rojeru_san.RSMTextFull bajajefe;
    private javax.swing.JPanel bajamenu;
    private rojeru_san.RSMTextFull bajaservicio;
    private rojeru_san.RSMTextFull buscarempleado;
    private rojeru_san.RSMTextFull buscarempresa;
    private rojeru_san.RSMTextFull buscarhnc;
    private rojeru_san.RSMTextFull buscarjefebaja;
    private rojeru_san.RSMTextFull buscarservicio;
    private javax.swing.JPanel cliente;
    private javax.swing.JPanel colaborador;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel3;
    private zesatic.JPanelRound jPanelRound1;
    private zesatic.JPanelRound jPanelRound2;
    private zesatic.JPanelRound jPanelRound3;
    private zesatic.JPanelRound jPanelRound4;
    private zesatic.JPanelRound jPanelRound5;
    private zesatic.JPanelRound jPanelRound6;
    private zesatic.JPanelRound jPanelRound7;
    private zesatic.JPanelRound jPanelRound8;
    private zesatic.JPanelRound jPanelRound9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private rojeru_san.RSButton rSButton10;
    private rojeru_san.RSButton rSButton12;
    private rojeru_san.RSButton rSButton4;
    private rojeru_san.RSButton rSButton6;
    private rojeru_san.RSButton rSButton8;
    private rojeru_san.RSButtonRiple rSButtonRiple14;
    private rojeru_san.RSButtonRiple rSButtonRiple15;
    private rojeru_san.RSButtonRiple rSButtonRiple16;
    private rojeru_san.RSButtonRiple rSButtonRiple17;
    private rojeru_san.RSButtonRiple rSButtonRiple18;
    private rojeru_san.RSButtonRiple rSButtonRiple5;
    private javax.swing.JPanel servicio;
    private rojeru_san.RSPanelsSlider sliderbaja;
    private javax.swing.JPanel socio;
    private rojerusan.RSTableMetro tablaempleado;
    private rojerusan.RSTableMetro tablaempresa;
    private rojerusan.RSTableMetro tablahnc;
    private rojerusan.RSTableMetro tablajefebaja;
    private rojerusan.RSTableMetro tablaservicio;
    // End of variables declaration//GEN-END:variables

}
