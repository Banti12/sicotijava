/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zesatic;

import ecxel.Excel;
import java.awt.Color;
import static java.awt.SystemColor.info;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.RSButton;
import rojeru_san.RSPanelsSlider;

/**
 *
 * @author Brayan
 */
public class reportemenu extends javax.swing.JPanel {

    /**
     * Creates new form reportemenu
     */
    conectar dentro;
    Color transparente;
    boolean bandera = true;
    boolean bandera1 = true;
    String usuario;
    public reportemenu(String usuario) {
        this.usuario=usuario;
        dentro= new conectar();
        transparente= new Color(0,0,0,0);
        initComponents();
        iniciar();
        
    }
    
    public void iniciar(){
        reportesocio.setBackground(transparente);
        botonsocio.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, new Color(255,69,0)));
        tablacliente.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablasocio.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        tablacolaborador.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        inforeporte.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        inforeporte1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infopanelc3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infopanelc2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infopanelc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infopanelc1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
    }
    public boolean verificafecha(int d, int d1, int m, int m1,int a, int a1){
        if(a1>a)
        {
            return true;
        }else if(a>a1)
        {
            return false;
        } else if(a == a1)
        {
                if(m1==m)
                {
                    if(d1>d)
                    {
                        return true;
                    }else if(d<d1)
                    {
                        return false;
                    }else
                    {
                        return false;
                    }   
                }else if(m1>m)
                {
                    return true;
                }else
                {
                    return false;
                }
        }else
        {
            return false;
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
    public void limpiarsocio(){
        diasocio.setSelectedIndex(0);
        messocio.setSelectedIndex(0);
        anosocio.setSelectedIndex(0);
        diasocio1.setSelectedIndex(0);
        messocio1.setSelectedIndex(0);
        anosocio1.setSelectedIndex(0);
        labelfecha.setVisible(false);
        buscarreportes.setVisible(false);
        nombres.setText("");
        inicialess.setText("");
        activos.setText("");
        ids.setText("");
        buscarsocio.setText("");        
        tablasocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Iniciales", "Nombre", "Activo"
            }
        ));
        tablasocio.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablasocio.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablasocio.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablasocio.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablasocio.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablasocio.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablasocio.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablasocio.setDragEnabled(true);
        tablasocio.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));
    }
    public void regresoreporte(){
        reportes.setPanelSlider(25, 5,reportesocio, RSPanelsSlider.DIRECT.RIGHT);
        RSButton menu[] = {botoncliente,botoncolaborador};
        cambiarcolorreporte(botonsocio,menu);
        
    }
    public void limpiarcliente(){
        diasocio.setSelectedIndex(0);
        messocio.setSelectedIndex(0);
        anosocio.setSelectedIndex(0);
        diasocio1.setSelectedIndex(0);
        messocio1.setSelectedIndex(0);
        anosocio1.setSelectedIndex(0);
        labelfecha.setVisible(false);
        buscarreportes.setVisible(false);
        nombrescl.setText("");
        ficl.setText("");
        activocl.setText("");
        idcl.setText("");
        buscarcliente.setText("");        
        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Fecha  de ingreso", "Activo"
            }
        ));
        tablacliente.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablacliente.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablacliente.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablacliente.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablacliente.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablacliente.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablacliente.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablacliente.setDragEnabled(true);
        tablacliente.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));
    }   
    public void limpiarcolaborador(){
        diasocio.setSelectedIndex(0);
        messocio.setSelectedIndex(0);
        anosocio.setSelectedIndex(0);
        diasocio1.setSelectedIndex(0);
        messocio1.setSelectedIndex(0);
        anosocio1.setSelectedIndex(0);
        labelfecha.setVisible(false);
        buscarreportes.setVisible(false);
        nombresc.setText("");
        activoc.setText("");
        idc.setText("");
        nivelc.setText("");
        socioc.setText("");       
        buscarcolaborador.setText("");  
        tablacolaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Activo", "Nivel", "Socio"
            }
        ));
        tablacolaborador.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablacolaborador.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablacolaborador.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablacolaborador.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablacolaborador.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablacolaborador.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablacolaborador.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablacolaborador.setDragEnabled(true);
        tablacolaborador.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistacolaborador = new javax.swing.JFrame();
        panelvistacolaborador = new javax.swing.JPanel();
        menudecolaborador = new zesatic.JPanelRound();
        rSButton5 = new rojeru_san.RSButton();
        rSButton7 = new rojeru_san.RSButton();
        hccolaborador = new javax.swing.JPanel();
        label6 = new javax.swing.JLabel();
        hnccolaborador = new javax.swing.JPanel();
        label7 = new javax.swing.JLabel();
        periodocolaboradormenu = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        periodocolaborador = new javax.swing.JLabel();
        periodosociodentro = new javax.swing.JLabel();
        crearexcelcolaborador = new rojeru_san.RSButtonRiple();
        tablascolaborador = new rojeru_san.RSPanelsSlider();
        hcargables1 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        vistatablacolaborador = new rojerusan.RSTableMetro();
        hncargables1 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        vistatablacolaboradorhnc = new rojerusan.RSTableMetro();
        minimizar_principal2 = new rojeru_san.RSButton();
        cerrar_principal2 = new rojeru_san.RSButton();
        fondosocio1 = new javax.swing.JLabel();
        reportemenu = new javax.swing.JPanel();
        paneldelreporte = new javax.swing.JPanel();
        botonsocio = new rojeru_san.RSButton();
        botoncliente = new rojeru_san.RSButton();
        botoncolaborador = new rojeru_san.RSButton();
        reportes = new rojeru_san.RSPanelsSlider();
        reportesocio = new javax.swing.JPanel();
        jPanelRound20 = new zesatic.JPanelRound();
        inforeporte = new javax.swing.JPanel();
        nombrereporte = new javax.swing.JLabel();
        inicialesreporte = new javax.swing.JLabel();
        nombres = new javax.swing.JLabel();
        inicialess = new javax.swing.JLabel();
        ids = new javax.swing.JLabel();
        botonbuscarcliente1 = new rojeru_san.RSButton();
        inforeporte1 = new javax.swing.JPanel();
        nombrereporte1 = new javax.swing.JLabel();
        idreporte = new javax.swing.JLabel();
        activos = new javax.swing.JLabel();
        imagensocio = new javax.swing.JLabel();
        buscarsocio = new rojeru_san.RSMTextFull();
        tablareporte = new javax.swing.JScrollPane();
        tablasocio = new rojerusan.RSTableMetro();
        reporteclientes = new javax.swing.JPanel();
        jPanelRound22 = new zesatic.JPanelRound();
        infopanelc3 = new javax.swing.JPanel();
        textoparapanelsocio6 = new javax.swing.JLabel();
        textoparapanelsocio7 = new javax.swing.JLabel();
        infopanelc2 = new javax.swing.JPanel();
        textoparapanelsocio14 = new javax.swing.JLabel();
        textoparapanelsocio8 = new javax.swing.JLabel();
        nombrescl = new javax.swing.JLabel();
        activocl = new javax.swing.JLabel();
        socioimageninfo2 = new javax.swing.JLabel();
        idcl = new javax.swing.JLabel();
        ficl = new javax.swing.JLabel();
        buscarcliente = new rojeru_san.RSMTextFull();
        botonbuscarcliente = new rojeru_san.RSButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        tablacliente = new rojerusan.RSTableMetro();
        reportecolaborador = new javax.swing.JPanel();
        jPanelRound21 = new zesatic.JPanelRound();
        socioimageninfo1 = new javax.swing.JLabel();
        infopanelc = new javax.swing.JPanel();
        textoparapanelsocio3 = new javax.swing.JLabel();
        textoparapanelsocio4 = new javax.swing.JLabel();
        textoparapanelsocio5 = new javax.swing.JLabel();
        nombresc = new javax.swing.JLabel();
        idc = new javax.swing.JLabel();
        infopanelc1 = new javax.swing.JPanel();
        textoparapanelsocio12 = new javax.swing.JLabel();
        textoparapanelsocio13 = new javax.swing.JLabel();
        socioc = new javax.swing.JLabel();
        nivelc = new javax.swing.JLabel();
        activoc = new javax.swing.JLabel();
        buscarcolaborador = new rojeru_san.RSMTextFull();
        rSButtonRiple11 = new rojeru_san.RSButton();
        jScrollPane22 = new javax.swing.JScrollPane();
        tablacolaborador = new rojerusan.RSTableMetro();
        fechasreporte = new javax.swing.JPanel();
        jPanelRound12 = new zesatic.JPanelRound();
        diasocio1 = new rojerusan.RSComboMetro();
        anosocio1 = new rojerusan.RSComboMetro();
        fechainiciotexto = new javax.swing.JLabel();
        messocio = new rojerusan.RSComboMetro();
        messocio1 = new rojerusan.RSComboMetro();
        fechainiciotexto1 = new javax.swing.JLabel();
        diasocio = new rojerusan.RSComboMetro();
        buscarreportes = new rojeru_san.RSButtonRiple();
        anosocio = new rojerusan.RSComboMetro();
        labelfecha = new javax.swing.JLabel();

        vistacolaborador.setMinimumSize(new java.awt.Dimension(1010, 650));
        vistacolaborador.setUndecorated(true);
        vistacolaborador.setSize(new java.awt.Dimension(1010, 690));

        panelvistacolaborador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButton5.setBackground(new java.awt.Color(255, 255, 255));
        rSButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/flechaiz.png"))); // NOI18N
        rSButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton5MouseClicked(evt);
            }
        });

        rSButton7.setBackground(new java.awt.Color(255, 255, 255));
        rSButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/flechader.png"))); // NOI18N
        rSButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButton7MouseClicked(evt);
            }
        });

        hccolaborador.setOpaque(false);
        hccolaborador.setPreferredSize(new java.awt.Dimension(432, 98));
        hccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,69,0)));

        label6.setFont(new java.awt.Font("Open Sans", 1, 30)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label6.setText("Horas cargables.");

        javax.swing.GroupLayout hccolaboradorLayout = new javax.swing.GroupLayout(hccolaborador);
        hccolaborador.setLayout(hccolaboradorLayout);
        hccolaboradorLayout.setHorizontalGroup(
            hccolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hccolaboradorLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(label6)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        hccolaboradorLayout.setVerticalGroup(
            hccolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hccolaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        hnccolaborador.setOpaque(false);
        hnccolaborador.setPreferredSize(new java.awt.Dimension(432, 100));

        label7.setFont(new java.awt.Font("Open Sans", 1, 30)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label7.setText("Horas no cargables.");

        javax.swing.GroupLayout hnccolaboradorLayout = new javax.swing.GroupLayout(hnccolaborador);
        hnccolaborador.setLayout(hnccolaboradorLayout);
        hnccolaboradorLayout.setHorizontalGroup(
            hnccolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hnccolaboradorLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(label7)
                .addGap(71, 71, 71))
        );
        hnccolaboradorLayout.setVerticalGroup(
            hnccolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hnccolaboradorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label7)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menudecolaboradorLayout = new javax.swing.GroupLayout(menudecolaborador);
        menudecolaborador.setLayout(menudecolaboradorLayout);
        menudecolaboradorLayout.setHorizontalGroup(
            menudecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menudecolaboradorLayout.createSequentialGroup()
                .addComponent(rSButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(hccolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hnccolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menudecolaboradorLayout.setVerticalGroup(
            menudecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menudecolaboradorLayout.createSequentialGroup()
                .addGroup(menudecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menudecolaboradorLayout.createSequentialGroup()
                        .addGroup(menudecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hccolaborador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hnccolaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelvistacolaborador.add(menudecolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 920, 100));

        periodocolaboradormenu.setBackground(new java.awt.Color(255, 255, 255));

        label2.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.setText("Periodo");

        periodocolaborador.setFont(new java.awt.Font("Open Sans", 1, 17)); // NOI18N
        periodocolaborador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        periodocolaborador.setText("2018-01-05 a 2019-01-05");

        periodosociodentro.setVisible(false);

        javax.swing.GroupLayout periodocolaboradormenuLayout = new javax.swing.GroupLayout(periodocolaboradormenu);
        periodocolaboradormenu.setLayout(periodocolaboradormenuLayout);
        periodocolaboradormenuLayout.setHorizontalGroup(
            periodocolaboradormenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periodocolaboradormenuLayout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(periodosociodentro, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(label2)
                .addGap(34, 34, 34)
                .addComponent(periodocolaborador)
                .addGap(22, 22, 22))
        );
        periodocolaboradormenuLayout.setVerticalGroup(
            periodocolaboradormenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periodocolaboradormenuLayout.createSequentialGroup()
                .addGroup(periodocolaboradormenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(periodosociodentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(periodocolaboradormenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(periodocolaborador)
                        .addComponent(label2)))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        panelvistacolaborador.add(periodocolaboradormenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 910, 30));

        crearexcelcolaborador.setBackground(new java.awt.Color(255, 255, 255));
        crearexcelcolaborador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        crearexcelcolaborador.setForeground(new java.awt.Color(0, 30, 100));
        crearexcelcolaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/excel.png"))); // NOI18N
        crearexcelcolaborador.setText("Crear Excel");
        crearexcelcolaborador.setColorText(new java.awt.Color(0, 0, 0));
        crearexcelcolaborador.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        crearexcelcolaborador.setMaximumSize(new java.awt.Dimension(65, 40));
        crearexcelcolaborador.setMinimumSize(new java.awt.Dimension(65, 40));
        crearexcelcolaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearexcelcolaboradorMouseClicked(evt);
            }
        });
        panelvistacolaborador.add(crearexcelcolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, -1, -1));

        hcargables1.setBackground(new java.awt.Color(255, 255, 255));

        vistatablacolaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Empresa", "Horas"
            }
        ));
        vistatablacolaborador.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        vistatablacolaborador.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        vistatablacolaborador.setColorBordeHead(new java.awt.Color(214, 214, 214));
        vistatablacolaborador.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        vistatablacolaborador.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        vistatablacolaborador.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        vistatablacolaborador.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        vistatablacolaborador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        vistatablacolaborador.setFuenteFilas(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaborador.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaborador.setFuenteHead(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaborador.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        jScrollPane16.setViewportView(vistatablacolaborador);

        javax.swing.GroupLayout hcargables1Layout = new javax.swing.GroupLayout(hcargables1);
        hcargables1.setLayout(hcargables1Layout);
        hcargables1Layout.setHorizontalGroup(
            hcargables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hcargables1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        hcargables1Layout.setVerticalGroup(
            hcargables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hcargables1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablascolaborador.add(hcargables1, "card2");

        hncargables1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane17.setBackground(new java.awt.Color(255, 255, 255));

        vistatablacolaboradorhnc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Horas no cargables", "Horas"
            }
        ));
        vistatablacolaboradorhnc.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        vistatablacolaboradorhnc.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        vistatablacolaboradorhnc.setColorBordeHead(new java.awt.Color(214, 214, 214));
        vistatablacolaboradorhnc.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        vistatablacolaboradorhnc.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        vistatablacolaboradorhnc.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        vistatablacolaboradorhnc.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        vistatablacolaboradorhnc.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        vistatablacolaboradorhnc.setFuenteFilas(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaboradorhnc.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaboradorhnc.setFuenteHead(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vistatablacolaboradorhnc.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(255,69,0)));
        jScrollPane17.setViewportView(vistatablacolaboradorhnc);

        javax.swing.GroupLayout hncargables1Layout = new javax.swing.GroupLayout(hncargables1);
        hncargables1.setLayout(hncargables1Layout);
        hncargables1Layout.setHorizontalGroup(
            hncargables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hncargables1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        hncargables1Layout.setVerticalGroup(
            hncargables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hncargables1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablascolaborador.add(hncargables1, "card3");

        panelvistacolaborador.add(tablascolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 910, 400));

        minimizar_principal2.setBackground(new java.awt.Color(0, 30, 100));
        minimizar_principal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-eliminar-con-linea-horizontal.png"))); // NOI18N
        minimizar_principal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizar_principal2MouseClicked(evt);
            }
        });
        panelvistacolaborador.add(minimizar_principal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 40, -1));

        cerrar_principal2.setBackground(new java.awt.Color(0, 30, 100));
        cerrar_principal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        cerrar_principal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrar_principal2MouseClicked(evt);
            }
        });
        panelvistacolaborador.add(cerrar_principal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, -1));

        fondosocio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/oficee.jpg"))); // NOI18N
        panelvistacolaborador.add(fondosocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 690));

        vistacolaborador.getContentPane().add(panelvistacolaborador, java.awt.BorderLayout.CENTER);

        setOpaque(false);

        reportemenu.setBackground(new java.awt.Color(255, 255, 255));
        reportemenu.setOpaque(false);

        botonsocio.setBackground(new java.awt.Color(255, 255, 255));
        botonsocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-azul.png"))); // NOI18N
        botonsocio.setText("Socio");
        botonsocio.setColorHover(new java.awt.Color(255, 255, 255));
        botonsocio.setColorText(new java.awt.Color(0, 30, 100));
        botonsocio.setColorTextHover(new java.awt.Color(0, 30, 100));
        botonsocio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonsocio.setIconTextGap(20);
        botonsocio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        botonsocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonsocioMouseClicked(evt);
            }
        });

        botoncliente.setBackground(new java.awt.Color(0, 30, 100));
        botoncliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        botoncliente.setText("Cliente");
        botoncliente.setColorHover(new java.awt.Color(204, 204, 255));
        botoncliente.setColorTextHover(new java.awt.Color(0, 30, 100));
        botoncliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoncliente.setIconTextGap(20);
        botoncliente.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        botoncliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonclienteMouseClicked(evt);
            }
        });

        botoncolaborador.setBackground(new java.awt.Color(0, 30, 100));
        botoncolaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dere.png"))); // NOI18N
        botoncolaborador.setText("Colaborador");
        botoncolaborador.setColorHover(new java.awt.Color(204, 204, 255));
        botoncolaborador.setColorTextHover(new java.awt.Color(0, 30, 100));
        botoncolaborador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoncolaborador.setIconTextGap(20);
        botoncolaborador.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        botoncolaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botoncolaboradorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneldelreporteLayout = new javax.swing.GroupLayout(paneldelreporte);
        paneldelreporte.setLayout(paneldelreporteLayout);
        paneldelreporteLayout.setHorizontalGroup(
            paneldelreporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonsocio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(botoncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(botoncolaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        paneldelreporteLayout.setVerticalGroup(
            paneldelreporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldelreporteLayout.createSequentialGroup()
                .addComponent(botonsocio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botoncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(botoncolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        reportes.setOpaque(false);

        reportesocio.setBackground(new java.awt.Color(255, 255, 255));
        reportesocio.setName("reportesocio"); // NOI18N
        reportesocio.setOpaque(false);

        jPanelRound20.setColorSecundario(new java.awt.Color(255, 255, 255));

        inforeporte.setBackground(new java.awt.Color(255, 255, 255));
        inforeporte.setOpaque(false);

        nombrereporte.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        nombrereporte.setText("Nombre");
        nombrereporte.setFocusable(false);

        inicialesreporte.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        inicialesreporte.setText("Iniciales");
        inicialesreporte.setFocusable(false);

        javax.swing.GroupLayout inforeporteLayout = new javax.swing.GroupLayout(inforeporte);
        inforeporte.setLayout(inforeporteLayout);
        inforeporteLayout.setHorizontalGroup(
            inforeporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombrereporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inicialesreporte, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        inforeporteLayout.setVerticalGroup(
            inforeporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inforeporteLayout.createSequentialGroup()
                .addComponent(nombrereporte)
                .addGap(15, 15, 15)
                .addComponent(inicialesreporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nombres.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        nombres.setFocusable(false);

        inicialess.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        inicialess.setFocusable(false);

        ids.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        ids.setFocusable(false);

        botonbuscarcliente1.setBackground(new java.awt.Color(255, 255, 255));
        botonbuscarcliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        botonbuscarcliente1.setColorHover(new java.awt.Color(204, 204, 204));
        botonbuscarcliente1.setDisabledIcon(null);
        botonbuscarcliente1.setDisabledSelectedIcon(null);
        botonbuscarcliente1.setFocusPainted(false);
        botonbuscarcliente1.setFocusable(false);
        botonbuscarcliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonbuscarcliente1MouseClicked(evt);
            }
        });

        inforeporte1.setBackground(new java.awt.Color(255, 255, 255));
        inforeporte1.setOpaque(false);

        nombrereporte1.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        nombrereporte1.setText("Activo");
        nombrereporte1.setFocusable(false);

        idreporte.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        idreporte.setText("ID");
        idreporte.setFocusable(false);

        javax.swing.GroupLayout inforeporte1Layout = new javax.swing.GroupLayout(inforeporte1);
        inforeporte1.setLayout(inforeporte1Layout);
        inforeporte1Layout.setHorizontalGroup(
            inforeporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombrereporte1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addComponent(idreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inforeporte1Layout.setVerticalGroup(
            inforeporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inforeporte1Layout.createSequentialGroup()
                .addComponent(nombrereporte1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idreporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        activos.setFont(new java.awt.Font("Open Sans Semibold", 0, 16)); // NOI18N
        activos.setFocusable(false);

        imagensocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/person_3_icon-icons.com_68899.png"))); // NOI18N
        imagensocio.setFocusable(false);

        buscarsocio.setForeground(new java.awt.Color(255, 255, 255));
        buscarsocio.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarsocio.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarsocio.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarsocio.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarsocio.setColorTransparente(true);
        buscarsocio.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        buscarsocio.setModoMaterial(true);
        buscarsocio.setNextFocusableComponent(tablasocio);
        buscarsocio.setPlaceholder("Buscar socio...");
        buscarsocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarsocioKeyReleased(evt);
            }
        });

        tablasocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Iniciales", "Nombre", "Activo"
            }
        ));
        tablasocio.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablasocio.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablasocio.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablasocio.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablasocio.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablasocio.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablasocio.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablasocio.setDragEnabled(true);
        tablasocio.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablasocio.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));
        tablasocio.setNextFocusableComponent(buscarreportes);
        tablasocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasocioMouseClicked(evt);
            }
        });
        tablareporte.setViewportView(tablasocio);

        javax.swing.GroupLayout jPanelRound20Layout = new javax.swing.GroupLayout(jPanelRound20);
        jPanelRound20.setLayout(jPanelRound20Layout);
        jPanelRound20Layout.setHorizontalGroup(
            jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tablareporte)
                    .addGroup(jPanelRound20Layout.createSequentialGroup()
                        .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound20Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(inforeporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inicialess, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(inforeporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ids, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(activos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
                            .addGroup(jPanelRound20Layout.createSequentialGroup()
                                .addComponent(buscarsocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonbuscarcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(imagensocio)))
                .addContainerGap())
        );
        jPanelRound20Layout.setVerticalGroup(
            jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound20Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound20Layout.createSequentialGroup()
                            .addComponent(activos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ids, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(inforeporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRound20Layout.createSequentialGroup()
                        .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inforeporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRound20Layout.createSequentialGroup()
                                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inicialess, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarsocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonbuscarcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imagensocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablareporte, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout reportesocioLayout = new javax.swing.GroupLayout(reportesocio);
        reportesocio.setLayout(reportesocioLayout);
        reportesocioLayout.setHorizontalGroup(
            reportesocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reportesocioLayout.setVerticalGroup(
            reportesocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reportes.add(reportesocio, "card2");

        reporteclientes.setBackground(new java.awt.Color(255, 255, 255));
        reporteclientes.setName("reportecliente"); // NOI18N
        reporteclientes.setOpaque(false);

        jPanelRound22.setColorSecundario(new java.awt.Color(255, 255, 255));

        infopanelc3.setBackground(new java.awt.Color(255, 255, 255));
        infopanelc3.setOpaque(false);

        textoparapanelsocio6.setBackground(new java.awt.Color(255, 255, 255));
        textoparapanelsocio6.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        textoparapanelsocio6.setText("Nombre");
        textoparapanelsocio6.setFocusable(false);

        textoparapanelsocio7.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        textoparapanelsocio7.setText("ID");
        textoparapanelsocio7.setFocusable(false);

        javax.swing.GroupLayout infopanelc3Layout = new javax.swing.GroupLayout(infopanelc3);
        infopanelc3.setLayout(infopanelc3Layout);
        infopanelc3Layout.setHorizontalGroup(
            infopanelc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc3Layout.createSequentialGroup()
                .addGroup(infopanelc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoparapanelsocio7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoparapanelsocio6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infopanelc3Layout.setVerticalGroup(
            infopanelc3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc3Layout.createSequentialGroup()
                .addComponent(textoparapanelsocio6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoparapanelsocio7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infopanelc3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0,0,0)));

        infopanelc2.setBackground(new java.awt.Color(255, 255, 255));
        infopanelc2.setOpaque(false);
        infopanelc2.setPreferredSize(new java.awt.Dimension(80, 105));

        textoparapanelsocio14.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        textoparapanelsocio14.setText("Fecha de ingreso");
        textoparapanelsocio14.setFocusable(false);

        textoparapanelsocio8.setFont(new java.awt.Font("Open Sans Semibold", 1, 20)); // NOI18N
        textoparapanelsocio8.setText("Activo");
        textoparapanelsocio8.setFocusable(false);

        javax.swing.GroupLayout infopanelc2Layout = new javax.swing.GroupLayout(infopanelc2);
        infopanelc2.setLayout(infopanelc2Layout);
        infopanelc2Layout.setHorizontalGroup(
            infopanelc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc2Layout.createSequentialGroup()
                .addGroup(infopanelc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoparapanelsocio14)
                    .addComponent(textoparapanelsocio8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infopanelc2Layout.setVerticalGroup(
            infopanelc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc2Layout.createSequentialGroup()
                .addComponent(textoparapanelsocio14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoparapanelsocio8)
                .addContainerGap())
        );

        infopanelc2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0,0,0)));

        nombrescl.setFont(new java.awt.Font("Open Sans Semibold", 1, 16)); // NOI18N
        nombrescl.setFocusable(false);

        activocl.setFont(new java.awt.Font("Open Sans Semibold", 1, 16)); // NOI18N
        activocl.setFocusable(false);

        socioimageninfo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/cliente.png"))); // NOI18N
        socioimageninfo2.setFocusable(false);

        idcl.setFont(new java.awt.Font("Open Sans Semibold", 1, 16)); // NOI18N
        idcl.setFocusable(false);

        ficl.setFont(new java.awt.Font("Open Sans Semibold", 1, 16)); // NOI18N
        ficl.setFocusable(false);

        buscarcliente.setBackground(new java.awt.Color(0, 0, 0));
        buscarcliente.setForeground(new java.awt.Color(255, 255, 255));
        buscarcliente.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarcliente.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarcliente.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarcliente.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarcliente.setColorTransparente(true);
        buscarcliente.setModoMaterial(true);
        buscarcliente.setNextFocusableComponent(tablacliente);
        buscarcliente.setPlaceholder("Buscar cliente...");
        buscarcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarclienteKeyReleased(evt);
            }
        });

        botonbuscarcliente.setBackground(new java.awt.Color(255, 255, 255));
        botonbuscarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        botonbuscarcliente.setColorHover(new java.awt.Color(204, 204, 204));
        botonbuscarcliente.setFocusPainted(false);
        botonbuscarcliente.setFocusable(false);

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Fecha  de ingreso", "Activo"
            }
        ));
        tablacliente.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablacliente.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablacliente.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablacliente.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablacliente.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablacliente.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablacliente.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablacliente.setDragEnabled(true);
        tablacliente.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablacliente.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));
        tablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclienteMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tablacliente);

        javax.swing.GroupLayout jPanelRound22Layout = new javax.swing.GroupLayout(jPanelRound22);
        jPanelRound22.setLayout(jPanelRound22Layout);
        jPanelRound22Layout.setHorizontalGroup(
            jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRound22Layout.createSequentialGroup()
                        .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound22Layout.createSequentialGroup()
                                .addComponent(buscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRound22Layout.createSequentialGroup()
                                .addComponent(infopanelc3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombrescl, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                                    .addComponent(idcl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infopanelc2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ficl, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(activocl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(socioimageninfo2))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanelRound22Layout.setVerticalGroup(
            jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound22Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelRound22Layout.createSequentialGroup()
                        .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound22Layout.createSequentialGroup()
                                .addComponent(ficl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(activocl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(infopanelc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound22Layout.createSequentialGroup()
                                    .addComponent(nombrescl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idcl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(infopanelc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(socioimageninfo2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout reporteclientesLayout = new javax.swing.GroupLayout(reporteclientes);
        reporteclientes.setLayout(reporteclientesLayout);
        reporteclientesLayout.setHorizontalGroup(
            reporteclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        reporteclientesLayout.setVerticalGroup(
            reporteclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reportes.add(reporteclientes, "card3");

        reportecolaborador.setBackground(new java.awt.Color(255, 255, 255));
        reportecolaborador.setName("reportecolaborador"); // NOI18N
        reportecolaborador.setOpaque(false);

        jPanelRound21.setColorSecundario(new java.awt.Color(255, 255, 255));

        socioimageninfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/colaborador.png"))); // NOI18N
        socioimageninfo1.setFocusable(false);

        infopanelc.setBackground(new java.awt.Color(255, 255, 255));
        infopanelc.setOpaque(false);

        textoparapanelsocio3.setBackground(new java.awt.Color(255, 255, 255));
        textoparapanelsocio3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textoparapanelsocio3.setText("Nombre");
        textoparapanelsocio3.setFocusable(false);

        textoparapanelsocio4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textoparapanelsocio4.setText("Nivel");
        textoparapanelsocio4.setFocusable(false);

        textoparapanelsocio5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textoparapanelsocio5.setText("ID");
        textoparapanelsocio5.setFocusable(false);

        javax.swing.GroupLayout infopanelcLayout = new javax.swing.GroupLayout(infopanelc);
        infopanelc.setLayout(infopanelcLayout);
        infopanelcLayout.setHorizontalGroup(
            infopanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoparapanelsocio5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textoparapanelsocio4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textoparapanelsocio3)
        );
        infopanelcLayout.setVerticalGroup(
            infopanelcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelcLayout.createSequentialGroup()
                .addComponent(textoparapanelsocio3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoparapanelsocio4)
                .addGap(11, 11, 11)
                .addComponent(textoparapanelsocio5)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        infopanelc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0,0,0)));

        nombresc.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        nombresc.setFocusable(false);

        idc.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        idc.setFocusable(false);

        infopanelc1.setBackground(new java.awt.Color(255, 255, 255));
        infopanelc1.setOpaque(false);
        infopanelc1.setPreferredSize(new java.awt.Dimension(80, 105));

        textoparapanelsocio12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textoparapanelsocio12.setText("Activo");
        textoparapanelsocio12.setFocusable(false);

        textoparapanelsocio13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textoparapanelsocio13.setText("Socio");
        textoparapanelsocio13.setFocusable(false);

        javax.swing.GroupLayout infopanelc1Layout = new javax.swing.GroupLayout(infopanelc1);
        infopanelc1.setLayout(infopanelc1Layout);
        infopanelc1Layout.setHorizontalGroup(
            infopanelc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc1Layout.createSequentialGroup()
                .addGroup(infopanelc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoparapanelsocio12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoparapanelsocio13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        infopanelc1Layout.setVerticalGroup(
            infopanelc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelc1Layout.createSequentialGroup()
                .addComponent(textoparapanelsocio12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoparapanelsocio13)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        infopanelc1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0,0,0)));

        socioc.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        socioc.setFocusable(false);

        nivelc.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        nivelc.setFocusable(false);

        activoc.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        activoc.setFocusable(false);

        buscarcolaborador.setForeground(new java.awt.Color(255, 255, 255));
        buscarcolaborador.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        buscarcolaborador.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        buscarcolaborador.setBotonColor(new java.awt.Color(0, 0, 0));
        buscarcolaborador.setCaretColor(new java.awt.Color(255, 255, 255));
        buscarcolaborador.setColorTransparente(true);
        buscarcolaborador.setModoMaterial(true);
        buscarcolaborador.setNextFocusableComponent(tablacolaborador);
        buscarcolaborador.setPlaceholder("Buscar colaborador...");
        buscarcolaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarcolaboradorKeyReleased(evt);
            }
        });

        rSButtonRiple11.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonRiple11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busqueda.png"))); // NOI18N
        rSButtonRiple11.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonRiple11.setFocusPainted(false);
        rSButtonRiple11.setFocusable(false);

        tablacolaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Activo", "Nivel", "Socio"
            }
        ));
        tablacolaborador.setColorBackgoundHead(new java.awt.Color(214, 214, 214));
        tablacolaborador.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablacolaborador.setColorBordeHead(new java.awt.Color(214, 214, 214));
        tablacolaborador.setColorFilasBackgound2(new java.awt.Color(234, 234, 234));
        tablacolaborador.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablacolaborador.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablacolaborador.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablacolaborador.setDragEnabled(true);
        tablacolaborador.setFont(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteFilas(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteFilasSelect(new java.awt.Font("Open Sans Semibold",1,12));
        tablacolaborador.setFuenteHead(new java.awt.Font("Open Sans Semibold",1,18));
        tablacolaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacolaboradorMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tablacolaborador);

        javax.swing.GroupLayout jPanelRound21Layout = new javax.swing.GroupLayout(jPanelRound21);
        jPanelRound21.setLayout(jPanelRound21Layout);
        jPanelRound21Layout.setHorizontalGroup(
            jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22)
                    .addGroup(jPanelRound21Layout.createSequentialGroup()
                        .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound21Layout.createSequentialGroup()
                                .addComponent(infopanelc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nivelc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombresc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(infopanelc1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(socioc, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                    .addComponent(activoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelRound21Layout.createSequentialGroup()
                                .addComponent(buscarcolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rSButtonRiple11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(socioimageninfo1)))
                .addContainerGap())
        );
        jPanelRound21Layout.setVerticalGroup(
            jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound21Layout.createSequentialGroup()
                .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRound21Layout.createSequentialGroup()
                                .addComponent(activoc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(socioc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(infopanelc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRound21Layout.createSequentialGroup()
                                    .addComponent(nombresc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nivelc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(idc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(infopanelc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarcolaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonRiple11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(socioimageninfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout reportecolaboradorLayout = new javax.swing.GroupLayout(reportecolaborador);
        reportecolaborador.setLayout(reportecolaboradorLayout);
        reportecolaboradorLayout.setHorizontalGroup(
            reportecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reportecolaboradorLayout.setVerticalGroup(
            reportecolaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reportes.add(reportecolaborador, "card4");

        fechasreporte.setBackground(new java.awt.Color(255, 255, 255));
        fechasreporte.setOpaque(false);

        diasocio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" }));
        diasocio1.setColorArrow(new java.awt.Color(0, 30, 100));
        diasocio1.setColorBorde(new java.awt.Color(0, 30, 130));
        diasocio1.setColorFondo(new java.awt.Color(0, 30, 100));
        diasocio1.setNextFocusableComponent(messocio1);

        anosocio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081" }));
        anosocio1.setColorArrow(new java.awt.Color(0, 30, 100));
        anosocio1.setColorBorde(new java.awt.Color(0, 30, 130));
        anosocio1.setColorFondo(new java.awt.Color(0, 30, 100));
        anosocio1.setNextFocusableComponent(diasocio);

        fechainiciotexto.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        fechainiciotexto.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto.setText("De");
        fechainiciotexto.setFocusable(false);

        messocio.setBackground(new java.awt.Color(0, 30, 100));
        messocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        messocio.setColorArrow(new java.awt.Color(0, 30, 100));
        messocio.setColorBorde(new java.awt.Color(0, 30, 130));
        messocio.setColorFondo(new java.awt.Color(0, 30, 100));
        messocio.setFocusCycleRoot(true);
        messocio.setFocusTraversalPolicyProvider(true);
        messocio.setNextFocusableComponent(anosocio);
        messocio.setOpaque(false);

        messocio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        messocio1.setColorArrow(new java.awt.Color(0, 30, 100));
        messocio1.setColorBorde(new java.awt.Color(0, 30, 130));
        messocio1.setColorFondo(new java.awt.Color(0, 30, 100));
        messocio1.setNextFocusableComponent(anosocio1);

        fechainiciotexto1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        fechainiciotexto1.setForeground(new java.awt.Color(255, 255, 255));
        fechainiciotexto1.setText("a ");
        fechainiciotexto1.setFocusable(false);

        diasocio.setBackground(new java.awt.Color(0, 30, 100));
        diasocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "29", "30", "31" }));
        diasocio.setColorArrow(new java.awt.Color(0, 30, 100));
        diasocio.setColorBorde(new java.awt.Color(0, 30, 130));
        diasocio.setColorFondo(new java.awt.Color(0, 30, 100));
        diasocio.setFocusCycleRoot(true);
        diasocio.setFocusTraversalPolicyProvider(true);
        diasocio.setNextFocusableComponent(messocio);
        diasocio.setOpaque(false);

        buscarreportes.setBackground(new java.awt.Color(255, 69, 0));
        buscarreportes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        buscarreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_menu/visibilidad.png"))); // NOI18N
        buscarreportes.setFocusCycleRoot(true);
        buscarreportes.setEnabled(false);
        buscarreportes.setVisible(false);
        buscarreportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarreportesMouseClicked(evt);
            }
        });

        anosocio.setBackground(new java.awt.Color(0, 30, 100));
        anosocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081" }));
        anosocio.setColorArrow(new java.awt.Color(0, 30, 100));
        anosocio.setColorBorde(new java.awt.Color(0, 30, 130));
        anosocio.setColorFondo(new java.awt.Color(0, 30, 100));
        anosocio.setFocusCycleRoot(true);
        anosocio.setFocusTraversalPolicyProvider(true);
        anosocio.setNextFocusableComponent(diasocio1);
        anosocio.setOpaque(false);

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(255, 0, 0));
        labelfecha.setText("¡Fecha invalida! ");
        labelfecha.setFocusable(false);
        labelfecha.setVisible(false);

        javax.swing.GroupLayout jPanelRound12Layout = new javax.swing.GroupLayout(jPanelRound12);
        jPanelRound12.setLayout(jPanelRound12Layout);
        jPanelRound12Layout.setHorizontalGroup(
            jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(fechainiciotexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diasocio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(messocio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(anosocio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechainiciotexto1)
                .addGap(18, 18, 18)
                .addComponent(diasocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(messocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(anosocio1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelfecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanelRound12Layout.setVerticalGroup(
            jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound12Layout.createSequentialGroup()
                .addGroup(jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound12Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelfecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buscarreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(diasocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(messocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anosocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diasocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(messocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anosocio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fechainiciotexto, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fechainiciotexto1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout fechasreporteLayout = new javax.swing.GroupLayout(fechasreporte);
        fechasreporte.setLayout(fechasreporteLayout);
        fechasreporteLayout.setHorizontalGroup(
            fechasreporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fechasreporteLayout.setVerticalGroup(
            fechasreporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fechasreporteLayout.createSequentialGroup()
                .addComponent(jPanelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout reportemenuLayout = new javax.swing.GroupLayout(reportemenu);
        reportemenu.setLayout(reportemenuLayout);
        reportemenuLayout.setHorizontalGroup(
            reportemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportemenuLayout.createSequentialGroup()
                .addComponent(paneldelreporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reportemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechasreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        reportemenuLayout.setVerticalGroup(
            reportemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneldelreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(reportemenuLayout.createSequentialGroup()
                .addComponent(fechasreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(reportemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(reportemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonsocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonsocioMouseClicked
        // TODO add your handling code here:}
        RSButton menu[] = {botoncliente,botoncolaborador};
        cambiarcolorreporte(botonsocio,menu);
        reportes.setPanelSlider(20, reportesocio, RSPanelsSlider.DIRECT.RIGHT);
        limpiarsocio();
    }//GEN-LAST:event_botonsocioMouseClicked

    private void botonclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonclienteMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {botoncolaborador,botonsocio};
        cambiarcolorreporte(botoncliente,menu);
        reportes.setPanelSlider(20, reporteclientes, RSPanelsSlider.DIRECT.RIGHT);
        limpiarcliente();
    }//GEN-LAST:event_botonclienteMouseClicked

    private void botoncolaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botoncolaboradorMouseClicked
        // TODO add your handling code here:
        RSButton menu[] = {botonsocio,botoncliente};
        cambiarcolorreporte(botoncolaborador,menu);
        reportes.setPanelSlider(20, reportecolaborador, RSPanelsSlider.DIRECT.RIGHT);
        limpiarcolaborador();
    }//GEN-LAST:event_botoncolaboradorMouseClicked

    private void botonbuscarcliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonbuscarcliente1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botonbuscarcliente1MouseClicked

    private void buscarsocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarsocioKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablasocio.setModel(dentro.buscarjefetabla4(buscarsocio.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarsocioKeyReleased

    private void tablasocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasocioMouseClicked
        // TODO add your handling code here:
        nombres.setText(tablasocio.getValueAt(tablasocio.getSelectedRow(),2).toString());
        inicialess.setText(tablasocio.getValueAt(tablasocio.getSelectedRow(),1).toString());
        ids.setText(tablasocio.getValueAt(tablasocio.getSelectedRow(),0).toString());
        activos.setText(tablasocio.getValueAt(tablasocio.getSelectedRow(),3).toString());
        buscarreportes.setVisible(true);
        buscarreportes.enable();
    }//GEN-LAST:event_tablasocioMouseClicked

    private void buscarclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarclienteKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablacliente.setModel(dentro.buscarempresa3(buscarcliente.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarclienteKeyReleased

    private void tablaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclienteMouseClicked
        // TODO add your handling code here:
        nombrescl.setText(tablacliente.getValueAt(tablacliente.getSelectedRow(),1).toString());
        idcl.setText(tablacliente.getValueAt(tablacliente.getSelectedRow(), 0).toString());
        activocl.setText(tablacliente.getValueAt(tablacliente.getSelectedRow(), 3).toString());
        ficl.setText(tablacliente.getValueAt(tablacliente.getSelectedRow(), 2).toString());
        buscarreportes.setVisible(true);
        buscarreportes.enable();
    }//GEN-LAST:event_tablaclienteMouseClicked

    private void buscarcolaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarcolaboradorKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablacolaborador.setModel(dentro.buscarempleadotabla3(buscarcolaborador.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarcolaboradorKeyReleased

    private void tablacolaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacolaboradorMouseClicked
        // TODO add your handling code here:
        nombresc.setText(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(),1).toString());
        nivelc.setText(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(),3).toString());
        idc.setText(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(),0).toString());
        activoc.setText(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(),2).toString());
        socioc.setText(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(),4).toString());
        buscarreportes.setVisible(true);
        buscarreportes.enable();
    }//GEN-LAST:event_tablacolaboradorMouseClicked

    private void buscarreportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarreportesMouseClicked
        // TODO add your handling code here:
        if(diasocio.getSelectedIndex()>0 && diasocio1.getSelectedIndex()>0 && messocio.getSelectedIndex()>0 && messocio1.getSelectedIndex()>0
            && anosocio.getSelectedIndex()>0 && anosocio1.getSelectedIndex()>0 )
        {
            boolean revisarfecha = verificafecha(diasocio.getSelectedIndex(),diasocio1.getSelectedIndex(),
                messocio.getSelectedIndex(),messocio1.getSelectedIndex(),
                anosocio.getSelectedIndex(),anosocio1.getSelectedIndex());
            String dia= "";
            String mes= "";
            String f1="";
            String f2="";
            String f3="";
            String f4="";
            if(revisarfecha == true)
            {
                if(diasocio.getSelectedIndex()<10){
                    dia="0"+diasocio.getSelectedItem().toString();
                }else{
                    dia=diasocio.getSelectedItem().toString();
                }
                if(messocio.getSelectedIndex()<10){
                    mes="0"+Integer.toString(messocio.getSelectedIndex());
                }else{
                    mes=Integer.toString(messocio.getSelectedIndex());
                }
                f3=dia+"-"+mes+"-"+anosocio.getSelectedItem().toString();
                f1=anosocio.getSelectedItem().toString()+"-"+mes+"-"+dia;
                String dia1= "";
                String mes1= "";
                if(diasocio1.getSelectedIndex()<10){
                    dia1="0"+diasocio1.getSelectedItem().toString();
                }else{
                    dia1=diasocio1.getSelectedItem().toString();
                }
                if(messocio1.getSelectedIndex()<10){
                    mes1="0"+Integer.toString(messocio1.getSelectedIndex());
                }else{
                    mes1=Integer.toString(messocio1.getSelectedIndex());
                }
                f4=dia1+"-"+mes1+"-"+anosocio1.getSelectedItem().toString();
                f2=anosocio1.getSelectedItem().toString()+"-"+mes1+"-"+dia1;
                
                String periodo= f3 + " a " + f4;
                String periodo2 = f1 + " a " + f2;
                //Vista de socio
                if(reportesocio.isShowing()==true)
                {
                    vistasocio vista1 = new vistasocio(nombres.getText(),ids.getText(),periodo);
                    String idjefe = tablasocio.getValueAt(tablasocio.getSelectedRow(), 0).toString();
                    idjefe = tablasocio.getValueAt(tablasocio.getSelectedRow(), 0).toString();
                    //Inicio desarrollo de tablas.
                    try {
                        DefaultTableModel columnaempresa = dentro.empleadoreporteexcel(idjefe, f1, f2);
                        String [][] columnaempresa1 = new String [columnaempresa.getRowCount()][columnaempresa.getColumnCount()];
                        for (int f = 0; f < columnaempresa.getRowCount(); f++) {
                            for (int c = 0; c < columnaempresa.getColumnCount(); c++) {
                                columnaempresa1[f][c]= columnaempresa.getValueAt(f, c).toString();
                            }
                        }
                        try {
                            DefaultTableModel renglonempresa = dentro.empresareporteexcel(idjefe, f1, f2);
                            String [][] renglonempresa1 = new String [renglonempresa.getRowCount()][renglonempresa.getColumnCount()];
                            for (int f = 0; f < renglonempresa.getRowCount(); f++)
                            {
                                for (int c = 0; c < renglonempresa.getColumnCount(); c++)
                                {
                                    renglonempresa1[f][c]= renglonempresa.getValueAt(f, c).toString();
                                }
                            }
                            DefaultTableModel renglonhnc =dentro.hncreporteexcel(idjefe, f1, f2);
                            String [][] renglonhnc1 = new String [renglonhnc.getRowCount()][renglonhnc.getColumnCount()];
                            for (int f = 0; f < renglonhnc.getRowCount(); f++)
                            {
                                for (int c = 0; c < renglonhnc.getColumnCount(); c++)
                                {
                                    renglonhnc1[f][c]= renglonhnc.getValueAt(f, c).toString();
                                }
                            }
                            String [][] matriz= new String [renglonempresa.getRowCount()+2][columnaempresa.getRowCount()+3];
                            String [][] matriz2= new String [renglonhnc.getRowCount()+2][columnaempresa.getRowCount()+3];
                            for(int i=0;i<renglonempresa.getRowCount()+2;i++){
                                for(int j=0;j<columnaempresa.getRowCount()+3;j++)
                                {
                                    if(j==0 && i>0 && i<renglonempresa.getRowCount()+1){
                                        //llena empresas
                                        matriz[i][j]= renglonempresa1[i-1][0];
                                    }
                                    if(j==1 && i>0 && i<renglonempresa.getRowCount()+1){
                                        //llenar servicio
                                        matriz[i][j]=renglonempresa1[i-1][1];
                                    }
                                    if(j>1 && i==0 && j<columnaempresa.getRowCount()+2){
                                        //llena nombres columnas
                                        matriz[0][j]= columnaempresa1[j-2][0];
                                    }
                                    if(j>1 && i>0 && i<renglonempresa.getRowCount()+1 &&j<columnaempresa.getRowCount()+2){
                                        matriz[i][j]=dentro.htempleado(idjefe, columnaempresa1[j-2][1],renglonempresa1[i-1][2], f1, f2);
                                    }
                                    if(i==renglonempresa.getRowCount()+1 && j>1 &&j<columnaempresa.getRowCount()+2){
                                        matriz[i][1]="Total";
                                        matriz[i][j]=Integer.toString(dentro.horastotalcargable(columnaempresa1[j-2][1], f1, f2));
                                    }
                                    if(j==columnaempresa.getRowCount()+2 && i>0 && i<renglonempresa.getRowCount()+1 ){
                                        matriz[0][j]="Total";
                                        matriz[i][j]=dentro.sumatrabajado(renglonempresa1[i-1][2], idjefe, f1, f2);
                                    }
                                }
                            }
                            for(int i=0;i<renglonhnc.getRowCount()+2;i++){
                                for(int j=0;j<columnaempresa.getRowCount()+2;j++){
                                    if(j==0 && i>0 && i<renglonhnc.getRowCount()+1){
                                        matriz2[i][j]= renglonhnc1[i-1][0];
                                    }
                                    if(j>0 && i==0 &&j<columnaempresa.getRowCount()+1){
                                        matriz2[0][j]= columnaempresa1[j-1][0];
                                    }
                                    if(j>0 && i>0 && i<renglonhnc.getRowCount()+1 && j<columnaempresa.getRowCount()+1){
                                        matriz2[i][j]=dentro.hthnc(idjefe, columnaempresa1[j-1][1],renglonhnc1[i-1][1], f1, f2);
                                    }
                                    if(i==renglonhnc.getRowCount()+1 && j>0 &&j<columnaempresa.getRowCount()+1){
                                        matriz2[i][0]="Total";
                                        matriz2[i][j]=Integer.toString(dentro.horastotalnocargable(columnaempresa1[j-1][1], f1, f2));
                                    }
                                    if(j==columnaempresa.getRowCount()+1 && i>0 &&i<renglonhnc.getRowCount()+1 ){
                                        matriz2[0][j]="Total";//la que necesito
                                        matriz2[i][j]=dentro.sumanotrabajado(renglonhnc1[i-1][1], idjefe, f1, f2);
                                    }
                                }
                            }
                            DefaultTableModel info= new DefaultTableModel();
                            DefaultTableModel info2= new DefaultTableModel();
                            matriz[0][0]="Empresa";
                            matriz[0][1]="Servicio/Empleado";
                            matriz2[0][0]="Hora NO cargable/Empleado";

                            int suma=0;
                            for(int i=1;i<renglonempresa.getRowCount()+1;i++){
                                suma+=Integer.parseInt(matriz[i][columnaempresa.getRowCount()+2]);
                            }
                            matriz[renglonempresa.getRowCount()+1][columnaempresa.getRowCount()+2]=Integer.toString(suma);
                            suma=0;
                            for(int i=1;i<renglonhnc.getRowCount()+1;i++){
                                suma+=Integer.parseInt(matriz2[i][columnaempresa.getRowCount()+1]);
                            }
                            matriz2[renglonhnc.getRowCount()+1][columnaempresa.getRowCount()+1]=Integer.toString(suma);
                            for(int j=0;j<columnaempresa.getRowCount()+3;j++){
                                info.addColumn(matriz[0][j]);
                            }
                            for(int i=1;i<renglonempresa.getRowCount()+2;i++){
                                info.addRow(matriz[i]);
                            }
                            for(int j=0;j<columnaempresa.getRowCount()+2;j++){
                                info2.addColumn(matriz2[0][j]);
                            }
                            for(int i=1;i<renglonhnc.getRowCount()+2;i++){
                                info2.addRow(matriz2[i]);
                            }
                            vista1.llenar(info, info2, periodo,nombres.getText());
                            vista1.setLocationRelativeTo(null);
                            vista1.setVisible(true);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } //Inicio de la vista de colaborador
                if(reportecolaborador.isShowing() == true)
                {
                    if(diasocio.getSelectedIndex()>0 && diasocio1.getSelectedIndex()>0 && messocio.getSelectedIndex()>0 && messocio1.getSelectedIndex()>0
                        && anosocio.getSelectedIndex()>0 && anosocio1.getSelectedIndex()>0 )
                    {
                        DefaultTableModel info;
                        DefaultTableModel info2;
                        periodocolaborador.setText(f3+" a "+f4);
                        periodosociodentro.setText(f1+" a "+f2);
                        try {
                            info=dentro.vitaempleadoanual(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(), 0).toString(), f1, f2);                       
                            info2=dentro.vitaempleadoanualhnc(tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(), 0).toString(), f1, f2);
                            vistacolaborador vista3 = new vistacolaborador(nombresc.getText(),idc.getText(),periodo,periodo2);
                            vista3.llenar(info, info2, periodo, nombresc.getText());
                            vista3.setLocationRelativeTo(null);
                            vista3.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if(reporteclientes.isShowing() == true)
                {
                    vistacliente vista2 = new vistacliente(nombrescl.getText(),idcl.getText(),periodo);
                    if(diasocio.getSelectedIndex()>0 && diasocio1.getSelectedIndex()>0 && messocio.getSelectedIndex()>0 && messocio1.getSelectedIndex()>0
                        && anosocio.getSelectedIndex()>0 && anosocio1.getSelectedIndex()>0 )
                    {                      
                        try {
                            DefaultTableModel info;
                            info=dentro.vistaanualempresa(idcl.getText(),f1,f2);
                            vista2.llenar(info, periodo, nombrescl.getText());
                            vista2.setLocationRelativeTo(null);
                            vista2.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
            }else
            {
                labelfecha.setVisible(true);
            }
        }else
        {
            labelfecha.setVisible(true);
        }
    }//GEN-LAST:event_buscarreportesMouseClicked

    private void rSButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton5MouseClicked
        // TODO add your handling code here:
        tablascolaborador.siguiente(RSPanelsSlider.DIRECT.LEFT);
        if(bandera1 == true)
        {
            hccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(255,69,0)));
            hnccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,69,0)));
            bandera1 = false;
        }else
        {
            hccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,69,0)));
            hnccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(255,69,0)));
            bandera1 = true;
        }
    }//GEN-LAST:event_rSButton5MouseClicked

    private void rSButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButton7MouseClicked
        // TODO add your handling code here:
        tablascolaborador.siguiente(RSPanelsSlider.DIRECT.RIGHT);
        if(bandera1 == true)
        {
            hccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(255,69,0)));
            hnccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,69,0)));
            bandera1 = false;
        }else
        {
            hccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,69,0)));
            hnccolaborador.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(255,69,0)));
            bandera1 = true;
        }
    }//GEN-LAST:event_rSButton7MouseClicked

    private void crearexcelcolaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearexcelcolaboradorMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Excel uno = new Excel();
            if(uno.exportarExcel(vistatablacolaborador,vistatablacolaboradorhnc,vistacolaborador,nombresc.getText(),periodocolaborador.getText(),
                tablacolaborador.getValueAt(tablacolaborador.getSelectedRow(), 0).toString(),periodosociodentro.getText())){
            int mj= JOptionPane.OK_OPTION;
            JOptionPane.showMessageDialog(this,"Archivo creado","", mj);
        }
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_crearexcelcolaboradorMouseClicked

    private void minimizar_principal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar_principal2MouseClicked
        // TODO add your handling code here:
        vistacolaborador.setState(vistacolaborador.ICONIFIED);
    }//GEN-LAST:event_minimizar_principal2MouseClicked

    private void cerrar_principal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrar_principal2MouseClicked
        // TODO add your handling code here:
        int mj= JOptionPane.YES_NO_OPTION;
        int message= JOptionPane.showConfirmDialog(vistacolaborador, "¿Está seguro que desea salir?", "Salir", mj);
        if(message==0){
            vistacolaborador.dispose();
        }
    }//GEN-LAST:event_cerrar_principal2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activoc;
    private javax.swing.JLabel activocl;
    private javax.swing.JLabel activos;
    private rojerusan.RSComboMetro anosocio;
    private rojerusan.RSComboMetro anosocio1;
    private rojeru_san.RSButton botonbuscarcliente;
    private rojeru_san.RSButton botonbuscarcliente1;
    private rojeru_san.RSButton botoncliente;
    private rojeru_san.RSButton botoncolaborador;
    private rojeru_san.RSButton botonsocio;
    private rojeru_san.RSMTextFull buscarcliente;
    private rojeru_san.RSMTextFull buscarcolaborador;
    private rojeru_san.RSButtonRiple buscarreportes;
    private rojeru_san.RSMTextFull buscarsocio;
    private rojeru_san.RSButton cerrar_principal2;
    private rojeru_san.RSButtonRiple crearexcelcolaborador;
    private rojerusan.RSComboMetro diasocio;
    private rojerusan.RSComboMetro diasocio1;
    private javax.swing.JLabel fechainiciotexto;
    private javax.swing.JLabel fechainiciotexto1;
    private javax.swing.JPanel fechasreporte;
    private javax.swing.JLabel ficl;
    private javax.swing.JLabel fondosocio1;
    private javax.swing.JPanel hcargables1;
    private javax.swing.JPanel hccolaborador;
    private javax.swing.JPanel hncargables1;
    private javax.swing.JPanel hnccolaborador;
    private javax.swing.JLabel idc;
    private javax.swing.JLabel idcl;
    private javax.swing.JLabel idreporte;
    private javax.swing.JLabel ids;
    private javax.swing.JLabel imagensocio;
    private javax.swing.JPanel infopanelc;
    private javax.swing.JPanel infopanelc1;
    private javax.swing.JPanel infopanelc2;
    private javax.swing.JPanel infopanelc3;
    private javax.swing.JPanel inforeporte;
    private javax.swing.JPanel inforeporte1;
    private javax.swing.JLabel inicialesreporte;
    private javax.swing.JLabel inicialess;
    private zesatic.JPanelRound jPanelRound12;
    private zesatic.JPanelRound jPanelRound20;
    private zesatic.JPanelRound jPanelRound21;
    private zesatic.JPanelRound jPanelRound22;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel labelfecha;
    private zesatic.JPanelRound menudecolaborador;
    private rojerusan.RSComboMetro messocio;
    private rojerusan.RSComboMetro messocio1;
    private rojeru_san.RSButton minimizar_principal2;
    private javax.swing.JLabel nivelc;
    private javax.swing.JLabel nombrereporte;
    private javax.swing.JLabel nombrereporte1;
    private javax.swing.JLabel nombres;
    private javax.swing.JLabel nombresc;
    private javax.swing.JLabel nombrescl;
    private javax.swing.JPanel paneldelreporte;
    private javax.swing.JPanel panelvistacolaborador;
    private javax.swing.JLabel periodocolaborador;
    private javax.swing.JPanel periodocolaboradormenu;
    private javax.swing.JLabel periodosociodentro;
    private rojeru_san.RSButton rSButton5;
    private rojeru_san.RSButton rSButton7;
    private rojeru_san.RSButton rSButtonRiple11;
    private javax.swing.JPanel reporteclientes;
    private javax.swing.JPanel reportecolaborador;
    private javax.swing.JPanel reportemenu;
    private rojeru_san.RSPanelsSlider reportes;
    private javax.swing.JPanel reportesocio;
    private javax.swing.JLabel socioc;
    private javax.swing.JLabel socioimageninfo1;
    private javax.swing.JLabel socioimageninfo2;
    private rojerusan.RSTableMetro tablacliente;
    private rojerusan.RSTableMetro tablacolaborador;
    private javax.swing.JScrollPane tablareporte;
    private rojeru_san.RSPanelsSlider tablascolaborador;
    private rojerusan.RSTableMetro tablasocio;
    private javax.swing.JLabel textoparapanelsocio12;
    private javax.swing.JLabel textoparapanelsocio13;
    private javax.swing.JLabel textoparapanelsocio14;
    private javax.swing.JLabel textoparapanelsocio3;
    private javax.swing.JLabel textoparapanelsocio4;
    private javax.swing.JLabel textoparapanelsocio5;
    private javax.swing.JLabel textoparapanelsocio6;
    private javax.swing.JLabel textoparapanelsocio7;
    private javax.swing.JLabel textoparapanelsocio8;
    private javax.swing.JFrame vistacolaborador;
    private rojerusan.RSTableMetro vistatablacolaborador;
    private rojerusan.RSTableMetro vistatablacolaboradorhnc;
    // End of variables declaration//GEN-END:variables
}
