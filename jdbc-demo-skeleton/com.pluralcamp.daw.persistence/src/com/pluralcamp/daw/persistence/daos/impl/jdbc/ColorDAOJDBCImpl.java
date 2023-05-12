package com.pluralcamp.daw.persistence.daos.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

import java.util.List;

public class ColorDAOJDBCImpl implements ColorDAO {
    @Override
    public Color getColorById(long id) throws DAOException {
        Color color = null;

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris", "root", "admin");
                 PreparedStatement sentSQL = connection.prepareStatement("SELECT id, name, red, gree, bkue FROM colors WHERE id = ?");){

                sentSQL.setLong(1, id);
                try (ResultSet reader = sentSQL.executeQuery()) {
                    if (reader.next()) {
                        color = new Color(reader.getString("name"), reader.getInt("red"), reader.getInt("green"), reader.getInt("blue"));
                        color.sentID(reader.getLong("id"));
                    }
            }

            } 
            catch (SQLException ex) {
                //Logger
                throw new DAOException(ex);
            }
        
        return color;
    }

    @Override
    public List<Color> getColors() throws DAOException {
        List<Color> colors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris", "root", "admin")
        );        
        return null;
    }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
}
