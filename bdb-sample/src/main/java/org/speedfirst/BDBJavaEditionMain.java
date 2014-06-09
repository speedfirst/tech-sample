package org.speedfirst;

import com.sleepycat.je.*;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * NOTE BDB Java Edition cannot share data with native BDB!!
 *
 */
public class BDBJavaEditionMain {
    public static void main(String[] args) throws DatabaseException, UnsupportedEncodingException {

        // open an environment
        EnvironmentConfig environmentConfig = new EnvironmentConfig();
        environmentConfig.setAllowCreate(true);
        Environment dbEnvironment = new Environment(new File("."), environmentConfig);


        // open a database
        DatabaseConfig databaseConfig = new DatabaseConfig();
        databaseConfig.setAllowCreate(true);
        Database database = dbEnvironment.openDatabase(null, "test-bdb", databaseConfig);

        // prepare key and value
        String key = "test-key";
        String value = "this is a test value for berkeley db";

        DatabaseEntry keyEntry = new DatabaseEntry(key.getBytes("UTF-8"));
        DatabaseEntry valueEntry = new DatabaseEntry(value.getBytes("UTF-8"));

        database.put(null, keyEntry, valueEntry);


        if (database != null) {
            database.close();
        }

        if (dbEnvironment != null) {
            dbEnvironment.close();
        }


    }
}
