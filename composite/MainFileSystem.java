package composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
	void showDetails();
}

class File implements FileSystemItem {
	private String name;
	private String topic;
	
	public File(String name, String topic) {
		this.name = name;
		this.topic = topic;
	}
	
	@Override
	public void showDetails() {
		System.out.println("File: " + name + " | Topic: " + topic);
	}
	
}

class Folder implements FileSystemItem {

	private String name;
	private String topic;
	private List<FileSystemItem> files = new ArrayList<FileSystemItem>();
	
	public Folder(String name, String topic) {
		this.name = name;
		this.topic = topic;
	}
	public void addFile(FileSystemItem file) {
		files.add(file);
	}
	public void addFile(List<FileSystemItem> files) {
		this.files.addAll(files);
	}
	public void removeFile(FileSystemItem file) {
		files.remove(file);
	}
	public void removeFile(List<FileSystemItem> files) {
		this.files.removeAll(files);
	}
	public void emptyFolder() {
		this.files.clear();
	}
	
	@Override
	public void showDetails() {
		System.out.println("Folder: "+ name + " - Topic: " + topic);
		System.out.println("     Files of Folder: ");
		for (FileSystemItem fileSystemItem : files) {
			System.out.print("          ");
			fileSystemItem.showDetails();
		}
	}
}



public class MainFileSystem {
	public static void main(String[] args) {
		FileSystemItem file1 = new File("DNA", "Biology");
		FileSystemItem file2 = new File("Genes", "Biology");
		FileSystemItem file3 = new File("Diseases", "Biology");
		FileSystemItem file4 = new File("Vaccines", "Biology");
		Folder bioFolder = new Folder("Biology Material", "Biology");
		bioFolder.addFile(file1);
		bioFolder.addFile(file2);
		bioFolder.addFile(file3);
		bioFolder.addFile(file4);
		bioFolder.showDetails();
	
	}
}
