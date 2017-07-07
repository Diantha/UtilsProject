package controller.primitive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


@Stateless
public class PrimitiveFileFunctions {
	private static final Log log = LogFactory.getLog(PrimitiveFileFunctions.class);

	public boolean checkIfFileExist(String filePathString){
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory())
			return true;
		else
			return false;
	}

	public boolean deleteSingleFile(String pathfileTodelet) throws Exception{

		File fileTodelet=  new File(pathfileTodelet);
		log.info("fileTodelet " +fileTodelet.getAbsolutePath());
		try{
			boolean del= fileTodelet.delete();
			log.info(fileTodelet + " : got deleted ? " + del);
			log.info(fileTodelet.getName() + " has been delected?"+del);
			return del;
		}catch(Exception e){
			throw new Exception();
			//String msg = "Non e' stato possibile eliminare il file : "+fileTodelet.toString();
//						int error = WSErrorCode.ERR_FILE_NOT_FOUND;
//						log.error(msg + " (" + error + ")");
//						throw new WSException(error, msg);
		}
	}

	public void deleteAllFiles(File folder) throws IOException {
		//rimuovi tutti i file di una directory
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				log.info(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				//  deleteFiles(file);
			}
		}
	}

	public void checkZipDimension(List<File> sources){
		int totalBytedimension=11000; //dimensione in bytes massima
		int somma=0;
		for (File source : sources)
		{
			somma=somma +(int) (source.length());
		}

		log.info("somma : " +somma);
		if(somma>totalBytedimension)
		{
			int numberOfFilesToRemove=sources.size();
			sources.remove(numberOfFilesToRemove-1);
			sources.remove(numberOfFilesToRemove-2);
			sources.remove(numberOfFilesToRemove-3);
			sources.remove(numberOfFilesToRemove-4);
		}
	}



	//Copia file

	@SuppressWarnings("unused")
	private void copyFile(File input,String output) throws IOException{
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		try{
			File outfile =new File(output);
			instream = new FileInputStream(input);
			outstream = new FileOutputStream(outfile);
			byte[] buffer = new byte[1024];
			int length;
			//copying the contents from input stream to
			// output stream using read and write methods
			//
			while ((length = instream.read(buffer)) > 0){
				outstream.write(buffer, 0, length);
			}
			//Closing the input/output file streams
			instream.close();
			outstream.close();
		}catch(IOException ioe){
			throw new IOException();
//			String msg = "Non e'stato trovato il file";
//			int error = WSErrorCode.ERR_FILE_NOT_FOUND;
//			log.error(msg + " (" + error + ")");
//			throw new WSException(error, msg);

		}
	}

	public String convertPdfToString(String pathPdf){
		String totalString="";
		try {

			PdfReader reader = new PdfReader(pathPdf);
			// System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
			log.info("Il pdf scelto ha "+reader.getNumberOfPages()+" pagine");
			for(int i=1;i<=reader.getNumberOfPages();i++){
				String page = PdfTextExtractor.getTextFromPage(reader, i);
				totalString=totalString+page;
			}
			//  System.out.println("Page Content:\n\n"+page+"\n\n");
			//  System.out.println("Is this document tampered: "+reader.isTampered());
			//  System.out.println("Is this document encrypted: "+reader.isEncrypted());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return totalString;
	}
	
	public void convertStringToByte(byte[] input, String pathOutPutFile) throws IOException{
			// convert file to byte[]
			//byte[] bFile = readBytesFromFile("C:/Users/l.cattalani/Desktop/poste.xml");

			//java nio
			//byte[] bFile = Files.readAllBytes(new File("C:\\temp\\testing1.txt").toPath());
			//byte[] bFile = Files.readAllBytes(Paths.get("C:\\temp\\testing1.txt"));

			// save byte[] into a file
			Path path = Paths.get(pathOutPutFile);
			Files.write(path, input);
	}
	
	public byte[] readBytesFromFile(String filePath) {

		FileInputStream fileInputStream = null;
		byte[] bytesArray = null;

		try {

			File file = new File(filePath);
			bytesArray = new byte[(int) file.length()];

			//read file into bytes[]
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytesArray);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return bytesArray;

	}
	public void removeAllFileFromDirectoryContract(String contractPathFile) throws IOException{
		contractPathFile=contractPathFile.substring(0, contractPathFile.length()-4);
		int position=1;
	    for(int i = contractPathFile.length()-1;i>0;i--){
	    	if(contractPathFile.charAt(i)=='/')
	    		break;
	    	else
	    		position++;
	    }
	    contractPathFile=contractPathFile.substring(0, contractPathFile.length()-position);
	    File directory= new File(contractPathFile);
	    FileUtils.cleanDirectory(directory); 
	}
//	public String[] fileStartWith(String path, String start){
//
//		File f = new File(path);
//		String[] result = f.list(new MyFilter(start));
//
//		return result;
//	}
	
}
