package com.lovo.EntInfoMan.dao.impl;

import com.lovo.EntInfoMan.bean.Address;
import com.lovo.EntInfoMan.dao.AddressDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends com.lovo.EntInfonMan.Util.DBUtil implements AddressDao {
    @Override
    public int add(Address address) {
        try {
            connection();

            sql = "insert into address(id,name,sex,mobile,email,qq,company,address,postcode) values(null,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, address.getName());
            ps.setString(2, address.getSex());
            ps.setString(3, address.getMobile());
            ps.setString(4, address.getEmail());
            ps.setString(5, address.getQq());
            ps.setString(6, address.getCompany());
            ps.setString(7, address.getAddress());
            ps.setInt(8, address.getPostcode());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }

    @Override
    public int updata(Address address) {
        try {
            connection();

            sql = "update address set name=?, sex=?, mobile=?, email=?, qq=?, company=?, address=?, postcode=? where id=?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, address.getName());
            ps.setString(2, address.getSex());
            ps.setString(3, address.getMobile());
            ps.setString(4, address.getEmail());
            ps.setString(5, address.getQq());
            ps.setString(6, address.getCompany());
            ps.setString(7, address.getAddress());
            ps.setInt(8, address.getPostcode());
            ps.setInt(9, address.getId());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }

    @Override
    public List<Address> getlist(int pageNo, int pageSize) {

        List<Address> list = new ArrayList<>();

        try {
            connection();

            sql = "select * from address limit ?,?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, (pageNo - 1) * pageSize < 0 ? 0 : (pageNo - 1) * pageSize);
            ps.setInt(2, pageSize);

            rs = ps.executeQuery();

            while (rs.next()) {
                Address address = new Address();

                address.setId(rs.getInt(1));
                address.setName(rs.getString(2));
                address.setSex(rs.getString(3));
                address.setMobile(rs.getString(4));
                address.setEmail(rs.getString(5));
                address.setQq(rs.getString(6));
                address.setCompany(rs.getString(7));
                address.setAddress(rs.getString(8));
                address.setPostcode(rs.getInt(9));

                list.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

//    @Override
    public Address getAdderss(int id) {

        Address address = new Address();

        try {
            connection();

            sql = "select * from address where id=?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                address.setId(rs.getInt(1));
                address.setName(rs.getString(2));
                address.setSex(rs.getString(3));
                address.setMobile(rs.getString(4));
                address.setEmail(rs.getString(5));
                address.setQq(rs.getString(6));
                address.setCompany(rs.getString(7));
                address.setAddress(rs.getString(8));
                address.setPostcode(rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return address;
    }

    @Override
    public int getTotalNum() {
        try {
            connection();

            sql = "select count(*) from address";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                n = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }

    @Override
    public int del(int id) {
        try {
            connection();

            sql = "delete from address where id=?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return n;
    }
}
