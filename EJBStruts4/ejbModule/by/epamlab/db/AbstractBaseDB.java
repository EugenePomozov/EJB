
package by.epamlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public abstract class AbstractBaseDB {
	
	
	static{
		try {
		Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection()  {
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost/struts_ejb",
					"root","");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	protected void closeResultSets(ResultSet... rs)  {
		try {
			for (ResultSet r : rs) {
				if (r != null) {
					r.close();
				}
			}
		} catch (Exception e) {
			
		}
	}

	protected void closeStatements(Statement... st)  {
		try {
			for (Statement s : st) {
				if (s != null) {
					s.close();
				}
			}

		} catch (Exception e) {
			
		}
	}

	protected void closeConnection(Connection cn) {
		try {
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e) {
			System.err.println("error close connection" + e);
		}
	}
	protected void closeAll(ResultSet rs, Statement st,Connection cn) {
		closeResultSets(rs);
		closeStatements(st);
		closeConnection(cn);
	}
	protected void closeAll(Statement st,Connection cn) {
		closeStatements(st);
		closeConnection(cn);
	}
	protected void closeAll(ResultSet rs, Statement st) {
		closeResultSets(rs);
		closeStatements(st);
	}

}
