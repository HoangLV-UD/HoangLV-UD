/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.ThongKesp;
import JDBC.JdbcHelper;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ADMIN
 */
public  class ThongKeDao {

    String sql_sodon_today = "SELECT COUNT(DISTINCT MAHD) FROM HOADON WHERE NGAYTAO = DAY(GETDATE())";
    String sql_bieudongay = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where day(NGAYTAO)=day(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_bieudonthang = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where month(NGAYTAO)=month(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_bieudonnam = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where year(NGAYTAO)=year(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_doanhthutong_ngay_table = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán',sum(THANHTIEN) as N'Thành Tiền' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where day(NGAYTAO)=day(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_doanhthutong_Thang_table = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán',sum(THANHTIEN) as N'Thành Tiền' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where month(NGAYTAO)=month(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_doanhthutong_nam_table = "select CTSANPHAM.MASP,SUM(CTSANPHAM.SOLUONG) AS N'Số lượng bán',sum(THANHTIEN) as N'Thành Tiền' from CTHOADON join CTSANPHAM on CTHOADON.MASP=CTSANPHAM.MASP \n"
            + "	join HOADON on CTHOADON.MAHD=HOADON.MAHD where year(NGAYTAO)=year(getdate())\n"
            + "		group by CTSANPHAM.MASP";
    String sql_doanhthutong_ngay_label = "select sum(THANHTIEN)from CTHOADON join HOADON on CTHOADON.MAHD=HOADON.MAHD where day(NGAYTAO)=day(getdate())";
    String sql_doanhthutong_thang_label = "select sum(THANHTIEN)from CTHOADON join HOADON on CTHOADON.MAHD=HOADON.MAHD where year(NGAYTAO)=year(getdate())";
    String sql_doanhthutong_nam_label = "select sum(THANHTIEN)from CTHOADON join HOADON on CTHOADON.MAHD=HOADON.MAHD where month(NGAYTAO)=month(getdate())";
    String sql_spDanghoatdong = "SELECT  COUNT(MASP) FROM CTSANPHAM WHERE  TRANGTHAI = 1";
    String sql_sohoadonhuy = "SELECT  COUNT(MAHD) FROM HOADON WHERE day(NGAYTAO)=day(getdate()) AND TRANGTHAI = 5";
    String sql_sohoadonthanhcong = "SELECT  COUNT(MAHD) FROM HOADON WHERE day(NGAYTAO)=day(getdate()) AND (TRANGTHAI =1 OR TRANGTHAI = 4 )";
    public List<Integer> selectsodon_todaylabel() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql_sodon_today);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void loadchartngay(JPanel jpnItem) {
        List<ThongKesp> lst = Chart1_sp_ngay();
        jpnItem.removeAll();
        jpnItem.updateUI();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (lst != null) {
            for (ThongKesp tk : lst) {
                dataset.addValue(tk.getSoluong(), "Dịch Vụ", tk.getTen());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng dịch vụ đã bán hôm nay".toUpperCase(),
                "Tên Dịch Vụ", "Số Lượng Đã bán",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 550));

        jpnItem.setLayout(new CardLayout());
        jpnItem.setBackground(Color.yellow);
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();

    }

    private List<ThongKesp> getListOfArray_thongke_spban(String sql, String[] cols, Object... args) {
        try {
            List<ThongKesp> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                ThongKesp a = new ThongKesp();
                a.setTen(rs.getString(1));
                a.setSoluong(rs.getInt(2));
                list.add(a);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ThongKesp> Chart1_sp_ngay() {

        String[] cols = {"MASP", "Số lượng bán"};
        return this.getListOfArray_thongke_spban(sql_bieudongay, cols);
    }

    public List<ThongKesp> Chart1_sp_Thang() {

        String[] cols = {"MASP", "Số lượng bán"};
        return this.getListOfArray_thongke_spban(sql_bieudonthang, cols);
    }

    public List<ThongKesp> Chart1_sp_nam() {

        String[] cols = {"MASP", "Số lượng bán"};
        return this.getListOfArray_thongke_spban(sql_bieudonnam, cols);
    }

    public List<Object[]> getDoanhThu_ngay_table() {

        String[] cols = {"MASP", "Số lượng bán", "Thành Tiền"};
        return this.getListOfArray(sql_doanhthutong_ngay_table, cols);
    }

    public List<Object[]> getDoanhThu_Thang_table() {

        String[] cols = {"MASP", "Số lượng bán", "Thành Tiền"};
        return this.getListOfArray(sql_doanhthutong_Thang_table, cols);
    }

    public List<Object[]> getDoanhThu_nam_table() {

        String[] cols = {"MASP", "Số lượng bán", "Thành Tiền"};
        return this.getListOfArray(sql_doanhthutong_nam_table, cols);
    }

    public List<Long> selectdaonhthu_ngay_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_doanhthutong_ngay_label);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Long> selectdaonhthu_Thang_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_doanhthutong_thang_label);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*Don huy*/
    public List<Long> selectdonHuy_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_sohoadonhuy);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Long> selectdonThanhCong_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_sohoadonthanhcong);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Long> selectsanphamHD_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_spDanghoatdong);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Long> selectdaonhthu_nam_label() {

        List<Long> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql_doanhthutong_nam_label);
            while (rs.next()) {
                list.add(rs.getLong(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadchartthang(JPanel jpnItem) {
        List<ThongKesp> lst = Chart1_sp_Thang();
        jpnItem.removeAll();
        jpnItem.updateUI();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (lst != null) {
            for (ThongKesp tk : lst) {
                dataset.addValue(tk.getSoluong(), "Dịch Vụ", tk.getTen());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng dịch vụ đã bán tháng này".toUpperCase(),
                "Tên Dịch Vụ", "Số Lượng Đã bán",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 550));

        jpnItem.setLayout(new CardLayout());
        jpnItem.setBackground(Color.yellow);
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    public void loadchartnam(JPanel jpnItem) {
        List<ThongKesp> lst = Chart1_sp_nam();
        jpnItem.removeAll();
        jpnItem.updateUI();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (lst != null) {
            for (ThongKesp tk : lst) {
                dataset.addValue(tk.getSoluong(), "Dịch Vụ", tk.getTen());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng dịch vụ đã bán tháng này".toUpperCase(),
                "Tên Dịch Vụ", "Số Lượng Đã bán",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 550));

        jpnItem.setLayout(new CardLayout());
        jpnItem.setBackground(Color.yellow);
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
