/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.User;

/**
 *
 * @author Emili
 */
public class Archive {
    	public static void write(Object obj, String fileName) {
		try {
                    FileOutputStream f = new FileOutputStream(new File(fileName + ".txt"));
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    // Write objects to file
                    o.writeObject(obj);
                    o.close();
                    f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
        public static User read(String fileName){
            User buffer = null;
            try{
                FileInputStream f = new FileInputStream(new File(fileName + ".txt"));
                ObjectInputStream o = new ObjectInputStream(f);
                try {
                    buffer = (User) o.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Archive.class.getName()).log(Level.SEVERE, null, ex);
                }
                o.close();
                f.close();
            } catch (IOException e){
                System.err.println(e);
            }
            
            return buffer;
        }
}
