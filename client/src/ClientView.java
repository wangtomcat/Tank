//	坦克大战连线版用户端
import javax.swing.*;
import java.awt.*;

//这个类代表服务器的图形界面
public class ClientView extends JFrame{
	public drawingPanel mainPanel;
	public JButton sendMessage, connectServer, exit, pauseAndResume, help;
	public JTextField messageField, IPfield;
	public JLabel enterIP;
	public Image offScreenImage;

	public ClientControler controler;
	public ClientModel model;


	public ClientView(){
		super("坦克大战");

		try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		getContentPane().setLayout(null);

		//设置动画绘制主面板
		mainPanel = new drawingPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,  22, 679, 605);
		mainPanel.setBackground(new Color(128, 64, 0));

		messageField = new JTextField();
		messageField.setBounds(0,519, 560,22);
		messageField.setEnabled(false);
		sendMessage = new JButton("发送");
		sendMessage.setBounds(570,518, 62,24);
		sendMessage.setFocusable(false);
		mainPanel.add(messageField);
		mainPanel.add(sendMessage);
		getContentPane().add(mainPanel);
		mainPanel.setFocusable(true);

		//设置选项按钮和IP文本字段
		enterIP = new JLabel("输入主机IP");
		enterIP.setBounds(5, 0,60,22);
		getContentPane().add(enterIP);

		IPfield = new JTextField();
		IPfield.setBounds(65, 0,90,22);
		getContentPane().add(IPfield);

		connectServer = new JButton("连接主机");
		connectServer.setBounds(160, 0,100,22);
		getContentPane().add(connectServer);
		connectServer.setFocusable(false);

		pauseAndResume = new JButton("暂停/继续");
		pauseAndResume.setBounds(260, 0,100,22);
		getContentPane().add(pauseAndResume);
		pauseAndResume.setFocusable(false);

		help = new JButton("帮助");
		help.setBounds(360, 0,100,22);
		getContentPane().add(help);
		help.setFocusable(false);

		exit = new JButton("退出");
		exit.setBounds(460, 0,100,22);
		getContentPane().add(exit);
		exit.setFocusable(false);

		//设置面框架
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 130, 640, 590);
    	setVisible(true);
    	setResizable( false );

		//设置客户端模型
		model = new ClientModel(this);

		//设置客户端控制器
		controler = new ClientControler(this, model);
	}

	public static void main(String[] args){
		new ClientView();
	}

}