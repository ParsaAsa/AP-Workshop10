import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	private Socket socket;
	private BufferedReader input;
	
	public ClientThread(Socket socket)throws IOException{
		this.socket = socket;
		this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				String response = input.readLine();
				System.out.println(response);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				input.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
