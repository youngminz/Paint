package figure;

import Information.Information;

import javax.swing.*;
import java.awt.*;

public class Text extends Figure {


    private String text;
    private int startX, startY;
    private int textSize = 10;
    private int fontStyle = Font.PLAIN;

    public Text(int StartX, int StartY) {
        super();
        textSize = Information.getTextSize();
        fontStyle = Information.gettextStyle();
        this.startX = StartX;
        this.startY = StartY;
        while (true) {
            if (text == null || text.equals("")) text = JOptionPane.showInputDialog(null, "텍스트를 입력해주세요.");
            if (text != null || !text.equals("")) break;
        }
    }


    @Override
    public void setFigureSize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void drawFigure(Graphics2D g) {
        // TODO Auto-generated method stub
        g.setPaint(figurePaint);

        g.setFont(new Font(null, fontStyle, textSize));
        g.drawString(text, startX, startY);

    }

    @Override
    public void calcFigure(int currentX, int currentY) {
        // TODO Auto-generated method stub
        if (Information.getCurrentMode() == Information.MODE_RESIZE) {
            int deltax = Math.abs(startX - currentX);
            int deltay = Math.abs(startX - currentX);
            textSize = (deltax + deltay / 100);

        }


    }

    public void moveTo(int curX, int curY) {
        startX += curX;
        startY += curY;
    }


    @Override
    public String toString() {
        return "Text [text=" + text + ", textSize=" + textSize + "]";
    }

    @Override
    public Figure clone() {
        Text obj = new Text(0, 0);

        obj.text = text;
        obj.startX = startX;
        obj.startY = startY;
        obj.textSize = textSize;
        obj.fontStyle = fontStyle;
        return obj;
    }


}
