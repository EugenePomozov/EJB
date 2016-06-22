package by.epamlab.ejbs;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

//import by.epamlab.ConnectionHome;
//import by.epamlab.ConnectionRemote;
import by.epamlab.db.AbstractBaseDB;

public class UserSvBean implements SessionBean {
//	public class UserBean extends AbstractBaseDB implements SessionBean {

	private static final long serialVersionUID = 1L;
	
	public String getReservation(String userName, String password){
		/* final  String TABLE_USER = "users";
		 final  String COLOMN_LOGIN = "userName";
		 final  String COLOMN_PASSWORD = "password";
		 final  String COLOMN_FILE = "dataFile";
		// -users
		final  String SELECT_LOGIN = "SELECT " + COLOMN_PASSWORD + ", " + COLOMN_FILE + " FROM " + TABLE_USER
				+ " WHERE " + COLOMN_LOGIN + " = ?";
		String reservation = "";
		//DataSource ds = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		InitialContext ic;
		try {
			ic = new InitialContext();
			Object ref =  ic.lookup("ConnectionBean");
			ConnectionHome home = (ConnectionHome) PortableRemoteObject.narrow(ref,
					ConnectionHome.class);
			ConnectionRemote bean = (ConnectionRemote) home.create();
			//ds = (DataSource) ic.lookup("java:/SqlDS");
			//con = ds.getConnection();
			con = bean.getConnection();
			System.out.println(con);
			pr = con.prepareStatement(SELECT_LOGIN);
			pr.setString(1, userName);
			rs = pr.executeQuery();
			if (rs.next()) {
				String pass = rs.getString(COLOMN_PASSWORD);
				if (pass.equals(password)) {
					reservation = rs.getString(COLOMN_FILE);
				}
			}

		} catch (Exception e) {
			// ...delayed implementation
			System.out.println("\n>>>>>>Error>>>>>>UserBean:\n" + e.getMessage() + "\n");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pr != null) {
				try {
					pr.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return reservation;
	}*/
		
		if(userName.equals("user") &&password.equals("user")){
			return "0004257753";
		}
		if(userName.equals("admin") &&password.equals("admin")){
			return "0004257753";
		}
		return "";
	}
	public UserSvBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}
	public void ejbCreate() throws EJBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

}
