import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


class Myframe extends JFrame implements ActionListener {
    Container c;
    JLabel head1,head2,city,state,country;
    JTextField cty,st,cont;
    JTextArea whe;
    JButton btn;
    Myframe(){
        setTitle("Weather Report");

        setBounds(110,200,1250,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();
        c.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("cloud.png"));
        setIconImage(icon.getImage());


        ImageIcon img = new ImageIcon(getClass().getResource("58329 (1).jpg"));
        JLabel bk = new JLabel(img);
        bk.setSize(1600,950);
        c.add(bk);


        btn = new JButton("Get Weather");
        btn.setBounds(350,450,250,60);
        Font btnf = new Font("Ariel",Font.BOLD,30);
        btn.setFont(btnf);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        btn.setCursor(cur);
        bk.add(btn);
        btn.addActionListener(this::actionPerformed);



        head1 = new JLabel("🤗 Welcome 🤗");
        head1.setBounds(520,40,240,40);
        head1.setForeground(Color.white);
        Font font = new Font("Ariel",Font.BOLD,30);
        head1.setFont(font);
        bk.add(head1);

        head2 = new JLabel("🌧 Get your Weather info. here 🌧");
        head2.setBounds(370,90,550,40);
        head2.setForeground(Color.white);
        Font font2 = new Font("Ariel",Font.BOLD,30);
        head2.setFont(font2);;
        bk.add(head2);




        city = new JLabel("⛅︎ City Name      ➡");
        city.setBounds(40,180,290,40);
        city.setForeground(Color.white);
        Font ct = new Font("Ariel",Font.BOLD,30);
        city.setFont(ct);
        bk.add(city);


        cty = new JTextField();
        cty.setBounds(350,180,250,40);
        cty.setBorder(new LineBorder(Color.white,2));
        Font ct1 = new Font("Ageo",Font.ITALIC,30);
        cty.setForeground(Color.white);
        cty.setCaretColor(Color.WHITE);

        cty.setOpaque(false);
        cty.setFont(ct1);
        //cty.setBackground(Color.getHSBColor(5,195,84));
        bk.add(cty);




        state = new JLabel("⛅︎ State Name     ➡");
        state.setBounds(40,270,300,40);
        state.setForeground(Color.white);
        Font sta = new Font("Ariel",Font.BOLD,30);
        state.setFont(sta);
        bk.add(state);


        st = new JTextField();
        st.setBounds(350,270,250,40);
        st.setBorder(new LineBorder(Color.white,2));
        Font sta1 = new Font("Ageo",Font.ITALIC,30);
        st.setForeground(Color.white);
        st.setCaretColor(Color.WHITE);
        st.setFont(sta1);
        st.setOpaque(false);
        bk.add(st);


        country = new JLabel("⛅︎ Country Name ➡");
        country.setBounds(40,360,360,40);
        country.setForeground(Color.white);
        Font cnt = new Font("Ariel",Font.BOLD,30);
        country.setFont(cnt);
        bk.add(country);


        cont = new JTextField();
        cont.setBounds(350,360,250,40);
        cont.setBorder(new LineBorder(Color.white,2));
        Font cnt2 = new Font("Ageo",Font.ITALIC,30);
        cont.setForeground(Color.white);
        cont.setCaretColor(Color.WHITE);
        cont.setFont(cnt2);
        cont.setOpaque(false);
        bk.add(cont);



//        whet = new JLabel("⦿ Weather Info. ⬇");
//        whet.setBounds(700,180,280,40);
//        whet.setForeground(Color.white);
//        Font whe1 = new Font("Ariel",Font.BOLD,30);
//        whet.setFont(font);
//        bk.add(whet);




        whe = new JTextArea();
        whe.setBounds(700,170,480,230);
        Font whe2 = new Font("Ageo",Font.ITALIC,30);
        whe.setFont(whe2);
        whe.setOpaque(false);
        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white,3,true)," ⛅︎ Weather Info. ➡",0,1,cnt,Color.white);
        whe.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(0,0,0,0)));
        whe.setForeground(Color.white);
        whe.setCaretColor(Color.WHITE);
        bk.add(whe);



        setVisible(true);
        cty.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cityname = cty.getText();
        String statecode = st.getText();
        String cntcode =cont.getText();


        try {
            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+cityname+","+statecode+","+cntcode+"&limit=1&appid=df2bea4491e7e31d4c644c3b17cb2d20");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int rc = con.getResponseCode();
            System.out.println(rc);
            if (rc != 200) {
                System.out.println("Error in Connection Establishment");
            } else {
                String data = "";
                Scanner sc = new Scanner(url.openStream());

                while (sc.hasNext()) {
                    data += sc.nextLine();
                }
                sc.close();
                System.out.println(data);
                JSONParser par = new JSONParser();
                JSONArray arr = (JSONArray) par.parse(data);
                //System.out.println(arr);
//              System.out.println(arr.get(0));
                JSONObject obj = null;

                for (int i = 0; i < arr.size(); i++) {
                    obj = (JSONObject) arr.get(i);
                    //System.out.println(obj);
                    //System.out.println(obj.get("lat"));
                    //System.out.println(obj.get("lon"));
                    double lat = (double) obj.get("lat");
                    double lon = (double) obj.get("lon");

                    URL url2 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=df2bea4491e7e31d4c644c3b17cb2d20");
                    HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
                    con2.setRequestMethod("GET");
                    con2.connect();
                    int rc2 = con2.getResponseCode();
                    //System.out.println(rc2);
                    if (rc2 != 200) {
                        System.out.println("Error in Connection Establishment");
                    } else {
                        String data2 = "";
                        Scanner sc2 = new Scanner(url2.openStream());
                        while (sc2.hasNext()) {
                            data2 += sc2.nextLine();
                        }
                        sc2.close();
                        //System.out.println(data2);
                        JSONParser para = new JSONParser();
                        JSONObject obj2 = (JSONObject) para.parse(data2);
                        //System.out.println(obj2);
                        JSONObject main =(JSONObject) obj2.get("main");
                        JSONObject wind = (JSONObject) obj2.get("wind");
                        //JSONObject visibility = (JSONObject) obj2.get("visibility");
                        double a =(double)main.get("temp");
                        float b = (float) (a-273.15);

                        whe.setText(
                                " ☁ Current Temp. ➡ " +(b)+ "°C"+
                                        "\n ☁ Humidity         ➡ "+ main.get("humidity") +"%"+
                                        "\n ☁ Wind Speed     ➡ " + wind.get("speed")+"Km/h"+
                                        "\n ☁ Visibility         ➡ " +obj2.get("visibility")+"m"+
                                        "\n ☁ Pressure         ➡ " + main.get("pressure") +"mBar");
                    }
                }
            }
        }
        catch(Exception f){
            System.out.println(f);
        }
    }
}


public class Main {

    public static void main(String[] args)
    {

        Myframe frame = new Myframe();
    }
}