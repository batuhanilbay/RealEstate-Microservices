package realestate.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.context.annotation.Configuration;

//Txt Dosyası İçin FileLogger Sınıfı
@Configuration
public class FileLogger implements LogOperation {

	@Override
	public void logOperation(String message) {
				System.out.println("Txt dosyasına yazma işlemi.");
				writeFolderTxt(message);
	}
	
	public void writeFolderTxt(String content){
          try{
                File folderPath = new File("C:\\Record\\kayit.txt");
                FileWriter writerPath = new FileWriter(folderPath);
                BufferedWriter writer = new BufferedWriter(writerPath);
                writer.write(content);
                writer.close();
                System.out.println("Ödeme işlemi kayıt altına alındı.");
          }
          catch(Exception error){
                error.printStackTrace();
          }
    }
	

	
}
