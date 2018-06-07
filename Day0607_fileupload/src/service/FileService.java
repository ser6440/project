package service;

import java.util.List;

import dao.Filedao;

public class FileService {
	
	private static FileService instance;
	
	public static FileService getInstance() {
		if(instance == null) {
			instance = new FileService();
		}
		return instance;
	}
	
	Filedao filedao;
	
	public FileService() {
		filedao = Filedao.getInstance();
	}
	public boolean uploadFile(String fileName) {
		int result = filedao.insertFile(fileName);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	public List<String> getAllFileNames(){
		List<String> files;
		
//		files = filedao.selectAllFiles();
		return filedao.selectAllFiles();
		//위에 둘중 아무거나 해도 상관없음
		
	}
}
