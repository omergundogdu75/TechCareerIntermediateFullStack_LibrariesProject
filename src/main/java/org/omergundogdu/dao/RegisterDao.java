package org.omergundogdu.dao;

import org.omergundogdu.dto.RegisterDto;
import org.omergundogdu.exception.NotFound404Exception;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// for Database & Java Core
public class RegisterDao implements IDaoGenerics<RegisterDto> {

    /*
    Transaction
    connection.setAutoCommit(false); // default:true
    connection.commit(); // başarılı
    connection.rollback(); // başarısız
    */

    // SPEED DATA
    @Override
    public String speedData(Long id) {
        return null;
    }

    // ALL DELETE
    @Override
    public String allDelete() {
        return null;
    }

    // CREATE
    // transaction: create,delete,update
    @Override
    public void create(RegisterDto registerDto) {
        try (Connection connection = getInterfaceConnection()) {
            // transaction: ya hep ya hiç kuralıdır.
            connection.setAutoCommit(false); // default:true
            String sql = "INSERT INTO `libraries`.`register` (`nick_name`, `email_address`, `password`,`remaining_number`,`is_passive`) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, registerDto.getuNickName());
            preparedStatement.setString(2, registerDto.getuEmailAddress());
            preparedStatement.setString(3, registerDto.getuPassword());
            preparedStatement.setInt(4, registerDto.getRemainingNumber());
            preparedStatement.setBoolean(5, registerDto.getPassive());
            // Ekleme yapmak
            // rowEffected=-1 eklenmemiştir.
            Integer rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println(RegisterDao.class + " Ekleme tamamdır");
                connection.commit();
            } else {
                System.err.println(RegisterDao.class + " Ekleme yapılmadı");
                connection.rollback();
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //end create

    // FIND BY ID
    @Override
    public RegisterDto findById(Long id) {
        RegisterDto registerDto = new RegisterDto();
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from `libraries`.`register` where id=" + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setuNickName(resultSet.getString("nick_name"));
                registerDto.setuEmailAddress(resultSet.getString("email_address"));
                registerDto.setuPassword(resultSet.getString("password"));
                registerDto.setRemainingNumber(resultSet.getInt("remaining_number"));
                registerDto.setPassive(resultSet.getBoolean("is_passive"));
                registerDto.setSystemCreatedDate(resultSet.getDate("system_created_date"));
            }
            System.out.println(registerDto);
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registerDto;
    }

    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        ArrayList<RegisterDto> list = new ArrayList<>();
        RegisterDto registerDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from `libraries`.`register`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // eğer burada new(instance) yapmazsak sadece son veriiyi ekler
                registerDto = new RegisterDto();
                registerDto.setId(resultSet.getLong("id"));
                registerDto.setuNickName(resultSet.getString("nick_name"));
                registerDto.setuEmailAddress(resultSet.getString("email_address"));
                registerDto.setuPassword(resultSet.getString("password"));
                registerDto.setRemainingNumber(resultSet.getInt("remaining_number"));
                registerDto.setPassive(resultSet.getBoolean("is_passive"));
                registerDto.setSystemCreatedDate(resultSet.getDate("system_created_date"));
                list.add(registerDto);
            }
            list.forEach(System.out::println);
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    // transaction: create,delete,update
    @Override
    public RegisterDto update(Long id, RegisterDto registerDto) {
        // İlgili ID nesne varsa update yapsın
        RegisterDto registerFindById = findById(id);
        if (registerFindById != null) {
            try (Connection connection = getInterfaceConnection()) {
                // transaction: ya hep ya hiç kuralıdır.
                connection.setAutoCommit(false); // default:true
                String sql = "UPDATE  `libraries`.`register` SET nick_name=?, email_address=?, password=?,remaining_number=?,is_passive=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, registerDto.getuNickName());
                preparedStatement.setString(2, registerDto.getuEmailAddress());
                preparedStatement.setString(3, registerDto.getuPassword());
                preparedStatement.setInt(4, registerDto.getRemainingNumber());
                preparedStatement.setBoolean(5, registerDto.getPassive());
                // Ekleme yapmak
                Integer rowsEffected = preparedStatement.executeUpdate();
                if (rowsEffected > 0) {
                    System.out.println(RegisterDao.class + " Güncelleme tamamdır");
                    connection.commit();
                } else {
                    System.err.println(RegisterDao.class + " Güncelleme yapılmadı");
                    connection.rollback();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NotFound404Exception((id + "veri bulunamadı!!!"));
        }
        return registerDto;
    }

    // DELETE
    // transaction: create,delete,update
    @Override
    public RegisterDto delete(RegisterDto registerDto) {
        // İlgili ID nesne varsa update yapsın
        RegisterDto registerFindById = findById(registerDto.getId());
        if (registerFindById != null) {
            try (Connection connection = getInterfaceConnection()) {
                // transaction: ya hep ya hiç kuralıdır.
                connection.setAutoCommit(false); // default:true
                String sql = "DELETE FROM `libraries`.`register` WHERE `id` =" + registerDto.getId();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, registerDto.getId());
                // Ekleme yapmak
                Integer rowsEffect = preparedStatement.executeUpdate();
                if (rowsEffect > 0) {
                    System.out.println(RegisterDao.class + " Ekleme tamamdır");
                    connection.commit();
                } else {
                    System.err.println(RegisterDao.class + " Ekleme yapılmadı");
                    connection.rollback();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NotFound404Exception((registerDto.getId() + "veri bulunamadı!!!"));
        }
        return registerDto;
    }

} //end class