import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
       //Delete
        Connection connection=null;
        DbHelper Helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection=Helper.getConnection();
            String sql="delete from world.city where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4093);
            int result = statement.executeUpdate();
            System.out.println("Kayıt Silindi");
        }catch (SQLException exception){
            Helper.showErrorMessage(exception);
        }finally {
           statement.close();
            connection.close();
        }
    }
    public static void selectDemo()throws SQLException{
        Connection connection=null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection=dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,continent,region from world.country");
            ArrayList<Country> countries=new ArrayList<Country>();
            while (resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
    }
    //Insert
    public static void  insertDate() throws SQLException {
        ;
        Connection connection = null;
        DbHelper Helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = Helper.getConnection();
            String sql = "insert into world.city(Name,CountryCode,District,Population) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Düzce iki");
            statement.setString(2, "TUR");
            statement.setString(3, "Düzce iki");
            statement.setInt(4, 70000);
            int result = statement.executeUpdate();
            System.out.println("Kayıt Eklendi");
        } catch (SQLException exception) {
            Helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public void updateDate() throws SQLException{
        //update
        Connection connection=null;
        DbHelper Helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection=Helper.getConnection();
            String sql="update world.city set population=80000,district='TÜS' where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4094);
            int result = statement.executeUpdate();
            System.out.println("\n" + "Record Updated");
        }catch (SQLException exception){
            Helper.showErrorMessage(exception);
        }finally {
            statement.close();
            connection.close();
        }
    }
}
