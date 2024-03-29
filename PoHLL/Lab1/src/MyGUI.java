import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

/**
 * This class realize graphical user interface
 */
public class MyGUI {
    private JButton startButton;
    private JButton guessButton;
    private JTextField textField;
    private JLabel label;
    private JMenuBar menuBar;
    private JFrame frame;
    private GameLogic gameLogic;

    /**
     * Method of initializing and running GUI.
     * @param border This is the border of randomize.
     */
    public void runGUI(final int border){
        constructFrame(border);
        makeMenu();
        addComponentsToFrame();
        finalSettingOfFrame();
    }

    /**
     * This method initialize main components of GUI.
     * @param border This is the border of randomize.
     */
    private void constructFrame(final int border) {
        frame = new JFrame("Guess the random");
        label = new JLabel("Начните игру");
        textField = new JTextField();
        startButton = new JButton ("Новая игра");
        guessButton = new JButton ("Угадать!");
        menuBar = new JMenuBar();
        gameLogic = new GameLogic(border);

        startButton.addActionListener(new RandomListener());
        guessButton.addActionListener(new GuessListener());
        final KeyListener keyListener = new KeyListener() {
            public void keyTyped(final KeyEvent e) { }
            public void keyPressed(final KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    gameLogic.setUserNumber(textField.getText());
                    gameLogic.incCounter();
                    printResultText();
                    textField.setText("");
                }
            }
           public void keyReleased(final KeyEvent e) { }
        };
        textField.addKeyListener(keyListener);
    }

    /**
     * This method makes menu.
     */
    private void makeMenu() {
        JMenu mainMenu = new JMenu("Меню");

        JMenuItem newGameItem = new JMenuItem("Новая игра");
        mainMenu.add(newGameItem);
        newGameItem.addActionListener(new RandomListener());

        menuBar.add(mainMenu);
        frame.setJMenuBar(menuBar);
    }

    /**
     * This method adds components on frame.
     */
    private void addComponentsToFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        textField.setBounds(20,15,150,20);
        panel.add (textField);

        label.setBounds(20,35, 200, 20);
        panel.add(label);

        guessButton.setBounds (20, 60, 90,30);
        panel.add(guessButton);

        startButton.setBounds (120, 60, 150, 30);
        panel.add(startButton);

        frame.getContentPane().add(panel);
    }

    /**
     * This method sets principal settings of frame.
     */
    private void finalSettingOfFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,165);
        frame.setLocation(800,400);
        frame.setUndecorated(false);
        frame.setVisible(true);
    }

    /**
     * Event handler of button "guessButton".
     * Realize the interface of reading and guessing number.
     */
    class GuessListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            gameLogic.setUserNumber(textField.getText());
            gameLogic.incCounter();
            printResultText();
            textField.setText("");
        }
    }

    /**
     * This method prints result of comparing on frame
     */
    private void printResultText(){
        switch (gameLogic.compareOfNumbers()) {
            case NOT_STARTED: label.setText("Начните новую игру"); break;
            case NOT_ENTERED: label.setText("Число не введено"); break;
            case MORE: label.setText("Число "+ gameLogic.getUserNumber()+" больше загаданного"); break;
            case LESS: label.setText("Число "+ gameLogic.getUserNumber()+" меньше загаданного"); break;
            case WIN: {
                label.setText("Победа!");
                JOptionPane.showMessageDialog(
                        null,
                        "Вы угадали число "+ gameLogic.getComputerNumber()+"!\nКоличество попыток: "+
                                gameLogic.getCounter(),
                        "Победа!", JOptionPane.PLAIN_MESSAGE);

                gameLogic.setNegativeComputerNumber();
                label.setText("Начните игру заново");
                textField.setText("");
                break;
            }
        }
    }

    /**
     * Event handler of button "startButton".
     * Realize the starting of a new game.
     */
    class RandomListener implements ActionListener{
        public void actionPerformed (ActionEvent event) {
            gameLogic.setRandomNumber();
            gameLogic.setCounterToZero();
            label.setText("Новое число сгенерировано");
            textField.setText("");
        }
    }
}