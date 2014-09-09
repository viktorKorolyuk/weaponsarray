package vafspy.weparr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SystemInfo extends JFrame {
	// Add a serialVersionUID: Takes care of those pesky warnings!
	private static final long serialVersionUID = 1L;
	
	// Now for the JPanel Declarations
	JPanel pnl = new JPanel();
	JPanel top = new JPanel();
	JPanel btm = new JPanel();
	JPanel tl = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel tr = new JPanel(new FlowLayout(FlowLayout.LEFT));
	// And GridLayout Declarations
	GridLayout gridlayout = new GridLayout(2,1);
	GridLayout topgrid = new GridLayout(1,2);
	// Now for section titles
	JLabel sysdata, userdata, allprops;
	// Now for the bottom table work
	String[] tcolnames = {"Name","Value"};
	Set<String> propnames = System.getProperties().stringPropertyNames();
	List<String> spropnames =  new ArrayList<String>(Arrays.asList(Arrays.copyOf(propnames.toArray(), propnames.toArray().length, String[].class)));
	String[][] props = new String[spropnames.size()][spropnames.size()];
	JTable table;
	JScrollPane tscroll;
	// Now for top left labels
	JLabel osname, osvers, subscr, hostname, users, groups, roots;
	// And the top right labels
	JLabel username, homedir, curdir, primgrp, grps, isroot;
	
	public void setLabels() {
		// Labels are set in here for more consistent fonts.
		// THE TITLES
		sysdata = new JLabel(" System Data");
		userdata = new JLabel(" User Data");
		allprops = new JLabel("All Properties");
		// THE TOP LEFT AREA
		osname = new JLabel(" OS Name: " + System.getProperty("os.name"));
		osvers = new JLabel(" OS Ver.: " + System.getProperty("os.version"));
		subscr = new JLabel("<html><br/><br/><br/><br/><br/><br/>----*Including System-Registered (non-person) users.----</html>");
		try {
			String htest = InetAddress.getLocalHost().getHostName();
			hostname = new JLabel(" Host Name: " + htest);
			if(htest == null || htest.isEmpty()){
				throw new Exception();
			}
		}
		catch(Exception e) {
			try {
				Process r = Runtime.getRuntime().exec("hostname");
				BufferedReader stdi = new BufferedReader(new InputStreamReader(r.getInputStream()));
				stdi.close();
				hostname = new JLabel(" Host Name: " + stdi.readLine());
			}
			catch(Exception err) {
				hostname = new JLabel(" Host Name: UNABLE TO FIND");
			}
		}
		BufferedReader etcpasswd, etcgroup;
		try {
			etcpasswd = new BufferedReader(new FileReader("/etc/passwd"));
			int lines = 0;
			int rootlns = 0;
			String ss;
			while ((ss = etcpasswd.readLine()) != null) {
				lines++;
				if (ss.startsWith("0:")) {
					rootlns++;
				}
			}
			etcpasswd.close();
			users = new JLabel(" Registered Users*: " + lines);
			roots = new JLabel(" Root Users: " + rootlns);
		} catch (Exception e) {
			users = new JLabel(" UNABLE TO RETREIVE REGISTERED USERS COUNT!");
			roots = new JLabel(" UNABLE TO RETREIVE ROOT USERS COUNT!");
		}
		try {
			etcgroup = new BufferedReader(new FileReader("/etc/group"));
			int lines = 0;
			while (etcgroup.readLine() != null) lines++;
			etcgroup.close();
			groups = new JLabel(" Registered Groups*: " + lines);
		} catch (Exception e) {
			groups = new JLabel(" UNABLE TO RETREIVE REGISTERED GROUPS COUNT!");
		}
		// THE TOP RIGHT AREA
		username = new JLabel(" User Name: " + System.getProperty("user.name"));
		homedir = new JLabel(" Home Dir.: " + System.getProperty("user.home"));
		curdir = new JLabel(" Curdir: " + System.getProperty("user.dir"));
		boolean isrt = (System.getenv("EUID") == "0");
		isroot = new JLabel(" Is Root: " + isrt);
		String[] groupslist;
		String grpslst;
		try
		{
			Process p = Runtime.getRuntime().exec("groups");
	 
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			grpslst = reader.readLine();
			groupslist = grpslst.split(" ");
		}
		catch (Exception e) {
			groupslist = new String[1];
			groupslist[0] = "ERROR READING GROUPS!";
			grpslst = "ERROR READING GROUPS!";
		}
		primgrp = new JLabel(" Primary Group: " + groupslist[0]);
		grps = new JLabel(" Groups: " + grpslst);
	}
	
	public void configProps(){
		int i = 0;
		for (String s : spropnames) {
			props[i][0] = s;
			props[i][1] = System.getProperty(s);
			i++;
		}
	}
	
	public SystemInfo() {
		super("System Info");
		setSize(650, 570);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // So that we can listen for close and open up mainPass
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        new MainLoader();
		    }
		});
		try {
			if(Features.nimbus()) {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
		        	}
		    	}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}
		}
		configProps();
		setLabels();
		add(pnl);
		pnl.setLayout(gridlayout);
		pnl.add(top);
		top.setLayout(topgrid);
		top.add(tl);
		tl.setBorder(BorderFactory.createLineBorder(Color.black));
		tl.setLayout(new BoxLayout(tl, BoxLayout.Y_AXIS));
		top.add(tr);
		tr.setBorder(BorderFactory.createLineBorder(Color.black));
		tr.setLayout(new BoxLayout(tr, BoxLayout.Y_AXIS));
		pnl.add(btm);
		btm.setBorder(BorderFactory.createLineBorder(Color.black));
		sysdata.setFont(new Font("Arial", Font.BOLD, 15));
		tl.add(sysdata);
		tl.add(new JLabel("   "));
		
		// Top Left Box Labels
		tl.add(osname);
		tl.add(osvers);
		tl.add(hostname);
		tl.add(users);
		tl.add(groups);
		tl.add(roots);
		subscr.setFont(new Font("Arial", Font.ITALIC, 13));
		tl.add(subscr);
		
		userdata.setFont(new Font("Arial", Font.BOLD, 15));
		tr.add(userdata);
		tr.add(new JLabel("   "));
		
		// Top Right Box Labels
		tr.add(username);
		tr.add(homedir);
		tr.add(curdir);
		tr.add(isroot);
		
		allprops.setFont(new Font("Arial", Font.BOLD, 15));
		btm.add(allprops);
		btm.add(new JLabel("   "));
		table = new JTable(props, tcolnames);
		table.setAutoCreateRowSorter(true);
		
		tscroll = new JScrollPane(table);
		tscroll.setPreferredSize(new Dimension(640, 240));  
		table.setFillsViewportHeight(true);
		btm.add(tscroll);
		setVisible(true);
	}
	// The main method, so that it can be invoked standalone!
	public static void main(String[] args){
		new SystemInfo();
	}
}
