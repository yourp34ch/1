import javax.swing.text.Segment;
import java.awt.*;

class Square {
    int[] segment;

    public static void main(Segment[] args) {
        public void paintComponent("Graphics g") {
            Graphics g2 = (Graphics2D)g;
            super.paintComponent(g2);
            Square[] square = new Square [8];
            for(int i=0;i<8;i++){
                super.paintComponent(g2);
                g2.drawLine(square[i].segment[i].pointsBegin[i].x, square[i].segment[i].pointsBegin[i].y,
                        square[i].segment[i].pointsEnd[i].x, square[i].segment[i].pointsEnd[i].y);
                //g2.drawLine(50, 50, 150, 150);

            }
        }
    }
}
