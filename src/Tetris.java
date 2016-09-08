import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by YSK on 2016/9/6.
 */
public class Tetris{
    private Field field;
    private View view;

    public Tetris(int height, int width){
        field = new Field(height, width);

        view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (field.keyUp()) {
                            view.repaint();
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (field.keyDown()) {
                            view.repaint();
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (field.keyLeft()) {
                            view.repaint();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (field.keyRight()) {
                            view.repaint();
                        }
                        break;
                }
            }
        });
    }

    void start(){
        field.createBlock();
        view.repaint();
        (new reFresh()).execute();
    }

    class reFresh extends SwingWorker{

        @Override
        protected Object doInBackground() throws Exception {
            Thread.sleep(1000);
            return null;
        }

        @Override
        protected void done() {
            if (field.isBlockFinished()){
                field.blockFinished();
                view.repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (field.hasNextBlankLine()){
                    field.removeLowestBlankLine();
                    view.repaint();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(field.createBlock()) {
                    view.repaint();
                }else {
                    JOptionPane.showMessageDialog(null, "alert", "游戏结束", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }else {
                field.keyDown();
                view.repaint();
            }
            (new reFresh()).execute();
        }
    }

    public static void main(String[] args) {
        Tetris tetris = new Tetris(20, 4);
        tetris.start();
    }
}
