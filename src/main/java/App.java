import com.google.gson.Gson;
import dao.Sql2oNewsDao;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oUsersDao;
import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oNewsDao newsDao;
        Sql2oDepartmentsDao departmentsDao;
        Sql2oUsersDao usersDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentsDao = new Sql2oDepartmentsDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();


        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(departments);
            res.status(201);
            res.type("application/json");
            return gson.toJson(departments);
        });


        post("/departments/new", "application/json", (req, res) -> {
            Departments departments = gson.fromJson(req.body(), Departments.class);
            departmentsDao.add(departments);
            res.status(201);
            return gson.toJson(departments);
        });
//        get: show all existing departments
        get("/departments", "application/json", (req, res) -> {
            return gson.toJson(departmentsDao.getAll());
        });
//        get: show specific department by id
        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentsDao.findById(departmentId));
        });
//        post: add new employee
        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            usersDao.add(users);
            res.status(201);
            return gson.toJson(users);
        });
//        get: show all users regardless of department
        get("/employees", "application/json", (req, res)->{
            return gson.toJson(usersDao.getAll());
        });

        get("/users/:id", "application/json", (req, res) -> {
            int employeeId = Integer.parseInt(req.params("id"));
            return gson.toJson(usersDao.findId(usersId));
        });
//        filters
        after((req, res) ->{
            res.type("application/json");
        });
        //        get: show all employees in a specific department
        get("/department/:deptId", "application/json", (req, res) ->{
//            int deptId = Integer.parseInt("deptId");
            int deptId = Integer.parseInt(req.queryParams("deptId"));
            Users users = gson.fromJson(req.body(), Users.class);
            departments.setDeptId(deptId);
            departmentsDao.getAllEmployeesInADept(deptId);
            res.status(201);
            return gson.toJson(users);
        });
//        post: create news
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });
//        get: show all generalNews
        get("/news", "application/json", (req, res)->{
            return gson.toJson(newsDao.getGeneralNews());
        });

//        get: show all departmentNews
        get("/departmentNews", "application/json", (req, res)->{
            return gson.toJson(departments.getDepartmentsNews());
        });
    }
    }
}
