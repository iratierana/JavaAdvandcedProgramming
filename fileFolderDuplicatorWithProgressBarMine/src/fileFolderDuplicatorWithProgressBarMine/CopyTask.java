package fileFolderDuplicatorWithProgressBarMine;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import fileFolderDuplicatorWithProgressBarMine.Window;

public class CopyTask extends SwingWorker<Void, Integer>{
   
	private File source;
    private File target;
    
    private JProgressBar progressBar;
    
    private long totalBytes = 0L;
    private long copiedBytes = 0L;

    public CopyTask(File source, File target, JProgressBar progressBar){
        this.source = source;
        this.target = target;
        this.progressBar = progressBar;

        progressBar.setValue(0);
    }

    @Override
    public Void doInBackground() throws Exception{
    	copyFiles(source, target);
    }

    @Override
    public void process(List<Integer> chunks){
    	for(int i : chunks){
    		progress.setValue(i);
    	}
    }
    {
        for(int i : chunks)
        {
            progressCurrent.setValue(i);
        }
    }

    @Override
    public void done()
    {
        setProgress(100);
        btnCopy.setText("Copy");
    }

    private void retrieveTotalBytes(File sourceFile)
    {
        File[] files = sourceFile.listFiles();
        for(File file : files)
        {
            if(file.isDirectory()) retrieveTotalBytes(file);
            else totalBytes += file.length();
        }
    }

    private void copyFiles(File sourceFile, File targetFile) throws IOException{
        if(sourceFile.isDirectory()){
            if(!targetFile.exists()) targetFile.mkdirs();

            String[] filePaths = sourceFile.list();

            for(String filePath : filePaths){
                File srcFile = new File(sourceFile, filePath);
                File destFile = new File(targetFile, filePath);

                copyFiles(srcFile, destFile);
            }
        }
        else{
        	
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));

            long fileBytes = sourceFile.length();
            long soFar = 0L;

            int theByte;

            while((theByte = bis.read()) != -1){
                bos.write(theByte);

                setProgress((int) (copiedBytes++ * 100 / totalBytes));
                publish((int) (soFar++ * 100 / fileBytes));
            }

            bis.close();
            bos.close();

            publish(100);
        }
    }
}
