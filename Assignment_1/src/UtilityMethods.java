//import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.filechooser.FileSystemView;

public class UtilityMethods {
	 protected File f = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat");
	
	//Utility Methods (REGEX)http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
	 boolean passwordCheck(String password){
		Pattern reg = Pattern.compile("((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]))");
		Matcher eml = reg.matcher(password);
		if(eml.find()==true){
			return true; 
		}else{return false;}
	}
	 boolean emailCheck(String email){
		Pattern reg = Pattern.compile("^(.+)@(.+)$");
		Matcher eml = reg.matcher(email);
		if(eml.find()==true){
			return true; 
		}else{return false;}
	}
	 boolean phoneNumberCheck(String phoneNumber){
		Pattern reg = Pattern.compile("^\\d{0,3}[^s]\\d{0,3}[^s]\\d{0,10}"); //do you know how many phone number styles there are? A LOT hopefully this will handle most of them.
		Matcher eml = reg.matcher(phoneNumber);
		if(eml.find()==true){
			return true; 
		}else{return false;}
	 }
	 public boolean ssnCheck(String ssn){
	 	Pattern reg = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");
	 	Matcher eml = reg.matcher(ssn);
	 	if(eml.find()==true){
	 		return true; 
	 	}else{return false;}
	 }
	 public boolean usernameCheck(String username) throws IOException{
		boolean found; 
		FileInputStream fis;
		ObjectInputStream ois = null;
		List<String> arr = new ArrayList<String>(); 
		try { //this is one of the dirtier ways I've written something in a while...
			//Load serialized file to an array, now check if the thing has a match
			fis = new FileInputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat");
			
			while(true){
			ois = new ObjectInputStream(fis);
			User u = (User) ois.readObject(); 
			arr.add(u.getUsername()); 
			
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}  catch (IOException e) {
			//e.addSuppressed(e); //Because when it does this, it's actually doing fine...I realize I shouldn't choose such a corruptible method, but here we are.
			//ignore
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
				ois.close();
		}
		if(arr.contains(username)){
			found = true; 
			return found; 
		}else{found = false; return found;}
		//return found;
	 }

	 public void writeFile(User u){
		
	        try{ 	
	        		if(!f.exists()){
		        		new FileOutputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat", true).close();
		        		System.out.println("object flushed");
	        		}

	        		FileOutputStream fos = new FileOutputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat", true);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.reset();
					oos.writeObject(u);
					oos.flush();
					oos.close();
	        		
	        } catch (IOException e) {
	        	System.err.println("already exists: " + e.getMessage());
	        }
	     
	 }
	   	 public void readFile(){
		        try{ 	FileInputStream fis = new FileInputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat");
						ObjectInputStream ois = new ObjectInputStream(fis);
						User result = (User) ois.readObject();
						System.out.println(result.getUsername());
						ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	   	 }
	 public User getProfile(String username) throws IOException{

		 FileInputStream fis ; 
		ObjectInputStream ois = null;
		 User u;
		 int spot = 0; int grab = 0; 
			List<User> arr = new ArrayList<User>(); 
			try {
				fis = new FileInputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\" + "userInfo.dat");
				while(true){
				ois = new ObjectInputStream(fis);
				arr.add(u = (User) ois.readObject()); 
				//System.out.println(u.getUsername() + " " + arr.toString());

				}

			} catch (FileNotFoundException e1) {
				//e1.printStackTrace();
			}  catch (IOException e) {
				//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			} finally{	ois.close();}

			//Thank goodness this doesn't have THOUSANDS of records...this is inefficent.
			for(User temp: arr){
				if(username.equals(temp.getUsername())){
					grab = spot;
				}
				spot++;
			}
			
			u = arr.get(grab);
			//System.out.println(u.getUsername() + " " + grab);
		 return u; 
	 }
} 
