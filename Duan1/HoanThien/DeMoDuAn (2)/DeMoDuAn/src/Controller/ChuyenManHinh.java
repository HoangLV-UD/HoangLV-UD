
package Controller;

import Bean.DanhMuc;
import GUI.BanHangJPanel;
import GUI.KhachHangJPanel;
import GUI.KhuyenMaiJPanel;
import GUI.NhanVienJPanel;
import GUI.SanPhamJPanel;
import GUI.ThongKeJpanel;
import GUI.TrangchuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class ChuyenManHinh {
    private JPanel root;
    private String kindSelected = "";
    List<DanhMuc> listItem = null;

    public ChuyenManHinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jblItem){
        kindSelected = "Trangchu";
        jpnItem.setBackground(new Color(96,100,191));
        jblItem.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangchuJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMuc> listItem){
        this.listItem = listItem;
        for(DanhMuc item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        

        @Override
        public void mouseClicked(MouseEvent e) {
          switch(kind){
              case "Trangchu":
                  node = new TrangchuJPanel();
                  break;
              case "BanHang":
                  node = new BanHangJPanel();
                  break;
              case "KhachHang":
                  node =  new KhachHangJPanel();
                  break;
              case "NhanVien":
                  node =  new NhanVienJPanel();
                  break;      
               case "ThongKe":
                  node =  new ThongKeJpanel();
                  break;
                case "SanPham":
                  node =  new SanPhamJPanel();
                  break;
              default:
                  node = new TrangchuJPanel();
                  break;
          }
          root.removeAll();
          root.setLayout(new BorderLayout());
          root.add(node);
          root.validate();
          root.repaint();
          setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jlbItem.setBackground(new Color(96, 100, 191));
           jpnItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           jlbItem.setBackground(new Color(96, 100, 191));
           jpnItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jlbItem.setBackground(new Color(76, 175, 80));
                jpnItem.setBackground(new Color(76, 175, 80));
            }
        }
        
    }
    private void setChangeBackground(String kind){
        for(DanhMuc item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            }else{
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
       
}
