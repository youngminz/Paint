import javax.swing.*;

@SuppressWarnings("FieldCanBeLocal")
class App extends JFrame {

    private JMenu fileMenu;
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenu drawMenu;
    private JMenuItem freeDrawingMenuItem;
    private JMenuItem lineDrawingMenuItem;
    private JMenuItem rectangleDrawingMenuItem;
    private JMenuItem ovalDrawingMenuItem;
    private JMenuItem fillColorMenuItem;
    private JMenuItem eraseMenuItem;
    private JMenuItem foregroundPickMenuItem;
    private JMenuItem backgroundPickMenuItem;

    App() {
        initGui();
    }

    private void initGui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Untitled - 그림판");

        JMenuBar menuBar = new JMenuBar();

        fileMenu = new JMenu("파일");
        openMenuItem = new JMenuItem("열기");
        saveMenuItem = new JMenuItem("저장");

        drawMenu = new JMenu("그리기");
        freeDrawingMenuItem = new JMenuItem("자유 그리기");
        lineDrawingMenuItem = new JMenuItem("직선 그리기");
        rectangleDrawingMenuItem = new JMenuItem("직사각형 그리기");
        ovalDrawingMenuItem = new JMenuItem("원 그리기");
        fillColorMenuItem = new JMenuItem("색상 채우기");
        eraseMenuItem = new JMenuItem("지우기");
        foregroundPickMenuItem = new JMenuItem("전경 색 선택");
        backgroundPickMenuItem = new JMenuItem("배경 색 선택");

        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        menuBar.add(drawMenu);
        drawMenu.add(freeDrawingMenuItem);
        drawMenu.add(lineDrawingMenuItem);
        drawMenu.add(rectangleDrawingMenuItem);
        drawMenu.add(ovalDrawingMenuItem);
        drawMenu.add(fillColorMenuItem);
        drawMenu.add(eraseMenuItem);
        drawMenu.add(foregroundPickMenuItem);
        drawMenu.add(backgroundPickMenuItem);

        setSize(800, 600);
        setVisible(true);
    }
}
