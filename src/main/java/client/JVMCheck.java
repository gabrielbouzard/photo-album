package client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

// Class written by Devon_C_Miller: https://stackoverflow.com/a/2789907/6506982

public class JVMCheck {
    private JVMCheck() {}
    public static boolean isJVMOk()
    {
        boolean result = false;
        String s = System.getProperty("java.version", "undef");
        if (!s.equals("undef")) {
            String parts[] = s.split("[^0-9]+");
            if (parts.length >= 2) {
                if (parts[0].equals("1") && parts[1].compareTo("6") >= 0) {
                    result = true;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        if (JVMCheck.isJVMOk())
        {
            // Call you real main class here:
            // RealMainClass.main(args);
        }
        else
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    JOptionPane.showMessageDialog(null, 
                        new JLabel("<html><b>Error<b>: Unsupported JVM: \""
                            + System.getProperty("java.vm.name", "Undef") + "\" "
                            + System.getProperty("java.vm.version", "Undef")
                            + "<br>The JVM version required to run is 1.6.0<br>"
                            + "The 1.6 JRE may be downloaded from:<br>"
                            + "http://java.sun.com/javase"),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            });
        }
    }
}