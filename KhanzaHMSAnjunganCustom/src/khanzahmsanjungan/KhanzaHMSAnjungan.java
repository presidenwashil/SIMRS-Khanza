/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanzahmsanjungan;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import fungsi.koneksiDB;
import java.awt.Color;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.UIManager;
import usu.widget.util.WidgetUtilities;

/**
 *
 * @author khanzasoft
 */
public class KhanzaHMSAnjungan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WidgetUtilities.invokeLater(() -> {
            HalamanUtamaDepan utama = HalamanUtamaDepan.getInstance();
            utama.setVisible(true);
            
            String printerBarcode = null, printerRegistrasi = null;
            
            for (PrintService ps: PrintServiceLookup.lookupPrintServices(null, null)) {
                System.out.println("Printer ditemukan: " + ps.getName());
                
                if (ps.getName().equals(koneksiDB.PRINTER_BARCODE())) {
                    printerBarcode = ps.getName();
                }
                
                if (ps.getName().equals(koneksiDB.PRINTER_REGISTRASI())) {
                    printerRegistrasi = ps.getName();
                }
            }
            
            if (printerBarcode != null) {
                System.out.println("Setting PRINTER_BARCODE menggunakan printer: " + printerBarcode);
            }
            
            if (printerRegistrasi != null) {
                System.out.println("Setting PRINTER_REGISTRASI menggunakan printer: " + printerRegistrasi);
            }
        });
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("TabbedPane.showTabSeparators", true);
            UIManager.put("TabbedPane.tabSeparatorsFullHeight", true);
            UIManager.put("ScrollBar.showButtons", true);
            UIManager.put("TabbedPane.selectedBackground", Color.LIGHT_GRAY);
            UIManager.put("TabbedPane.underlineColor", Color.GREEN);
            UIManager.put("TabbedPane.tabSeparatorColor", Color.darkGray);
            UIManager.put("Component.arrowType", "chevron");
            UIManager.put("Component.innerFocusWidth", 1);
            UIManager.put("TextBoxGlass.innerFocusWidth", 1);
            UIManager.put("TextBox.focusWidth", 1);
            UIManager.put("Component.focusWidth", 1);
            UIManager.put("Button.innerFocusWidth", 1);
            UIManager.put("Button.arc", 0);
            UIManager.put("Component.arc", 0);
            UIManager.put("CheckBox.arc", 0);
            UIManager.put("ProgressBar.arc", 0);
            UIManager.put("TextBox.arc", 5);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

}
