package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAltaLector;
import interfaces.IControladorModificarEstadoLector;
import interfaces.IControladorMaterial;

public class Principal {
    private JFrame frame;

    private AltaLector agregarLectorInternalFrame;
    private EstadoLectorFrame estadoLectorInternalFrame;
    private AltaDonacionEspecial altaDonacionEspecialInternalFrame;
    private AltaDonacionLibro altaDonacionLibroInternalFrame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal window = new Principal();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        initialize();

        Fabrica fabrica = Fabrica.getInstancia();
        IControladorAltaLector controladorAlta = fabrica.getIControladorAltaLector();
        IControladorModificarEstadoLector controladorModificar = fabrica.getIControladorModificarEstadoLector();
        IControladorMaterial controladorMaterial = fabrica.getIControladorMaterial();

        Dimension desktopSize = frame.getSize();

        agregarLectorInternalFrame = new AltaLector(controladorAlta);
        agregarLectorInternalFrame.setLocation(
                (desktopSize.width - agregarLectorInternalFrame.getSize().width) / 2,
                (desktopSize.height - agregarLectorInternalFrame.getSize().height) / 2
        );
        agregarLectorInternalFrame.setVisible(false);
        frame.getContentPane().add(agregarLectorInternalFrame);

        estadoLectorInternalFrame = new EstadoLectorFrame(controladorModificar);
        estadoLectorInternalFrame.setLocation(
                (desktopSize.width - estadoLectorInternalFrame.getSize().width) / 2,
                (desktopSize.height - estadoLectorInternalFrame.getSize().height) / 2
        );
        estadoLectorInternalFrame.setVisible(false);
        frame.getContentPane().add(estadoLectorInternalFrame);

        altaDonacionEspecialInternalFrame = new AltaDonacionEspecial(controladorMaterial);
        altaDonacionEspecialInternalFrame.setLocation(
                (desktopSize.width - altaDonacionEspecialInternalFrame.getSize().width) / 2,
                (desktopSize.height - altaDonacionEspecialInternalFrame.getSize().height) / 2
        );
        altaDonacionEspecialInternalFrame.setVisible(false);
        frame.getContentPane().add(altaDonacionEspecialInternalFrame);

        altaDonacionLibroInternalFrame = new AltaDonacionLibro(controladorMaterial);
        altaDonacionLibroInternalFrame.setLocation(
                (desktopSize.width - altaDonacionLibroInternalFrame.getSize().width) / 2,
                (desktopSize.height - altaDonacionLibroInternalFrame.getSize().height) / 2
        );
        altaDonacionLibroInternalFrame.setVisible(false);
        frame.getContentPane().add(altaDonacionLibroInternalFrame);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnLectores = new JMenu("Lectores");
        menuBar.add(mnLectores);

        JMenuItem mntmAgregarLector = new JMenuItem("Agregar lector");
        mntmAgregarLector.addActionListener(e -> agregarLectorInternalFrame.setVisible(true));
        mnLectores.add(mntmAgregarLector);

        JMenuItem mntmCambiarEstado = new JMenuItem("Cambiar estado de lector");
        mntmCambiarEstado.addActionListener(e -> estadoLectorInternalFrame.setVisible(true));
        mnLectores.add(mntmCambiarEstado);

        JMenu mnMateriales = new JMenu("Materiales");
        menuBar.add(mnMateriales);

        JMenuItem mntmAltaDonacionEspecial = new JMenuItem("Alta Donación Especial");
        mntmAltaDonacionEspecial.addActionListener(e -> altaDonacionEspecialInternalFrame.setVisible(true));
        mnMateriales.add(mntmAltaDonacionEspecial);

        JMenuItem mntmAltaDonacionLibro = new JMenuItem("Alta Donación Libro");
        mntmAltaDonacionLibro.addActionListener(e -> altaDonacionLibroInternalFrame.setVisible(true));
        mnMateriales.add(mntmAltaDonacionLibro);
    }
}
