import java.awt.*;
import javax.swing.*;
public class PokemonCard extends JFrame{
    private IPokemon actor;
    private int size = 25;
    private int pad = 10;
    public PokemonCard(IPokemon actor){
        this.actor = actor;
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(actor.getName());
        Font f = new Font("Arial", Font.BOLD, size);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(Color.WHITE);
        JLabel title = new JLabel(actor.getName());
        title.setFont(f);
        p.add(title, BorderLayout.NORTH);
        JPanel main = new MainPanel();       
        p.add(main, BorderLayout.CENTER);
        add(p);
        setVisible(true);
    }

    private class MainPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            g.drawImage(actor.getImage(), 0, 0, this.getWidth(), this.getHeight()/3*2, this);
            g.setFont(new Font("Arial", Font.BOLD, size));
            g.drawString("\tName: \t" + actor.getName(), this.getWidth()/5, this.getHeight()/3*2 + pad);
            g.drawString("\tType: \t" + actor.getType(), this.getWidth()/5, this.getHeight()/3*2+ size + pad);
            g.drawString("\tHP: \t" + actor.getHP(), this.getWidth()/5, this.getHeight()/3*2 + 2*(size + pad)); 
        }
    }
}