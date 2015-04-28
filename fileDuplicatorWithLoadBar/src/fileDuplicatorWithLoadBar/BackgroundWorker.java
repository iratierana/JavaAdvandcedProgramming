package fileDuplicatorWithLoadBar;

import java.io.File;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class BackgroundWorker extends SwingWorker<Void, Integer>{
	
	int completed;
	JProgressBar progressBar;
	
	public BackgroundWorker(int completed, JProgressBar progressBar) {
		this.completed = completed;
		this.progressBar = progressBar;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		while(completed<100){
			Thread.sleep(1000);
			progressBar.setValue(completed);
		}	
		return null;
		
	}
}
