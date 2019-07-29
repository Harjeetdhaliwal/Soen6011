import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator2 implements ActionListener {

    JTextField input;
    JRadioButton population, sample;
    JButton calculate, reset;
    JLabel intro,answer;


    Calculator2() {
        JFrame f = new JFrame();

        intro=new JLabel("Please provide numbers separated by commas");
        intro.setBounds(50,50, 300,30);

        input = new JTextField();
        input.setBounds(50, 100, 250, 30);
        calculate = new JButton("calculate");
        calculate.setBounds(50, 200, 95, 30);
        reset = new JButton("reset");
        reset.setBounds(180, 200, 95, 30);

        population = new JRadioButton("Population");
        population.setBounds(75, 150, 100, 30);
        sample = new JRadioButton("Sample");
        sample.setBounds(180, 150, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(population);
        bg.add(sample);

        answer=new JLabel("");
        answer.setBounds(50,250, 300,30);

        calculate.addActionListener(this);
        reset.addActionListener(this);
        f.add(intro);
        f.add(input);
        f.add(reset);
        f.add(calculate);
        f.add(population);
        f.add(sample);
        f.add(answer);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
       String nondigits = input.getText().replaceAll("[^0-9.\\,]+|\\.(?!\\d)", "KK");
        String Trimed = input.getText().replaceAll("\\s","");
        String[] array = Trimed.split(",");
        int length = array.length;
        if (command.charAt(0) == 'r') {
            input.setText("");
            answer.setText("");
        } else if (command.charAt(0) == 'c') {
            if (population.isSelected()) {

                if (input.getText().isEmpty()) {
                	answer.setText("");
                    JOptionPane optionPane = new JOptionPane("Please enter numbers to calculate standard deviation", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
                else if(length<2) {
                	answer.setText("");
                    JOptionPane optionPane = new JOptionPane("Please enter numbers separated by commas", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                   
                }
                
                else if(nondigits.contains("KK")){
                	answer.setText("");
                	JOptionPane optionPane = new JOptionPane("Enter Numbers only", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                   
                }
                else {
                 answer.setText("Answer:  "+ Double.toString(evaluate(input.getText())));
                }
            } else if (sample.isSelected()) {
                if (input.getText().isEmpty()) {
                	answer.setText("");
                    JOptionPane optionPane = new JOptionPane("Please enter numbers to calculate standard deviation", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    
                }
                else if(length<2) {
                	answer.setText("");
                    JOptionPane optionPane = new JOptionPane("Please enter numbers separated by commas", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    
                }
                else if(nondigits.contains("KK")){
                	answer.setText("");
                	JOptionPane optionPane = new JOptionPane("Enter Numbers only", JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Warning!");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                   
                }
                
                else {
                    answer.setText("Answer:  " + Double.toString(evaluatesample(input.getText())));

                }

            } else {
            	answer.setText("");
                JOptionPane optionPane = new JOptionPane("Please Select the type of data set to calculate standard deviation", JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Warning!");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                
            }
        }

    }

    public static double evaluate(String expression) {
    	String nondigits = expression.replaceAll("[^0-9.\\,]+|\\.(?!\\d)", "");
        String[] array = nondigits.split(",");
        double[] numbers = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Double.parseDouble(array[i]);
        }
        //int counter, count = 5;
        double sum = 0, mean;
        double standardDeviation = 0;
        for (double num : numbers) {
            sum += num;
        }
        mean = sum / numbers.length;
        for (double num : numbers) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        String output =String.format("%.12f", Math.sqrt(standardDeviation / numbers.length)) ;
        return Double.parseDouble(output) ;

    }




    public static double evaluatesample(String expression) {
    	String nondigits = expression.replaceAll("[^0-9.\\,]+|\\.(?!\\d)", "");
        String[] array1 = nondigits.split(",");
        double[] numbers = new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            numbers[i] = Double.parseDouble(array1[i]);
        }
        double sum = 0, mean;
        double standardDeviation = 0;
        for (double num : numbers) {
            sum += num;
        }
        mean = sum / numbers.length;
        for (double num : numbers) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        String output =String.format("%.12f", Math.sqrt(standardDeviation /( numbers.length-1))) ;
        return Double.parseDouble(output) ;

    }


    public static void main(String[] args) {
        new Calculator2();
    }
}
