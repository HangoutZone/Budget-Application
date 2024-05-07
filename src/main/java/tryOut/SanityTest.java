package tryOut;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class SanityTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(700,700));

        /*todo if the fill is true choose a fill color. (using a button for choosing fill via mouseclick event)
          this is outside the budget app program this is now the basis for a shape spawn program
         */
        DrawShape drawShape = new DrawShape(new Ellipse2D.Double(400,100, 50,50), Color.BLUE, true, jFrame);
        DrawShape a = new DrawShape(new Rectangle2D.Double(300, 300, 40, 50), Color.RED, false, jFrame);
        DrawShape b = new DrawShape(new Arc2D.Double(150, 210, 200, 200, 180, 180, Arc2D.OPEN), Color.CYAN, false, jFrame);


        JLabel costLabel = new JLabel("Cost: ");
        costLabel.setBounds(0, 0, 60, 50);
        costLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));

        jFrame.add(drawShape);
        jFrame.add(a);
        jFrame.add(b);
        jFrame.add(costLabel);

        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

//rectangle use Rectangle2D.float
//line use Line2D.Float
//arc use Arc2D.Float

