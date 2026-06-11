package batch.nine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class API {
    private Connection connection;
    public API(){connection = Connecting.getConnect();}
    public void deleteById(int id){
        try{
            String qry = "delete from patients where id=?";
            PreparedStatement ps = connection.prepareStatement(qry);
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if(count!=0)System.out.println(id+" has been deleted");
            else System.out.println("Invlaid id");
            ps.close();
        }catch(SQLException s){s.printStackTrace();}
    }
    public void findAll(){
        try{
            String qry = "select * from patients";
            PreparedStatement stmt = connection.prepareStatement(qry);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(
                    rs.getString("name")+" "+
                    rs.getInt("id")+" "+
                    rs.getInt("age")+" "+
                    rs.getString("gender")+" "+
                    rs.getDouble("bmi")
                );
            }stmt.close();
        }catch(SQLException s){s.printStackTrace();}
    }
    public void updateTable(int id, double wt){
        try{
            String qry = "select height from patients where id=?";
            PreparedStatement state = connection.prepareStatement(qry);
            state.setInt(1, id);
            ResultSet rs = state.executeQuery();
            if(!rs.next()) System.out.println("No Patients record");
            else {
                double ht = rs.getDouble("height"),bmi=wt/(ht*ht);
                qry = "update patients set weight=?, bmi=? where id=?";
                state = connection.prepareStatement(qry);
                state.setDouble(1, wt);
                state.setDouble(2, bmi);
                state.setInt(3, id);
                int count = state.executeUpdate();
                if(count!=0) System.out.println(id+" weight & bmi updated");
                else System.out.println("Update failed");
                state.close();
            }
        }catch(SQLException s){s.printStackTrace();}
    }
    public void createTable(){
        try{
            String qry = "create table patients(id int not null primary key auto_increment,name varchar(255) not null, gender varchar(10) not null, age int not null, height double not null, weight double not null,bmi double not null)";
            PreparedStatement state = connection.prepareStatement(qry);
            state.execute();
            System.out.println("Table has created");
            state.close();
        }catch(SQLException s){}
    }
    public void insertRecord(String nm, String gen, int age, double ht,
         double wt){   
        try{
            ht/=100;// cm to m
            double bmi = wt/(ht*ht);
            String qry = "insert into patients(name,gender,age,height,weight,bmi) values(?,?,?,?,?,?)";
            PreparedStatement state = connection.prepareStatement(qry);
            state.setString(1, nm);state.setString(2, gen);
            state.setInt(3,age);state.setDouble(4, ht);
            state.setDouble(5, wt);state.setDouble(6, bmi);
            int count = state.executeUpdate();
            if(count!=0) System.out.println("Patient "+nm+" registered");
            else System.out.println(nm+" hasn't registered");
            state.close();
        }catch(SQLException s){s.printStackTrace();}
    }
}
