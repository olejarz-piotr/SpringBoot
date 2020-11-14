package pl.olejarz.CarAppWithVaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Car car){
        String sql="INSERT INTO Car VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                car.getId(),
                car.getMark(),
                car.getModel(),
                car.getColor()

        });
    }

    public List<Map<String,Object>> showByMark(String mark){
        String sql="SELECT * FROM Car WHERE mark LIKE ?";
       return jdbcTemplate.queryForList(sql,new Object[]{mark});
    }



    @EventListener(ApplicationReadyEvent.class)
    public void dbInit(){
        save(new Car(1,"BMW", "E91", "Black"));
        save(new Car(2,"BMW", "E24", "Green"));
        save(new Car(3,"Nissan", "R34", "Blue"));
        save(new Car(4,"Toyota", "Supra", "Orange"));


//        String sql ="CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar(255));";
//        getJdbcTemplate().update(sql);
    }
}
