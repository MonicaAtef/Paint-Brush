package paintpkg;

import java.awt.Color;
import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.BasicStroke;
import java.awt.Checkbox;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;

public class PiantBrush extends Applet {

    int x1;
    int y1;
    int x2;
    int y2;
    int calc_x;
    int calc_y;
    int width = 0;
    int height = 0;

    int temp_x1;
    int temp_y1;
    int counter;
    char currentShape;
    int index = 0;
    int eraserWidth = 20;
    int eraserHeight = 20;
    boolean isClearAll = false;
    boolean isDotted = false;
    boolean isFilled = false;
    boolean isUndo = false;
    boolean isOpen = false;
    boolean isSave = false;

    Button saveBtn;
    Button openBtn;
    Button blackBtn;
    Button greyBtn;
    Button redBtn;
    Button pinkBtn;
    Button greenBtn;
    Button orangeBtn;
    Button blueBtn;
    Button yellowBtn;
    Button lineBtn;
    Button recBtn;
    Button circleBtn;
    Button FreeHandBtn;
    Button clrearBtn;
    Button clearBtn;
    Checkbox dotCheckbox;
    Checkbox fillCheckbox;
    Button undoBtn;

    Color currentColor = Color.black;
    Vector<Shape> allShapesVector = new Vector<>();
    
    

    @Override
    public void init() {

        saveBtn = new Button("  Save  ");
        saveBtn.setBackground(Color.WHITE);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = null;
                try {

                    File input_file = new File("D:\\ITI\\mgs");//write any path
                    image = new BufferedImage(2500, 2500, BufferedImage.TYPE_INT_ARGB);
                    image = ImageIO.read(input_file);
                } catch (IOException ioExcp) {
                    System.out.println("Error is: " + ioExcp);
                }
                try {
                    saveBtn.setBackground(Color.green);
                    JFileChooser chooser1 = new JFileChooser();
                    chooser1.showSaveDialog(null);
                    File file = chooser1.getSelectedFile();
                    Graphics2D repaint = image.createGraphics();
                    paintAll(repaint);
                    ImageIO.write(image, "png", file);// write extension .png
                    System.out.println("Saved");
                } catch (IOException ex2) {
                    System.out.println("Error");
                }
            }
        });
        add(saveBtn);
        openBtn = new Button("  Open  ");
        openBtn.setBackground(Color.WHITE);
        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isOpen = true;
                repaint();
            }
        });
        add(openBtn);
        blackBtn = new Button("           ");
        blackBtn.setBackground(Color.BLACK);
        blackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
                repaint();
            }
        });
        add(blackBtn);
        greyBtn = new Button("           ");
        greyBtn.setBackground(Color.GRAY);
        greyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GRAY;
                repaint();
            }
        });
        add(greyBtn);
        redBtn = new Button("           ");
        redBtn.setBackground(Color.RED);
        redBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
                repaint();
            }
        });
        add(redBtn);
        pinkBtn = new Button("           ");
        pinkBtn.setBackground(Color.PINK);
        pinkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.PINK;
                repaint();
            }
        });
        add(pinkBtn);
        orangeBtn = new Button("           ");
        orangeBtn.setBackground(Color.ORANGE);
        orangeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.ORANGE;
                repaint();
            }
        });
        add(orangeBtn);
        blueBtn = new Button("           ");
        blueBtn.setBackground(Color.BLUE);
        blueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
                repaint();

            }
        });
        add(blueBtn);

        greenBtn = new Button("           ");
        greenBtn.setBackground(Color.GREEN);
        greenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.green;
                repaint();

            }
        });
        add(greenBtn);
        yellowBtn = new Button("           ");
        yellowBtn.setBackground(Color.yellow);
        yellowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.yellow;
                repaint();
            }
        });
        add(yellowBtn);

        lineBtn = new Button("Line");
        lineBtn.setBackground(Color.WHITE);
        lineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'L';
            }
        }
        );
        add(lineBtn);

        recBtn = new Button("Rectangle");
        recBtn.setBackground(Color.WHITE);
        recBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'R';
            }
        });
        add(recBtn);
        circleBtn = new Button("Circle");
        circleBtn.setBackground(Color.WHITE);
        circleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'C';
            }
        });
        add(circleBtn);

        FreeHandBtn = new Button("Free Hand");
        FreeHandBtn.setBackground(Color.WHITE);
        FreeHandBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'F';
                repaint();

            }
        });
        add(FreeHandBtn);

        clrearBtn = new Button("Clear");
        clrearBtn.setBackground(Color.WHITE);
        clrearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'E';
            }
        });
        add(clrearBtn);

        clearBtn = new Button("Clear All");
        clearBtn.setBackground(Color.WHITE);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isClearAll = true;
                repaint();
            }

        });
        add(clearBtn);

        undoBtn = new Button("Undo");
        undoBtn.setBackground(Color.WHITE);
        undoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isUndo = true;
                if (!allShapesVector.isEmpty()) {
                    allShapesVector.removeElementAt(allShapesVector.size() - 1);

                } else {
                    System.out.println("UNDO IS UNAVAILABE");
                }
                repaint();
            }
        }
        );
        add(undoBtn);

        dotCheckbox = new Checkbox("Dotted");
        dotCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (dotCheckbox.getState()) {
                    isDotted = true;
                } else {
                    isDotted = false;
                }
                repaint();
            }
        });
        add(dotCheckbox);
        fillCheckbox = new Checkbox("Fill");
        fillCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (fillCheckbox.getState()) {
                    isFilled = true;
                } else {
                    isFilled = false;
                }
                repaint();
            }

        });
        add(fillCheckbox);

    MouseListener listener = new MouseListener_();
        MotionListener motionListener = new MotionListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(motionListener);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        float[] dot = {15, 15, 15};
        BufferedImage image2 = null;
        if (isSave) {

            isSave = false;
        }
        if (isOpen) {
            JFileChooser chooser = new JFileChooser();
            try {
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File im1 = chooser.getSelectedFile();
                    image2 = ImageIO.read(im1);
                    System.out.println("Done ");
                } else {
                    System.out.println("No selection ");
                }
            } catch (HeadlessException | IOException e) {
                System.out.println("Error is: " + e);
            }
        }
        g.drawImage(image2, 150, 150, this);
        isOpen = false;

        if (isClearAll) {
            allShapesVector = new Vector<>();
            isClearAll = false;
        }

        for (index = 0; index < allShapesVector.size(); index++) {
            g2d.setColor(allShapesVector.get(index).getColor());
            if (allShapesVector.get(index).isDotted()) {
                g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, dot, 10));
            } else {
                g2d.setStroke(new BasicStroke(0));
            }

            switch (allShapesVector.get(index).getShapeName()) {
                case 'L':
                    g2d.drawLine(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(),
                            allShapesVector.get(index).getX2(), allShapesVector.get(index).getY2());
                    break;
                case 'R':

                    g2d.drawRect(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(),
                            allShapesVector.get(index).getX2(), allShapesVector.get(index).getY2());
                    if (allShapesVector.get(index).isFilled()) {
                        g2d.fillRect(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(),
                                allShapesVector.get(index).getX2(), allShapesVector.get(index).getY2());
                    }
                    break;
                case 'C':
                    g2d.drawOval(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(),
                            allShapesVector.get(index).getX2(), allShapesVector.get(index).getY2());
                    if (allShapesVector.get(index).isFilled()) {
                        g2d.fillOval(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(),
                                allShapesVector.get(index).getX2(), allShapesVector.get(index).getY2());
                    }
                    break;
                case 'E':
                    g2d.fillRect(allShapesVector.get(index).getX1(), allShapesVector.get(index).getY1(), eraserWidth, eraserHeight);

            }

        }
        if (isDotted) {
            g2d.setStroke(new BasicStroke(0, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, dot, 10));
        }
        g.setColor(currentColor);

        switch (currentShape) {
            case 'C':
                if ((x1 - x2) < 0) {
                    calc_x = x1;
                } else {
                    calc_x = x2;
                }
                if ((y1 - y2) < 0) {
                    calc_y = y1;
                } else {
                    calc_y = y2;
                }
                g2d.drawOval(calc_x, calc_y, width, height);
                if (isFilled) {
                    g.setColor(currentColor);
                    g.fillOval(calc_x, calc_y, width, height);
                }
                width = height = 0;
                break;
            case 'E':
                g.setColor(Color.black);
                g.drawRect(x2, y2, eraserWidth, eraserHeight);
                g.setColor(Color.WHITE);
                g.fillRect(x2, y2, eraserWidth, eraserHeight);
                break;
            case 'L':
                if (!isUndo) {
                    g2d.drawLine(x1, y1, x2, y2);
                }
                break;
            case 'R':
                if ((x1 - x2) < 0) {
                    calc_x = x1;
                } else {
                    calc_x = x2;
                }
                if ((y1 - y2) < 0) {
                    calc_y = y1;
                } else {
                    calc_y = y2;
                }
                g2d.drawRect(calc_x, calc_y, width, height);
                if (isFilled) {
                    g.setColor(currentColor);
                    g.fillRect(calc_x, calc_y, width, height);
                }
                width = height = 0;
                break;
            case 'F':
                g.drawLine(x1, y1, x2, y2);
                break;
        }
        if (isUndo) {
            isUndo = false;
        }
    }

    class MouseListener_ implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();

            width = Math.abs(x2 - x1);
            height = Math.abs(y2 - y1);
            switch (currentShape) {
                case 'C':
                    if ((x1 - x2) < 0) {
                        calc_x = x1;
                    } else {
                        calc_x = x2;
                    }
                    if ((y1 - y2) < 0) {
                        calc_y = y1;
                    } else {
                        calc_y = y2;
                    }
                    allShapesVector.add(new Circle(calc_x, calc_y, width, height, currentColor, isDotted, isFilled, 'C'));
                    break;
                case 'L':
                    allShapesVector.add(new Line(x1, y1, x2, y2, currentColor, isDotted, 'L'));
                    break;
                case 'R':
                    if ((x1 - x2) < 0) {
                        calc_x = x1;
                    } else {
                        calc_x = x2;
                    }
                    if ((y1 - y2) < 0) {
                        calc_y = y1;
                    } else {
                        calc_y = y2;
                    }
                    allShapesVector.add(new Rectangle(calc_x, calc_y, width, height, currentColor, isDotted, isFilled, 'R'));
                    break;

            }

            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
    }

    class MotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();

            width = Math.abs(x2 - x1);
            height = Math.abs(y2 - y1);

            switch (currentShape) {

                case 'E':
                    allShapesVector.add(new Rectangle(x2, y2, eraserWidth, eraserHeight, currentColor, isDotted, isFilled, 'E'));
                    break;
                case 'F':
                    allShapesVector.add(new Line(x1, y1, x2, y2, currentColor, isDotted, 'L'));
                    counter += 1;
                    if (counter % 2 == 0) {
                        x1 = x2;
                        y1 = y2;
                    }
                    break;
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

}
