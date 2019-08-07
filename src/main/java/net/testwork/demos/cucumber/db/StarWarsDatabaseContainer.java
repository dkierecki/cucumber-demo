package net.testwork.demos.cucumber.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.testcontainers.containers.MySQLContainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StarWarsDatabaseContainer extends MySQLContainer<StarWarsDatabaseContainer> {
    private static final String INIT_SCRIPT = "db/init_db.sql";
    private static StarWarsDatabaseContainer container;

    private HikariDataSource dataSource;

    public static StarWarsDatabaseContainer getInstance() {
        if (container == null) {
            container = new StarWarsDatabaseContainer().withInitScript(INIT_SCRIPT);
        }
        return container;
    }

    public ResultSet performQuery(String sql) throws SQLException {
        if (dataSource == null) {
            initDatasource();
        }

        Statement statement = dataSource.getConnection().createStatement();
        statement.execute(sql);

        return statement.getResultSet();
    }

    private void initDatasource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setDriverClassName(container.getDriverClassName());

        dataSource = new HikariDataSource(hikariConfig);
    }
}
