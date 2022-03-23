package realestate.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.context.annotation.Configuration;

// .txt Dosya uzantısında istediğimiz bir yeri kayıt altına almamızı sağlar.

@Configuration
public class FileLogger implements LogOperation {

	@Override
	public void logOperation(String message) {
		writeFolderTxt(message);		
	}
	
	public void writeFolderTxt(String content){
        try{
              File folderPath = new File("C:\\Record\\kayit.txt");
              FileWriter writerPath = new FileWriter(folderPath);
              BufferedWriter writer = new BufferedWriter(writerPath);
              writer.write(content);
              writer.close();
              System.out.println("Txt Dosyası Kayıdı alınmıştır.");
        }
        catch(Exception error){
              error.printStackTrace();
        }
  }

}
