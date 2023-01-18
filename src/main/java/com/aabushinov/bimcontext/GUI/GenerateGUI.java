/*
 * Created by JFormDesigner on Sun Jan 15 18:38:46 MSK 2023
 */

package com.aabushinov.bimcontext.GUI;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

import com.aabushinov.bimcontext.Type.Field;
import net.miginfocom.swing.*;

/**
 * @author abush
 */
public class GenerateGUI extends JPanel {
    private final ArrayList<Field> IBlockTypeField;
    private final ArrayList<Field> IBlockField;
    private final ArrayList<Field> IBlockPropertyField;
    private final ArrayList<Field> currentField;

    public GenerateGUI() {
        currentField = new ArrayList<Field>();
        IBlockTypeField = new ArrayList<Field>();
        IBlockField = new ArrayList<Field>();
        IBlockPropertyField = new ArrayList<Field>();
        initComponents();

        //Create IBlock type fields
        JLabel IBlockFieldLabel = new JLabel();
        IBlockFieldLabel.setText("IBlock type code");
        IBlockTypeField.add(new Field(IBlockFieldLabel, new JTextField()));

        //Create IBlock fields
        JLabel IBlockLabel = new JLabel();
        IBlockLabel.setText("IBlock code");
        IBlockField.add( new Field(IBlockLabel, new JTextField()));

        //Create IBlock property
        JLabel IBlockPropertyLabel = new JLabel();
        IBlockPropertyLabel.setText("IBlock property code");
        IBlockPropertyField.add( new Field(IBlockLabel, new JTextField()));
        IBlockPropertyField.add( new Field(IBlockPropertyLabel, new JTextField()));
    }

    public ArrayList<Field> getCurrentField() {
        return currentField;
    }

    public String getCommandName() {
        return comboBox1.getSelectedItem().toString();
    }

    public String getDescription() {
        return textArea1.getText().toString();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        deleteCurrentField();

        if (Objects.equals(e.getItem().toString(), "IBlock type")) {
            createFields(IBlockTypeField);
        }

        if (Objects.equals(e.getItem().toString(), "IBlock")) {
            createFields(IBlockField);
        }

        if (Objects.equals(e.getItem().toString(), "IBlock property")) {
            createFields(IBlockPropertyField);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboBox1 = new JComboBox<>();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

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
            "[140,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[136]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("gen type");
        add(label1, "cell 1 1");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "simple",
            "IBlock",
            "IBlock type",
            "IBlock property"
        }));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        add(comboBox1, "cell 7 1 7 1");

        //---- label2 ----
        label2.setText("description");
        add(label2, "cell 1 3");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1, "cell 7 3 7 2,growy");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void createFields(ArrayList<Field> fields) {
        int row = 6;

        for (Field field : fields) {
            add(field.getLabel(), "cell 1 " + row);
            add(field.getInput(), "cell 7 " + row + " 7 1");
            row += 2;
            currentField.add(field);
        }

        validate();
        repaint();
    }

    private void deleteCurrentField() {
        for (Field field : currentField) {
            remove(field.getLabel());
            remove(field.getInput());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox<String> comboBox1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
