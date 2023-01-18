/*
 * Created by JFormDesigner on Sun Jan 15 16:13:52 MSK 2023
 */

package com.aabushinov.bimcontext;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author abush
 */
public class ConfigurationGUI extends JPanel {
    private ConfigurationState config;

    public ConfigurationGUI(ConfigurationState config) {
        this.config = config;
        initComponents();
    }

    public String getExec() {
        return textField1.getText();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Bim exec");
        add(label1, "cell 1 1");
        add(textField1, "cell 3 1 23 1");

        //---- label2 ----
        label2.setText("%ARGS% placeholder for command args");
        add(label2, "cell 4 2");

        //---- label3 ----
        label3.setText("Example: php vendor\\korusdev\\bim-core\\src\\bin\\bim %ARGS%");
        add(label3, "cell 4 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        textField1.setText(config.getExec());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
